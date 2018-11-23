import { TestBed, inject } from '@angular/core/testing';

import { DeptoService } from './depto.service';

describe('DeptoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DeptoService]
    });
  });

  it('should be created', inject([DeptoService], (service: DeptoService) => {
    expect(service).toBeTruthy();
  }));
});
