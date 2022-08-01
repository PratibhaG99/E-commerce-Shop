import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private _user:UserService, private router:Router) { }
  orderDetails:any;
  
  ngOnInit(): void {
    this.orderDetails = this._user.getOrderDetils();
  }

  placeOrder(){
    let x=this._user.getCid();
    console.log(this._user.getCid());
    for(let i=0; i<this.orderDetails.product.length; i++){
      let temp={
        buyername:'',
        buyeremail:'',
        buyeraddress:'',
        buyerphone:'',
        totalcost:0,
        pid:'',
        pname:'',
        count:''
      }
      temp.buyername=this.orderDetails.buyername;
      temp.buyeremail=this.orderDetails.buyeremail;
      temp.buyeraddress=this.orderDetails.buyeraddress;
      temp.buyerphone=this.orderDetails.buyerphone;
      temp.totalcost=this.orderDetails.totalcost;
      temp.pid=this.orderDetails.product[i].pid;
      temp.pname=this.orderDetails.product[i].pname;
      temp.count=this.orderDetails.product[i].count;
      this._user.placeOrder(temp).subscribe(
        (data:any)=>{
          temp=data;
          console.log("Success");

        },(error)=>{
          console.log(error);
        });
        let p=x.pop();
      this._user.deleteCart(p).subscribe(
        (data:any)=>{
          console.log(data);

        },(error)=>{
          console.log(error);
        });
    }
    this.router.navigate(['/user-dashboard/0']);
  }
}
