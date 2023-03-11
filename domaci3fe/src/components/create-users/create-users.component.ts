import {Component, OnInit} from '@angular/core';
import {CreateUsersService} from "../../services/users/create-users.service";

@Component({
  selector: 'app-create-users',
  templateUrl: './create-users.component.html',
  styleUrls: ['./create-users.component.css']
})
export class CreateUsersComponent implements OnInit {

  email: string = ''
  name: string = ''
  surname: string = ''
  password: string = ''
  permissions: string = ''
  errorMessage: string = ''
  successMessage: string = ''

  constructor(private service: CreateUsersService) {}

  ngOnInit(): void {
  }

  clearInput(){
    this.email = ''
    this.name = ''
    this.surname = ''
    this.password = ''
    this.permissions = ''
    this.errorMessage = ''
  }

  createUser(email: string, name: string, surname: string, password: string, permissions: string): void {
    if (email == '' || name == '' || surname == '' || password == ''){
      this.successMessage = ''
      this.errorMessage = 'Please, fill in the missing required fields.'
      return
    }
    this.service.createUser(email, name, surname, password, permissions).subscribe((wrapper => {
      console.log(wrapper)
      this.clearInput()
      this.successMessage = 'User successfully created!'
    }), error => {
      this.successMessage = ''
      this.errorMessage = 'Something went wrong.'
    })
  }
}
