import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchSong } from './search-song';

describe('SearchSong', () => {
  let component: SearchSong;
  let fixture: ComponentFixture<SearchSong>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchSong]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchSong);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
