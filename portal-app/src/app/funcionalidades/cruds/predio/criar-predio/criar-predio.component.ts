import { Component, OnInit } from '@angular/core';
import { Predio } from '../../../../models/predio.model';
import { Router } from '@angular/router';
import { PredioService } from '../predio.service';
import { Local } from '../../../../models/local.model';
import { LocalService } from '../../local/local.service';

@Component({
  selector: 'app-criar-predio',
  templateUrl: './criar-predio.component.html',
  styleUrls: ['./criar-predio.component.css'],
  providers: [LocalService, PredioService]
})
export class CriarPredioComponent implements OnInit {

  predio: Predio = new Predio();
  locais: Local[];
  id_local: string;

  constructor(private router: Router, private predioService: PredioService, private localService: LocalService) {

  }

  ngOnInit() {
    this.localService.getLocais()
      .subscribe(data => {
        this.locais = data;
      });
  };

  createPredio(): void {
    if(this.predio.local == null || this.predio.nome == null || this.predio.nome == '') {
      alert('Todos os campos devem ser preenchidos!');
      return;
    }
    this.predioService.createPredio(this.predio)
      .subscribe(data => {
        alert("Predio criado com sucesso.");
      });

  };

}
