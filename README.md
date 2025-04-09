# 📚 Bookstore REST API

This is a Spring Boot-based REST API for managing a collection of books. It supports basic CRUD operations and custom sorting, with a separate authentication module built using Spring Security and JWT.

---

## 📘 Book API Endpoints

### ✅ Add a New Book
**POST** `/api/books`  
Creates a new book entry.

#### Request Body:
```json
{
  "title": "The Pragmatic Programmer",
  "author": "Andrew Hunt",
  "category": "Programming",
  "price": 39.99,
  "rating": 4.7,
  "publishDate": "2021-06-01"
}
```

---

### 📚 Get All Books  
**GET** `/api/books`

---

### 🔍 Get Book by ID  
**GET** `/api/books/{id}`

---

### 💰 Sort Books by Price  
**GET** `/api/books/SortPrice`

---

### ⭐ Sort Books by Rating  
**GET** `/api/books/SortRating`

---

### ✏️ Update a Book  
**PUT** `/api/books`

#### Request Body:
Same format as the create JSON.

---

### ❌ Delete a Book  
**DELETE** `/api/books/{id}`

---

## 🔐 Authentication API

### 🔏 Sign Up  
**POST** `/auth/signup`  
Creates a new user.

#### Request Body:
```json
{
  "email": "user@example.com",
  "password": "MySecurePass123"
}
```

---

### 🔓 Log In  
**POST** `/auth/login`  
Returns a JWT token on successful login.

#### Request Body:
```json
{
  "email": "user@example.com",
  "password": "MySecurePass123"
}
```

---

## 🚲 Current Status

- ✅ **Book API** is fully functional and tested. CRUD operations and sorting endpoints work as expected.
- ❗ **Authentication system** using Spring Security + JWT is implemented but not yet fully integrated.  
  Currently, the application works **without authentication** but gives forbidden message with authentication running.

---
---

## 👤 Author

Charu

---
