import { Component, OnInit } from '@angular/core';
import { BpService } from '../cruds/bp/bp.service';
import { OrdemServico } from '../../models/ordem-servico.model';
import { OrdemServicoService } from './ordem-servico.service';
import { Bem } from '../../models/bem.model';

@Component({
  selector: 'app-registrar-ordem-servico',
  templateUrl: './registrar-ordem-servico.component.html',
  styleUrls: ['./registrar-ordem-servico.component.css'],
  providers: [OrdemServicoService, BpService]
})
export class RegistrarOrdemServicoComponent implements OnInit {

  bens: Bem[];
  findOneById: Bem;
  bool: boolean = false;
  id: String;
  ordemServico: OrdemServico = new OrdemServico();
  ordem: OrdemServico;


  constructor(private _bemService: BpService, private _ordemService: OrdemServicoService) { }

  ngOnInit() {
  }

  buscarBems() {
    this._bemService.findNumTomb(this.id).subscribe(data => {
      this.bens = data;
    });
  }

  criarOrdem() {
    this._ordemService.create(this.ordemServico).subscribe(data => {
      this.ordem = data;
    });
  }

  findOne(bem: Bem): void {
    this._bemService.findOne(bem).subscribe(data => {
      this.findOneById = data;
      this.ordemServico.bem = data;
      if(this.findOneById.situacao == "INCORPORADO") {
        this.bool = true;
      }
    })
  }

  situacao(bem: Bem) {
    return this.findOneById.situacao == "INCORPORADO";
  }

}
