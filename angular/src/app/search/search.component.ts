import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog } from  '@angular/material/dialog';
import { PopUpComponent } from '../pop-up/pop-up.component';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  branchCode = new FormControl();
  mandateType = new FormControl();  
  accountNumber = new FormControl();
  mandateId = new FormControl();
  // country = new FormControl({value: 'India', disabled: true});
  // married = new FormControl(true);
  // mandateType = new FormControl(20, Validators.required); 
  cols:Array<any>;
  data:any;
<<<<<<< HEAD
  constructor(private http : HttpClient,private  dialogRef : MatDialog){
     this.cols=["id","payerId","payeeId","validFrom","validTo","status"]
=======
  constructor(private http : HttpClient){
     this.cols=["Mandate ID","Payee","Payer","Mandate valid From","Mandate Valid To","Status","Actions"]
>>>>>>> 2446e159b4dad5e83ebc11e7ed4af4195de57692
     this.data=[]
}

ngOnInit(): void {
}
Search(){
  console.log(this.branchCode.value,this.mandateId.value,this.mandateType.value,this.accountNumber.value);
  this.http.post('http://localhost:8080/mandates',{ "branchCode":this.branchCode.value,"mandateId":this.mandateId.value,"mandateType":this.mandateType.value,"accountNumber":this.accountNumber.value })
  .subscribe(Response => {
  let ele = document.getElementById("test") as HTMLDivElement;
  this.data=Response;
  console.log("For debugging:",Response);
  },
  error=>{alert("Refresh or wait, error occurred");console.log("For debugging:",error);});
}
openDialog(){

  this.dialogRef.open(PopUpComponent,{
    width: '600px',
    height: '1000px',
    position: {right: '5px'}
  }) 
}
}