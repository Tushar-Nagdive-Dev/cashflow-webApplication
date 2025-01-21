#!/bin/bash

# Define directories
ANGULAR_DIR="cashflow-user-interface"
SPRING_DIR="cashflow-server-core"
STATIC_DIR="$SPRING_DIR/src/main/resources/static"

# Function to log messages
log() {
    echo -e "[INFO] $1"
}

error() {
    echo -e "[ERROR] $1"
    exit 1
}

# Step 1: Validate Directories
log "Validating directories..."
if [ ! -d "$ANGULAR_DIR" ]; then
    error "Angular directory not found: $ANGULAR_DIR"
fi

if [ ! -d "$SPRING_DIR" ]; then
    error "Spring Boot directory not found: $SPRING_DIR"
fi
log "Directories validated successfully."

# Step 2: Build Angular
log "Building Angular application..."
cd "$ANGULAR_DIR" || error "Failed to navigate to Angular directory."

# Install Angular dependencies if node_modules is missing
if [ ! -d "node_modules" ]; then
    log "Installing Angular dependencies..."
    npm install || error "Failed to install Angular dependencies."
fi

# Build Angular application
log "Running Angular build..."
ng build --configuration production || error "Angular build failed!"
log "Angular application built successfully."

# Step 3: Copy Angular Build to Spring Boot Static Resources
log "Preparing Spring Boot static directory..."
mkdir -p "$STATIC_DIR" || error "Failed to create Spring Boot static directory."
rm -rf "$STATIC_DIR"/* || error "Failed to clean Spring Boot static directory."
cp -r dist/* "$STATIC_DIR/" || error "Failed to copy Angular build to Spring Boot static directory."
log "Angular build copied successfully to Spring Boot static directory."

# Step 4: Build Spring Boot
log "Building Spring Boot application..."
cd "../$SPRING_DIR" || error "Failed to navigate to Spring Boot directory."

# Check if Maven Wrapper exists, fallback to Maven if not
if [ -f "./mvnw" ]; then
    ./mvnw clean package || error "Spring Boot build failed!"
else
    mvn clean package || error "Spring Boot build failed!"
fi
log "Spring Boot application built successfully."

# Step 5: Run Spring Boot Application
log "Running Spring Boot application..."
SPRING_BOOT_JAR=$(find target -name "*.jar" | head -n 1)
if [ -z "$SPRING_BOOT_JAR" ]; then
    error "No JAR file found in target directory. Ensure the Spring Boot build was successful."
fi

log "Starting Spring Boot application from: $SPRING_BOOT_JAR"
java -jar "$SPRING_BOOT_JAR" || error "Failed to run Spring Boot application."

# Success message
log "Application is running successfully. Access it at http://localhost:2001"
