import { Component, OnInit } from '@angular/core';
import { product } from '../product';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
products =  new product();
 allproduct : any;
  constructor(private service: RegistrationService) { }

  ngOnInit(): void {
    this.service.GetallProduct().subscribe((res)=>{
      this.allproduct = res
    console.log(res)
    console.log(this.allproduct)
    
    });
  }

}
