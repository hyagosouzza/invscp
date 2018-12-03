import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Movimentacao} from '../../models/movimentacao.model';
import {MovimentacaoResponse} from '../../models/mov-response';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MovimentacaoService {

  constructor(private http: HttpClient) {}

  private movUrl = 'http://localhost:8080/user-portal/movimentacoes';

  public getEntradas(departamento) {
    return this.http.post<Movimentacao[]>(this.movUrl + '/entradas', departamento);
  }

  public getSaidas(departamento) {
    return this.http.post<Movimentacao[]>(this.movUrl + '/saidas', departamento);
  }

  public registrarMovimentacao(solicitacao) {
    return this.http.post<MovimentacaoResponse>(this.movUrl + '/registrar', solicitacao);
  }

  public aceiteEntrada(acao) {
    return this.http.put(this.movUrl + '/aceite-entrada/' + acao.movimentacao.id, acao);
  }

  public aceiteSaida(acao) {
    return this.http.put(this.movUrl + '/aceite-saida/' + acao.movimentacao.id, acao);
  }

  public cancelar(acao) {
    return this.http.put(this.movUrl + '/cancelar/' + acao.movimentacao.id, acao);
  }

  public findOne(mov) {
    return this.http.get(this.movUrl + '/' + mov.id);
  }
}
