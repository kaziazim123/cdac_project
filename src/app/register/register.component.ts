import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  ConfirmPassword: String = '';
  user=
  {
  "uId":"",
  "uName":"",
  "uEmail":"",
  "uPassword":"",
  "uAadharNo":"",
  "uPhoneNo":"",
  "uRole":"USER"
//   "uRole":null
  
}
message:any;
  Users:any;

  constructor(
      private service: DataService,
      private router: Router) { }

  ngOnInit() { }

  onCancel() {
      this.router.navigate(['/home']);
  }

  onRegister() {
      // tslint:disable-next-line:no-debugger
      debugger;
      if (this.user.uName.length === 0 ) {
          alert('please enter full name');
      }  else if (this.user.uEmail.length === 0 ) {
          alert('please enter email');
      }   else if (this.user.uPassword.length === 0) {
          alert('please enter password');
      }else if (this.user.uAadharNo.length === 0 ) {
          alert('please enter Aadhar Number');
      }else if (this.user.uPhoneNo.length === 0 ) {
          alert('please enter mobile Number');
      }
       else {
          if (this.user.uPassword === this.ConfirmPassword) {
              this.service.registerUser(this.user).subscribe((response) => {
                  // tslint:disable-next-line:no-debugger
                  debugger;
                  const result = response;
                  console.log(result);
                  // tslint:disable-next-line:no-debugger
                  debugger;
                  if (result != null) {
                      this.router.navigate(['/login']);
                  } else {
                      alert('error occured');
                  }
              },
              (error) => {
                  // tslint:disable-next-line:no-debugger
                  debugger;
                  alert('something went wrong');
              });
          } else {
              alert('password not matching!!');
          }

  }
}

}
