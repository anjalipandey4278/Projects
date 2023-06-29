import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NodeWithI18n } from '@angular/compiler';
import { keyframes } from '@angular/animations';
import baseUrl from './product-details/constant';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {


  constructor(private http:HttpClient) { }
  public longinUserFromRemote(users:User):Observable<any>{
    return this.http.post<any>(`${baseUrl}login`,users)

  }
  public RegisterUserFromRemote(users:User):Observable<any>{
    return this.http.post<any>(`${baseUrl}registeruser`,users)

  }
  public GetallProduct():Observable<any>{
    return this.http.get<any>(`${baseUrl}getallProducts`)
  }
  public getproductCount():Observable<any>{
    return this.http.get<any>(`${baseUrl}getproductCount`)
  }
  public getuserCount():Observable<any>{
    return this.http.get<any>(`${baseUrl}getUsersCount`)
  }
  public getonlineuser():Observable<any>{
    return this.http.get<any>(`${baseUrl}getonlineuser`)
  }
  public search(search: any):Observable<any>{
    return this.http.get<any>(`${baseUrl}search?query=`+search)
  }
  public logoutUserFromRemote(userid : any):Observable<any>{
   
    return this.http.post<any>(`${baseUrl}logout`,userid)
  }
  public savreviews(reviewdata :any,productId :any):Observable<any>{
    console.log(productId)
    return this.http.post<any>(`${baseUrl}Product/${productId}/reviews`,reviewdata)
  }
  public getReviews(productId :any):Observable<any>{
    return this.http.get<any>(`${baseUrl}Product/${productId}/reviews`)
  }
  public approveReviewById(id:any):Observable<any>{
    return this.http.post<any>(`${baseUrl}review`, id)
  }
  public declineReviewById(id:any):Observable<any>{
    return this.http.delete<any>(`${baseUrl}review/`+id)
  }
  public getProductById(id:any):Observable<any>{
    return this.http.get<any>(`${baseUrl}Products/`+id)
    
  }
  public getAvgRating(productId :any):Observable<any>{
    return this.http.get<any>(`${baseUrl}Product/${productId}/avgreview`)
  }
}
