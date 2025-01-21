import { Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { stats } from '../../interface/stats.interface';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-learn-more',
  standalone: true,
  imports: [
    MatIconModule,
    CommonModule,
    RouterModule
  ],
  templateUrl: './learn-more.component.html',
  styleUrl: './learn-more.component.scss'
})
export class LearnMoreComponent implements OnInit{

  public stats!: stats[];

  public features: any;

  ngOnInit(): void {
    this.stats = [
      { value: '10K+', label: 'Happy Users' },
      { value: '100M+', label: 'Transactions Tracked' },
      { value: '5+', label: 'Years in Business' },
    ];

    this.features = [
      {
        title: 'Track Your Expenses',
        description: 'Log and categorize expenses with ease.',
        icon: 'attach_money',
      },
      {
        title: 'Set Budgets',
        description: 'Plan your finances and save more.',
        icon: 'pie_chart',
      },
      {
        title: 'Gain Insights',
        description: 'Analyze spending patterns with detailed charts.',
        icon: 'analytics',
      },
      {
        title: 'Stay Secure',
        description: 'Your data is encrypted and private.',
        icon: 'lock',
      },
    ];
  }

}
