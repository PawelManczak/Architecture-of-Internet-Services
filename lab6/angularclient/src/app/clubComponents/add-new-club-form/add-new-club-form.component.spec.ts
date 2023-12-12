import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewClubFormComponent } from './add-new-club-form.component';

describe('AddNewClubFormComponent', () => {
  let component: AddNewClubFormComponent;
  let fixture: ComponentFixture<AddNewClubFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddNewClubFormComponent]
    });
    fixture = TestBed.createComponent(AddNewClubFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
