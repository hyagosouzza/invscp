import {Component, OnInit} from '@angular/core';
import {BpService} from '../../funcionalidades/cruds/bp/bp.service';
import {Bem} from '../../models/bem.model';
import {Local} from '../../models/local.model';
import {Predio} from '../../models/predio.model';
import {Departamento} from '../../models/departamento.model';
import {Sala} from '../../models/sala.model';
import {LocalService} from '../cruds/local/local.service';
import {PredioService} from '../cruds/predio/predio.service';
import {DeptoService} from '../cruds/depto/depto.service';
import {SalaService} from '../cruds/sala/sala.service';
import {SolicitacaoMov} from '../../models/solicitacao-mov.model';
import {MovimentacaoService} from '../movimentacao/movimentacao.service';
import {User} from '../../models/user.model';
import {MovimentacaoResponse} from '../../models/mov-response';

@Component({
  selector: 'app-pesquisar-bem-user',
  templateUrl: './pesquisar-bem-user.component.html',
  styleUrls: ['./pesquisar-bem-user.component.css'],
  providers: [BpService, LocalService, PredioService, DeptoService, SalaService, MovimentacaoService]
})


export class PesquisarBemUserComponent implements OnInit {

  constructor(private bemService: BpService, private localService: LocalService,
              private predioService: PredioService, private deptoService: DeptoService,
              private salaService: SalaService, private movService: MovimentacaoService) {
  }

  escolha: String;
  itemPesquisa: String;
  bens: Bem[];
  locais: Local[];
  predios: Predio[];
  predios1: Predio[];
  departamentos: Departamento[];
  departamentos1: Departamento[];
  salas: Sala[];
  salas1: Sala[];
  findOneById: any;
  solicitacao: SolicitacaoMov = new SolicitacaoMov();
  local: Local;
  departamento: Departamento;
  predio: Predio;
  user: User = new User();

  ngOnInit() {
    if (localStorage.length > 0) {
      this.user = JSON.parse(localStorage.getItem('user'));
    }

    this.localService.getLocais()
      .subscribe(data => {
        this.locais = data;
      });

    this.predioService.getPredios()
      .subscribe(data => {
        this.predios = data;
      });

    this.deptoService.getDepartamentos()
      .subscribe(data => {
        this.departamentos = data;
      });

    this.salaService.getSalas()
      .subscribe(data => {
        this.salas = data;
      });
  }

  searchBPFilter(): void {
    if (this.escolha === 'numTomb') {
      this.bemService.findNumTomb(this.itemPesquisa)
        .subscribe(data => {
          this.bens = data;
        });
    } else if (this.escolha === 'denomi') {
      this.bemService.findDenomi(this.itemPesquisa)
        .subscribe(data => {
          this.bens = data;
        });
    } else if (this.escolha === 'marca') {
      this.bemService.findMarca(this.itemPesquisa)
        .subscribe(data => {
          this.bens = data;
        });
    }
  }

  findOne(bem: Bem): void {
    this.bemService.findOne(bem)
      .subscribe(data => {
        this.findOneById = data;
      });
  }

  filterPredio(): void {
    this.predios1 = this.predios.filter(prd => {
      return prd.local.id === this.local.id;
    });
  }

  filterDepto(): void {
    console.table(this.departamentos);
    console.log(this.predio);
    this.departamentos1 = this.departamentos.filter(dpt => {
      if (dpt.predio) {
        return dpt.predio.id === this.predio.id;
      } else {
        return false;
      }
    });
  }

  filterSala(): void {
    this.salas1 = this.salas.filter(sl => {
      return sl.departamento.id === this.departamento.id;
    });
  }

  registrarMovimentacao(): void {
    if (this.solicitacao.destino == null) {
      alert('Todos os campos devem ser preenchidos.');
      return;
    }
    this.solicitacao.bem = this.findOneById;
    this.solicitacao.solicitante = JSON.parse(localStorage.getItem('user'));
    this.movService.registrarMovimentacao(this.solicitacao).subscribe(data => {
      let response: MovimentacaoResponse;
      response = data;
      if (response.success) {
        alert('Movimentação registrada!');
        if (response.crossCity) {
          localStorage.setItem('guia', response.html);
          window.location.href = 'http://localhost:4200/admin/guia';
        }
      } else {
        alert('Erro na movimentação');
        location.reload();
      }
    });
  }

}
