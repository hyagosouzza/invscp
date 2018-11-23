import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Predio } from '../../../models/predio.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class PredioService {

  constructor(private http:HttpClient) {}

  private predioUrl = 'http://localhost:8080/user-portal/predios';
  //private predioUrl = '/api';

  public getPredios() {
    return this.http.get<Predio[]>(this.predioUrl);
  }

  public deletePredio(predio) {
    return this.http.delete(this.predioUrl + "/"+ predio.id);
  }

  public createPredio(predio) {
    return this.http.post<Predio>(this.predioUrl, predio);
  }

  public updatePredio(predio) {
    return this.http.put(this.predioUrl + "/"+ predio.id, predio);
  }

  public findOne(predio) {
    return this.http.get(this.predioUrl + "/"+ predio.id);
  }

}
