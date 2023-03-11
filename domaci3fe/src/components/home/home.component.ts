import {Component, OnInit} from '@angular/core';
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  readPermission: boolean
  createPermission: boolean

  constructor(private loginService: LoginService) {
    this.loginService = loginService
    this.readPermission = this.loginService.getPermissions().includes("can_read_users")
    this.createPermission = this.loginService.getPermissions().includes("can_create_users")
  }

  ngOnInit(): void {
  }

}
