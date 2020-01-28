import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-user-list',
  templateUrl: './admin-user-list.component.html',
  styleUrls: ['./admin-user-list.component.css']
})
export class AdminUserListComponent implements OnInit {

  public users:any;

  constructor(private service:DataService,
    private authService:AuthService,
      private router:Router) { }

 
  ngOnInit() {
    let observalbleResult=this.service.SelectUser();
    observalbleResult.subscribe((result)=>{
      //console.log(result);
      this.users=result;
      console.log(result);    
    })
     
  }

  backpage()
  {
    this.router.navigate(['admin-home']);
  }

  // DeleteUser()
  // {
  //   let observalbleResult=this.service.DeleteUserById(this.user.uId);
  //   // observalbleResult.subscribe((result)=>{
  //   //   //console.log(result);
  //   //   this.users=result;
  //   //   console.log(result);   })
  //   this.router.navigate(['admin-user-list']);
  // }

}
