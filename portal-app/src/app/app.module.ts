import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UserComponent } from './funcionalidades/cruds/user/user.component';
import { AppRoutingModule } from './app.routing.module';
import {UserService} from './funcionalidades/cruds/user/user.service';
import {HttpClientModule} from '@angular/common/http';
import {AddUserComponent} from './funcionalidades/cruds/user/add-user.component';
import { LocalComponent } from './funcionalidades/cruds/local/local.component';
import { AddLocalComponent } from './funcionalidades/cruds/local/add-local/add-local.component';
import { AnonimoComponent } from './profiles/anonimo/anonimo.component';
import { UsuariosComponent } from './profiles/usuarios/usuarios.component';
import { ChefeComponent } from './profiles/chefe/chefe.component';
import { AdminComponent } from './profiles/admin/admin.component';
import { PesquisarBemComponent } from './funcionalidades/pesquisar-bem/pesquisar-bem.component';
import { RegistrarMovimentacaoComponent } from './funcionalidades/movimentacao/registrar-movimentacao.component';
import { BaixarBemComponent } from './funcionalidades/baixar-bem/baixar-bem.component';
import { CriarDepComponent } from './funcionalidades/cruds/depto/criar-dep/criar-dep.component';
import { CriarBpComponent } from './funcionalidades/cruds/bp/criar-bp/criar-bp.component';
import { BpComponent } from './funcionalidades/cruds/bp/bp.component';
import { DeptoComponent } from './funcionalidades/cruds/depto/depto.component';
import { SalaComponent } from './funcionalidades/cruds/sala/sala.component';
import { CriarSalaComponent } from './funcionalidades/cruds/sala/criar-sala/criar-sala.component';
import { PredioComponent } from './funcionalidades/cruds/predio/predio.component';
import { CriarPredioComponent } from './funcionalidades/cruds/predio/criar-predio/criar-predio.component';
import {PesquisarBemUserComponent} from './funcionalidades/pesquisar-bem-user/pesquisar-bem-user.component';
import { EmitirInventarioComponent } from './funcionalidades/emitir-inventario/emitir-inventario.component';
import { RelatorioComponent } from './funcionalidades/relatorio/relatorio.component';
import { GrupoMateiralPorSalaComponent } from './funcionalidades/relatorio/grupo-mateiral-por-sala/grupo-mateiral-por-sala.component';
import {MovimentacaoEntradaComponent} from './funcionalidades/movimentacao/movimentacao-entrada.component';
import {MovimentacaoSaidaComponent} from './funcionalidades/movimentacao/movimentacao-saida.component';
import { GuiaComponent } from './funcionalidades/guia/guia.component';
import { RegistrarOrdemServicoComponent } from './funcionalidades/registrar-ordem-servico/registrar-ordem-servico.component';
import { BpService } from './funcionalidades/cruds/bp/bp.service';
import { OrdemServicoService } from './funcionalidades/registrar-ordem-servico/ordem-servico.service';
import { PesquisarBensComponent } from './funcionalidades/cruds/bp/pesquisar-bens/pesquisar-bens.component'

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    LocalComponent,
    AddLocalComponent,
    AnonimoComponent,
    UsuariosComponent,
    ChefeComponent,
    AdminComponent,
    PesquisarBemComponent,
    PesquisarBemUserComponent,
    RegistrarMovimentacaoComponent,
    RegistrarOrdemServicoComponent,
    BaixarBemComponent,
    CriarDepComponent,
    CriarBpComponent,
    BpComponent,
    DeptoComponent,
    SalaComponent,
    CriarSalaComponent,
    PredioComponent,
    CriarPredioComponent,
    EmitirInventarioComponent,
    RelatorioComponent,
    GrupoMateiralPorSalaComponent,
    MovimentacaoEntradaComponent,
    MovimentacaoSaidaComponent,
    GuiaComponent,
    PesquisarBensComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
