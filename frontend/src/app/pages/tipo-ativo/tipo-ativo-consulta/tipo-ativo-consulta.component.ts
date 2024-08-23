import { Component, OnInit } from '@angular/core';
import {
	TipoAtivoDto,
	TipoAtivoService,
} from '../../../services/tipo-ativo.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
	selector: 'app-tipo-ativo-consulta',
	standalone: true,
	imports: [CommonModule],
	templateUrl: './tipo-ativo-consulta.component.html',
	styleUrl: './tipo-ativo-consulta.component.scss',
})
export class TipoAtivoConsultaComponent implements OnInit {
	tiposAtivo: TipoAtivoDto[] = [];

	constructor(private tipoAtivoService: TipoAtivoService, private router: Router) {}

	ngOnInit(): void {
		this.tipoAtivoService.listarTiposAtivo().subscribe((data) => {
			this.tiposAtivo = data;
		});
	}

	editarTipoAtivo(id: number): void {
		this.router.navigate(['/tipos-ativo/detalhes/', id]);
	}
}
