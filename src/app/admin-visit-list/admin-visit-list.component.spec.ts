import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminVisitListComponent } from './admin-visit-list.component';

describe('AdminVisitListComponent', () => {
  let component: AdminVisitListComponent;
  let fixture: ComponentFixture<AdminVisitListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminVisitListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminVisitListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
