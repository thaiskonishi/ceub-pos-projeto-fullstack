import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoDetalheComponent } from './cotacao-detalhe.component';

describe('CotacaoDetalheComponent', () => {
  let component: CotacaoDetalheComponent;
  let fixture: ComponentFixture<CotacaoDetalheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CotacaoDetalheComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CotacaoDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
