import { Component, Inject, Input, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
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
  payerId = new FormControl();
  payerLinkedAccount = new FormControl();  
  payerAccountType = new FormControl();
  
  // country = new FormControl({value: 'India', disabled: true});
  // married = new FormControl(true);
  // mandateType = new FormControl(20, Validators.required);
  filteredPayerId:Array<any>; 
  filteredPayerLinkedAccount:Array<any>;
  filteredPayerAccountType:Array<any>;

  constructor(private http : HttpClient,@Inject(MAT_DIALOG_DATA) public data: any){
    this.filteredPayerId=[];
    this.filteredPayerAccountType = [];
    this.filteredPayerLinkedAccount = [];};
  ngOnInit(): void {
    
    this.http.get(this.data)
    .subscribe(Response => {this.mandate=Response;
    this.http.get('http://localhost:8080/accounts/'+this.mandate.payeeId) .subscribe(Response => {this.payee=Response;});
    this.http.get('http://localhost:8080/accounts/'+this.mandate.payerId) .subscribe(Response => {this.payer=Response;});
    this.FilterData();
    });
    this.payerId.valueChanges.forEach(response=>{this.FilterData()});
    this.payerAccountType.valueChanges.forEach(response=>{this.FilterData()});
    this.payerLinkedAccount.valueChanges.forEach(response=>{this.FilterData()});

  }

  
FilterData(){
  let post={ "field":"payerId","Id":this.payerId.value,"accountType":this.payerAccountType.value,"linkedAccount":this.payerLinkedAccount.value}
  let url="http://localhost:8080/accounts/autocomplete";
  post.field = "payerId";
  this.filteredPayerId = this.Autocomplete(url,post);
  post.field = "accountType";
  this.filteredPayerAccountType = this.Autocomplete(url,post);
  post.field = "linkedAccount";
  this.filteredPayerLinkedAccount = this.Autocomplete(url,post);
  // post.field = "accountNumber";
  // this.filteredAccountNumber = this.Autocomplete(url,post);
  
}

  Autocomplete(url:string,post:any){
    this.http.post(url,post)
    .subscribe(Response => {
    console.log("For debugging autocomplete:",Response);
    return <Array<any>>Response;
    
    });
    return [];
  }
  

}
