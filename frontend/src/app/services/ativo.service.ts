import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { enviroment } from '../enviroment';

export interface AtivoDto {
	id: number;
	idSetor: number;
	idTipoAtivo: number;
	nome: string;
	ticker: string;
	dataFundacao: string;
	setor: string;
	tipoAtivo: string;
}

@Injectable({
	providedIn: 'root',
})
export class AtivoService {
	private ativoPath = '/ativo';

	private apiUrl = `${enviroment.endpoint}${this.ativoPath}`;

	constructor(private http: HttpClient) {}

	listaAtivos(): Observable<AtivoDto[]> {
		return this.http.get<AtivoDto[]>(`${this.apiUrl}/lista`);
	}

	recuperaAtivo(id: number): Observable<AtivoDto> {
		return this.http.get<AtivoDto>(`${this.apiUrl}/detalhes/${id}`);
	}

	salvarAtivo(cotacao: AtivoDto): Observable<AtivoDto> {
		return this.http.post<AtivoDto>(`${this.apiUrl}`, cotacao);
	}

	deletarAtivo(id: number): Observable<void> {
		return this.http.delete<void>(`${this.apiUrl}/${id}`);
	}

	atualizarAtivo(cotacao: AtivoDto): Observable<AtivoDto> {
		return this.http.put<AtivoDto>(
			`${this.apiUrl}/${cotacao.id}`,
			cotacao
		);
	}
}
