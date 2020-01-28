import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminDonationListComponent } from './admin-donation-list.component';

describe('AdminDonationListComponent', () => {
  let component: AdminDonationListComponent;
  let fixture: ComponentFixture<AdminDonationListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminDonationListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminDonationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
