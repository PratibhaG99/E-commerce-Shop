import { Component, OnInit } from '@angular/core';

import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private admin:AdminService) { }

  ngOnInit(): void {
  }

  coupons:any;
  addDiscount={
    couponname:'',
    percentage:0
  }

  add(){
    this.admin.addCoupon(this.addDiscount).subscribe((data:any)=>{
      alert("Discount Coupon Added Successfully !!");
    },
    (error)=>{
      console.log(error);
    });
  }

  show(){
    this.coupons=null;
    this.admin.getAllCoupons().subscribe((data:any)=>{
      this.coupons=data;
      console.log(this.coupons);
    },
    (error)=>{
      console.log(error);
    });
  }

}
