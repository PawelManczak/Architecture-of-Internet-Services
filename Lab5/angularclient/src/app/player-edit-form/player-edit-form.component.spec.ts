import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerEditFormComponent } from './player-edit-form.component';

describe('PlayerEditFormComponent', () => {
  let component: PlayerEditFormComponent;
  let fixture: ComponentFixture<PlayerEditFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PlayerEditFormComponent]
    });
    fixture = TestBed.createComponent(PlayerEditFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
