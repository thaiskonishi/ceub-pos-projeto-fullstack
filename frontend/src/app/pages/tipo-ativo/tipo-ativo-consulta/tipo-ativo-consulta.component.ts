import { Component, OnInit } from '@angular/core';
import {
	TipoAtivoDto,
	TipoAtivoService,
} from '../../../services/tipo-ativo.service';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

@Component({
	selector: 'app-tipo-ativo-consulta',
	standalone: true,
	imports: [CommonModule, MatButtonModule, MatTableModule, RouterModule],
	templateUrl: './tipo-ativo-consulta.component.html',
	styleUrl: './tipo-ativo-consulta.component.scss',
})
export class TipoAtivoConsultaComponent implements OnInit {
	displayedColumns: string[] = ['ID', 'NOME', 'DESCRICAO', 'EDITAR'];
	tiposAtivo: TipoAtivoDto[] = [];

	constructor(
		private tipoAtivoService: TipoAtivoService,
		private router: Router
	) {}

	ngOnInit(): void {
		this.carregaTiposAtivo();
	}

	private carregaTiposAtivo() {
		this.tipoAtivoService.listarTiposAtivo().subscribe({
			next: (data) => (this.tiposAtivo = data),
			error: (err) => console.error('Erro ao carregar cotações', err),
		});
	}

	editarTipoAtivo(id: number): void {
		this.router.navigate(['/tipos-ativo/detalhes/', id]);
	}
}
