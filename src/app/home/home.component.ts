import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

 Donation =
 {
   
    "name": "",
    "email": "",
    "contactNo": "",
    "transactionId": "",
    "amount": ""
}
donate: any;
constructor(
  private router: Router,
  private service: DataService
) { }

  ngOnInit() {
  }
  makeDonation()
  {
     
      if (this.Donation.name.length === 0 ) {
          alert('please enter name');
        }  else if (this.Donation.email.length === 0 ) {
           alert('please enter email');
       }   else if (this.Donation.contactNo.length === 0) {
           alert('please enter mobile no');
       }else if (this.Donation.transactionId.length === 0 ) {
          alert('please enter transaction id');
      }else if (this.Donation.amount.length === 0 ) {
          alert('please enter amount');
      }
       else {
              this.service.Donations(this.Donation).subscribe((response) => {
                  debugger;
                  const result = response;
                  console.log(result);
                  debugger;
                  if (result != null) {
                      alert("Thankyou for donation!!");
                     window.location.reload();
                  } else {
                      alert('error occured');
                      window.location.reload();
                  }
              },
              (error) => {
                  debugger;
                  alert('something went wrong');
                  window.location.reload();
              });
          } 

      }
  
}
