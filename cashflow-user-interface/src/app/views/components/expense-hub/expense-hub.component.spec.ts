import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseHubComponent } from './expense-hub.component';

describe('ExpenseHubComponent', () => {
  let component: ExpenseHubComponent;
  let fixture: ComponentFixture<ExpenseHubComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExpenseHubComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExpenseHubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
