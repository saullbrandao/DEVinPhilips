import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { NotificationService } from './notification.service';
import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

describe('NotificationService', () => {
  let httpTestingController: HttpTestingController;
  let httpClient: HttpClient;
  let notificationService: NotificationService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [NotificationService],
    }).compileComponents();

    httpTestingController = TestBed.inject(HttpTestingController);
    httpClient = TestBed.inject(HttpClient);
    notificationService = TestBed.inject(NotificationService);
  });

  it('Should create component', () => {
    expect(notificationService).toBeTruthy();
  });
});
