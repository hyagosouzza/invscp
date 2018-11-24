import {Departamento} from "./departamento.model";

export class User {
  id: string;
  nome: string;
  senha: string;
  email: string;
  profile: number;
  departamento: Departamento;
}
