import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
users:any;
u:any;
  constructor(
    private service:DataService,
    private authService:AuthService,
      private router:Router
  ) { }

  ngOnInit() {
    this.u= JSON.parse(window.sessionStorage.getItem("user"));
   
    let id=this.u.uId;
    let observalbleRes=this.service.UserById(id);
    observalbleRes.subscribe((result)=>{
      //console.log(result);
      this.users=result;  })
  }
  SignOut()
  {
    sessionStorage.removeItem("user");
    sessionStorage.removeItem("active");
    window.sessionStorage.setItem("isloggedin","0");
    this.router.navigate(['login']);
  }  
}
