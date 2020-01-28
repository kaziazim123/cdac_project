import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAdoptionRegisterComponent } from './admin-adoption-register.component';

describe('AdminAdoptionRegisterComponent', () => {
  let component: AdminAdoptionRegisterComponent;
  let fixture: ComponentFixture<AdminAdoptionRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAdoptionRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAdoptionRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
