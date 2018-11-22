import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarPredioComponent } from './criar-predio.component';

describe('CriarPredioComponent', () => {
  let component: CriarPredioComponent;
  let fixture: ComponentFixture<CriarPredioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriarPredioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriarPredioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
