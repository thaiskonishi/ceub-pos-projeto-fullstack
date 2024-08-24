import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AtivoDto, AtivoService } from '../../../services/ativo.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-ativo-consulta',
	standalone: true,
	imports: [CommonModule],
	templateUrl: './ativo-consulta.component.html',
	styleUrl: './ativo-consulta.component.scss',
})
export class AtivoConsultaComponent implements OnInit {
	ativos: AtivoDto[] = [];

	constructor(private ativoService: AtivoService, private router: Router) {}

	ngOnInit(): void {
		this.carregaAtivos();
	}

	carregaAtivos(): void {
		this.ativoService.listaAtivos().subscribe({
			next: (data) => (this.ativos = data),
			error: (err) => console.error('Erro ao carregar ativos', err),
		});
	}

	editarAtivo(id: number): void {
		this.router.navigate(['/ativos/detalhes', id]);
	}
}
