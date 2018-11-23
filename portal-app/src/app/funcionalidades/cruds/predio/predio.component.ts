import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Predio } from '../../../models/predio.model';
import { PredioService } from './predio.service';
import { LocalService } from '../local/local.service';
import { Local } from '../../../models/local.model';

@Component({
  selector: 'app-predio',
  templateUrl: './predio.component.html',
  styleUrls: ['./predio.component.css'],
  providers: [LocalService, PredioService]
})
export class PredioComponent implements OnInit {

  predios: Predio[];
  predioUpdate: Predio = new Predio();
  findOneById: any;
  locais: Local[];

  constructor(private router: Router, private predioService: PredioService, private localService: LocalService) {

  }

  ngOnInit() {
    this.predioService.getPredios()
      .subscribe(data => {
        this.predios = data;
      });
    this.localService.getLocais()
      .subscribe(data => {
        this.locais = data;
      });
  };

  findOne(predio: Predio): void {
    this.predioService.findOne(predio)
      .subscribe(data => {
        this.findOneById = data;
      })
  };

  deletePredio(predio: Predio): void {
    this.predioService.deletePredio(predio)
      .subscribe(data => {
        this.predios = this.predios.filter(u => u !== predio);
      })
  };

  updatePredio(): void {
    this.predioUpdate.id = this.findOneById.id;
    console.log(this.predioUpdate);
    this.predioService.updatePredio(this.predioUpdate)
      .subscribe(data => {
        alert('Prédio editado!');
        location.reload();
      })
  };

}
