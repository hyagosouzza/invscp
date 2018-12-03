import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {MovimentacaoService} from './movimentacao.service';
import {User} from '../../models/user.model';
import {Movimentacao} from '../../models/movimentacao.model';
import {AcaoMovimentacao} from '../../models/acao-mov.model';

@Component({
  selector: 'app-entradas',
  templateUrl: './movimentacao-entrada.component.html',
  styleUrls: ['./registrar-movimentacao.component.css'],
  providers: [MovimentacaoService]
})
export class MovimentacaoEntradaComponent implements OnInit {

  user: User = new User();
  entradas: Movimentacao[];
  findOneById: any;
  motivo: string;

  constructor(private router: Router, private movService: MovimentacaoService) {

  }

  ngOnInit() {
    if (localStorage.length > 0) {
      this.user = JSON.parse(localStorage.getItem('user'));
    }
    this.movService.getEntradas(this.user.departamento).subscribe(
      data => {
        this.entradas = data;
      }
    );
  }

  aprovarEntrada(movimentacao) {
    const acao = new AcaoMovimentacao();
    acao.movimentacao = movimentacao;
    acao.solicitante = this.user;
    this.movService.aceiteEntrada(acao).subscribe(data => {
      if (data) {
        alert('Movimentação aprovada!');
      } else {
        alert('Erro na aprovação');
      }
    });
  }

  cancelar(movimentacao) {
    const acao = new AcaoMovimentacao();
    acao.movimentacao = movimentacao;
    acao.movimentacao.motivoCancelamento = this.motivo;
    acao.solicitante = this.user;
    this.movService.cancelar(acao);
  }

  findOne(mov: Movimentacao): void {
    this.movService.findOne(mov)
      .subscribe( data => {
        this.findOneById = data;
      });
  }
}
