import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CotacaoConsultaComponent } from './cotacao-consulta.component';

describe('CotacaoConsultaComponent', () => {
	let component: CotacaoConsultaComponent;
	let fixture: ComponentFixture<CotacaoConsultaComponent>;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			imports: [CotacaoConsultaComponent],
		}).compileComponents();

		fixture = TestBed.createComponent(CotacaoConsultaComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
