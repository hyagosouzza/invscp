import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {MovimentacaoService} from './movimentacao.service';
import {User} from '../../models/user.model';
import {Movimentacao} from '../../models/movimentacao.model';
import {AcaoMovimentacao} from '../../models/acao-mov.model';
import {Local} from '../../models/local.model';

@Component({
  selector: 'app-saidas',
  templateUrl: './movimentacao-saida.component.html',
  styleUrls: ['./registrar-movimentacao.component.css'],
  providers: [MovimentacaoService]
})
export class MovimentacaoSaidaComponent implements OnInit {

  user: User = new User();
  saidas: Movimentacao[];
  findOneById: any;

  constructor(private router: Router, private movService: MovimentacaoService) {

  }

  ngOnInit() {
    if (localStorage.length > 0) {
      this.user = JSON.parse(localStorage.getItem('user'));
    }
    this.movService.getSaidas(this.user.departamento).subscribe(
      data => {
        this.saidas = data;
      }
    );
  }

  aprovarSaida(movimentacao) {
    let acao = new AcaoMovimentacao();
    acao.movimentacao = movimentacao;
    acao.solicitante = this.user;
    this.movService.aceiteSaida(acao).subscribe(data => {
      if (data) {
        alert('Movimentação aprovada!');
      } else {
        alert('Erro na aprovação');
      }
    });
  }

  /*cancelar(movimentacao) {
    let acao = new AcaoMovimentacao();
    acao.movimentacao = movimentacao;
    acao.solicitante = this.user;
    this.movService.aceiteEntrada(acao);
  }*/

  findOne(mov: Movimentacao): void {
    this.movService.findOne(mov)
      .subscribe( data => {
        this.findOneById = data;
      });
  }
}
