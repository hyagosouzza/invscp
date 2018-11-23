import { Component, OnInit } from '@angular/core';

import { Bem } from '../../../../models/bem.model';
import { BpService } from '../bp.service';

@Component({
  selector: 'app-criar-bp',
  templateUrl: './criar-bp.component.html',
  styleUrls: ['./criar-bp.component.css'],
  providers: [BpService]
})
export class CriarBpComponent {

  bem: Bem = new Bem();

  constructor(private bemService: BpService) {

  }

  createBem(): void {
    this.bemService.createBem(this.bem)
        .subscribe( data => {
          alert("Bem created successfully.");
        });

  };

}
