import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../../../models/user.model';
import { UserService } from './user.service';
import { DeptoService } from '../depto/depto.service';
import { Departamento } from '../../../models/departamento.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: [],
  providers: [DeptoService]
})
export class UserComponent implements OnInit {

  users: User[];
  userUpdate: User = new User();
  findOneById: any;
  departamentos: Departamento[];

  constructor(private router: Router, private userService: UserService, private departamentoService: DeptoService) {

  }

  ngOnInit() {
    this.departamentoService.getDepartamentos()
      .subscribe(data => {
        this.departamentos = data;
      });
    this.userService.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  };

  findOne(user: User): void {
    this.userService.findOne(user)
      .subscribe( data => {
        this.findOneById = data;
      })
  };

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      })
  };

  updateUser(): void {
    this.userUpdate.id = this.findOneById.id;
    console.log(this.userUpdate);
    this.userService.updateUser(this.userUpdate)
      .subscribe( data => {
        alert('Usuário editado!');
        location.reload();
      })
  };

}


