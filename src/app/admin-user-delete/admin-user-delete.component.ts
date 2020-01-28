import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-admin-user-delete',
  templateUrl: './admin-user-delete.component.html',
  styleUrls: ['./admin-user-delete.component.css']
})
export class AdminUserDeleteComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private service:DataService,
    private router:Router) { }

  ngOnInit()
 {
  this.route.paramMap.subscribe((result)=>{
    let id=result.get("uId");

     let observabelResult = this.service.DeleteUserById(id);

     observabelResult.subscribe((data)=>{
       console.log(data);

        this.router.navigate(['/admin-user-list']);
     })
   }); 
  
  }

}
