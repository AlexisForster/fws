import {HttpClient, HttpHeaders} from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Story} from '../story/story';
import { retry, catchError} from 'rxjs/operators';

@Injectable()
export class StoryListService{

  baseurl = 'http://localhost:8080';

  constructor(private http: HttpClient){}
  
  // Http Headers
  httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
        })
  }

      // GET
    getStoriesByBookshelf(topicId: number): Observable<Story> {
        return this.http.get<Story>(this.baseurl + '/bookshelf/' + topicId + '/stories/')
        .pipe(
        retry(1),
        catchError(this.handleError)
    )
  }

  private handleError(error: Response){
    return Observable.throw(error);
  }

}