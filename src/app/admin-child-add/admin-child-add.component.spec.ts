import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminChildAddComponent } from './admin-child-add.component';

describe('AdminChildAddComponent', () => {
  let component: AdminChildAddComponent;
  let fixture: ComponentFixture<AdminChildAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminChildAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminChildAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
