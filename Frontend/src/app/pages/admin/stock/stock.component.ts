import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  constructor(private admin:AdminService,private router: Router) { }
  products=null

  ngOnInit(): void {
    this.admin.getProducts().subscribe(
      (data:any)=>{
        this.products=data;
        console.log(this.products);
      },(error)=>{
        console.log(error);
      });
  }

  mail(pname:any){
    this.router.navigate(['/admin/mail']);
  }
}
