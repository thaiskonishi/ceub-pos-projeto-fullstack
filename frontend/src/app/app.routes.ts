import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';

export const routes: Routes = [
		{
			path: '',
			redirectTo: 'login', // Redireciona para a rota /login quando a raiz é acessada
			pathMatch: 'full' // Garante que a rota seja redirecionada apenas se o caminho for exatamente ''
		},
		{
			path: 'login',
			component: LoginComponent,
			title: 'Login',
		},
		{
			path: '',
			component: LoginComponent,
		},

];

