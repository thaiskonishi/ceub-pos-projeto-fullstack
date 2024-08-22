import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AtivoDto, AtivoService } from '../../../services/ativo.service';

@Component({
	selector: 'app-ativo-consulta',
	standalone: true,
	imports: [CommonModule],
	templateUrl: './ativo-consulta.component.html',
	styleUrl: './ativo-consulta.component.scss',
})
export class AtivoConsultaComponent implements OnInit {
	ativos: AtivoDto[] = [];

	constructor(private ativoService: AtivoService) {}

	ngOnInit(): void {
		this.loadAtivos();
	}

	loadAtivos(): void {
		this.ativoService.getAtivos().subscribe({
			next: (data) => (this.ativos = data),
			error: (err) => console.error('Erro ao carregar ativos', err),
		});
	}
}
