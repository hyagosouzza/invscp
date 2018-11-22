import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnonimoComponent } from './anonimo.component';

describe('AnonimoComponent', () => {
  let component: AnonimoComponent;
  let fixture: ComponentFixture<AnonimoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnonimoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnonimoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
