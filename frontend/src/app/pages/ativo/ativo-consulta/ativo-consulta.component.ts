import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AtivoDto, AtivoService } from '../../../services/ativo.service';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { Router } from '@angular/router';

@Component({
	selector: 'app-ativo-consulta',
	standalone: true,
	imports: [CommonModule, MatButtonModule,MatTableModule],
	templateUrl: './ativo-consulta.component.html',
	styleUrl: './ativo-consulta.component.scss',
})

export class AtivoConsultaComponent implements OnInit {
	ativos: AtivoDto[] = [];
	displayedColumns: string[] = ['ID', 'NOME', 'TICKER', 'DATA DE FUNDAÇÃO','SETOR','TIPO DE ATIVO', 'EDITAR'];
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
