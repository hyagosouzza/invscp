import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PesquisarBemComponent } from './pesquisar-bem.component';

describe('PesquisarBemComponent', () => {
  let component: PesquisarBemComponent;
  let fixture: ComponentFixture<PesquisarBemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PesquisarBemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PesquisarBemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
