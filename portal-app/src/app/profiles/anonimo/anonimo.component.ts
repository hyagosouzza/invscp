import { Component, OnInit } from '@angular/core';
import { BpService } from '../../funcionalidades/cruds/bp/bp.service';

@Component({
  selector: 'app-anonimo',
  templateUrl: './anonimo.component.html',
  styleUrls: ['./anonimo.component.css'],
  providers: [BpService]
})
export class AnonimoComponent implements OnInit {
  constructor(private bemService: BpService) { }

  ngOnInit() {
  }



}
