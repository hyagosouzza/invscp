import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PesquisarBensComponent } from './pesquisar-bens.component';

describe('PesquisarBensComponent', () => {
  let component: PesquisarBensComponent;
  let fixture: ComponentFixture<PesquisarBensComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PesquisarBensComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PesquisarBensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
