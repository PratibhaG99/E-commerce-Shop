import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  public login(loginData: any){
    return this.http.post(`${baseUrl}/user/login`, loginData);
  }

  public isLoggedIn(){
    let status=localStorage.getItem("status");
    if(status=="true"){
      return true;
    }
    else{
      return false;
    }
  }

  public logout() {
    localStorage.removeItem('username');
    localStorage.removeItem('user');
    localStorage.setItem("status", "false");
    return true;
  }

  public setUser(user : any){
    localStorage.setItem('user', JSON.stringify(user));
  }

  public getUser(){
    let userStr = localStorage.getItem('user');
    if(userStr!=null){
      return JSON.parse(userStr);
    }
    else{
      this.logout();
      return null;
    }
  }

  public getUserRole(){
    let user=this.getUser();
    return user.role;
  }
}
