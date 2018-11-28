import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { User } from "../../models/user.model";
import { AnonimoService } from "./anonimo.service";

@Component({
  selector: 'app-anonimo',
  templateUrl: './anonimo.component.html',
  styleUrls: ['./anonimo.component.css'],
  providers: [AnonimoService]
})

export class AnonimoComponent implements OnInit {
  user: User = new User();
  constructor(private router: Router, private anonimoService: AnonimoService) { }


  ngOnInit() {
  }

  login() {
    this.anonimoService.isUserValid(this.user);
  }

  // get User() {
  //   return this.user;
  // }
}
