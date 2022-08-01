import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(private admin:AdminService) { }

  cid= localStorage.getItem('cid')
  category=null;
  products:any;
  
  addData={
    productname:'',
    price:'',
    stock:'',
    description:'',
    image:'',
    category:{
      cid:'',
    }
  }

  ngOnInit(): void {
    this.category=null;
    this.admin.categories().subscribe(
      (data:any)=>{
        this.category=data;
        console.log(this.addData);
      },(error)=>{
        console.log(error);
      });
  }

  show(){
    this.admin.getProducts().subscribe((data:any)=>{
      this.products=data;
      console.log(this.products);
    },
    (error)=>{
      console.log(error);
    });
  }

  data:any;

  add(){
    for(let i=1;i<this.data.length;i++){
      for(let j=0;j<6;j++){
        if(j==0){
          this.addData.productname = this.data[i][j];
        }
        if(j==1){
          this.addData.price = this.data[i][j];
        }
        if(j==2){
          this.addData.stock = this.data[i][j];
        }
        if(j==3){
          this.addData.image = this.data[i][j];
        }
        if(j==4){
          this.addData.description = this.data[i][j];
        }
        if(j==5){
          this.addData.category.cid = this.data[i][j];
        }
      }
      console.log(this.addData)
        //in outer loop
        this.admin.addProduct(this.addData).subscribe((data:any)=>{
          console.log(data);
          console.log("Product Added Successfully !!");
        },
        (error)=>{
          console.log(error);
        });
      }
      alert("All Product added successfull!!")
    }
 

  onFileUpload(event:any){
    const target: DataTransfer= <DataTransfer>(event.target);
    if(target.files.length !== 1)throw new Error('Cannot upload multiple files');
    const reader:FileReader = new FileReader();
    reader.onload=(e:any)=>{
      const bstr: string = e.target.result;
      const wb: XLSX.WorkBook = XLSX.read(bstr, {type: 'binary'})
      const wsname: string = wb.SheetNames[0];
      const ws: XLSX.WorkSheet = wb.Sheets[wsname];
      console.log(ws);
      this.data = (XLSX.utils.sheet_to_json(ws, {header:1}));
      console.log(this.data);
    };
    reader.readAsBinaryString(target.files[0]);
  }

  // delete(productname:String){
  //   console.log(productname);
  //   this.admin.deleteProduct(productname).subscribe((data:any)=>{
  //     alert("Product Deleted Successfully !!");
  //   },
  //   (error)=>{
  //     console.log(error);
  //   });
  // }

}