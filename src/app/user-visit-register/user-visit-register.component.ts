import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
//import { Visit } from './Visit';

@Component({
  selector: 'app-user-visit-register',
  templateUrl: './user-visit-register.component.html',
  styleUrls: ['./user-visit-register.component.css']
})
export class UserVisitRegisterComponent implements OnInit {

  // adoptionVisit: Visit = new Visit();
adoptionVisit = 
{
  visitDate:"",
  description:""
}
users:any;

  constructor(

                private router: Router,
                private service: DataService
  ) { }

  ngOnInit() {
    this.users=JSON.parse(window.sessionStorage.getItem("user"));
  

  }

  scheduleVisit()
  {
    console.log(this.users.uId);
    this.service
    .scheduleAdoptionVisit(this.users,this.adoptionVisit)
    .subscribe((response) => {
        debugger;
        const result = response;
        console.log(result);
        alert('Appointment booked');
        this.router.navigate(['/user-home']);
    },
    (error) => {
        debugger;
        alert('something went wrong');
   });
  }

}
