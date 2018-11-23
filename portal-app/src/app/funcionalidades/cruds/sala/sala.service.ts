import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Sala } from '../../../models/sala.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class SalaService {

  constructor(private http:HttpClient) {}

  private salaUrl = 'http://localhost:8080/user-portal/salas';
  //private salaUrl = '/api';

  public getSalas() {
    return this.http.get<Sala[]>(this.salaUrl);
  }

  public deleteSala(sala) {
    return this.http.delete(this.salaUrl + "/"+ sala.id);
  }

  public createSala(sala) {
    return this.http.post<Sala>(this.salaUrl, sala);
  }

  public updateSala(sala) {
    return this.http.put(this.salaUrl + "/"+ sala.id, sala);
  }

  public findOne(sala) {
    return this.http.get(this.salaUrl + "/"+ sala.id);
  }


}
