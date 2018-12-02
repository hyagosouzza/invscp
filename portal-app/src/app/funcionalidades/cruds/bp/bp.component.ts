import { Component, OnInit } from '@angular/core';
declare var $: any;
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
  dateHtml: any;
  date: any;

  constructor(private router: Router, private bemService: BpService, private salaService: SalaService) {

  }

  ngOnInit() {

    if (localStorage.length > 0) {
      let user = JSON.parse(localStorage.getItem('user'));
      console.log("DENTRO DE BP: " + user.departamento.nome);
      if (user.departamento.nome == "Departamento de Patrimônio") {
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
    
    this.dateHtml = new Date().toLocaleDateString('pt-BR');
    console.log();
    this.bemService.findOne(bem)
      .subscribe(data => {
        this.findOneById = data;
        this.bemUpdate = this.findOneById;
      })
  };

  deleteBem(bem: Bem): void {

    this.bemService.deleteBem(bem)
      .subscribe(data => {
        this.bens = this.bens.filter(u => u !== bem);
      })
  };

  updateBem(): void {

    console.log(this.bemUpdate);
    this.bemService.updateBem(this.bemUpdate)
      .subscribe(data => {
        alert('Bem editado!');
        location.reload();
      })
  };

  baixarBem(): void {

    if (this.bemUpdate.motivoDaBaixa == null) {
      alert("Informe o motivo da baixa.");
      return;
    }
    let tomorrow = new Date();
    let today = new Date();
    tomorrow.setDate(today.getDate() + 1);
    this.date = tomorrow.toLocaleDateString('fr-CA');
    
    this.bemUpdate.dataDaBaixa = this.date;

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
