import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongCardEditable } from './song-card-editable';

describe('SongCardEditable', () => {
  let component: SongCardEditable;
  let fixture: ComponentFixture<SongCardEditable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SongCardEditable]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongCardEditable);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
