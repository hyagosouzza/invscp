import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    if (localStorage.length > 0) {
      let user = JSON.parse(localStorage.getItem('user'));
      //console.log(user);
      if (user.profile == 'CHEFE_DEPART') {
        this.router.navigate(['/admin']);
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

}
