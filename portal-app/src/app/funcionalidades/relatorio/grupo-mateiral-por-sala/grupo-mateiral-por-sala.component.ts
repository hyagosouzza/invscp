import { Component, OnInit } from '@angular/core';
import {BpService} from '../../cruds/bp/bp.service';
import {Router} from '@angular/router';
import {Bem} from '../../../models/bem.model';

@Component({
  selector: 'app-grupo-mateiral-por-sala',
  templateUrl: './grupo-mateiral-por-sala.component.html',
  styleUrls: ['./grupo-mateiral-por-sala.component.css'],
  providers: [BpService]
})
export class GrupoMateiralPorSalaComponent implements OnInit {

  gms: String[] = ['Eletrodoméstico', 'Informática', 'Didático', 'Móveis',
    'Ferramenta', 'Máquina ou equipamento industrial',
    'Veículo leve', 'Veículo Pesado'];
  gmClick: String;
  salaEscolha: String;
  bens: Bem[];
  bensFiltrados: Bem[];
  tamanho: number;
  contador: number;

  constructor(private router: Router,  private bemService: BpService) {
  }

  ngOnInit() {
    if (localStorage.length > 0) {
      let salaEscolha = JSON.parse(localStorage.getItem('salaEscolha'));
      this.salaEscolha = salaEscolha;
    }
    this.bemService.findAllBySalaGm(this.salaEscolha)
      .subscribe(data => {
        this.bens = data;
      });
  }

  verBens(gm) {
    this.gmClick = gm;
    let contador: number;
    if (this.gmClick === 'Eletrodoméstico') {
      this.gmClick = 'ELETRO';
    } else if (this.gmClick === 'Informática') {
      this.gmClick = 'INFORMATICA';
    } else if (this.gmClick === 'Didático') {
      this.gmClick = 'DIDATICO';
    } else if (this.gmClick === 'Móveis') {
      this.gmClick = 'MOVEIS';
    } else if (this.gmClick === 'Ferramenta') {
      this.gmClick = 'FERRAMENTA';
    } else if (this.gmClick === 'Máquina ou equipamento industrial') {
      this.gmClick = 'EQUIPAMENTO_INDUSTRIAL';
    } else if (this.gmClick === 'Veículo leve') {
      this.gmClick = 'VEICULO_LEVE';
    } else if (this.gmClick === 'Veículo Pesado') {
      this.gmClick = 'VEICULO_PESADO';
    }
  }

}
