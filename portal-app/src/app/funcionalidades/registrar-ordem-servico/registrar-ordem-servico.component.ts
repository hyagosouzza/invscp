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
  findOneById: Bem = new Bem();
  id: String;
  ordemServico: OrdemServico = new OrdemServico();
  ordem: OrdemServico;
  object: any;


  constructor(private _bemService: BpService, private _ordemService: OrdemServicoService) { }

  ngOnInit() {
    this._bemService.getBensIncorps().subscribe(data => {
      this.bens = data;
    })
  }

  buscarBems() {
    this._bemService.findNumTomb(this.id).subscribe(data => {
      this.bens = data;
    });
  }

  criarOrdem() {
    this.ordemServico.bem = this.findOneById;
    console.log(this.ordemServico);
    this._ordemService.create(this.ordemServico).subscribe(data => {
      this.ordem = data;
       this.object = data;
       console.log(data);
      if(this.object.error != "OK" ) {
        alert("Ordem de Serviço registrada com sucesso!");
      } else{
        alert("Não foi possível registrar a ordem de serviço. Tente novamente mais tarde!"); 
      }
    });
    this.buscarBems();
  }

  findOne(bem: Bem): void {
    this._bemService.findOne(bem).subscribe(data => {
      this.findOneById = data;
    })
  }

  situacao(bem: Bem) {
    return this.findOneById.situacao == "INCORPORADO";
  }


}
