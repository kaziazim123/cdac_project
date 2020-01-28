import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {NgForm,NgModel, FormsModule } from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
// import { AppComponent, AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { UserHomeComponent } from './user-home/user-home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AuthService } from './auth.service';
import { RegisterComponent } from './register/register.component';
import { ChildrenListComponent } from './user-children-list/children-list.component';
import { AdminChildrenListComponent } from './admin-children-list/admin-children-list.component';
import { AdminUserListComponent } from './admin-user-list/admin-user-list.component';
import { AdminUserDeleteComponent } from './admin-user-delete/admin-user-delete.component';
import { AdminVisitListComponent } from './admin-visit-list/admin-visit-list.component';
import { AdminAdoptionListComponent } from './admin-adoption-list/admin-adoption-list.component';
import { AppComponent } from './app.component';
import { AdminChildAddComponent } from './admin-child-add/admin-child-add.component';
//import { UserVisitRegisterComponent } from './user-visit-register/user-visit-register.component';
import { AdminDonationListComponent } from './admin-donation-list/admin-donation-list.component';
import { UserVisitRegisterComponent } from './user-visit-register/user-visit-register.component';
import { AdminAdoptionRegisterComponent } from './admin-adoption-register/admin-adoption-register.component';
//import { AdminAdoptionRegisterComponent } from './admin-adoption-register/admin-adoption-register.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    UserHomeComponent,
    AdminHomeComponent,
    RegisterComponent,
    ChildrenListComponent,
    AdminChildrenListComponent,
    AdminUserListComponent,
    AdminUserDeleteComponent,
    AdminVisitListComponent,
    AdminAdoptionListComponent,
    AdminChildAddComponent,
    //UserVisitRegisterComponent,
    AdminDonationListComponent,
    UserVisitRegisterComponent,
    AdminAdoptionRegisterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
     { path: '', component: HomeComponent },
     { path: '#', component: HomeComponent },
      { path: 'home', component: HomeComponent },
      { path: 'login', component: LoginComponent  },
      { path: 'register', component: RegisterComponent },
      { path: 'user-home', component: UserHomeComponent    , canActivate:[AuthService] },
      { path: 'admin-children-list', component: AdminChildrenListComponent ,canActivate:[AuthService]},
      { path: 'admin-home', component: AdminHomeComponent   , canActivate:[AuthService]},
      { path: 'user-children-list', component: ChildrenListComponent , canActivate:[AuthService]},
      { path: 'admin-user-list', component: AdminUserListComponent , canActivate:[AuthService]},
      {path:"delete_user/:uId",component:AdminUserDeleteComponent , canActivate:[AuthService]},
      {path:"admin-visit-list",component:AdminVisitListComponent , canActivate:[AuthService]},
      {path:"admin-adoption-list",component:AdminAdoptionListComponent , canActivate:[AuthService]},
      {path:"admin-child-add",component:AdminChildAddComponent , canActivate:[AuthService]},
      {path:"admin-donation-list",component:AdminDonationListComponent , canActivate:[AuthService]},
      {path:"user-visit-register",component:UserVisitRegisterComponent , canActivate:[AuthService]},
      {path:"admin-adoption-register",component:AdminAdoptionRegisterComponent , canActivate:[AuthService]},
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
