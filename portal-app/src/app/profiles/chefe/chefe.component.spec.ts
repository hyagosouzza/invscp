import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChefeComponent } from './chefe.component';

describe('ChefeComponent', () => {
  let component: ChefeComponent;
  let fixture: ComponentFixture<ChefeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChefeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChefeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
