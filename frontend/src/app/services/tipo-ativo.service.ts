import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { enviroment } from '../enviroment';

export interface TipoAtivoDto {
	id: number;
	nomeTipoAtivo: string;
	descricao: string;
}

@Injectable({
	providedIn: 'root',
})
export class TipoAtivoService {
	private pathTipoAtivo = '/tipo-ativo';

	constructor(private http: HttpClient) {}

	listarTiposAtivo(): Observable<TipoAtivoDto[]> {
		return this.http.get<TipoAtivoDto[]>(
			`${enviroment.endpoint}${this.pathTipoAtivo}/lista`
		);
	}

	recuperaTipoAtivo(id: number): Observable<TipoAtivoDto> {
		return this.http.get<TipoAtivoDto>(
			`${enviroment.endpoint}${this.pathTipoAtivo}/detalhes/${id}`
		);
	}

	salvarTipoAtivo(tipoAtivo: TipoAtivoDto): Observable<TipoAtivoDto> {
		return this.http.post<TipoAtivoDto>(
			`${enviroment.endpoint}${this.pathTipoAtivo}`,
			tipoAtivo
		);
	}

	deletarTipoAtivo(id: number): Observable<void> {
		return this.http.delete<void>(
			`${enviroment.endpoint}${this.pathTipoAtivo}/${id}`
		);
	}

	atualizarTipoAtivo(tipoAtivo: TipoAtivoDto): Observable<TipoAtivoDto> {
		return this.http.put<TipoAtivoDto>(
			`${enviroment.endpoint}${this.pathTipoAtivo}/${tipoAtivo.id}`,
			tipoAtivo
		);
	}
}
