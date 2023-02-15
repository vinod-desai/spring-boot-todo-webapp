import { ErrorHandler, Injectable } from '@angular/core';
import { ApplicationInsightsService } from './application-insights.service';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService extends ErrorHandler {

  constructor(private applicationInsightsService: ApplicationInsightsService) {
    super();
  }

  override handleError(error: Error) {
    this.applicationInsightsService.logException(error);
  }

}
