import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private https: HttpClient) {
   }

   get(path: String, params: HttpParams = new HttpParams()) : Observable<any>{
         return this.http.get(path,{params}).pipe(catchError(this.formatError));
   }

   post(path: String, params: HttpParams = new HttpParams()) : Observable<any>{
    return this.http.post(path,{params}).pipe(catchError(this.formatError));
   }

   put(path: String, params: HttpParams = new HttpParams()) : Observable<any>{
    return this.http.put(path,{params}).pipe(catchError(this.formatError));
  }
 
  delete(path: String, params: HttpParams = new HttpParams()) : Observable<any>{
    return this.http.delete(path,{params}).pipe(catchError(this.formatError));
  }

   private formatError(error: any){
     return Observable.of(error.error);

   }
}
