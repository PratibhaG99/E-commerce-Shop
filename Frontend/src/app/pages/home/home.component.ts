import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private admin:AdminService) { }

  products:any;

  ngOnInit(): void {
    this.admin.getProducts().subscribe((data:any)=>{
      this.products=data;
    },
    (error)=>{
      console.log(error);
    });
  }

}
