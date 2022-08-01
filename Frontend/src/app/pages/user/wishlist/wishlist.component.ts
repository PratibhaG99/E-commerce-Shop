import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

  constructor(private _user:UserService,private router: Router) { }
  u=localStorage.getItem('username');

  wishlist=null;
  cart={
    count:1,
    product:'',
    user:''
  }

  ngOnInit(): void {
    this._user.getWishlist().subscribe(
      (data:any)=>{
        this.wishlist=data;
        console.log(this.wishlist);
      },(error)=>{
        console.log(error);
      });
  }

  moveToCart(product:any, user:any, wid:any){
    this.cart.product=product;
    this.cart.user=user;
    console.log("Wishlist to be deleted=> "+ wid)
    console.log(this.cart);
      this._user.addToCart(this.cart).subscribe((data:any)=>{
        alert("Product Moved to cart!!");
      },
      (error)=>{
        alert("Something Went Wrong!!!")
        console.log(error);
      });
      this._user.deleteFromWishlist(wid).subscribe(
        (data:any)=>{
          console.log("Success");
        },(error)=>{
          console.log(error);
        });
      this.router.navigate(['/user-dashboard/0/cart']);
  }

}
