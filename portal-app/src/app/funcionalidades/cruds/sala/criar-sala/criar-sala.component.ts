import { Component, OnInit } from '@angular/core';
import { DeptoService } from '../../depto/depto.service';
import { Departamento } from '../../../../models/departamento.model';
import { Router } from '@angular/router';
import { Sala } from '../../../../models/sala.model';
import { SalaService } from '../../sala/sala.service';

@Component({
  selector: 'app-criar-sala',
  templateUrl: './criar-sala.component.html',
  styleUrls: ['./criar-sala.component.css'],
  providers: [SalaService, DeptoService]
})
export class CriarSalaComponent implements OnInit {

  sala: Sala = new Sala();
  departamentos: Departamento[];

  constructor(private router: Router, private departamentoService: DeptoService, private salaService: SalaService) {

  }

  ngOnInit() {
    this.departamentoService.getDepartamentos()
      .subscribe(data => {
        this.departamentos = data;
      });
  };

  createSala(): void {
    this.salaService.createSala(this.sala)
      .subscribe(data => {
        alert("Sala criada com sucesso.");
      });

  };

}
