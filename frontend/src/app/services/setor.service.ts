import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface SetorDto {
  id: number;
  nomeSetor: string;
  descricao: string;
}

@Injectable({
  providedIn: 'root'
})
export class SetorService {

  private apiUrl = 'http://localhost:8080/setor/lista';  // Altere para a URL real da sua API

  constructor(private http: HttpClient) { }

  listarSetores(): Observable<SetorDto[]> {
    return this.http.get<SetorDto[]>(this.apiUrl);
  }
}