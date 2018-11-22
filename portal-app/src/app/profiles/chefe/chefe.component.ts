import { Component, OnInit } from '@angular/core';
declare var $: any;
@Component({
  selector: 'app-chefe',
  templateUrl: './chefe.component.html',
  styleUrls: ['./chefe.component.css']
})
export class ChefeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $('#datepicker').datepicker({
      uiLibrary: 'bootstrap4'
  });
  }

}
