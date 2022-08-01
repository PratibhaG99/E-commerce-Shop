import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private _user:UserService, private router: Router,private admin:AdminService) { }
  u=localStorage.getItem('username');

orderDetails={
  buyername:'',
  buyeremail:'',
  buyeraddress:'',
  buyerphone:'',
  totalcost:0,
  product:[
    {
    pid:'',
    pname:'',
    count:''
  }
]
}
  flag=0;
  cart:any;
  newStock={
    productname:'',
    price:'',
    stock:0,
    description:'',
    image:'',
  }

  ngOnInit(): void {
    this._user.getCart().subscribe(
      (data:any)=>{
        this.cart=data;
        console.log(this.cart);
      },(error)=>{
        console.log(error);
      });
  }

  order(){
    this._user.cid.pop();
    this.orderDetails.product.pop();
    let sum=0;
    let x={
      pid:'',
      pname:'',
      count:''
    }
    for(let c of this.cart){
      this._user.setCid(c.cartid);
      console.log("This is cart id test "+c.cartid);
      x={
        pid:'',
        pname:'',
        count:''
      }
      let l=1;
        this.orderDetails.buyername=c.user.firstName+" "+c.user.lastName ;
        this.orderDetails.buyeremail=c.user.email;
        this.orderDetails.buyeraddress=c.user.address;
        this.orderDetails.buyerphone=c.user.phone;
        if(c.user.username==this.u){
          x.pid=c.product.pid;
          x.pname=c.product.productname;
          for(let t of this.temp){
            if(t.pid==c.product.pid){
              x.count=t.count;
              l=Number(t.count);
          }
          }
          
          this.admin.getProductById(c.product.pid).subscribe((data:any)=>{
            this.newStock=data;
            this.newStock.stock = this.newStock.stock - l;
            this.admin.updateProduct(this.newStock).subscribe((data:any)=>{
              console.log(data);
            },
            (error)=>{
              console.log(error);
            })
            // console.log(this.newStock);
          },(error)=>{
            console.log(error);
          });
          sum = sum + (c.count*c.product.price);
          console.log(x)
          this.orderDetails.product.push(x);
        }
    }
    if(this.orderDetails.product.length==0){
      alert("Your Cart is empty");
    }else{
      this.orderDetails.totalcost= sum - sum*(this.percentage/100);
      console.log(this.orderDetails.product);
      this._user.setOrderDetails(this.orderDetails);
      console.log(this.orderDetails);
      this.router.navigate(['/user-dashboard/0/order']);
    }
  }

  deleteFromCart(cid:any){
    this._user.deleteCart(cid).subscribe(
      (data:any)=>{
        alert("Item deleted from Cart");
      },(error)=>{
        console.log(error);
      });
      this.router.navigate(['/user-dashboard/0']);
  }

  count:any;
  temp=[{
    pid:'',
    count:''
  }];
  setCount(pid:any){
    let newCount={
      pid:'',
      count:''
    }
    newCount.pid=pid;
    newCount.count=this.count;
    let x=newCount;
    console.log(x);
    this.temp.push(x);
    console.log(this.temp);
  }

  percentage=0;
  coupons:any
  coupon:any
  setDiscount(){
    this.admin.getAllCoupons().subscribe((data)=>
    {
      this.coupons=data;
      console.log(this.coupons);
      for(let d of this.coupons){
        if(d.couponname==this.coupon){
          this.percentage=d.percentage;
          console.log(this.percentage);
          alert("Discount of "+this.percentage+"% is applied!!!")
        }
      }
    },(error)=>{
      alert("error in fetching discount options!!")
    })
  }
}
