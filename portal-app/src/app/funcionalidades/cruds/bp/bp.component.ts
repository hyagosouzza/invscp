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
  id_sala: string;

  constructor(private router: Router, private bemService: BpService, private salaService: SalaService) {

  }

  ngOnInit() {
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

    this.bemUpdate.sala =  this.salas.find(obj => {
      return obj.id == this.id_sala;
    });

    this.bemService.updateBem(this.bemUpdate)
      .subscribe(data => {
        alert('Bem editado!');
        location.reload();
      })
  };

}
