import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Local } from '../../../models/local.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LocalService {

  constructor(private http:HttpClient) {}

  private localUrl = 'http://localhost:8080/user-portal/locais';
  //private localUrl = '/api';

  public getLocais() {
    return this.http.get<Local[]>(this.localUrl);
  }

  public deleteLocal(local) {
    return this.http.delete(this.localUrl + "/"+ local.id);
  }

  public createLocal(local) {
    return this.http.post<Local>(this.localUrl, local);
  }

}
