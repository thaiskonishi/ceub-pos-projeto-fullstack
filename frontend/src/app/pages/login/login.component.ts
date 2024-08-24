import { Component} from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
	selector: 'app-login',
	standalone: true,
	imports: [CommonModule],
	templateUrl: './login.component.html',
	styleUrl: './login.component.scss',
})
export class LoginComponent {
	email:string ='';
	senha:string='';

	constructor(private router: Router) {}

validarLogin(email: string,senha:string ) : void{
if(email==='email@gmail.com' && senha==='12345678'){
	this.router.navigate(['/cotacoes']);

}else{
	alert('Credenciais inválidas');}
}

}

