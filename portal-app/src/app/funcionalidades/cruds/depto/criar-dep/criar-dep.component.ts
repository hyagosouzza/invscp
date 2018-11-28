import { Component, OnInit } from '@angular/core';
import { Departamento } from '../../../../models/departamento.model';
import { Router } from '@angular/router';
import { DeptoService } from '../depto.service';
import { Predio } from '../../../../models/predio.model';
import { PredioService } from '../../predio/predio.service';

@Component({
  selector: 'app-criar-dep',
  templateUrl: './criar-dep.component.html',
  styleUrls: ['./criar-dep.component.css'],
  providers: [PredioService, DeptoService]
})
export class CriarDepComponent implements OnInit {

  departamento: Departamento = new Departamento();
  predios: Predio[];
  id_predio: string;

  constructor(private router: Router, private departamentoService: DeptoService, private predioService: PredioService) {

  }

  ngOnInit() {
    this.predioService.getPredios()
      .subscribe(data => {
        this.predios = data;
      });
  };

  createDepartamento(): void {

    this.departamentoService.createDepartamento(this.departamento)
      .subscribe(data => {
        alert("Departamento criado com sucesso.");
      });

  };

}
