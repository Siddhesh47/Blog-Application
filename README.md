# 📝 Blog Application

A full-stack blog application built with **Spring Boot** and **React**. The application provides user authentication, JWT-based security, and complete management of blog posts, categories, and tags.

## 🚀 Features

- 🔐 User registration and login
- 🔑 JWT-based authentication
- 🛡️ Spring Security
- 📝 Create and manage blog posts
- 📚 Categories management
- 🏷️ Tags management
- 👤 User and author management
- 🔄 RESTful APIs
- 🎨 React-based frontend
- 📦 PostgreSQL database integration
- ✅ Request validation
- ⚠️ Centralized API error handling
- 🔒 Protected API endpoints

## 🛠️ Tech Stack

### Backend

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Lombok
- MapStruct

### Frontend

- React
- Vite
- JavaScript
- React Router
- Axios
- Tailwind CSS
- Lucide React
- Framer Motion

## 🏗️ Project Architecture

```text
Blog-Application/
│
├── blog/                         # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/bms/blog/
│   │   │   │
│   │   │   ├── Controllers/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── CategoryController.java
│   │   │   │   ├── ErrorController.java
│   │   │   │   ├── PostController.java
│   │   │   │   └── TagController.java
│   │   │   │
│   │   │   ├── Security/
│   │   │   │   ├── BlogUserDetails.java
│   │   │   │   ├── BlogUserDetailsService.java
│   │   │   │   └── JwtAuthenticationFilter.java
│   │   │   │
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java
│   │   │   │
│   │   │   ├── domain/
│   │   │   │   ├── entities/
│   │   │   │   └── dtos/
│   │   │   │
│   │   │   ├── mappers/
│   │   │   ├── repositories/
│   │   │   └── services/
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   ├── pom.xml
│   └── docker-compose.yml
│
└── frontend/                     # React Frontend
    ├── src/
    │   ├── assets/
    │   ├── components/
    │   ├── pages/
    │   └── services/
    ├── public/
    └── package.json
```

## 🔐 Authentication & Security

The backend uses **Spring Security** with JWT authentication.

The authentication system consists of:

```text
AuthController
      │
      ▼
AuthenticationService
      │
      ▼
BlogUserDetailsService
      │
      ▼
UserRepository
      │
      ▼
Database
```

After successful authentication, a JWT token is generated and used to access protected endpoints.

The JWT authentication filter is implemented in:

```text
JwtAuthenticationFilter.java
```

Security configuration is handled by:

```text
SecurityConfig.java
```

## 📝 Blog Posts

The application provides functionality for managing blog posts.

Posts contain information such as:

- Title
- Content
- Author
- Category
- Tags
- Status
- Creation/update information

Post-related functionality is implemented using:

```text
PostController
PostService
PostServiceImpl
PostRepository
PostMapper
```

## 🏷️ Tags

Tags can be created and associated with blog posts.

Tag functionality is handled by:

```text
TagController
TagService
TagServiceImpl
TagRepository
TagMapper
```

Example tag names:

```text
Technology
Programming
Java
Spring Boot
React
Database
```

## 📚 Categories

Blog posts can be organized into categories.

Category functionality is implemented through:

```text
CategoryController
CategoryService
CategoryServiceImpl
CategoryRepository
CategoryMapper
```

This allows posts to be grouped into different sections such as:

```text
Technology
Programming
Education
Travel
Lifestyle
```

## 👤 Users & Authors

The application maintains user information and provides authentication-related functionality.

Important classes include:

```text
User.java
UserRepository.java
BlogUserDetails.java
BlogUserDetailsService.java
AuthenticationService.java
AuthenticationServiceImpl.java
```

Authors can be associated with blog posts and their information can be returned through DTOs.

## 📦 Backend DTOs

The backend uses Data Transfer Objects (DTOs) to transfer data between the client and server.

Some DTOs include:

```text
LoginRequest
AuthResponse
CreatePostRequestDto
UpdatePostRequestDto
CreateCategoryRequest
CreateTagsRequest
PostDto
CategoryDto
TagDto
AuthorDto
ApiErrorResponse
```

This helps keep API requests and responses separate from the database entities.

## 🗄️ Database

The application uses a relational database through:

- Spring Data JPA
- Hibernate
- PostgreSQL

Main entities include:

```text
User
Post
Category
Tag
```

The relationships between these entities allow users to create posts, assign categories and associate multiple tags with posts.

## ⚙️ Backend Configuration

Backend configuration is located at:

```text
blog/src/main/resources/application.properties
```

Configure your database credentials and application-specific properties before running the backend.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blog
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Replace the values with your own database configuration.

**Never commit database passwords, JWT secrets or other sensitive credentials to GitHub.**

## 📋 Prerequisites

Make sure the following are installed:

- Java JDK
- Maven
- Node.js
- npm
- PostgreSQL
- Git

Check Java:

```bash
java -version
```

Check Node.js:

```bash
node -v
```

Check npm:

```bash
npm -v
```

## ▶️ Running the Backend

Navigate to the backend directory:

```bash
cd blog
```

Run the Spring Boot application using Maven:

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux / macOS

```bash
./mvnw spring-boot:run
```

Or, if Maven is installed:

```bash
mvn spring-boot:run
```

The backend will normally run on:

```text
http://localhost:8080
```

## ▶️ Running the Frontend

Open another terminal and navigate to the frontend:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The frontend will normally be available at:

```text
http://localhost:5173
```

## 🔄 Application Flow

```text
                    ┌─────────────────┐
                    │     React       │
                    │    Frontend     │
                    └────────┬────────┘
                             │
                             │ REST API
                             ▼
                    ┌─────────────────┐
                    │  Spring Boot    │
                    │    Backend      │
                    └────────┬────────┘
                             │
              ┌──────────────┼──────────────┐
              │              │              │
              ▼              ▼              ▼
        ┌──────────┐   ┌───────────┐   ┌──────────┐
        │ Security │   │ Services  │   │Controllers│
        └──────────┘   └───────────┘   └──────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │ Spring Data JPA │
                    │    Hibernate     │
                    └────────┬────────┘
                             │
                             ▼
                    ┌─────────────────┐
                    │   PostgreSQL    │
                    │    Database     │
                    └─────────────────┘
```

## 🧪 Testing

Backend tests can be executed using:

```bash
mvn test
```

On Windows:

```bash
mvnw.cmd test
```

The project contains tests for application functionality, including controller-level testing.

## 🔌 API Testing

The backend APIs can be tested using tools such as:

- Postman
- Insomnia
- Browser
- React frontend
- Swagger/OpenAPI, if configured

The main API areas include:

```text
Authentication
Posts
Categories
Tags
Users
```

## 📌 Main API Modules

| Module | Description |
|---|---|
| Authentication | User registration and login |
| Posts | Create, read, update and manage blog posts |
| Categories | Create and manage post categories |
| Tags | Create and manage post tags |
| Users | User and author information |

## 🔮 Future Improvements

Possible future enhancements include:

- 🖼️ Image upload for blog posts
- 💬 Comments and replies
- ❤️ Post likes
- 🔎 Advanced post search
- 📄 Pagination
- 🔔 Notifications
- 👨‍💼 Admin dashboard
- 📊 Blog analytics
- 🌐 Deployment to cloud
- 🐳 Docker-based deployment
- 📖 Swagger/OpenAPI documentation
- 🔄 Refresh token support
- 📧 Email verification
- 🔑 Password reset functionality

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a new branch:

```bash
git checkout -b feature/new-feature
```

3. Make your changes.
4. Commit your changes:

```bash
git commit -m "Add new feature"
```

5. Push your branch:

```bash
git push origin feature/new-feature
```

6. Open a Pull Request.

## 📄 License

This project is developed for **educational and learning purposes**.

## 👨‍💻 Author

**Siddhesh Patre**

⭐ If you found this project useful, consider giving the repository a star!
