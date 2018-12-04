import { Component, OnInit } from '@angular/core';
declare var $: any;
import { Bem } from '../../../models/bem.model';
import { BpService } from './bp.service';
import { SalaService } from '../sala/sala.service';
import { Sala } from '../../../models/sala.model';
import { Router } from '@angular/router';
import {User} from '../../../models/user.model';
import {Local} from '../../../models/local.model';
import {Predio} from '../../../models/predio.model';
import {Departamento} from '../../../models/departamento.model';
import {SolicitacaoMov} from '../../../models/solicitacao-mov.model';
import {LocalService} from '../local/local.service';
import {PredioService} from '../predio/predio.service';
import {DeptoService} from '../depto/depto.service';
import {MovimentacaoService} from '../../movimentacao/movimentacao.service';
import {MovimentacaoResponse} from '../../../models/mov-response';
import { Historico } from '../../../models/historico.model';
import { Movimentacao } from '../../../models/movimentacao.model';
import { OrdemServico } from '../../../models/ordem-servico.model';

@Component({
  selector: 'app-bp',
  templateUrl: './bp.component.html',
  styleUrls: ['./bp.component.css'],
  providers: [BpService, SalaService, LocalService, PredioService, DeptoService, MovimentacaoService]
})

export class BpComponent implements OnInit {

  bens: Bem[];
  bemUpdate: Bem = new Bem();
  findOneById: any;
  salas: Sala[];
  admin: boolean;
  dateHtml: any;
  date: any;
  user: User = new User();
  locais: Local[];
  predios: Predio[];
  predios1: Predio[];
  departamentos: Departamento[];
  departamentos1: Departamento[];
  salas1: Sala[];
  solicitacao: SolicitacaoMov = new SolicitacaoMov();
  local: Local;
  departamento: Departamento;
  predio: Predio;
  historico: Historico;
  bem:  Bem;
  movimentacoes: Movimentacao[];
  ordens: OrdemServico[];

  constructor(private router: Router, private bemService: BpService, private salaService: SalaService,
              private localService: LocalService, private predioService: PredioService,
              private deptoService: DeptoService, private movService: MovimentacaoService) {

  }

  ngOnInit() {

    if (localStorage.length > 0) {
      this.user = JSON.parse(localStorage.getItem('user'));
      if (this.user.departamento.nome == 'Departamento de Patrimônio') {
        this.admin = true;
      } else {
        this.admin = false;
      }
    }
    this.bemService.getBens()
      .subscribe(data => {
        this.bens = data;
      });
    this.salaService.getSalas()
      .subscribe(data => {
        this.salas = data;
      });

    this.localService.getLocais()
      .subscribe( data => {
        this.locais = data;
      });

    this.predioService.getPredios()
      .subscribe( data => {
        this.predios = data;
      });

    this.deptoService.getDepartamentos()
      .subscribe( data => {
        this.departamentos = data;
      });
  }

  findOne(bem: Bem): void {

    this.dateHtml = new Date().toLocaleDateString('pt-BR');
    this.bemService.findOne(bem)
      .subscribe(data => {
        this.findOneById = data;
        this.bemUpdate = this.findOneById;
      });
  }

  deleteBem(bem: Bem): void {

    this.bemService.deleteBem(bem)
      .subscribe(data => {
        this.bens = this.bens.filter(u => u !== bem);
      });
  }

  updateBem(): void {

    console.log(this.bemUpdate);
    this.bemService.updateBem(this.bemUpdate)
      .subscribe(data => {
        alert('Bem editado!');
        location.reload();
      });
  }

  baixarBem(): void {

    if (this.bemUpdate.motivoDaBaixa == null) {
      alert('Informe o motivo da baixa.');
      return;
    }
    const tomorrow = new Date();
    const today = new Date();
    tomorrow.setDate(today.getDate() + 1);
    this.date = tomorrow.toLocaleDateString('fr-CA');

    this.bemUpdate.dataDaBaixa = this.date;

    this.bemService.baixarBem(this.bemUpdate)
      .subscribe(data => {
        alert('Bem baixado!');
        location.reload();
      });
  }

  getAdmin(): boolean {
    return this.admin;
  }

  filterPredio(): void {
    this.predios1 = this.predios.filter(prd => {
      return prd.local.id === this.local.id;
    });
  }

  filterDepto(): void {
    console.table(this.departamentos);
    console.log(this.predio);
    this.departamentos1 = this.departamentos.filter(dpt => {
      if (dpt.predio) {
        return dpt.predio.id === this.predio.id;
      } else {
        return false;
      }
    });
  }

  filterSala(): void {
    this.salas1 = this.salas.filter(sl => {
      return sl.departamento.id === this.departamento.id;
    });
  }

  registrarMovimentacao(): void {
    if (this.solicitacao.destino == null) {
        alert('Todos os campos devem ser preenchidos.');
        return;
      }
    this.solicitacao.bem = this.findOneById;
    this.solicitacao.solicitante = JSON.parse(localStorage.getItem('user'));
    this.movService.registrarMovimentacao(this.solicitacao).subscribe(data => {
      let response: MovimentacaoResponse;
      response = data;
      if (response.success) {
        alert('Movimentação registrada!');
        if (response.crossCity) {
          localStorage.setItem('guia', response.html);
          window.location.href = 'http://localhost:4200/admin/guia';
        }
      } else {
        alert('Erro na movimentação');
        location.reload();
      }
    });
  }

  getHist(bem) {
    this.bemService.getHist(bem).subscribe(data => {
      this.bem = data.bem;
      this.movimentacoes = data.movimentacoes;
      this.ordens = data.ordens;
    })
  }

}
