import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin: boolean;

  constructor(private router: Router) { }

  ngOnInit() {
    if (localStorage.length > 0) {
      let user = JSON.parse(localStorage.getItem('user'));
      //console.log(user);
      if (user.departamento.nome == "Departamento de Patrimônio"){
        this.admin = true;
      } else {
        this.admin = false;
      }
      if (user.profile != 'CHEFE_DEPART') {
        this.router.navigate(['/usuarios']);
      }
    } else {
      this.router.navigate(['/anonimo']);
    }

  }

  logout() {
    localStorage.clear();
    alert('Desconectado!');
    this.router.navigate(['/anonimo']);
  }

  getAdmin(): boolean {
    return this.admin;
  }
}
