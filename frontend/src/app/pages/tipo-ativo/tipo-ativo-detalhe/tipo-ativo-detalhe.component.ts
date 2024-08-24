import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TipoAtivoDto, TipoAtivoService } from '../../../services/tipo-ativo.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-tipo-ativo-detalhe',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './tipo-ativo-detalhe.component.html',
  styleUrl: './tipo-ativo-detalhe.component.scss'
})
export class TipoAtivoDetalheComponent implements OnInit {
  tipoAtivo: TipoAtivoDto = { id: 0, nomeTipoAtivo: '', descricao: '' };
  isEditMode: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private tipoAtivoService: TipoAtivoService
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    if (id) {
      this.isEditMode = true;
      this.tipoAtivoService.recuperaTipoAtivo(id).subscribe({
        next: (data) => this.tipoAtivo = data,
        error: (err) => console.error('Erro ao carregar tipo de ativo', err)
      });
    }
  }

  salvar(): void {
    if (this.isEditMode) {
      this.tipoAtivoService.atualizarTipoAtivo(this.tipoAtivo).subscribe({
        next: () => this.router.navigate(['/tipos-ativo']),
        error: (err) => console.error('Erro ao salvar tipo de ativo', err)
      });
    } else {
      this.tipoAtivoService.salvarTipoAtivo(this.tipoAtivo).subscribe({
        next: () => this.router.navigate(['/tipos-ativo']),
        error: (err) => console.error('Erro ao criar tipo de ativo', err)
      });
    }
  }

  deletar(): void {
    this.tipoAtivoService.deletarTipoAtivo(this.tipoAtivo.id).subscribe({
      next: () => this.router.navigate(['/tipos-ativo']),
      error: (err) => console.error('Erro ao deletar tipo de ativo', err)
    });
  }

  cancelar(): void {
    this.router.navigate(['/tipos-ativo']);
  }
}