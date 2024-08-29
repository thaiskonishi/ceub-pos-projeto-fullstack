import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
	HistoricoCotacaoDto,
	HistoricoCotacaoService,
} from '../../../services/historico-cotacao.service';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

@Component({
	selector: 'app-historico-cotacao-consulta',
	standalone: true,
	imports: [CommonModule, MatButtonModule, MatTableModule, RouterModule],
	templateUrl: './historico-cotacao-consulta.component.html',
	styleUrls: ['./historico-cotacao-consulta.component.scss'],
})
export class HistoricoCotacaoConsultaComponent implements OnInit {
	displayedColumns: string[] = ['ID', 'TICKER', 'DATA', 'COTACAO'];
	historicoCotacoes: HistoricoCotacaoDto[] = [];
	idAtivo!: number;

	constructor(
		private historicoCotacaoService: HistoricoCotacaoService,
		private route: ActivatedRoute
	) {}

	ngOnInit(): void {
		this.route.paramMap.subscribe((params) => {
			this.idAtivo = +params.get('id')!;
			this.carregaHistoricoCotacoes();
		});
	}

	carregaHistoricoCotacoes(): void {
		this.historicoCotacaoService.getHistoricoCotacoes(this.idAtivo).subscribe({
			next: (data) => (this.historicoCotacoes = data),
			error: (err) =>
				console.error('Erro ao carregar histórico de cotações', err),
		});
	}
}
