import { Component, OnInit } from '@angular/core';
import {BpService} from '../cruds/bp/bp.service';
import {SalaService} from '../cruds/sala/sala.service';
import {Router} from '@angular/router';
import {Sala} from '../../models/sala.model';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  styleUrls: ['./relatorio.component.css'],
  providers: [BpService, SalaService]
})
export class RelatorioComponent implements OnInit {

  salas: Sala[];
  depart: String;
  salaEscolha: String;

  constructor(private router: Router, private bemService: BpService, private salaService: SalaService) { }

  ngOnInit() {
    if (localStorage.length > 0) {
      let user = JSON.parse(localStorage.getItem('user'));
      this.depart = user.departamento.nome;
    }
    this.salaService.findAllPerDepart(this.depart)
      .subscribe(data => {
        // @ts-ignore
        this.salas = data;
      });
  }

  verGms(salaEscolha) {
    this.salaEscolha = salaEscolha;
    localStorage.setItem('salaEscolha', JSON.stringify(this.salaEscolha));
    this.router.navigate(['/admin/relat/gm']);
  };

}
