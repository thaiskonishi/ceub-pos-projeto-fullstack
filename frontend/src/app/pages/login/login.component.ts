import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth-service';

@Component({
	selector: 'app-login',
	standalone: true,
	imports: [CommonModule],
	templateUrl: './login.component.html',
	styleUrl: './login.component.scss',
})
export class LoginComponent {
	email: string = '';
	senha: string = '';

	constructor(private router: Router, private authService: AuthService) {}

	validarLogin(email: string, senha: string): void {
		const credenciais = { login: email, password: senha };

		this.authService.login(credenciais).subscribe((isLoggedIn) => {
			if (isLoggedIn) {
				this.router.navigate(['/cotacoes']);
			} else {
				alert('Credenciais inválidas');
			}
		});
	}
}
