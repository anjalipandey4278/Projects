import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { createUrlTreeFromSnapshot, Router } from '@angular/router';
import { product } from '../product';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
productcount:number;
membercount:number;
value1 = "";
searchval : any;
showerror: boolean = false ;
isresulfound :boolean = false;
searchresult : any;
onlineusercount:number;
public reviewForm !: FormGroup
products =  new product();
allproduct : any;
productid :any;
displayStyle = "none";
isadmin :boolean= false;
heading : String = '';
review : String ='';
rating: number=0;
isapproved:boolean= false;
  constructor(private formbuilder:FormBuilder,private ser: RegistrationService,public router: Router) { }

  ngOnInit(): void {
    this.ser.getproductCount().subscribe((res)=>{
      this.productcount = res
    });
    this.ser.getuserCount().subscribe((res)=>{
      this.membercount=res
    });
    this.ser.getonlineuser().subscribe((res)=>{
      this.onlineusercount=res
    });
    this.ser.GetallProduct().subscribe((res)=>{
      this.allproduct = res
      console.log(this.allproduct)
    });
    if(localStorage.getItem('role')== "admin"){
     this.isadmin = true;
    }
    this.reviewForm=this.formbuilder.group({
      heading:['', Validators.required],
      review:['', Validators.required],
      rating:['', Validators.required],
      isapproved:this.isapproved
    })
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


  searchi(){
    this.searchresult = null;
    this.ser.search(this.searchval).subscribe((res)=>{
     if(res){
      this.showerror=false;
    
      this.searchresult = res;
      this.isresulfound= true;
      console.log(res)
     } 
     if(res.length == 0){
      console.log(res)
      console.log("error")
      this.showerror = true
     }

    })
  }
    addreview(addreview: any){
      this.productid = this.allproduct[addreview].id
    }
    
  
  
  savereviews(){
    this.ser.savreviews(this.reviewForm.value,this.productid).subscribe((res: any)=>{
      console.log(res)
      this.reviewForm.reset();
    })
    
  }
  // getvalue(event:Event){
   
  //   if(event.target==null){
  //     this.isresulfound =false;
     
    
      
  //   }
   
    

  // }

}
