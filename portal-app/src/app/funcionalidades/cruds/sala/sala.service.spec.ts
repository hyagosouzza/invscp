import { TestBed, inject } from '@angular/core/testing';

import { SalaService } from './sala.service';

describe('SalaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalaService]
    });
  });

  it('should be created', inject([SalaService], (service: SalaService) => {
    expect(service).toBeTruthy();
  }));
});
