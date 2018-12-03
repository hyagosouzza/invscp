import { Component, OnInit } from '@angular/core';
import { BpService } from '../cruds/bp/bp.service';
import { OrdemServico } from '../../models/ordem-servico.model';
import { OrdemServicoService } from './ordem-servico.service';

@Component({
  selector: 'app-registrar-ordem-servico',
  templateUrl: './registrar-ordem-servico.component.html',
  styleUrls: ['./registrar-ordem-servico.component.css']
})
export class RegistrarOrdemServicoComponent implements OnInit {

  findById: any;
  bool: boolean = false;
  id: String;
  ordemServico: OrdemServico = new OrdemServico();


  constructor(private _bemService: BpService, private _ordemService: OrdemServicoService) { }

  ngOnInit() {
  }

  buscarBem() {
    this._bemService.findById(this.id).subscribe(data => {
      this.findById = data;
    });
    if(this.findById.situacao == 'INCORPORADO') {
      this.bool = true;
      this.ordemServico.bem = this.findById; 
    } else {
      this.bool = false;
    }
  }

  criarOrdem() {
    this._ordemService.create(this.ordemServico).subscribe(data => {
      this.ordemServico = data;
    })
    if(!(this.ordemServico.id == '')){
      alert("Ordem Criada com Sucesso!");
    }
  }

}
