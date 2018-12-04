import { Component, OnInit } from '@angular/core';
import { BpService } from '../../cruds/bp/bp.service';
import { OrdemServico } from '../../../models/ordem-servico.model';
import { OrdemServicoService } from './../ordem-servico.service';
import { Bem } from '../../../models/bem.model';

@Component({
  selector: 'app-concluir-ordem',
  templateUrl: './concluir-ordem.component.html',
  styleUrls: ['./concluir-ordem.component.css'],
  providers: [OrdemServicoService, BpService]
})
export class ConcluirOrdemComponent implements OnInit {

  ordens: OrdemServico[];
  findOneById: Bem = new Bem();
  bool: boolean = true;
  id: String;
  ordemServico: OrdemServico = new OrdemServico();
  ordem: OrdemServico = new OrdemServico();
  object: any;


  constructor(private _bemService: BpService, private _ordemService: OrdemServicoService) { }

  ngOnInit() {
    this._ordemService.getOrdens().subscribe(data => {
      this.ordens = data;
    });
  }

  concluir() {
    console.log(this.ordemServico);
    this._ordemService.concluir(this.ordemServico).subscribe(data => {
      this.ordem = data;
      this.object = data;
      console.log(data);
      if(this.object.error != "OK" ) {
        alert("Ordem de Serviço foi concluida com sucesso!");
      } else{
        alert("Não foi possível concluir a ordem de serviço. Tente novamente mais tarde!"); 
      }
    });
    this._ordemService.getOrdens().subscribe(data => {
      this.ordens = data;
    });
  }

  findOne(ordem: OrdemServico): void {
    this._ordemService.findOne(ordem).subscribe(data => {
      this.ordemServico = data;
      this._bemService.findOne(this.ordemServico.bem).subscribe(data => {
        this.findOneById = data;
      });
    });
  }

  findBemById(bem: Bem): void {
    this._bemService.findOne(bem).subscribe(data => {
        this.findOneById = data;
    });
  }
  

}
