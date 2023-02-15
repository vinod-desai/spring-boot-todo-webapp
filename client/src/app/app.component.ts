import { Component } from '@angular/core';
import { ApplicationInsightsService } from './service/application-insights.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private ApplicationInsightsService: ApplicationInsightsService){ }

}
