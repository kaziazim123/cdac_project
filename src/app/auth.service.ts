import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate } from '@angular/router';
import { DataService } from './data.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate{
 
  // user = 
  // {
  //   "uId":""
  // }
    constructor(private router:Router)
   { 
    
  }
   
  setSession(result)
  {
   
        window.sessionStorage.setItem("user",JSON.stringify(result));
        window.sessionStorage.setItem("active","12345advnsjdufua4654adgnj@n");
        // window.sessionStorage.setItem("userid","uId");
        // window.sessionStorage.setItem("username","uName");
        return true;
    
  }

   canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot)
   {
     if(this.isLoggedIn())
     {
       console.log("User has logged In")
       return true;
     }
     else{
       console.log("User has not Logged In")
       this.router.navigate(['login'])
       return false;
     }
   }
  //  canActivate(route:ActivatedRouteSnapshot, 
  //   state:RouterStateSnapshot)
  //   {
  //     if(this.isLoggedIn())
  //     {
  //       return true;
  //     }
  //     else
  //     {
  //       this.router.navigate(['login']);
  //       return false;
  //     }
  //   }
  
  isLoggedIn()
  {
    if(window.sessionStorage.getItem("active")!=null
        && 
        window.sessionStorage.getItem("active")=="12345advnsjdufua4654adgnj@n")
        {
          return true;
        }
      else
      {
        return false;
      }
  }

  CheckUser(user)
    {
      
        if (user!=null)
        {
          window.sessionStorage.setItem("isloggedin","1");
          return true;
        }
        else{
          return false; 
        }
    }
    SignOut()
    {
      sessionStorage.removeItem("user");
      sessionStorage.removeItem("active");
      window.sessionStorage.setItem("isloggedin","0");
     
      // window.sessionStorage.setItem("isloggedout","null");
      this.router.navigate(['login']);
    }
}