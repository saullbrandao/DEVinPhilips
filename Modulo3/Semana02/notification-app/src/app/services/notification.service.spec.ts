import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { NotificationService } from './notification.service';
import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { NOTIFICATIONS_MOCK } from '../utils/notifications-mock';

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

  it('getNotifications - Should call method with success', () => {
    notificationService.getNotifications().subscribe((data) => {
      expect(data).toEqual(NOTIFICATIONS_MOCK);
    });
  });

  it('getNotificationsApi - Should call method with success', () => {
    notificationService.getNotificationsApi().subscribe();

    const request = httpTestingController.expectOne(
      `${notificationService.BASE_URL}`
    );
    expect(request.request.method).toEqual('GET');
    httpTestingController.verify();
  });

  it('addNotificationApi - Should call method with success', () => {
    const notificationMock = { message: 'Test' };

    notificationService.addNotificationApi(notificationMock).subscribe();

    const request = httpTestingController.expectOne(
      `${notificationService.BASE_URL}`
    );
    expect(request.request.method).toEqual('POST');
    expect(request.request.body).toEqual(notificationMock);
    httpTestingController.verify();
  });

  it('editNotificationApi - Should call method with success', () => {
    const notificationMock = { id: 1, message: 'Test' };

    notificationService.editNotificationApi(notificationMock).subscribe();

    const request = httpTestingController.expectOne(
      `${notificationService.BASE_URL}/${notificationMock.id}`
    );
    expect(request.request.method).toEqual('PUT');
    expect(request.request.body).toEqual(notificationMock);
    httpTestingController.verify();
  });

  it('removeNotification - Should call method with success', () => {
    const notificationMock = { id: 1, message: 'Test' };

    notificationService.removeNotification(notificationMock.id).subscribe();

    const request = httpTestingController.expectOne(
      `${notificationService.BASE_URL}/${notificationMock.id}`
    );
    expect(request.request.method).toEqual('DELETE');
    httpTestingController.verify();
  });
});
