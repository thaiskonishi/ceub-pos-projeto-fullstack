import { Component, OnInit } from '@angular/core';
import { SetorDto, SetorService } from '../../../services/setor.service';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

@Component({
	selector: 'app-setor-consulta',
	standalone: true,
	imports: [CommonModule, MatButtonModule, MatTableModule, RouterModule],
	templateUrl: './setor-consulta.component.html',
	styleUrl: './setor-consulta.component.scss',
})
export class SetorConsultaComponent implements OnInit {
	displayedColumns: string[] = ['ID', 'SETOR', 'DESCRICAO', 'EDITAR'];
	setores: SetorDto[] = [];

	constructor(private setorService: SetorService, private router: Router) {}

	ngOnInit(): void {
		this.carregaSetores();
	}

	carregaSetores() {
		this.setorService.listarSetores().subscribe({
			next: (data) => (this.setores = data),
			error: (err) => console.error('Erro ao carregar setores', err),
		});
	}

	editarSetor(id: number): void {
		this.router.navigate(['/setores/detalhes', id]);
	}
}
