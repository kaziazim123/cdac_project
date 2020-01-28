import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-donation-list',
  templateUrl: './admin-donation-list.component.html',
  styleUrls: ['./admin-donation-list.component.css']
})
export class AdminDonationListComponent implements OnInit {

  donationList: any;
  constructor(  
                 private router: Router,
                 private service: DataService

  ) {
    this.donationRecord();
   }

  ngOnInit() {
  }

  donationRecord()
  {
      this.service.donationList().subscribe((res)=>{
           console.log(res);
           this.donationList = res;
  },(error)=>{
    alert("inside error");
    console.log(error)
  });
 }


 deleteDonationRecord(id){
  const res = confirm("Are you sure ??");
  if(res==true){
    this.service.deleteDonationRecord(id).subscribe((res)=>{
      this.donationRecord();
    })
  }

}

}

