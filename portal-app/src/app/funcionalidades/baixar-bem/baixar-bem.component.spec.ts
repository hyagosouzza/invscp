import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BaixarBemComponent } from './baixar-bem.component';

describe('BaixarBemComponent', () => {
  let component: BaixarBemComponent;
  let fixture: ComponentFixture<BaixarBemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BaixarBemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BaixarBemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
