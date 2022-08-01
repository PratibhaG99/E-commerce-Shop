import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  categoryId=localStorage.getItem('cid');

  public getCategory(){
    return this.http.get(`${baseUrl}/category/`+localStorage.getItem('cid'));
  }

  public categories(){
    return this.http.get(`${baseUrl}/category/getAllCat`);
  }
  
  public getProducts(){
    return this.http.get(`${baseUrl}/product/`);
  }

  public addCategory(addData: any){
    return this.http.post(`${baseUrl}/category/`, addData);
  }

  public addProduct(addData: any){
    return this.http.post(`${baseUrl}/product/`, addData);
  }

  public deleteCategory(categoryname:any){
    return this.http.delete(`${baseUrl}/category/`+categoryname);
  }

  public deleteProduct(productname:any){
    return this.http.delete(`${baseUrl}/product/`+productname);
  }

  //get products of category
  public getProductOfCategory(cid:any){
    return this.http.get(`${baseUrl}/product/cat/`+cid);
  }

  //get report from report microservice
  public getReport(){
    return this.http.get(`http://localhost:8999/order/`)
  }

  public updateProduct(product:any){
    return this.http.put(`${baseUrl}/product/updateProd`,product);
  }

  public getProductById(pid:any){
    return this.http.get(`${baseUrl}/product/byId/`+pid);
  }

  public addCoupon(coupon:any){
    return this.http.post(`http://localhost:8999/discount/`,coupon);
  }

  public getAllCoupons(){
    return this.http.get(`http://localhost:8999/discount/`)
  }
}
