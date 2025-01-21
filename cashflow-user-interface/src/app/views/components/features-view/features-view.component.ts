import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-features-view',
  standalone: true,
  imports: [
    MatCardModule,
    RouterModule,
    MatIconModule,
    CommonModule
  ],
  templateUrl: './features-view.component.html',
  styleUrl: './features-view.component.scss'
})
export class FeaturesViewComponent implements OnInit{

  public cards:any;

  ngOnInit(): void {
    this.cards = [
      {
        title: 'Track Expenses',
        subtitle: 'Stay on top of your finances',
        description: 'Easily log and track your daily expenses with intuitive charts.',
        icon: 'attach_money',
        iconBackground: '#4caf50', // Green
        link: '/expenses',
      },
      {
        title: 'Set Budgets',
        subtitle: 'Plan for the future',
        description: 'Create monthly or custom budgets to manage your spending.',
        icon: 'pie_chart',
        iconBackground: '#ff9800', // Orange
        link: '/budgets',
      },
      {
        title: 'Analyze Insights',
        subtitle: 'Understand your finances',
        description: 'Get detailed insights and reports to make smarter decisions.',
        icon: 'analytics',
        iconBackground: '#2196f3', // Blue
        link: '/insights',
      },
      {
        title: 'Secure and Private',
        subtitle: 'Your data is safe',
        description: 'We ensure top-notch security and privacy for your data.',
        icon: 'lock',
        iconBackground: '#f44336', // Red
        link: '/security',
      },
    ];
  }

}
