import { Component, OnInit } from '@angular/core';
import {BpService} from '../cruds/bp/bp.service';
import {SalaService} from '../cruds/sala/sala.service';
import { Router } from '@angular/router';
import {Bem} from '../../models/bem.model';
import {Sala} from '../../models/sala.model';

@Component({
  selector: 'app-emitir-inventario',
  templateUrl: './emitir-inventario.component.html',
  styleUrls: ['./emitir-inventario.component.css'],
  providers: [BpService, SalaService]
})
export class EmitirInventarioComponent implements OnInit {

  bens: Bem[];
  salas: Sala[];
  findOneById: any;

  constructor(private router: Router, private bemService: BpService, private salaService: SalaService) { }

  ngOnInit() {
    this.bemService.getInventario()
      .subscribe(data => {
        this.bens = data;
      });
    this.salaService.getSalas()
      .subscribe(data => {
        this.salas = data;
      });
  }

  findOne(bem: Bem): void {
    this.bemService.findOne(bem)
      .subscribe(data => {
        this.findOneById = data;
      })
  };

}
