import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card'; // Import MatCardModule
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [
    MatCardModule,
    RouterModule
  ],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.scss'
})
export class WelcomeComponent implements OnInit{

  ngOnInit(): void {
    console.log("Welcome Component");
  }

}
