import { Bem } from "./bem.model";

export class OrdemServico {
    id: string;
    dataAbertura: Date;
    dataFechamento: Date;
    bem: Bem;
    motivo: string;
    prestadoraDeServico: string;
    valor: number;
    situacao: string;
}