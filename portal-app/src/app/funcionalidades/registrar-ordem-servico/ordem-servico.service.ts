import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { OrdemServico } from '../../models/ordem-servico.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class OrdemServicoService {

  constructor(private http:HttpClient) {}

  private url = 'http://localhost:8080/user-portal/ordens';

  public getOrdens() {
    return this.http.get<OrdemServico[]>(this.url);
  }

  public delete(ordem) {
    return this.http.delete(this.url + "/"+ ordem.id);
  }

  public create(ordem) {
    return this.http.post<OrdemServico>(this.url, ordem);
  }

  public update(ordem) {
    return this.http.put(this.url + "/update/"+ ordem.id, ordem);
  }

  public concluir(ordem) {
    return this.http.put(this.url + "/concluir/"+ ordem.id, ordem);
  }

  public baixarBem(ordem) {
    return this.http.put(this.url + "/"+ ordem.id, ordem);
  }

  public findOne(ordem) {
    return this.http.get(this.url + "/"+ ordem.id);
  }

  public findById(id: String) {
    return this.http.get(this.url + "/"+ id);
  }

}
