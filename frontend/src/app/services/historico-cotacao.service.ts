import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface HistoricoCotacaoDto {
  id: number;
  ticker: string;
  data: string;
  cotacao: number;
}

@Injectable({
  providedIn: 'root'
})
export class HistoricoCotacaoService {
  private apiUrl = 'http://localhost:8080/historico-cotacao/'; 

  constructor(private http: HttpClient) { }

  getHistoricoCotacoes(idAtivo: number): Observable<HistoricoCotacaoDto[]> {
    const url = `${this.apiUrl}/${idAtivo}`;
    return this.http.get<HistoricoCotacaoDto[]>(url);
  }
}
