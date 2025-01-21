import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { AuthService } from '../../../services/auth.service';
import { TokenService } from '../../../services/token.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    CommonModule,
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'], // Fixed property name
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  isLoading = false; // Flag to disable the button during API call
  errorMessage: string | null = null; // For displaying error messages

  constructor(private fb: FormBuilder, private authService: AuthService,public token: TokenService) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  onSubmit(): void {
    if (this.loginForm.invalid) {
      // Show form validation errors
      this.loginForm.markAllAsTouched();
      return;
    }

    this.isLoading = true;
    this.errorMessage = null;

    this.authService.loginUser(this.loginForm.value).subscribe({
      next: (response) => {
        console.log('Login successful', response);
        this.isLoading = false;
        this.token.saveToken(response.data.token);
        // Optionally, redirect the user after successful login
        // this.router.navigate(['/dashboard']);
      },
      error: (err) => {
        console.error('Login failed', err);
        this.errorMessage = 'Invalid username or password.';
        this.isLoading = false;
      },
    });
  }

  // Helper function to get form controls for validation in the template
  getControl(controlName: string) {
    return this.loginForm.get(controlName);
  }
}
