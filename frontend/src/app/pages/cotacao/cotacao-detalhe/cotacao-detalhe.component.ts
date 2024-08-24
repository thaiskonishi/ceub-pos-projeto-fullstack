import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CotacaoDto, CotacaoService } from '../../../services/cotacao.service';

@Component({
	selector: 'app-cotacao-detalhe',
	standalone: true,
	imports: [CommonModule, FormsModule],
	templateUrl: './cotacao-detalhe.component.html',
	styleUrl: './cotacao-detalhe.component.scss',
})
export class CotacaoDetalheComponent implements OnInit {
	cotacao: CotacaoDto = { id: 0, ticker: '', data: new Date(), cotacao: 0 };
	isEditMode: boolean = false;

	constructor(
		private cotacaoService: CotacaoService,
		private route: ActivatedRoute,
		private router: Router
	) {}

	ngOnInit(): void {
		const id = this.route.snapshot.paramMap.get('id');
		if (id) {
			this.isEditMode = true;
			this.cotacaoService.recuperaCotacao(parseInt(id)).subscribe((data) => {
				this.cotacao = data;
			});
		}
	}

	salvar(): void {
		if (this.isEditMode) {
			this.cotacaoService.atualizarCotacao(this.cotacao).subscribe(() => {
				this.router.navigate(['/cotacoes']);
			});
		} else {
			this.cotacaoService.salvarCotacao(this.cotacao).subscribe(() => {
				this.router.navigate(['/cotacoes']);
			});
		}
	}

	deletar(): void {
		this.cotacaoService.deletarCotacao(this.cotacao.id).subscribe(() => {
			this.router.navigate(['/cotacoes']);
		});
	}

	cancelar(): void {
		this.router.navigate(['/cotacoes']);
	}

}
