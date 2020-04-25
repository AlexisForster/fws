import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Story } from '../story/story';
import { Bookshelf } from '../bookshelf/bookshelf';
import { retry, catchError } from 'rxjs/operators';

@Injectable()
export class StoryListService {

  baseurl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // GET
  getStoriesByBookshelf(bookshelfId: number): Observable<Story> {
    return this.http.get<Story>(this.baseurl + '/bookshelf/' + bookshelfId + '/stories/')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  getBookshelf(bookshelfId: number): Observable<Bookshelf> {
    return this.http.get<Bookshelf>(this.baseurl + '/bookshelf/' + bookshelfId)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }
  private handleError(error: Response) {
    return Observable.throw(error);
  }

}