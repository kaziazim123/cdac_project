import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminChildrenListComponent } from './admin-children-list.component';

describe('AdminChildrenListComponent', () => {
  let component: AdminChildrenListComponent;
  let fixture: ComponentFixture<AdminChildrenListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminChildrenListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminChildrenListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
