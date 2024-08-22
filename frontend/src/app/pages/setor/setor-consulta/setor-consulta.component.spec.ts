import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SetorConsultaComponent } from './setor-consulta.component';

describe('SetorConsultaComponent', () => {
	let component: SetorConsultaComponent;
	let fixture: ComponentFixture<SetorConsultaComponent>;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			imports: [SetorConsultaComponent],
		}).compileComponents();

		fixture = TestBed.createComponent(SetorConsultaComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
