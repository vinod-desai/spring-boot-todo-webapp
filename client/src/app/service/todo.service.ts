import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Todo } from '../todo-list/todo';
import { Observable } from 'rxjs';
import { ApiBaseUrl } from './service.constsants';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient) { }

  getTodos(): Observable<Todo[]> {
    const todosEndPoint: string = "/todos";
    return this.http.get<Todo[]>(ApiBaseUrl + todosEndPoint);
  }

}
