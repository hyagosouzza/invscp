import { Component, OnInit } from '@angular/core';

import { Bem } from '../../../../models/bem.model';
import { BpService } from '../bp.service';
import { Sala } from '../../../../models/sala.model';
import { Router } from '@angular/router';
import { SalaService } from '../../sala/sala.service';

@Component({
  selector: 'app-criar-bp',
  templateUrl: './criar-bp.component.html',
  styleUrls: ['./criar-bp.component.css'],
  providers: [BpService, SalaService]
})
export class CriarBpComponent implements OnInit {

  bem: Bem = new Bem();
  salas: Sala[];

  constructor(private router: Router, private bpService: BpService, private salaService: SalaService) {

  }

  ngOnInit() {
    this.salaService.getSalas()
      .subscribe(data => {
        this.salas = data;
      });
  };

  createBem(): void {
    this.bpService.createBem(this.bem)
      .subscribe(data => {
        alert("Bem Patrimonial criado com sucesso.");
      });

  };

}
