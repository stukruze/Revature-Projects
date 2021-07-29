import { Component, OnInit } from '@angular/core';
import { WebRequestService } from './web-request.service'

export class bored {
  constructor(
    private accessibility: number,
    private activity: string,
    private key: number,
    private link: string,
    private paricipants: number,
    private price: number,
    private type: string 
    ){
      this.accessibility = accessibility;
      this.activity = activity;
      this.key = key;
      this.link = link;
      this.paricipants = paricipants;
      this.price = price;
      this.type = type;
    }
}


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  boreds!: bored;
  uri: string = '';

  constructor(private api:WebRequestService){}

  
ngOnInit(){
  this.api.getURL(this.uri).subscribe((data)=>{
    console.warn("get api data", data);
    this.boreds = data;
});
}
}