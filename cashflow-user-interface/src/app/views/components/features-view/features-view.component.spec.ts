import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturesViewComponent } from './features-view.component';

describe('FeaturesViewComponent', () => {
  let component: FeaturesViewComponent;
  let fixture: ComponentFixture<FeaturesViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeaturesViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeaturesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
