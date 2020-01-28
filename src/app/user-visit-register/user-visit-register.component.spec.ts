import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserVisitRegisterComponent } from './user-visit-register.component';

describe('UserVisitRegisterComponent', () => {
  let component: UserVisitRegisterComponent;
  let fixture: ComponentFixture<UserVisitRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserVisitRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserVisitRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
