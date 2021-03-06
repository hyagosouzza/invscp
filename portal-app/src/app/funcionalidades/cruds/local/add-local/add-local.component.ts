import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LocalService } from '../local.service';
import { Local } from '../../../../models/local.model';

@Component({
  selector: 'app-add-local',
  templateUrl: './add-local.component.html',
  styleUrls: ['./add-local.component.css'],
  providers: [LocalService]
})
export class AddLocalComponent {

  local: Local = new Local();

  constructor(private router: Router, private localService: LocalService) {

  }

  createLocal(): void {
    if(this.local.nome == (null || '') || this.local.estado == (null || '') || this.local.cidade == (null || '')
     || this.local.unidadeAdminstra == null ) {
       alert("Todos os campos devem ser preenchidos.");
       return;
     }
    this.localService.createLocal(this.local)
        .subscribe( data => {
          alert("Localização criada com sucesso.");
        });

  };
}
