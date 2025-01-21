import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private apiService: ApiService) {}

  /**
   * Registers a new user
   * @param data User registration payload
   * @returns Observable of the server response
   */
  registerUser(data: any): Observable<any> {
    return this.apiService.post('auth/register', data);
  }

  /**
   * Logs in the user
   * @param credentials User login payload
   * @returns Observable of the server response with JWT token
   */
  loginUser(credentials: any): Observable<any> {
    return this.apiService.post('auth/login', credentials);
  }

  /**
   * Retrieves the current user profile
   * @returns Observable of the user's profile data
   */
  getUserProfile(): Observable<any> {
    return this.apiService.get('auth/profile');
  }

  /**
   * Logs out the user
   * @returns Observable of the logout response
   */
  logoutUser(): Observable<any> {
    return this.apiService.post('auth/logout', {});
  }
}
