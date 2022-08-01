import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    username:'',
    password:'',
  }

  constructor(private loginService:LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  formSubmit(){
    console.log("login for submitted!!")
    if(this.loginData.username.trim()=='' || this.loginData.username==null){
      alert("Username is required");
      return ;
    }
    if(this.loginData.password.trim()=='' || this.loginData.password==null){
      alert("Password is required");
      return ;
    }

    this.loginService.login(this.loginData).subscribe(
      (data:any)=>{
        if(data!=null){
          localStorage.setItem('username', data.username);
          localStorage.setItem('status', "true");
          localStorage.setItem('user', JSON.stringify(data))

          alert("login successful!!"+" "+localStorage.getItem('username'));
          //Check role
          if(this.loginService.getUserRole()=="Admin"){
            //admin dashboard
            this.router.navigate(['/admin/profile']);
          }
          else if(this.loginService.getUserRole()=="User"){
            //normal user dashboard
            this.router.navigate(['/user-dashboard/0']);
          }
          else{
            this.loginService.logout();
          }
        }
        else{
          alert("Wrong Credentials!!");
        }
      },
      (error)=>{
        console.log(error);
      }
    )
  }

}
