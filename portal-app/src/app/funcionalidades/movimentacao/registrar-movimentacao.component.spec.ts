import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarMovimentacaoComponent } from './registrar-movimentacao.component';

describe('RegistrarMovimentacaoComponent', () => {
  let component: RegistrarMovimentacaoComponent;
  let fixture: ComponentFixture<RegistrarMovimentacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrarMovimentacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrarMovimentacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
