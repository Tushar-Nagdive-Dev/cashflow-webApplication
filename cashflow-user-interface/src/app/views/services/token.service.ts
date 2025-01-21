import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TokenService {
  private readonly storageKey = 'auth-token';

  /**
   * Saves the token securely.
   * @param token JWT token
   */
  saveToken(token: string): void {
    const encryptedToken = btoa(token); // Simple Base64 encoding
    sessionStorage.setItem(this.storageKey, encryptedToken);
  }

  /**
   * Retrieves the token.
   * @returns The JWT token or null
   */
  getToken(): string | null {
    const encryptedToken = sessionStorage.getItem(this.storageKey);
    return encryptedToken ? atob(encryptedToken) : null;
  }

  /**
   * Removes the token from storage.
   */
  removeToken(): void {
    sessionStorage.removeItem(this.storageKey);
  }
}
