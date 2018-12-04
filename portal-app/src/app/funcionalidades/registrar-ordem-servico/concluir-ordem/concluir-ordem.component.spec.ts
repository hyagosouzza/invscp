import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConcluirOrdemComponent } from './concluir-ordem.component';

describe('ConcluirOrdemComponent', () => {
  let component: ConcluirOrdemComponent;
  let fixture: ComponentFixture<ConcluirOrdemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConcluirOrdemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConcluirOrdemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
