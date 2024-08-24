import { Component, OnInit } from '@angular/core';
import { SetorDto, SetorService } from '../../../services/setor.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
	selector: 'app-setor-consulta',
	standalone: true,
	imports: [CommonModule],
	templateUrl: './setor-consulta.component.html',
	styleUrl: './setor-consulta.component.scss',
})
export class SetorConsultaComponent implements OnInit {
	setores: SetorDto[] = [];

	constructor(private setorService: SetorService, private router: Router ) {}

	ngOnInit(): void {
		this.setorService.listarSetores().subscribe((data: SetorDto[]) => {
			this.setores = data;
		});
	}

	editarSetor(id: number): void {
		this.router.navigate(['/setores/detalhes', id]);
	}
}
