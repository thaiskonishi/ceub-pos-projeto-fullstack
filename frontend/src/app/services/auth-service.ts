import { Injectable } from '@angular/core';
import { enviroment } from '../enviroment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, Observable, of } from 'rxjs';

export interface UsuarioForm {
	login: string;
	password: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private ativoPath = '/login';
  private apiUrl = `${enviroment.endpoint}${this.ativoPath}`;

  constructor(private http: HttpClient) {}

  private isAuthenticated = false;

  login(credenciais: UsuarioForm): Observable<boolean> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });

    return this.http.post<UsuarioForm>(`${this.apiUrl}`, credenciais, { observe: 'response' }).pipe(
      map(response => {
        if (response.status === 200) {
          this.isAuthenticated = true;
          return true;
        } else {
          this.isAuthenticated = false;
          return false;
        }
      }),
      catchError(() => {
        this.isAuthenticated = false;
        return of(false);
      })
    );
  }

  logout() {
    this.isAuthenticated = false;
  }

  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }
}
