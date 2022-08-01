import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  constructor(private admin:AdminService) { }

  report=null;

  ngOnInit(): void {
    this.admin.getReport().subscribe(
      (data:any)=>{
        this.report=data;
      },(error)=>{
        console.log(error);
      });
  }

}
