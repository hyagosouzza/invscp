import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrupoMateiralPorSalaComponent } from './grupo-mateiral-por-sala.component';

describe('GrupoMateiralPorSalaComponent', () => {
  let component: GrupoMateiralPorSalaComponent;
  let fixture: ComponentFixture<GrupoMateiralPorSalaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrupoMateiralPorSalaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrupoMateiralPorSalaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
