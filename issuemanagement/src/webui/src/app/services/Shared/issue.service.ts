import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { Observable } from 'rxjs/Rx';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })  
export class IssueServie{

    private ISSUE_PATH = "/issue";

    constructor(private apiService: ApiService){

    }

    getAll(): Observable<any>{
      return this.apiService.get(this.ISSUE_PATH).pipe(map(
          res =>{
              if(res) {
                  return res;

              }else {
                  console.log(res);
                  return null;
              }
          }
      ));
    }


    getById(id): Observable<any>{
      return this.apiService.get(this.ISSUE_PATH, id).pipe(map(
          res =>{
              if(res) {
                  return res;

              }else {
                  console.log(res);
                  return null;
              }
          }
      ));
    }

    createIssue(issue) : Observable<any> {
             return this.apiService.post(this.ISSUE_PATH,issue).pipe(map(
          res =>{
              if(res) {
                  return res;

              }else {
                  console.log(res);
                  return null;
              }
          }
      ));

    }

    delete(id) : Observable<any> {
        return this.apiService.delete(this.ISSUE_PATH,id).pipe(map(
     res =>{
         if(res) {
             return res;

         }else {
             console.log(res);
             return null;
         }
     }
 ));

}

}