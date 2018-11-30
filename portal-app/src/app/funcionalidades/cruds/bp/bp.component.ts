import { Component, OnInit } from '@angular/core';

import { Bem } from '../../../models/bem.model';
import { BpService } from './bp.service';
import { SalaService } from '../sala/sala.service';
import { Sala } from '../../../models/sala.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bp',
  templateUrl: './bp.component.html',
  styleUrls: ['./bp.component.css'],
  providers: [BpService, SalaService]
})

export class BpComponent implements OnInit {

  bens: Bem[];
  bemUpdate: Bem = new Bem();
  findOneById: any;
  salas: Sala[];
  admin: boolean;

  constructor(private router: Router, private bemService: BpService, private salaService: SalaService) {

  }

  ngOnInit() {
    if (localStorage.length > 0) {
      let user = JSON.parse(localStorage.getItem('user'));
      console.log("DENTRO DE BP: " + user.departamento.nome);
      if (user.departamento.nome == "Departamento de Patrimônio"){
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
  };

  findOne(bem: Bem): void {
    this.bemService.findOne(bem)
      .subscribe(data => {
        this.findOneById = data;
      })
  };

  deleteBem(bem: Bem): void {
    this.bemService.deleteBem(bem)
      .subscribe(data => {
        this.bens = this.bens.filter(u => u !== bem);
      })
  };

  updateBem(): void {
    this.bemUpdate.id = this.findOneById.id;
    console.log(this.bemUpdate);
    this.bemService.updateBem(this.bemUpdate)
      .subscribe(data => {
        alert('Bem editado!');
        location.reload();
      })
  };

  baixarBem(): void {
    this.bemUpdate.id = this.findOneById.id;
    this.bemUpdate.denominacao = this.findOneById.denominacao;
    this.bemUpdate.especificacao = this.findOneById.especificacao;
    this.bemUpdate.numNotaFiscal = this.findOneById.numNotaFiscal;
    this.bemUpdate.marca = this.findOneById.marca;
    this.bemUpdate.garantia = this.findOneById.garantia;
    this.bemUpdate.valorCompra = this.findOneById.valorCompra;
    this.bemUpdate.valorAtual = this.findOneById.valorAtual;
    this.bemUpdate.vidaUtil = this.findOneById.vidaUtil;
    this.bemUpdate.dataAquis = this.findOneById.dataAquis;
    this.bemUpdate.numTombamento = this.findOneById.numTombamento;
    this.bemUpdate.grupoMaterial = this.findOneById.grupoMaterial;
    console.log(this.bemUpdate);
    this.bemService.baixarBem(this.bemUpdate)
      .subscribe(data => {
        alert('Bem baixado!');
        location.reload();
      })
  };

  getAdmin(): boolean {
    return this.admin;
  }

}
