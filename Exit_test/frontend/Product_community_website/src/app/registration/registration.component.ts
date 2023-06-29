import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import {FormGroup, FormBuilder, Validators, AbstractControl, FormControl} from '@angular/forms'
import { RegistrationService } from '../registration.service';



@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
 user=new User();
 title='formvalidation';
 passwordsMatching = false;
 submitted=false;
 isConfirmPasswordDirty = false;
 confirmPasswordClass = 'form-control';
 public registerForm !: FormGroup;
 

  constructor(private formBuilder:FormBuilder,private _service: RegistrationService,private router:Router ) { }


  ngOnInit(): void {
    this.registerForm=this.formBuilder.group({
      firstName:['',[Validators.required,Validators.minLength(4)]],
      lastName:['', [Validators.required,Validators.minLength(4)]],
      email:['', [Validators.required,Validators.pattern(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/), ], ], 
      password:['',[Validators.required,Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/), Validators.minLength(8),], ],
      role : 'user'
    });

 
  }
 


  checkPasswords(pw: string, cpw: string) {
    this.isConfirmPasswordDirty = true;
    if (pw == cpw) {
      this.passwordsMatching = true;
      this.confirmPasswordClass = 'form-control is-valid';
    } else {
      this.passwordsMatching = false;
      this.confirmPasswordClass = 'form-control is-invalid';
    }
  }

  registerUser(): void {
    this.submitted=true

    if(this.registerForm.invalid){
      return
    }
    alert("success")
    console.log(this.registerForm.value)

    this._service.RegisterUserFromRemote(this.registerForm.value).
      subscribe(res => {
        if (res.status == "400") {
          console.log("Details cannot be empty");
        } else {
          
          this.router.navigate(['/login']);
        }
      },
       );
    
  }

}
  
