import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Departamento } from '../../../models/departamento.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class DeptoService {

  constructor(private http:HttpClient) {}

  private departamentoUrl = 'http://localhost:8080/user-portal/departamentos';
  //private departamentoUrl = '/api';

  public getDepartamentos() {
    return this.http.get<Departamento[]>(this.departamentoUrl);
  }

  public deleteDepartamento(departamento) {
    return this.http.delete(this.departamentoUrl + "/"+ departamento.id);
  }

  public createDepartamento(departamento) {
    return this.http.post<Departamento>(this.departamentoUrl, departamento);
  }

  public updateDepartamento(departamento) {
    return this.http.put(this.departamentoUrl + "/"+ departamento.id, departamento);
  }

  public findOne(departamento) {
    return this.http.get(this.departamentoUrl + "/"+ departamento.id);
  }

}
