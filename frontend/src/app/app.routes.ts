import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SetorConsultaComponent } from './pages/setor/setor-consulta/setor-consulta.component';
import { TipoAtivoConsultaComponent } from './pages/tipo-ativo/tipo-ativo-consulta/tipo-ativo-consulta.component';
import { HistoricoCotacaoConsultaComponent } from './pages/historico-cotacao/historico-cotacao-consulta/historico-cotacao-consulta.component';

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
		{ path: 'tipo-ativo', component: TipoAtivoConsultaComponent },
  		{ path: 'setor', component: SetorConsultaComponent },
		{ path: 'historico-cotacoes/:id', component: HistoricoCotacaoConsultaComponent },

];