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
  departamentos: Departamento[];

  constructor(private router: Router, private userService: UserService, private departamentoService: DeptoService) {

  }

  ngOnInit() {
    this.departamentoService.getDepartamentos()
      .subscribe(data => {
        this.departamentos = data;
      });
  }

  createUser(): void {
    this.userService.createUser(this.user)
        .subscribe( data => {
          alert("Usuário Criado com sucesso.");
        });

  };

}
