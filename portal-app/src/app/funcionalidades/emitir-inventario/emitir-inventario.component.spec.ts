import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmitirInventarioComponent } from './emitir-inventario.component';

describe('EmitirInventarioComponent', () => {
  let component: EmitirInventarioComponent;
  let fixture: ComponentFixture<EmitirInventarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmitirInventarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmitirInventarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
