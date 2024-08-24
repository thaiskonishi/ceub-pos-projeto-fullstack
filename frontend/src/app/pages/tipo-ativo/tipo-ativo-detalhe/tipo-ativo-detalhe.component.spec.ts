import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoAtivoDetalheComponent } from './tipo-ativo-detalhe.component';

describe('TipoAtivoDetalheComponent', () => {
  let component: TipoAtivoDetalheComponent;
  let fixture: ComponentFixture<TipoAtivoDetalheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TipoAtivoDetalheComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TipoAtivoDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
