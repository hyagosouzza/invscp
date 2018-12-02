import { Sala } from './sala.model';
import {Bem} from './bem.model';
import {User} from './user.model';

export class Movimentacao {
    id: string;
    etapa: number;
    bem: Bem;
    origem: Sala;
    destino: Sala;
    solicitante: User;
    dataSaida: Date;
    aprovadorSaida: User;
    dataEntrada: Date;
    aprovadorEntrada: User;
    dataCancelamento: Date;
    userCancelamento: User;
}
