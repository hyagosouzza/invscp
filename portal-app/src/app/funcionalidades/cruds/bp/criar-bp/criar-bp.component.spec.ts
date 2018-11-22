import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarBpComponent } from './criar-bp.component';

describe('CriarBpComponent', () => {
  let component: CriarBpComponent;
  let fixture: ComponentFixture<CriarBpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriarBpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriarBpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
