import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Chapter} from './chapter';
import { retry, catchError} from 'rxjs/operators';

@Injectable()
export class ChapterService{

  baseurl = 'http://localhost:8080';

  constructor(private http: HttpClient){}
     
  ngOninit(){

  }

  // Http Headers
  httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
        })
  }

      // GET
    getChapter(topicId: number, storyId: number, chapterId: number): Observable<Chapter> {
        return this.http.get<Chapter>(this.baseurl + '/topics/'+ topicId +'/stories/' + storyId +'/chapters/' + chapterId)
        .pipe(
        retry(1),
        catchError(this.handleError)
    ) 
  }

  private handleError(error: Response){
    return Observable.throw(error);
  }

}