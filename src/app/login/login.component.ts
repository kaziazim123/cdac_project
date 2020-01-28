import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userdetails=
  {
  "uId":"",
  "uName":"",
  "uEmail":"",
  "uPassword":"",
  "uAadharNo":"",
  "uPhoneNo":"",
  "uRole":null
}
message:any;
  Users:any;

  


constructor(private service:DataService,private router:Router,private authService:AuthService)
{

}

ngOnInit()
{

}
SignIn()
 {
   
   let observable=this.service.login(this.userdetails);
    observable.subscribe((result)=>{

      this.Users=result;
      
        console.log(this.Users);
       
       let isinvalid=this.authService.CheckUser(this.Users);
       if(isinvalid!=null)
       {
       this.authService.setSession(result);
       this.Users=result;
         if(this.Users.uRole=='USER')
            { 
              // sessionStorage['uId']= ['result']['uId']
              // sessionStorage['uId']= ['result']['uName']
              console.log("Hi")
              this.router.navigate(['user-home']);
             
            }
         else if(this.Users.uRole=="ADMIN")
           {
            console.log("Hi 2")

               this.router.navigate(['admin-home']);
           }
         else
         {
          console.log("Hi 3")

             this.router.navigate(['home']);
             
         }
       }
       else
       {
         this.message="Username or password is incorrect";
       } 
     })
 }

  Home()
  {
      this.router.navigate(['home']);  
    
  }
  
}

