import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Departamento } from '../../../models/departamento.model';
import { DeptoService } from './depto.service';
import { PredioService } from '../predio/predio.service';
import { Predio } from '../../../models/predio.model';

@Component({
  selector: 'app-depto',
  templateUrl: './depto.component.html',
  styleUrls: ['./depto.component.css'],
  providers: [PredioService, DeptoService]
})
export class DeptoComponent implements OnInit {

  departamentos: Departamento[];
  departamentoUpdate: Departamento = new Departamento();
  findOneById: any;
  predios: Predio[];
  id_predio: string;

  constructor(private router: Router, private departamentoService: DeptoService, private predioService: PredioService) {

  }

  ngOnInit() {
    this.departamentoService.getDepartamentos()
      .subscribe(data => {
        this.departamentos = data;
      });
    this.predioService.getPredios()
      .subscribe(data => {
        this.predios = data;
      });
  };

  findOne(departamento: Departamento): void {
    this.departamentoService.findOne(departamento)
      .subscribe(data => {
        this.findOneById = data;
      })
  };

  deleteDepartamento(departamento: Departamento): void {
    this.departamentoService.deleteDepartamento(departamento)
      .subscribe(data => {
        this.departamentos = this.departamentos.filter(u => u !== departamento);
      })
  };

  updateDepartamento(): void {
    this.departamentoUpdate.id = this.findOneById.id;

    this.departamentoUpdate.predio =  this.predios.find(obj => {
      return obj.id == this.id_predio;
    });

    this.departamentoService.updateDepartamento(this.departamentoUpdate)
      .subscribe(data => {
        alert('Departamento editado!');
        location.reload();
      })
  };

}
