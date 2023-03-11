import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "../components/home/home.component";
import {LoginComponent} from "../components/login/login.component";
import {ListUsersComponent} from "../components/list-users/list-users.component";
import {ListUsersAuthGuard} from "../components/list-users/list-users-auth.guard";
import {EditUsersComponent} from "../components/edit-users/edit-users.component";
import {EditUsersAuthGuard} from "../components/edit-users/edit-users-auth.guard";
import {CreateUsersComponent} from "../components/create-users/create-users.component";
import {CreateUsersAuthGuard} from "../components/create-users/create-users-auth.guard";
import {NodeSearchComponent} from "../components/node-search/node-search.component";
import {NodeSearchAuthGuard} from "../components/node-search/node-search-auth.guard";
import {NodeCreateComponent} from "../components/node-create/node-create.component";
import {NodeCreateAuthGuard} from "../components/node-create/node-create-auth.guard";
import {NodeScheduleComponent} from "../components/node-schedule/node-schedule.component";
import {ErrorMessageComponent} from "../components/error-message/error-message.component";
import {NodeScheduleAuthGuard} from "../components/node-schedule/node-schedule-auth.guard";

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "list-users",
    component: ListUsersComponent,
    canActivate: [ListUsersAuthGuard]
  },
  {
    path: "edit-users",
    component: EditUsersComponent,
    canActivate: [EditUsersAuthGuard]
  },
  {
    path: "add-users",
    component: CreateUsersComponent,
    canActivate: [CreateUsersAuthGuard]
  },
  {
    path: "nodes",
    component: NodeSearchComponent,
    canActivate: [NodeSearchAuthGuard]
  },
  {
    path: "create-node",
    component: NodeCreateComponent,
    canActivate: [NodeCreateAuthGuard]
  },
  {
    path: "schedule",
    component: NodeScheduleComponent,
  },
  {
    path: "errors",
    component: ErrorMessageComponent,
    canActivate: [NodeScheduleAuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
