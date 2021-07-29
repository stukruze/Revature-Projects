import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class WebRequestService {

  readonly ROOT_URL: any;
  constructor(private httpClient: HttpClient) {
    this.ROOT_URL = 'https://www.boredapi.com/api/activity'
   }

   getURL(uri: string){
     return this.httpClient.get(`${this.ROOT_URL}/${uri}`);
   }
}
