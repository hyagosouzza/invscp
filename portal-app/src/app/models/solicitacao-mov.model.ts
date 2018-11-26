import {Bem} from "./bem.model";
import {Sala} from "./sala.model";
import {User} from "./user.model";

export class SolicitacaoMov {
  bem: Bem;
  destino: Sala;
  solicitante: User;
}
