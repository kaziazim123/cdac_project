import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
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

      SignOut()
      {
        sessionStorage.removeItem("user");
        sessionStorage.removeItem("active");
        window.sessionStorage.setItem("isloggedin","0");
        this.router.navigate(['login']);
      }  

}
