import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CotacaoDto, CotacaoService } from '../../../services/cotacao.service';
import { Router, RouterModule } from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';

@Component({
	selector: 'app-cotacao-consulta',
	standalone: true,
	imports: [CommonModule,MatButtonModule,MatTableModule,RouterModule],
	templateUrl: './cotacao-consulta.component.html',
	styleUrl: './cotacao-consulta.component.scss',
})
export class CotacaoConsultaComponent implements OnInit {
	displayedColumns: string[] = ['ID', 'TICKER', 'DATA','COTAÇÃO', 'EDITAR', 'HISTORICO'];
	cotacoes: CotacaoDto[] = [];

	constructor(private cotacaoService: CotacaoService, private router: Router) {}

	ngOnInit(): void {
		this.carregaCotacoes();
	}

	carregaCotacoes(): void {
		this.cotacaoService.listarCotacoes().subscribe({
			next: (data) => (this.cotacoes = data),
			error: (err) => console.error('Erro ao carregar cotações', err),
		});
	}

	editarCotacao(id: number): void {
		this.router.navigate(['/cotacoes/detalhes', id]);
	}
}
