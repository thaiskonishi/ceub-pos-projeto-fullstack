import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoAtivoConsultaComponent } from './tipo-ativo-consulta.component';

describe('TipoAtivoConsultaComponent', () => {
	let component: TipoAtivoConsultaComponent;
	let fixture: ComponentFixture<TipoAtivoConsultaComponent>;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			imports: [TipoAtivoConsultaComponent],
		}).compileComponents();

		fixture = TestBed.createComponent(TipoAtivoConsultaComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
