import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AtivoDto, AtivoService } from '../../../services/ativo.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SetorDto, SetorService } from '../../../services/setor.service';
import { TipoAtivoDto, TipoAtivoService } from '../../../services/tipo-ativo.service';

@Component({
	selector: 'app-ativo-detalhe',
	standalone: true,
	imports: [CommonModule, FormsModule],
	templateUrl: './ativo-detalhe.component.html',
	styleUrl: './ativo-detalhe.component.scss',
})
export class AtivoDetalheComponent {
	ativo: AtivoDto = {
		id: 0,
		idSetor: 0,
		idTipoAtivo: 0,
		nome: '',
		ticker: '',
		dataFundacao: '',
		setor: '',
		tipoAtivo: '',
	};
	isEditMode: boolean = false;
	setores: SetorDto[] = [];
	tiposAtivo: TipoAtivoDto[] = [];

	constructor(
		private ativoService: AtivoService,
		private setorService: SetorService,
		private tipoAtivoService: TipoAtivoService,
		private route: ActivatedRoute,
		private router: Router
	) {}

	ngOnInit(): void {
		var id = this.route.snapshot.paramMap.get('id');

		this.setorService.listarSetores().subscribe((data) => {
			this.setores = data;
		});

		this.tipoAtivoService.listarTiposAtivo().subscribe((data) => {
			this.tiposAtivo = data;
		});

		if (id) {
			this.isEditMode = true;
			this.ativoService.recuperaAtivo(parseInt(id)).subscribe((data) => {
				this.ativo = data;
        this.ativo.dataFundacao = this.ativo.dataFundacao.split('T')[0];
			});
		}
	}

	salvar(): void {
		if (this.isEditMode) {
			this.ativoService.atualizarAtivo(this.ativo).subscribe(() => {
				this.router.navigate(['/ativos']);
			});
		} else {
			this.ativoService.salvarAtivo(this.ativo).subscribe(() => {
				this.router.navigate(['/ativos']);
			});
		}
	}

	deletar(): void {
		this.ativoService.deletarAtivo(this.ativo.id).subscribe(() => {
			this.router.navigate(['/ativos']);
		});
	}

	cancelar(): void {
		this.router.navigate(['/ativos']);
	}
}
