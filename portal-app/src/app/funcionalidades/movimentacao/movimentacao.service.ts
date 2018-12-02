import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Movimentacao} from '../../models/movimentacao.model';

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
    return this.http.post(this.movUrl + '/registrar', solicitacao);
  }

}
