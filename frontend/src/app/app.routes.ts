import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SetorConsultaComponent } from './pages/setor/setor-consulta/setor-consulta.component';
import { TipoAtivoConsultaComponent } from './pages/tipo-ativo/tipo-ativo-consulta/tipo-ativo-consulta.component';
import { HistoricoCotacaoConsultaComponent } from './pages/historico-cotacao/historico-cotacao-consulta/historico-cotacao-consulta.component';
import { CotacaoConsultaComponent } from './pages/cotacao/cotacao-consulta/cotacao-consulta.component';
import { AtivoConsultaComponent } from './pages/ativo/ativo-consulta/ativo-consulta.component';
import { TipoAtivoDetalheComponent } from './pages/tipo-ativo/tipo-ativo-detalhe/tipo-ativo-detalhe.component';
import { SetorDetalheComponent } from './pages/setor/setor-detalhe/setor-detalhe.component';
import { CotacaoDetalheComponent } from './pages/cotacao/cotacao-detalhe/cotacao-detalhe.component';
import { AtivoDetalheComponent } from './pages/ativo/ativo-detalhe/ativo-detalhe.component';
import { AuthGuard } from './pages/login/auth-guard';

export const routes: Routes = [
	{
		path: '',
		redirectTo: 'login', // Redireciona para a rota /login quando a raiz é acessada
		pathMatch: 'full', // Garante que a rota seja redirecionada apenas se o caminho for exatamente ''
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
	{ path: 'tipos-ativo', component: TipoAtivoConsultaComponent, canActivate: [AuthGuard]  },
	{ path: 'setores', component: SetorConsultaComponent, canActivate: [AuthGuard]  },
	{ path: 'setores/detalhes/:id', component: SetorDetalheComponent, canActivate: [AuthGuard]  },
	{ path: 'setores/novo', component: SetorDetalheComponent, canActivate: [AuthGuard] },
	{
		path: 'historico-cotacoes/:id',
		component: HistoricoCotacaoConsultaComponent, canActivate: [AuthGuard]  
	},
	{ path: 'cotacoes', component: CotacaoConsultaComponent, canActivate: [AuthGuard]  },
	{ path: 'cotacoes/detalhes/:id', component: CotacaoDetalheComponent, canActivate: [AuthGuard]  },
	{ path: 'cotacoes/novo', component: CotacaoDetalheComponent, canActivate: [AuthGuard] },
	{ path: 'ativos', component: AtivoConsultaComponent, canActivate: [AuthGuard]  },
	{ path: 'ativos/detalhes/:id', component: AtivoDetalheComponent, canActivate: [AuthGuard]  },
	{ path: 'ativos/novo', component: AtivoDetalheComponent, canActivate: [AuthGuard] },
	{ path: 'tipos-ativo', component: TipoAtivoConsultaComponent, canActivate: [AuthGuard]  },
	{ path: 'tipos-ativo/detalhes/:id', component: TipoAtivoDetalheComponent, canActivate: [AuthGuard]  },
	{ path: 'tipos-ativo/novo', component: TipoAtivoDetalheComponent, canActivate: [AuthGuard]  },

	{ path: '\*\*', component: CotacaoConsultaComponent, canActivate: [AuthGuard] },
];
