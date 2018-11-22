import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarDepComponent } from './criar-dep.component';

describe('CriarDepComponent', () => {
  let component: CriarDepComponent;
  let fixture: ComponentFixture<CriarDepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriarDepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriarDepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
