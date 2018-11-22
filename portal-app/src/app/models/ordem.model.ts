export class Ordem {
    num: string;
    dataAbertura: Date = new Date();
    dataFechamento: Date = new Date();
    motivo: string;
    prestadoraServico: string;
    valor: number;
    situacao: number;
}