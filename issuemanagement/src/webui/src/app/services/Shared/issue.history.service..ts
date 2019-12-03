import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { Observable } from 'rxjs/Rx';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })  
export class IssueServiceHistory{

    private ISSUE_HISTORY_PATH = "/issue/history";

    constructor(private apiService: ApiService){

    }

    getAll(): Observable<any>{
      return this.apiService.get(this.ISSUE_HISTORY_PATH).pipe(map(
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
      return this.apiService.get(this.ISSUE_HISTORY_PATH, id).pipe(map(
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

    createIssueHistory(issueHistory) : Observable<any> {
             return this.apiService.post(this.ISSUE_HISTORY_PATH,issueHistory).pipe(map(
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
        return this.apiService.delete(this.ISSUE_HISTORY_PATH,id).pipe(map(
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