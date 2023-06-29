import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms'
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public LoginForm !: FormGroup
 user= new User();
 msg=false;
 showErrorMessage=false;
 data:any;

  constructor(private formbuilder:FormBuilder,private _service: RegistrationService,private router:Router) { }

  ngOnInit(): void {
    this.LoginForm=this.formbuilder.group({
      email:['', Validators.required],
      password:['', Validators.required]
    })
  }
  loginForm(){
    this.showErrorMessage = false;
   this._service.longinUserFromRemote(this.LoginForm.value).subscribe((res)=>{
    console.log(res)
    
    if(res){
      localStorage.setItem('user_id',res.userid);
      localStorage.setItem('role',res.role)
      if(res.role == 'admin'){
        alert("Login Success");
        this.LoginForm.reset()
        this.router.navigate(['all-products']);
      }
      else{
        alert("Login Success");
        this.LoginForm.reset()
        this.router.navigate(['user-dashboard']);
      }
    }
    },
    (error) => {
     this.showErrorMessage = true;
       

    }
    )
    
  }
     
      
    
    
    
  

}
