import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongEditing } from './song-editing';

describe('SongEditing', () => {
  let component: SongEditing;
  let fixture: ComponentFixture<SongEditing>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SongEditing]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongEditing);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
