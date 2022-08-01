import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories:any;
  addData={
    categoryname:'',
  }
  constructor(private admin:AdminService,private router: Router) { }

  ngOnInit(): void {
  }

  show(){
    this.categories=null;
    this.admin.categories().subscribe((data:any)=>{
      this.categories=data;
      console.log(this.categories);
    },
    (error)=>{
      console.log(error);
    });
  }

  delete(categoryname:String){
    console.log(categoryname);
    this.admin.deleteCategory(categoryname).subscribe((data:any)=>{
      alert("Product Category Deleted Successfully !!");
    },
    (error)=>{
      console.log(error);
    });
  }

  add(){
    this.admin.addCategory(this.addData).subscribe((data:any)=>{
      alert("Product Category Added Successfully !!");
    },
    (error)=>{
      console.log(error);
    });
  }

}
