import { TestBed, inject } from '@angular/core/testing';

import { BpService } from './bp.service';

describe('BpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BpService]
    });
  });

  it('should be created', inject([BpService], (service: BpService) => {
    expect(service).toBeTruthy();
  }));
});
