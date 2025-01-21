# Integration of Angular with Spring Boot (Using JWT Security)

This document provides a detailed guide to integrating an Angular front-end application with a Spring Boot back-end, including handling issues faced during the process and their resolutions.

---

## **1. Prerequisites**

### **For Angular**
- Angular CLI version: 18.x.x
- Node.js version: 18.x.x or higher
- Dependencies:
  - `zone.js`

### **For Spring Boot**
- Spring Boot version: 3.x.x
- Java version: 17 or higher
- Dependencies:
  - Spring Security
  - Spring Data JPA
  - JWT libraries
  - PostgreSQL Driver (or any database driver)

---

## **2. Steps for Integration**

### **2.1 Angular Setup**
1. **Build Angular Application:**
   ```bash
   ng build --configuration production
   ```
   This generates the production-ready files in the `dist` folder.

2. **Configure `angular.json`:**
   Ensure the `outputPath` points to the Spring Boot static resources directory:
   ```json
   "outputPath": "../cashflow-server-core/src/main/resources/static"
   ```

3. **Handle Missing `polyfills.ts`:**
   Since Angular 16+, `polyfills.ts` is optional. Ensure `zone.js` is imported in `main.ts`:
   ```typescript
   import 'zone.js'; // Included with Angular CLI
   ```

4. **Resolve Budget Warnings:**
   If the initial chunk size exceeds the budget, increase the `budgets` in `angular.json`:
   ```json
   "budgets": [
     {
       "type": "initial",
       "maximumWarning": "600kB",
       "maximumError": "1.2MB"
     }
   ]
   ```

5. **Favicon Issues:**
   Ensure `favicon.ico` exists in the `src` folder and is included in `angular.json`:
   ```json
   "assets": [
     {
       "glob": "favicon.ico",
       "input": "src",
       "output": "/"
     }
   ]
   ```

### **2.2 Spring Boot Setup**
1. **Serve Angular Files:**
   Angular’s build files must be placed in the `src/main/resources/static` directory.

2. **Update Spring Security Configuration:**
   Permit access to static files and API routes in the `SecurityConfig`:
   ```java
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
               .csrf(csrf -> csrf.disable())
               .cors(cors -> cors.configurationSource(corsConfigurationSource()))
               .authorizeHttpRequests(auth -> auth
                   .requestMatchers("/", "/index.html", "/static/**", "/favicon.ico", "/**/*.js", "/**/*.css", "/**/*.png", "/**/*.svg").permitAll()
                   .requestMatchers("/api/auth/**").permitAll()
                   .anyRequest().authenticated()
               )
               .build();
   }
   ```

3. **Handle CORS Issues:**
   Add CORS configuration:
   ```java
   @Bean
   public CorsConfigurationSource corsConfigurationSource() {
       CorsConfiguration configuration = new CorsConfiguration();
       configuration.setAllowedOrigins(List.of("http://localhost:4200", "http://localhost:2001"));
       configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
       configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
       configuration.setExposedHeaders(List.of("Authorization"));
       configuration.setAllowCredentials(true);

       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       source.registerCorsConfiguration("/**", configuration);
       return source;
   }
   ```

4. **Configure Application Properties:**
   ```properties
   server.port=2001
   spring.web.resources.static-locations=classpath:/static/
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.url=jdbc:postgresql://localhost:5432/cashflow_db
   spring.datasource.username=cashflow_dev
   spring.datasource.password=connect
   spring.jpa.show-sql=true
   logging.level.org.springframework.web=DEBUG
   logging.level.org.springframework.security=DEBUG
   ```

---

## **3. Common Issues and Resolutions**

### **3.1 `H: NG0908` Error**
- **Cause:** Missing or misconfigured `zone.js`.
- **Resolution:** Ensure `zone.js` is installed and imported in `main.ts`.

### **3.2 Favicon Not Found (`403 Forbidden`)**
- **Cause:** The `favicon.ico` is missing or not permitted by Spring Security.
- **Resolution:**
  1. Add `favicon.ico` to the Angular `src` folder.
  2. Include the file in the `assets` configuration in `angular.json`.
  3. Permit access to `favicon.ico` in Spring Security.

### **3.3 Schema Validation Error (`wrong column type`)**
- **Cause:** Mismatch between Hibernate and PostgreSQL schema definitions.
- **Resolution:** Align column types explicitly in the database:
  ```sql
  ALTER TABLE users ALTER COLUMN id TYPE bigint;
  ```

### **3.4 Budget Warnings During Build**
- **Cause:** The initial chunk size exceeds the defined budget.
- **Resolution:** Optimize your build:
  - Use lazy loading for Angular modules.
  - Increase the `maximumWarning` budget in `angular.json`.

### **3.5 Static Files Not Loading in Spring Boot**
- **Cause:** Incorrect `static` folder configuration.
- **Resolution:** Ensure the static resources are correctly located in `src/main/resources/static` and the application is serving them with:
  ```properties
  spring.web.resources.static-locations=classpath:/static/
  ```

---

## **4. Final Deployment Checklist**

1. Build Angular for production:
   ```bash
   ng build --configuration production
   ```

2. Copy `dist` files to `src/main/resources/static` in Spring Boot.

3. Ensure Spring Security permits access to static files and API routes.

4. Test the application locally:
   - Angular Dev Server: `http://localhost:4200`
   - Spring Boot Server: `http://localhost:2001`

5. Resolve any runtime or integration errors based on the troubleshooting steps above.

---

## **5. Notes for Future Enhancements**
- Consider setting up an Nginx or Apache server to serve Angular files for better scalability.
- Use a reverse proxy to route API requests to Spring Boot.
- Implement GraphQL in Spring Boot for better flexibility (optional).

---

This document provides a comprehensive guide for integrating Angular with Spring Boot and resolving common issues. Keep it updated as the application evolves.

