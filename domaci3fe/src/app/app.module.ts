import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUsersComponent } from '../components/create-users/create-users.component';
import { EditUsersComponent } from '../components/edit-users/edit-users.component';
import { HomeComponent } from '../components/home/home.component';
import { ListUsersComponent } from '../components/list-users/list-users.component';
import { LoginComponent } from '../components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ErrorMessageComponent } from '../components/error-message/error-message.component';
import { NodeCreateComponent } from '../components/node-create/node-create.component';
import { NodeScheduleComponent } from '../components/node-schedule/node-schedule.component';
import { NodeSearchComponent } from '../components/node-search/node-search.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateUsersComponent,
    EditUsersComponent,
    HomeComponent,
    ListUsersComponent,
    LoginComponent,
    ErrorMessageComponent,
    NodeCreateComponent,
    NodeScheduleComponent,
    NodeSearchComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
