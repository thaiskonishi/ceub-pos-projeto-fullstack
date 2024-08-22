import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoricoCotacaoConsultaComponent } from './historico-cotacao-consulta.component';

describe('HistoricoCotacaoConsultaComponent', () => {
  let component: HistoricoCotacaoConsultaComponent;
  let fixture: ComponentFixture<HistoricoCotacaoConsultaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HistoricoCotacaoConsultaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HistoricoCotacaoConsultaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
