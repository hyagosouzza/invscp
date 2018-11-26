import { Component, OnInit } from '@angular/core';
import {AnonimoService} from "../anonimo/anonimo.service";

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css'],
  providers: [AnonimoService]
})
export class UsuariosComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
