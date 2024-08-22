import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface TipoAtivoDto {
  id: number;
  nomeTipoAtivo: string;
  descricao: string;
}

@Injectable({
  providedIn: 'root'
})
export class TipoAtivoService {

  private apiUrl = 'http://localhost:8080/tipo-ativo/lista';

  constructor(private http: HttpClient) { }

  listarTiposAtivo(): Observable<TipoAtivoDto[]> {
    return this.http.get<TipoAtivoDto[]>(this.apiUrl);
  }
}