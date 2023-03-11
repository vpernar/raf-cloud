import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {NodeCreateService} from "../../services/node/node-create.service";

@Component({
  selector: 'app-node-create',
  templateUrl: './node-create.component.html',
  styleUrls: ['./node-create.component.css']
})
export class NodeCreateComponent implements OnInit {

  name: string = ''
  errorMessage: string = ''
  successMessage: string = ''

  constructor(private route: Router, private service: NodeCreateService) {
  }

  ngOnInit(): void {
  }

  create() {
    this.service.create(this.name).subscribe((response) => {
      this.errorMessage = ''
      this.successMessage = 'Successfully created a new node!'
    }, error => {
      console.log(error)
      this.successMessage = ''
      this.errorMessage = 'Something went wrong.'
    })
  }

}
