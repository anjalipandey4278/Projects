import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  productcount:number;
  membercount:number;
  onlineusercount:number;
  constructor(private ser: RegistrationService) { }

  ngOnInit(): void {
    this.ser.getproductCount().subscribe((res)=>{
      this.productcount = res
    });
    this.ser.getuserCount().subscribe((res)=>{
      this.membercount=res
    });
    this.ser.getonlineuser().subscribe((res)=>{
      this.onlineusercount=res
    })
  }

}
