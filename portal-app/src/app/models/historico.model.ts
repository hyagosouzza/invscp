import { Bem } from "./bem.model";
import { Movimentacao } from "./movimentacao.model";
import { OrdemServico } from "./ordem-servico.model";

export class Historico {
    bem: Bem;
    movimentacoes: Movimentacao[];
    ordens: OrdemServico[];
}
