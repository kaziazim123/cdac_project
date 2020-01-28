import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-children-list',
  templateUrl: './children-list.component.html',
  styleUrls: ['./children-list.component.css']
})
export class ChildrenListComponent implements OnInit {

  children: any;
  constructor(
                  private router: Router,
                  public service: DataService
  ) { 
       this.childrenList();
  }

  ngOnInit() {
  }


    childrenList(){
   
    this.service.Selectchildren().subscribe((res)=>{
      console.log(res);
      this.children=res;  ///////
    },(error)=>{
      alert("inside error");
      console.log(error)
    })
  }

  
}
