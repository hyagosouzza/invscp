import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Departamento } from '../../../models/departamento.model';
import { DeptoService } from './depto.service';

@Component({
  selector: 'app-depto',
  templateUrl: './depto.component.html',
  styleUrls: ['./depto.component.css'],
  providers: [DeptoService]
})
export class DeptoComponent implements OnInit {

  departamentos: Departamento[];
  departamentoUpdate: Departamento = new Departamento();
  findOneById: any;

  constructor(private router: Router, private departamentoService: DeptoService) {

  }

  ngOnInit() {
    this.departamentoService.getDepartamentos()
      .subscribe(data => {
        this.departamentos = data;
      });

  };

  findOne(departamento: Departamento): void {
    this.departamentoService.findOne(departamento)
      .subscribe(data => {
        this.findOneById = data;
        this.departamentoUpdate = this.findOneById;
      })
  };

  deleteDepartamento(departamento: Departamento): void {
    this.departamentoService.deleteDepartamento(departamento)
      .subscribe(data => {
        this.departamentos = this.departamentos.filter(u => u !== departamento);
      })
  };

  updateDepartamento(): void {

    this.departamentoService.updateDepartamento(this.departamentoUpdate)
      .subscribe(data => {
        alert('Departamento editado!');
        location.reload();
      })
  };

}
