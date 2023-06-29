import { Component, ElementRef, Inject, OnInit, VERSION, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { product } from '../product';
import { RegistrationService } from '../registration.service';


@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
export class AllProductsComponent implements OnInit {

  constructor(private formbuilder:FormBuilder,private ser: RegistrationService,private router: Router) { }
  reviewraiseForm: FormGroup;
  public reviewForm !: FormGroup
  products =  new product();
  allproduct : any;
  showerror: boolean = false ;
  showForm=false
  productid :any;
  starWidth: number = 0;
  displayStyle = "none";
  isadmin :boolean= false;
  heading : String = '';
  rating: number=0;
  isapproved:boolean= false;
  toDisplay:boolean = false;
  maxlength=400;
  minlength=20;
  ErrorMessage=" ";
  
 
  
  ngOnInit(): void {
    


    this.ser.GetallProduct().subscribe((res)=>{
      this.allproduct = res
      console.log(this.allproduct)
    });
    if(localStorage.getItem('role')== "admin"){
     this.isadmin = true;
    }
    this.reviewForm=this.formbuilder.group({
      heading:['', Validators.required],
      review:['', Validators.required,Validators.minLength(4)],
      rating:['', Validators.required],
      isapproved:this.isapproved
    });
    this.reviewraiseForm=this.formbuilder.group({
      productcode:['', Validators.required],
      productBrand:['', Validators.required],
      productName:['', Validators.required],
      isapproved:this.isapproved
    });
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

addreview(addreview: any){
  this.productid = this.allproduct[addreview].id

  

}

savereviews(){
  this.ser.savreviews(this.reviewForm.value,this.productid).subscribe((res: any)=>{
    console.log(res)
    alert("review is added successfully")


  })
  this.reviewForm.reset()
  
}

productcode(productid : any){
  this.router.navigate(
    ['product-details'],
  {queryParams:{id:productid}}
  );
}
toggleData() {
  console.log("------------------------------------------")
  this.toDisplay = !this.toDisplay;
}

raiseForm(){
  if(this.allproduct.find((x: any) =>x.id == this.reviewraiseForm.value.productcode) ){
    this.showerror=true
    

    setTimeout(() =>{
      this.navigator();
      
   }, 5000);
   
  }
if(!this.showerror){
  this.toDisplay = false;

}
  

}

navigator(){
   this.router.navigate(
      ['product-details'],
    {queryParams:{id:this.reviewraiseForm.value.productcode}}
    );

}

get review(){
  return this.reviewForm.get('review')
}
rateProduct(rateValue: number) {
  this.starWidth = rateValue * 75 / 5;
}
}







