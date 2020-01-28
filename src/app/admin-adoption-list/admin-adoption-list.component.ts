import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-adoption-list',
  templateUrl: './admin-adoption-list.component.html',
  styleUrls: ['./admin-adoption-list.component.css']
})
export class AdminAdoptionListComponent implements OnInit {

  adoptionrecord: any;

  constructor(

                  private router: Router,
                  public service: DataService
  ) {

      this.adoptionList();
   }

  ngOnInit() {
  }


  adoptionList(){
   
    this.service.adoptionList().subscribe((res)=>{
      console.log(res);
      this.adoptionrecord=res;  ///////
    },(error)=>{
      alert("inside error");
      console.log(error)
    })
  } 


}