import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "../../models/user.model";
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AnonimoService {
  constructor(private router: Router, private http:HttpClient) {}

  private loginUrl = 'http://localhost:8080/user-portal/login';

  user: User = new User();

  public isUserValid(user: User) {
    this.http.post<User>(this.loginUrl, user).subscribe(data => {
      this.user = data;
      localStorage.setItem('user', JSON.stringify(this.user));
      if (String(this.user.profile) == 'CHEFE_DEPART') {
        //console.log(this.user);
        //alert("Usuario valido");
        this.router.navigate(['/admin']);
      } else if (String(this.user.profile) == 'FUNCIONARIO' || String(this.user.profile) == 'GERAL') {
        //console.log(this.user);
        //alert("Usuario valido");
        this.router.navigate(['/usuarios']);
      } else {
        this.user = new User();
        alert("Usuario invalido");
      }
    })
    //return this.http.post<User>(this.loginUrl, user);
  }

  public usuarioLogado() {
    return this.user;
  }
}
