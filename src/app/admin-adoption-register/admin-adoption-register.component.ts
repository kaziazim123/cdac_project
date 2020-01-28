import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';
import { AdoptionRecord } from '../AdoptionRecord';
import { User } from '../User';
import { Children } from '../Children';

@Component({
  selector: 'app-admin-adoption-register',
  templateUrl: './admin-adoption-register.component.html',
  styleUrls: ['./admin-adoption-register.component.css']
})
export class AdminAdoptionRegisterComponent implements OnInit {

  adoptionRecord: AdoptionRecord = new AdoptionRecord();
  user: User = new User();
  child: Children = new Children();

  constructor(
                private service: DataService,
                private router: Router
  ) { }

  ngOnInit() {
  }


  addAdoptionRecord() {
    debugger;


alert("in adoption record");
             this.service
             .addAdoptionRecord(this.adoptionRecord)
             .subscribe((response) => {
                 debugger;
                 alert("in adoption record 2");
                 const result = response;
                 console.log(result);
                 alert('Record added successfully');
                 this.router.navigate(['/admin-home']);
                
             },
             (error) => {
                 debugger;
                 alert('something went wrong');
            });
  
}
}
