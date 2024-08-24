import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SetorDetalheComponent } from './setor-detalhe.component';

describe('SetorDetalheComponent', () => {
  let component: SetorDetalheComponent;
  let fixture: ComponentFixture<SetorDetalheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SetorDetalheComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SetorDetalheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
