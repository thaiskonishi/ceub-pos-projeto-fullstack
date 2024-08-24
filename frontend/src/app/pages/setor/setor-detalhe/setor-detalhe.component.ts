import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { SetorDto, SetorService } from '../../../services/setor.service';

@Component({
	selector: 'app-setor-detalhe',
	standalone: true,
	imports: [CommonModule, FormsModule],
	templateUrl: './setor-detalhe.component.html',
	styleUrl: './setor-detalhe.component.scss',
})
export class SetorDetalheComponent implements OnInit {
	setor: SetorDto = { id: 0, nomeSetor: '', descricao: '' };
	isEditMode: boolean = false;

	constructor(
		private setorService: SetorService,
		private route: ActivatedRoute,
		private router: Router
	) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    if (id) {
      this.isEditMode = true;
      this.setorService.recuperaSetor(id).subscribe({
        next: (data) => this.setor = data,
        error: (err) => console.error('Erro ao carregar setor', err)
      });
    }
  }

  salvar(): void {
    if (this.isEditMode) {
      this.setorService.atualizarSetor(this.setor).subscribe({
        next: () => this.router.navigate(['/setores']),
        error: (err) => console.error('Erro ao salvar setor', err)
      });
    } else {
      this.setorService.salvarSetor(this.setor).subscribe({
        next: () => this.router.navigate(['/setores']),
        error: (err) => console.error('Erro ao criar setor', err)
      });
    }
  }

  deletar(): void {
    this.setorService.deletarSetor(this.setor.id).subscribe({
      next: () => this.router.navigate(['/setores']),
      error: (err) => console.error('Erro ao deletar setor', err)
    });
  }

  cancelar(): void {
    this.router.navigate(['/setores']);
  }
}
