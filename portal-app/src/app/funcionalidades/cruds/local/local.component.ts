import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LocalService } from './local.service';
import { Local } from '../../../models/local.model';

@Component({
  selector: 'app-local',
  templateUrl: './local.component.html',
  styleUrls: ['./local.component.css'],
  providers: [LocalService]
})
export class LocalComponent implements OnInit {

  locais: Local[];
  localUpdate: Local = new Local();
  findOneById: any;

  constructor(private router: Router, private localService: LocalService) {

  }

  ngOnInit() {
    this.localService.getLocais()
      .subscribe( data => {
        this.locais = data;
      });
  }

  findOne(local: Local): void {
    this.localService.findOne(local)
      .subscribe( data => {
        this.findOneById = data;
        this.localUpdate = this.findOneById;
      });
  }

  deleteLocal(local: Local): void {
    this.localService.deleteLocal(local)
      .subscribe( data => {
        this.locais = this.locais.filter(u => u !== local);
      });
  }

  updateLocal(): void {

    this.localService.updateLocal(this.localUpdate)
      .subscribe( data => {
        alert('Localização editada!');
        location.reload();
      });
  }
}
