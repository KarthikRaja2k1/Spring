import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-http-client-module',
  templateUrl: './http-client-module.component.html',
  styleUrls: ['./http-client-module.component.css']
})
export class HttpClientModuleComponent implements OnInit {

  li:any;
  lis=[];
  constructor(private http : HttpClient){
     
}
ngOnInit(): void {
  this.http.get('http://www.mocky.io/v2/5ea172973100002d001eeada')
  .subscribe(Response => {

    // If response comes hideloader() function is called
    // to hide that loader
    // if(Response){ 
    //   hideloader();
    // }
    console.log(Response);
    //document.getElementById("display").innerHTML=JSON.stringify(Response);
    this.li=Response; 
    // this.lis=this.li.list;
  });
  // function hideloader(){
  //  document.getElementById('loading').style.display = 'none';}
}

}
