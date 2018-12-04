import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Bem } from '../../../models/bem.model';
import { Historico } from '../../../models/historico.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class BpService {

  constructor(private http:HttpClient) {}

  private bemUrl = 'http://localhost:8080/user-portal/bens';
  private baixarBemUrl = 'http://localhost:8080/user-portal/bens/baixar';
  private bemUrlNumTomb = 'http://localhost:8080/user-portal/bens/numTomb';
  private bemUrlMarca = 'http://localhost:8080/user-portal/bens/marca';
  private bemUrlDenomi = 'http://localhost:8080/user-portal/bens/denomi';
  private bemUrlInvent = 'http://localhost:8080/user-portal/bens/inventario';
  private bemUrlRelat = 'http://localhost:8080/user-portal/bens/relat';
  private bemUrlHist = 'http://localhost:8080/user-portal/bens/hist'
  //private bemUrl = '/api';

  public getBens() {
    return this.http.get<Bem[]>(this.bemUrl);
  }

  public getInventario(){
    return this.http.get<Bem[]>(this.bemUrlInvent);
  }

  public deleteBem(bem) {
    return this.http.delete(this.bemUrl + "/"+ bem.id);
  }

  public createBem(bem) {
    return this.http.post<Bem>(this.bemUrl, bem);
  }

  public updateBem(bem) {
    return this.http.put(this.bemUrl + "/"+ bem.id, bem);
  }

  public baixarBem(bem) {
    return this.http.put(this.baixarBemUrl + "/"+ bem.id, bem);
  }

  public findOne(bem) {
    return this.http.get<Bem>(this.bemUrl + "/"+ bem.id);
  }

  public findById(id: String) {
    return this.http.get<Bem>(this.bemUrl + "/"+ id);
  }

  public findNumTomb(numTomb) {
    return this.http.get<Bem[]>(this.bemUrlNumTomb + "/"+ numTomb);
  }

  public findMarca(marca) {
    console.log("VEIO PRO BP.SERVICE");
    return this.http.get<Bem[]>(this.bemUrlMarca + "/"+ marca);
  }

  public findDenomi(denomi) {
    return this.http.get<Bem[]>(this.bemUrlDenomi + "/"+ denomi);
  }

  public findAllBySalaGm(sala) {
    return this.http.get<Bem[]>(this.bemUrlRelat + "/"+ sala);
  }

  public getHist(bem) {
    return this.http.get<Historico>(this.bemUrlHist + "/"+ bem.id);
  }

  public getBensIncorps() {
    return this.http.get<Bem[]>(this.bemUrl + "/incorps");
  }

}
