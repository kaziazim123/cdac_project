import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-child-add',
  templateUrl: './admin-child-add.component.html',
  styleUrls: ['./admin-child-add.component.css']
})
export class AdminChildAddComponent implements OnInit {

child =
{
  "cId":"",
  "cAge":"",
  "cGender":"",
  "cName":"",
  "cStatus":"NOTADOPTED"
}

  constructor(
    private service: DataService,
    private router: Router 
  ) { }

  ngOnInit() {
  }


onCancel()
{
  this.router.navigate(['/admin-home']);
}

onRegister()
{
  let observable = this.service.registerChild(this.child);
  observable.subscribe((data)=>{
    console.log(data);

     this.router.navigate(['/admin-home']);
  })
}

}


