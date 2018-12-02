import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { SalaService } from './sala.service';
import { Sala } from '../../../models/sala.model';

@Component({
  selector: 'app-sala',
  templateUrl: './sala.component.html',
  styleUrls: ['./sala.component.css'],
  providers: [SalaService]
})
export class SalaComponent implements OnInit {

  salas: any;
  salaUpdate: Sala = new Sala();
  findOneById: any;

  constructor(private router: Router, private salaService: SalaService) {

  }

  ngOnInit() {

    this.salaService.getSalas()
      .subscribe(data => {
        this.salas = data;
      });
  };

  findOne(sala: Sala): void {
    this.salaService.findOne(sala)
      .subscribe(data => {
        this.findOneById = data;
        this.salaUpdate = this.findOneById;
      })
  };

  deleteSala(sala: Sala): void {
    this.salaService.deleteSala(sala)
      .subscribe(data => {
        this.salas = this.salas.filter(u => u !== sala);
      })
  };

  updateSala(): void {

    this.salaService.updateSala(this.salaUpdate)
      .subscribe(data => {
        alert('Sala editada!');
        location.reload();
      })
};
}
