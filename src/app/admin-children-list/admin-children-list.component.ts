import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-admin-children-list',
  templateUrl: './admin-children-list.component.html',
  styleUrls: ['./admin-children-list.component.css']
})
export class AdminChildrenListComponent implements OnInit {

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

  deleteChild(id){
    const res = confirm("Are you sure ??");
    if(res==true){
      this.service.deleteChild(id).subscribe((res)=>{
        this.childrenList();
      })
    }
  }
  // updateChild(id){
  //   const res = confirm("Are you sure ??");
  //   if(res==true){
  //     this.service.deleteChild(id).subscribe((res)=>{
  //       this.childrenList();
  //     })
  //   }
  // }
  backpage()
  {
    this.router.navigate(['admin-home']);
  }
  
}

