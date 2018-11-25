import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "../../models/user.model";
import {BehaviorSubject} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AnonimoService {
  constructor(private http:HttpClient) {}

  private loginUrl = 'http://localhost:8080/user-portal/login';

  public isUserValid(user: User) {
    return this.http.post<User>(this.loginUrl, user);
  }
}
