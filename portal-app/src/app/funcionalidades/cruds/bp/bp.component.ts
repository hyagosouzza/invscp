import { Component, OnInit } from '@angular/core';

import { Bem } from '../../../models/bem.model';
import { BpService } from './bp.service';

@Component({
  selector: 'app-bp',
  templateUrl: './bp.component.html',
  styleUrls: ['./bp.component.css']
})

export class BpComponent implements OnInit {

  bens: Bem[];

  constructor(private bemService: BpService) {

  }

  ngOnInit() {
    this.bemService.getBens()
      .subscribe( data => {
        this.bens = data;
      });
  };

  deleteBem(bem: Bem): void {
    this.bemService.deleteBem(bem)
      .subscribe( data => {
        this.bens = this.bens.filter(u => u !== bem);
      })
  };

}
