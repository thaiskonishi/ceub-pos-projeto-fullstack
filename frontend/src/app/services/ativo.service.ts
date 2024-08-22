import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { enviroment } from '../enviroment';

const ativoPath = '/ativo/lista';

export interface AtivoDto {
	id: number;
	nome: string;
	ticker: string;
	dataFundacao: Date;
	setor: string;
	tipoAtivo: string;
}

@Injectable({
	providedIn: 'root',
})
export class AtivoService {
	private apiUrl = `${enviroment.endpoint}${ativoPath}`;

	constructor(private http: HttpClient) {}

	getAtivos(): Observable<AtivoDto[]> {
		return this.http.get<AtivoDto[]>(this.apiUrl);
	}
}
