
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private REST_API_SERVER = "http://localhost:8080/products";
  constructor(private httpClient: HttpClient) {

  }
  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
  public sendGetRequest() {
    return this.httpClient.get(this.REST_API_SERVER).pipe(retry(3), catchError(this.handleError));
  }

}
