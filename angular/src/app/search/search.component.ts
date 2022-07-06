import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { FormControl, Validators } from '@angular/forms';
import { MatDialog } from  '@angular/material/dialog';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { MatAutocomplete } from '@angular/material/autocomplete';

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
  filteredMandateType:Array<any>;
  filteredMandateId:Array<any>;
  filteredAccountNumber:Array<any>;
  data:any;
  options:Array<any>;

  filteredOptions=["Sam", "Varun", "Jasmine"];
  constructor(private http : HttpClient,private  dialogRef : MatDialog){
    this.cols=["Mandate ID","Payee","Payer","Mandate valid From","Mandate Valid To","Status","Actions"]
    this.data=[]
    this.options=[];
    this.filteredMandateType=[];
    this.filteredMandateId=[];
    this.filteredAccountNumber=[];
}


ngOnInit(): void {
  this.FilterData();
  this.mandateId.valueChanges.forEach(response=>{this.FilterData();console.log("auto",this.mandateId);});
  this.mandateType.valueChanges.forEach(response=>{this.FilterData();console.log("auto",this.mandateType);});
  //this.accountNumber.valueChanges.forEach(response=>{this.FilterData()});
}

FilterData(){
  let post={ "field":"branchCode","branchCode":this.branchCode.value,"mandateId":this.mandateId.value,"mandateType":this.mandateType.value,"accountNumber":this.accountNumber.value }
  let url="http://localhost:8080/mandates/autocomplete";
  post.field = "mandateId";
  this.filteredMandateId = this.Autocomplete(url,post);
  post.field = "mandateType";
  this.filteredMandateType = this.Autocomplete(url,post);
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


Search(){
  console.log(this.branchCode.value,this.mandateId.value,this.mandateType.value,this.accountNumber.value);
  this.http.post('http://localhost:8080/mandates',{ "branchCode":this.branchCode.value,"mandateId":this.mandateId.value,"mandateType":this.mandateType.value,"accountNumber":this.accountNumber.value })
  .subscribe(Response => {
  this.data=Response;
  console.log("For debugging:",Response);
  });
}
openDialog(param:any){

  this.dialogRef.open(PopUpComponent,{
    
    width: '600px',
    height: '1000px',
    position: {right: '5px'},
    data: param
  }) 
  
}
}