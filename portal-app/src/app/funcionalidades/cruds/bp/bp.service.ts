import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Bem } from '../../../models/bem.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class BpService {

  constructor(private http:HttpClient) {}

  private bemUrl = 'http://localhost:8080/user-portal/bens';
  private bemUrlNumTomb = 'http://localhost:8080/user-portal/bens/numTomb';
  //private bemUrl = '/api';

  public getBens() {
    return this.http.get<Bem[]>(this.bemUrl);
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

  public findOne(bem) {
    return this.http.get(this.bemUrl + "/"+ bem.id);
  }

  public findNumTomb(numTomb) {
    return this.http.get(this.bemUrlNumTomb + "/"+ numTomb);
  }

}
