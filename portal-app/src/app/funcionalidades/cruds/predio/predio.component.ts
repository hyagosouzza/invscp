import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Predio } from '../../../models/predio.model';
import { PredioService } from './predio.service';

@Component({
  selector: 'app-predio',
  templateUrl: './predio.component.html',
  styleUrls: ['./predio.component.css'],
  providers: [PredioService]
})
export class PredioComponent implements OnInit {

  predios: Predio[];
  predioUpdate: Predio = new Predio();
  findOneById: any;


  constructor(private router: Router, private predioService: PredioService) {

  }

  ngOnInit() {
    this.predioService.getPredios()
      .subscribe(data => {
        this.predios = data;
      });
  };

  findOne(predio: Predio): void {
    this.predioService.findOne(predio)
      .subscribe(data => {
        this.findOneById = data;
        this.predioUpdate = this.findOneById;
      })
  };

  deletePredio(predio: Predio): void {
    this.predioService.deletePredio(predio)
      .subscribe(data => {
        this.predios = this.predios.filter(u => u !== predio);
      })
  };

  updatePredio(): void {

    console.log(this.predioUpdate);

    this.predioService.updatePredio(this.predioUpdate)
      .subscribe(data => {
        alert('Prédio editado!');
        location.reload();
      })
  };

}
