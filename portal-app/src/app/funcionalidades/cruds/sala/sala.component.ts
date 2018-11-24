import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Departamento } from '../../../models/departamento.model';
import { SalaService } from './sala.service';
import { DeptoService } from '../depto/depto.service';
import { Sala } from '../../../models/sala.model';

@Component({
  selector: 'app-sala',
  templateUrl: './sala.component.html',
  styleUrls: ['./sala.component.css'],
  providers: [SalaService, DeptoService]
})
export class SalaComponent implements OnInit {

  salas: Sala[];
  salaUpdate: Sala = new Sala();
  findOneById: any;
  departamentos: Departamento[];
  id_departamento: string;

  constructor(private router: Router, private departamentoService: DeptoService, private salaService: SalaService) {

  }

  ngOnInit() {
    this.departamentoService.getDepartamentos()
      .subscribe(data => {
        this.departamentos = data;
      });
    this.salaService.getSalas()
      .subscribe(data => {
        this.salas = data;
      });
  };

  findOne(sala: Sala): void {
    this.salaService.findOne(sala)
      .subscribe(data => {
        this.findOneById = data;
      })
  };

  deleteSala(sala: Sala): void {
    this.salaService.deleteSala(sala)
      .subscribe(data => {
        this.salas = this.salas.filter(u => u !== sala);
      })
  };

  updateSala(): void {
    this.salaUpdate.id = this.findOneById.id;

    this.salaUpdate.departamento =  this.departamentos.find(obj => {
      return obj.id == this.id_departamento;
    });

    this.salaService.updateSala(this.salaUpdate)
      .subscribe(data => {
        alert('Sala editada!');
        location.reload();
      })
};
}
