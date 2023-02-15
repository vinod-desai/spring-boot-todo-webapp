import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TodoService } from '../service/todo.service';
import { Todo } from './todo';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent {

  todos$: Observable<Todo[]>;

  constructor(private readonly todoService: TodoService) {
    this.todos$ = this.todoService.getTodos();
  }

}
