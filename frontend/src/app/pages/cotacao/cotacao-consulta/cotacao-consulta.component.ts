import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CotacaoDto, CotacaoService } from '../../../services/cotacao.service';

@Component({
	selector: 'app-cotacao-consulta',
	standalone: true,
	imports: [CommonModule],
	templateUrl: './cotacao-consulta.component.html',
	styleUrl: './cotacao-consulta.component.scss',
})
export class CotacaoConsultaComponent implements OnInit {
	cotacoes: CotacaoDto[] = [];

	constructor(private cotacaoService: CotacaoService) {}

	ngOnInit(): void {
		this.carregaCotacoes();
	}

	carregaCotacoes(): void {
		this.cotacaoService.getCotacoes().subscribe({
			next: (data) => (this.cotacoes = data),
			error: (err) => console.error('Erro ao carregar cotações', err),
		});
	}
}
