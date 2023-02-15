import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiBaseUrl } from './service.constsants';

@Injectable({
  providedIn: 'root'
})
export class AboutService {

  constructor(private http: HttpClient) { }

  getAbout(): Observable<void> {
    const aboutEndPoint: string = "/about";
    return this.http.get<void>(ApiBaseUrl + aboutEndPoint);
  }
}
