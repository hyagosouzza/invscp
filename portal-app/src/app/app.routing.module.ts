import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AnonimoComponent } from './profiles/anonimo/anonimo.component';
import { UsuariosComponent } from './profiles/usuarios/usuarios.component';
import { ChefeComponent } from './profiles/chefe/chefe.component';
import { AdminComponent } from './profiles/admin/admin.component';
import { UserComponent } from './funcionalidades/cruds/user/user.component';
import { AddUserComponent } from './funcionalidades/cruds/user/add-user.component';
import { AddLocalComponent } from './funcionalidades/cruds/local/add-local/add-local.component';
import { LocalComponent } from './funcionalidades/cruds/local/local.component';
import { CriarDepComponent } from './funcionalidades/cruds/depto/criar-dep/criar-dep.component';
import { CriarBpComponent } from './funcionalidades/cruds/bp/criar-bp/criar-bp.component';
import { DeptoComponent } from './funcionalidades/cruds/depto/depto.component';
import { BpComponent } from './funcionalidades/cruds/bp/bp.component';
import { CriarPredioComponent } from './funcionalidades/cruds/predio/criar-predio/criar-predio.component';
import { PredioComponent } from './funcionalidades/cruds/predio/predio.component';
import { SalaComponent } from './funcionalidades/cruds/sala/sala.component';
import { CriarSalaComponent } from './funcionalidades/cruds/sala/criar-sala/criar-sala.component';
import { EmitirInventarioComponent } from './funcionalidades/emitir-inventario/emitir-inventario.component';
import { RelatorioComponent } from './funcionalidades/relatorio/relatorio.component';
import { GrupoMateiralPorSalaComponent } from './funcionalidades/relatorio/grupo-mateiral-por-sala/grupo-mateiral-por-sala.component';
import {MovimentacaoEntradaComponent} from './funcionalidades/movimentacao/movimentacao-entrada.component';
import {MovimentacaoSaidaComponent} from './funcionalidades/movimentacao/movimentacao-saida.component';
import { GuiaComponent } from './funcionalidades/guia/guia.component';

const routes: Routes = [
  { path: '', redirectTo: 'anonimo', pathMatch: 'full' },
  { path: 'anonimo', component: AnonimoComponent },
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'chefe', component: ChefeComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'admin/users', component: UserComponent },
  { path: 'admin/adduser', component: AddUserComponent },
  { path: 'admin/locais', component: LocalComponent },
  { path: 'admin/addlocal', component: AddLocalComponent },
  { path: 'admin/deptos', component: DeptoComponent },
  { path: 'admin/adddepto', component: CriarDepComponent },
  { path: 'admin/bps', component: BpComponent },
  { path: 'admin/addbp', component: CriarBpComponent },
  { path: 'admin/salas', component: SalaComponent },
  { path: 'admin/addsala', component: CriarSalaComponent },
  { path: 'admin/addpredio', component: CriarPredioComponent },
  { path: 'admin/predios', component: PredioComponent },
  { path: 'admin/invent', component: EmitirInventarioComponent },
  { path: 'admin/relat', component: RelatorioComponent},
  { path: 'admin/relat/gm', component: GrupoMateiralPorSalaComponent},
  { path: 'admin/entradas', component: MovimentacaoEntradaComponent},
  { path: 'admin/saidas', component: MovimentacaoSaidaComponent},
  { path: 'admin/guia', component: GuiaComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
