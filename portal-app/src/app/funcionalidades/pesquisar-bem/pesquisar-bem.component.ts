import { Component, OnInit } from '@angular/core';
import { BpService } from '../../funcionalidades/cruds/bp/bp.service';
import {Bem} from '../../models/bem.model';

@Component({
  selector: 'app-pesquisar-bem',
  templateUrl: './pesquisar-bem.component.html',
  styleUrls: ['./pesquisar-bem.component.css'],
  providers: [BpService]
})


export class PesquisarBemComponent implements OnInit {

  constructor(private bemService: BpService) { }

  escolha: String;
  itemPesquisa: String;
  bens: Bem[];

  ngOnInit() {
  }

  searchBPFilter(): void{
    if (this.escolha === "numTomb") {
      this.bemService.findNumTomb(this.itemPesquisa)
        .subscribe(data => {
          this.bens = data;
        });
    }else if (this.escolha === "denomi") {
      this.bemService.findDenomi(this.itemPesquisa)
        .subscribe(data => {
          this.bens = data;
        });
    } else if (this.escolha === "marca") {
      this.bemService.findMarca(this.itemPesquisa)
        .subscribe( data => {
          this.bens = data;
        });
    }
  }

}
