import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { enviroment } from '../enviroment';

export interface CotacaoDto {
	id: number;
	ticker: string;
	data: Date;
	cotacao: number;
}

@Injectable({
	providedIn: 'root',
})
export class CotacaoService {
	private pathCotacao = '/cotacao';

	private apiUrl = `${enviroment.endpoint}${this.pathCotacao}`;

	constructor(private http: HttpClient) {}

	listarCotacoes(): Observable<CotacaoDto[]> {
		return this.http.get<CotacaoDto[]>(`${this.apiUrl}/lista`);
	}

	recuperaCotacao(id: number): Observable<CotacaoDto> {
		return this.http.get<CotacaoDto>(`${this.apiUrl}/detalhes/${id}`);
	}

	salvarCotacao(tipoAtivo: CotacaoDto): Observable<CotacaoDto> {
		return this.http.post<CotacaoDto>(`${this.apiUrl}`, tipoAtivo);
	}

	deletarCotacao(id: number): Observable<void> {
		return this.http.delete<void>(`${this.apiUrl}/${id}`);
	}

	atualizarCotacao(tipoAtivo: CotacaoDto): Observable<CotacaoDto> {
		return this.http.put<CotacaoDto>(
			`${this.apiUrl}/${tipoAtivo.id}`,
			tipoAtivo
		);
	}
}
