import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {User} from "../../models/user.model";
import {AnonimoService} from "./anonimo.service";

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
    this.anonimoService.isUserValid(this.user)
      .subscribe(data => {
        this.user = data;

        if(this.user != null) {
          console.log(this.user);
          alert("Usuario valido");
          this.router.navigate(['/usuarios']);
        } else {
          this.user = new User();
          alert("Usuario invalido");
        }
      })
  }

 // get User() {
 //   return this.user;
 // }
}
