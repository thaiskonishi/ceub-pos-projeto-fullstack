import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { enviroment } from '../enviroment';

export interface SetorDto {
	id: number;
	nomeSetor: string;
	descricao: string;
}

@Injectable({
	providedIn: 'root',
})
export class SetorService {
	private pathSetor = '/setor';

	constructor(private http: HttpClient) {}

	listarSetores(): Observable<SetorDto[]> {
		return this.http.get<SetorDto[]>(
			`${enviroment.endpoint}${this.pathSetor}/lista`
		);
	}

	recuperaSetor(id: number): Observable<SetorDto> {
		return this.http.get<SetorDto>(
			`${enviroment.endpoint}${this.pathSetor}/detalhes/${id}`
		);
	}

	salvarSetor(setor: SetorDto): Observable<SetorDto> {
		return this.http.post<SetorDto>(
			`${enviroment.endpoint}${this.pathSetor}`,
			setor
		);
	}

	deletarSetor(id: number): Observable<void> {
		return this.http.delete<void>(
			`${enviroment.endpoint}${this.pathSetor}/${id}`
		);
	}

	atualizarSetor(setor: SetorDto): Observable<SetorDto> {
		return this.http.put<SetorDto>(
			`${enviroment.endpoint}${this.pathSetor}/${setor.id}`,
			setor
		);
	}
}
