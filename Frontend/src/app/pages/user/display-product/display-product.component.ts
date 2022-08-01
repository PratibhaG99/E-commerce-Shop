import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-display-product',
  templateUrl: './display-product.component.html',
  styleUrls: ['./display-product.component.css']
})
export class DisplayProductComponent implements OnInit {
  products:any;
  catId:any;
  u:any;
  cart={
    count:1,
    product:'',
    user:''
  }

  wishlist={
    wproduct:'',
    wuser:''
  }

  constructor(private route:ActivatedRoute, private admin:AdminService, private _user:UserService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
          this.catId = +params['catId'];
          if(this.catId==0){
            this.u=localStorage.getItem('user');
            this.cart.user=JSON.parse(this.u);

            this.u=localStorage.getItem('user');
            this.wishlist.wuser=JSON.parse(this.u);
            this.admin.getProducts().subscribe((data:any)=>{
              this.products=data;
            },
            (error)=>{
              console.log(error);
            })
          }
          else{
            this.admin.getProductOfCategory(this.catId).subscribe((data)=>{

              this.u=localStorage.getItem('user');
              this.cart.user=JSON.parse(this.u);

              this.u=localStorage.getItem('user');
              this.wishlist.wuser=JSON.parse(this.u);
              this.products=data;
            },
            (error)=>{
              console.log("error");
              alert("Error in loading Products by category!!");
            });
          }
        },(error)=>{
          console.log(error);
        });
    }


    addToCart(p:any){
      console.log(p);
      this.cart.product=p;
      console.log(this.cart);
      this._user.addToCart(this.cart).subscribe((data:any)=>{
        console.log(data);
        alert("Product Added to cart!!");
      },
      (error)=>{
        console.log(error);
      });
    }

    addToWishlist(p:any){
      console.log(p);
      this.wishlist.wproduct=p;
      console.log(this.wishlist);
      this._user.addToWishlist(this.wishlist).subscribe((data:any)=>{
        console.log(data);
        alert("Product Added to Wishlist!!");
      },
      (error)=>{
        console.log(error);
      });
    }
}

