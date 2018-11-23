import { TestBed, inject } from '@angular/core/testing';

import { PredioService } from './predio.service';

describe('PredioService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PredioService]
    });
  });

  it('should be created', inject([PredioService], (service: PredioService) => {
    expect(service).toBeTruthy();
  }));
});
