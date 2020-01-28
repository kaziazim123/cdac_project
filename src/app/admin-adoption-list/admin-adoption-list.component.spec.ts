import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAdoptionListComponent } from './admin-adoption-list.component';

describe('AdminAdoptionListComponent', () => {
  let component: AdminAdoptionListComponent;
  let fixture: ComponentFixture<AdminAdoptionListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAdoptionListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAdoptionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
