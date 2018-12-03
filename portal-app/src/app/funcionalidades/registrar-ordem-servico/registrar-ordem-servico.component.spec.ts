import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarOrdemServicoComponent } from './registrar-ordem-servico.component';

describe('RegistrarOrdemServicoComponent', () => {
  let component: RegistrarOrdemServicoComponent;
  let fixture: ComponentFixture<RegistrarOrdemServicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrarOrdemServicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrarOrdemServicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
