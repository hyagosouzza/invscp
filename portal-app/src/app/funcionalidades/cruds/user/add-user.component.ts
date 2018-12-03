import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../../../models/user.model';
import { UserService } from './user.service';
import { DeptoService } from '../depto/depto.service';
import { Departamento } from '../../../models/departamento.model';

@Component({
  templateUrl: './add-user.component.html',
  providers: [DeptoService]
})
export class AddUserComponent implements OnInit{

  user: User = new User();
  users: User[];
  departamentos: Departamento[];
  id_departamento: string;

  constructor(private router: Router, private userService: UserService, private departamentoService: DeptoService) {

  }

  ngOnInit() {
    this.departamentoService.getDepartamentos()
      .subscribe(data => {
        this.departamentos = data;
      });

      this.userService.getUsers()
      .subscribe(data => {
        this.users = data;
      });
  }

  createUser(): void {
    if(this.user.email == null || this.user.senha == null || this.user.departamento == null
      || this.user.email == '' || this.user.senha == '') {
      alert("Os campos email, senha e departamento devem ser preenchidos!");
      return;
    }
    for (let i in this.users) {
      if(this.users[i].email == this.user.email) {
        alert("Já existe um usuário com este email.");
        return;
      }
   }

    this.userService.createUser(this.user)
        .subscribe( data => {
          alert("Usuário Criado com sucesso.");
        });

  };

}
