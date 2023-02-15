import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AboutService } from '../service/about.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit, OnDestroy  {

  private subscriptions = new Subscription();

  constructor(private readonly aboutService: AboutService) { }

  ngOnInit(): void {
    this.subscriptions.add(this.aboutService.getAbout().subscribe());
  }

  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }

}

