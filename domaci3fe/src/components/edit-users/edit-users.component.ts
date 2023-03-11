import {Component, OnInit} from '@angular/core';
import {EditUsersService} from "../../services/users/edit-users.service";
import {User} from "../../model/model";

@Component({
  selector: 'app-edit-users',
  templateUrl: './edit-users.component.html',
  styleUrls: ['./edit-users.component.css']
})
export class EditUsersComponent implements OnInit {

  email: string = ''
  name: string = ''
  surname: string = ''
  permissions: string = ''
  errorMessage: string = ''
  successMessage: string = ''

  constructor(private service: EditUsersService) {
  }

  ngOnInit(): void {
    let user: User = this.service.getUser()
    this.email = user.email
    this.name = user.name
    this.surname = user.surname
    this.permissions = String(user.permissions)
  }

  editUser(email: string, name: string, surname: string, permissions: string): void {
    if (email == '' || name == '' || surname == ''){
      this.successMessage = ''
      this.errorMessage = 'Please, fill in the missing required fields.'
      return
    }
    this.service.editUser(email, name, surname, permissions).subscribe((wrapper => {
      console.log(wrapper)
      this.successMessage = 'User successfully edited!'
      this.errorMessage = ''
    }), error => {
      this.successMessage = ''
      this.errorMessage = 'Something went wrong.'
    })
  }
}

