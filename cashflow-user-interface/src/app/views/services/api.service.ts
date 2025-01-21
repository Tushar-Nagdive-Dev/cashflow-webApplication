import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private BASE_URL = 'http://localhost:2001/api'; // Default Base URL

  constructor(private http: HttpClient) {}

  /**
   * Set Base URL dynamically
   */
  setBaseUrl(url: string): void {
    this.BASE_URL = url;
  }

  /**
   * Generic GET method
   */
  get<T>(
    endpoint: string,
    params?: HttpParams | { [param: string]: string | number | boolean },
    headers?: { [header: string]: string | string[] }
  ): Observable<T> {
    const options = this.createOptions(params, headers);
    return this.http.get<T>(`${this.BASE_URL}/${endpoint}`, options).pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Generic POST method
   */
  post<T>(
    endpoint: string,
    body: any,
    headers?: { [header: string]: string | string[] }
  ): Observable<T> {
    const options = this.createOptions(undefined, headers);
    return this.http.post<T>(`${this.BASE_URL}/${endpoint}`, body, options).pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Generic PUT method
   */
  put<T>(
    endpoint: string,
    body: any,
    headers?: { [header: string]: string | string[] }
  ): Observable<T> {
    const options = this.createOptions(undefined, headers);
    return this.http.put<T>(`${this.BASE_URL}/${endpoint}`, body, options).pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Generic DELETE method
   */
  delete<T>(
    endpoint: string,
    params?: HttpParams | { [param: string]: string | number | boolean },
    headers?: { [header: string]: string | string[] }
  ): Observable<T> {
    const options = this.createOptions(params, headers);
    return this.http.delete<T>(`${this.BASE_URL}/${endpoint}`, options).pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Generic PATCH method
   */
  patch<T>(
    endpoint: string,
    body: Partial<T>,
    headers?: { [header: string]: string | string[] }
  ): Observable<T> {
    const options = this.createOptions(undefined, headers);
    return this.http.patch<T>(`${this.BASE_URL}/${endpoint}`, body, options).pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Create Request Options
   */
  private createOptions(
    params?: HttpParams | { [param: string]: string | number | boolean },
    headers?: { [header: string]: string | string[] }
  ): { headers?: HttpHeaders; params?: HttpParams } {
    const httpHeaders = headers ? new HttpHeaders(headers) : undefined;
    const httpParams =
      params instanceof HttpParams ? params : new HttpParams({ fromObject: params });
    return { headers: httpHeaders, params: httpParams };
  }

  /**
   * Handle Errors
   */
  private handleError(error: any): Observable<never> {
    console.error('API Error:', error);
    return throwError(() => new Error(error.message || 'Server Error'));
  }
}
