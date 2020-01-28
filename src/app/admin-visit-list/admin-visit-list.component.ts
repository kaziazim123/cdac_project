import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-visit-list',
  templateUrl: './admin-visit-list.component.html',
  styleUrls: ['./admin-visit-list.component.css']
})
export class AdminVisitListComponent implements OnInit {

  visitList: any;
  constructor(  
                 private router: Router,
                 private service: DataService

  ) {
    this.visitRecord();
   }

  ngOnInit() {
  }

  visitRecord()
  {
      this.service.visitList().subscribe((res)=>{
           console.log(res);
           this.visitList = res;
  },(error)=>{
    alert("inside error");
    console.log(error)
  });
 }

}
