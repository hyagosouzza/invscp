import { Sala } from "./sala.model";

export class Bem {
    id: string;
    dataAquis: Date;
    dataDaBaixa: Date;
    denominacao: string;
    especificacao: string;
    garantia: Date;
    catDepre: number;
    grupoMaterial: number;
    marca: string;
    motivoDaBaixa: number;
    numNotaFiscal: string;
    numTombamento: string;
    obsrBaixa: string;
    situacao: number;
    valorAtual: number;
    valorCompra: number;
    vidaUtil: Date;
    sala: Sala;
}
