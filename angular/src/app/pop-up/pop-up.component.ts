import { Component, Inject, Input, OnInit } from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {HttpClient} from '@angular/common/http';
import { FormControl, Validators } from '@angular/forms';
@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})
export class PopUpComponent implements OnInit {
  mandate:any;
  payee:any;
  payer:any;
  isDataLoaded=false;
  payerId = new FormControl();
  payerLinkedAccount = new FormControl();  
  payerAccountType = new FormControl();
  mandateId = new FormControl();
  modal = new FormControl();
  
  // country = new FormControl({value: 'India', disabled: true});
  // married = new FormControl(true);
  // mandateType = new FormControl(20, Validators.required);
  filteredPayerId:any; 
  filteredPayerLinkedAccount:any;
  filteredPayerAccountType:any;

  constructor(private http : HttpClient,private dialogRef: MatDialogRef<PopUpComponent>,@Inject(MAT_DIALOG_DATA) public data: any){
    
    this.filteredPayerId=[];
    this.filteredPayerAccountType = [];
    this.filteredPayerLinkedAccount = [];
    
    this.http.get(this.data)
    .subscribe(Response => {this.mandate=Response;
    this.http.get('http://localhost:8080/accounts/'+this.mandate.payeeId) .subscribe(Response => {this.payee=Response;});
    this.http.get('http://localhost:8080/accounts/'+this.mandate.payerId) .subscribe(Response => {this.payer=Response;
    this.mandateId.setValue(this.mandate.id);
    this.payerId.setValue(this.payer.id);
    this.payerLinkedAccount.setValue(this.payer.linkedAccount);
    this.payerAccountType.setValue(this.payer.accountType);
    this.FilterData();
    this.isDataLoaded=true;
    });

  

    });
    this.payerId.valueChanges.forEach(response=>{this.payerLinkedAccount.setValue("");this.payerAccountType.setValue("");this.FilterData()});
    this.payerAccountType.valueChanges.forEach(response=>{this.FilterData()});
    this.payerLinkedAccount.valueChanges.forEach(response=>{this.FilterData()});

  
  };
  ngOnInit(): void {
    
  }

  
FilterData(){
  let postdata={ "field":"payerId","Id":this.payerId.value,"accountType":this.payerAccountType.value,"linkedAccount":this.payerLinkedAccount.value}
  let url="http://localhost:8080/accounts/autocomplete";
  postdata.field = "accountId";
  this.http.post(url,postdata).subscribe(Response =>{this.filteredPayerId=Response;});
  postdata.field = "accountType";
  this.http.post(url,postdata).subscribe(Response =>{this.filteredPayerAccountType=Response;});
  postdata.field = "linkedAccount";
  this.http.post(url,postdata).subscribe(Response =>{this.filteredPayerLinkedAccount=Response;});
  
}

submit(){
  var url="http://localhost:8080/mandates"
  var putdata ={
    "id":this.mandateId.value,
    "payerId":this.payerId.value } ;
  console.log("PUT");
  this.http.put<any>(url,putdata).subscribe();
  this.dialogRef.close();
}
close() {
  this.dialogRef.close();
}
  

}
