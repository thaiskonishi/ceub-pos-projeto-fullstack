import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtivoConsultaComponent } from './ativo-consulta.component';

describe('AtivoConsultaComponent', () => {
  let component: AtivoConsultaComponent;
  let fixture: ComponentFixture<AtivoConsultaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AtivoConsultaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AtivoConsultaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
