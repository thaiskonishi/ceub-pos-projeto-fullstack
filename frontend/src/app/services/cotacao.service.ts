import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { enviroment } from '../enviroment';

const cotacaoPath = '/cotacao/lista';

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
	private apiUrl = `${enviroment.endpoint}${cotacaoPath}`;

	constructor(private http: HttpClient) {}

	getCotacoes(): Observable<CotacaoDto[]> {
		return this.http.get<CotacaoDto[]>(this.apiUrl);
	}
}
