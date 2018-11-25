import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user.model";
import {AnonimoService} from "../../profiles/anonimo/anonimo.service";

@Component({
  selector: 'app-registrar-movimentacao',
  templateUrl: './registrar-movimentacao.component.html',
  styleUrls: ['./registrar-movimentacao.component.css'],
})
export class RegistrarMovimentacaoComponent implements OnInit {
  constructor(private anonimoService: AnonimoService) { }

  ngOnInit() {

  }

}
