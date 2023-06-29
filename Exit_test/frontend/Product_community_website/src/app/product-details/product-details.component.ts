import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { product } from '../product';
import { RegistrationService } from '../registration.service';


@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  products =  new product();
  productdetails : any;
  avg:number=0;
  aprovedreviews : Array<any>=[];
  productid : any;
  notaprovedreviews: Array<any>=[];
  productreview:any;
  avgRating:any;
  isadmin :boolean= false;
  constructor(private ser: RegistrationService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams
    .subscribe(params => {
      console.log(params); // { orderby: "price" }
      this.productid = params['id'];
      console.log(this.productid); // price
    }
  );
  if(localStorage.getItem('role')== "admin"){
    this.isadmin = true;
   }
   this.getallreviews();
  

    this.ser.getProductById(this.productid).subscribe((res)=>{
      this.productdetails = res
      console.log(this.productdetails)
    })
    this.ser.getAvgRating(this.productid).subscribe((res)=>{
      this.avgRating=res
    })

   
    console.log(this.aprovedreviews)
    console.log(this.avg)
   

  }
  logout(){
    const user_d = localStorage.getItem('user_id');
    this.ser.logoutUserFromRemote(user_d).subscribe((res: any)=>{
      console.log(res)
    if(res == "done"){
      localStorage.clear();
    }
    })
    
   
  }
  declinereview(indexOfelement:any){
    const reviewid = this.notaprovedreviews[indexOfelement].id

    this.ser.declineReviewById(reviewid).subscribe((res)=>{
      console.log(res)   
    this.notaprovedreviews.splice(indexOfelement,1);

    })


  }

getallreviews(){
  this.ser.getReviews(this.productid).subscribe((res)=>{
    

    this.productreview = res
    res.forEach((element: any) => {
      if(element.isapproved == true){
        this.aprovedreviews.push(element)
      }
      else{
        this.notaprovedreviews.push(element)
      }

    });
  
  })
}

  approvereview(indexOfelement: any){
    const reviewid = this.notaprovedreviews[indexOfelement].id
    console.log(reviewid)
    console.log(this.notaprovedreviews[indexOfelement])
    this.ser.approveReviewById(reviewid).subscribe((res)=>{
      console.log(res)   
      this.notaprovedreviews.splice(indexOfelement,1);
     })
      
  }
  
  counter(i: number) {
    return new Array(i);
}


}
