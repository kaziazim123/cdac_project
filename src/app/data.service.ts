import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http : HttpClient) { }

  login(user)
  {
    console.log("inside log in");
    return this.http.post("http://localhost:8080/orphanage1/user/validation",user);
  }
  SelectUser()
  {
    return this.http.get("http://localhost:8080/orphanage1/admin");
  }
  Selectchildren()
  {
    return this.http.get("http://localhost:8080/orphanage1/admin/children");
  }
  donationList()
  {
   
    return this.http.get(" http://localhost:8080/orphanage1/admin/donations");
  }
  visitList()
  {
    return this.http.get(" http://localhost:8080/orphanage1/admin/visit");
  }
  adoptionList()
  {
    return this.http.get(" http://localhost:8080/orphanage1/admin/adoption_record");
  }
  addAdoptionRecord(adoptionRecord)
  {
    return this.http.post(" http://localhost:8080/orphanage1/admin/adoption_record/add",adoptionRecord);
  }
  deleteDonationRecord(id)
  {
    return this.http.delete("http://localhost:8080/orphanage1/admin/donations/delete/"+id);
  }

  registerUser(user)
  {
    console.log("inside log in");
    return this.http.post("http://localhost:8080/orphanage1/user/register",user);
  }

  registerChild(child)
  {
    return this.http.post("http://localhost:8080/orphanage1/admin/register_child",child);
  }
  deleteChild(id)
  {
    return this.http.delete("http://localhost:8080/orphanage1/admin/children/"+id);
  }
  DeleteUserById(id)
  {
    return this.http.delete("http://localhost:8080/orphanage1/admin/"+id);
  }
  UserById(id)
  {
    return this.http.get("http://localhost:8080/orphanage1/user/"+id);
  }
  Update(user)

  {
    return this.http.post("http://localhost:8080/orphanage1/user/update/"+user.uId,user);
  }
  Donations(Donation)
  {
    return this.http.post("http://localhost:8080/orphanage1/user/donate/",Donation);
  }
  scheduleAdoptionVisit(user,Visit)
  {
    return this.http.post("http://localhost:8080/orphanage1/user/visit/"+user.uId,Visit);
  }

  // childrenList()
  // {
  //   return this.http.get("http://localhost:8080/orphanage1/admin/children");
  // }
}
