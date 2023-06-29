import { Component, OnInit } from '@angular/core';
import { product } from '../product';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css']
})
export class SearchProductComponent implements OnInit {
  products =  new product();
  allproduct : any;
  constructor(private ser: RegistrationService) { }

  ngOnInit(): void {
    this.ser.GetallProduct().subscribe((res)=>{
      this.allproduct = res
    });
  }
  
}
  
