import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService:UserService, private snack:MatSnackBar, private router:Router) { }

  public user={
    username:'',
    firstName:'',
    lastName:'',
    email:'',
    phone:'',
    address:'',
    role:'User',
    password:''
  };

  cpwd:any
  ngOnInit(): void {
  }

  formSubmit(){
    if(this.cpwd!=this.user.password){
      alert("Please enter same password in confirm password!!!")
    }
    else{
      this.snack.open("Form submitted !!",'',{
        duration: 3000,
      });

      //addUser: userService
      this.userService.addUser(this.user).subscribe(
        (data)=>{
          console.log(data);
          alert("User Registered !!");
          this.router.navigate(['/login']);
        },
        (error)=>{
          console.log(error);
          this.snack.open("Something went wrong !!",'',{
            duration: 3000,
          });
        }
      )
    }
  }
}
