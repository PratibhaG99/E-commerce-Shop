import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) {}

  cid=[0];

  public setCid(n:number){
    this.cid.push(n);
  }

  public getCid(){
    console.log(this.cid);
    return this.cid;
  }

  public orderDetails={
    buyername:'',
    buyeremail:'',
    buyeraddress:'',
    buyerphone:'',
    totalcost:0,
    product:[{
      pid:'',
      pname:'',
      count:''
    }]
  }


  public order={
    buyername:'',
    buyeremail:'',
    buyeraddress:'',
    buyerphone:'',
    totalcost:0,
    pid:'',
    pname:'',
    count:''
  }

  public placeOrder(data:any){
    return this.http.post(`http://localhost:8999/order/`,data)
  }

  public setOrderDetails(data:any){
    this.orderDetails=data;
  }

  public getOrderDetils(){
    return this.orderDetails;
  }

  public addUser(user:any){
    return this.http.post(`${baseUrl}/user/`,user);
  }

  public addToCart(cart:any){
    return this.http.post(`${baseUrl}/cart/`,cart);
  }

  public addToWishlist(wishlist:any){
    return this.http.post(`${baseUrl}/wishlist/`,wishlist);
  }

  public getWishlist(){
    return this.http.get(`${baseUrl}/wishlist/`);
  }

  public getCart(){
    return this.http.get(`${baseUrl}/cart/`);
  }

  public deleteCart(cid:any){
    return this.http.delete(`${baseUrl}/cart/`+cid)
  }

  public deleteFromWishlist(wid:any){
    return this.http.delete(`${baseUrl}/wishlist/`+wid)
  }
}
