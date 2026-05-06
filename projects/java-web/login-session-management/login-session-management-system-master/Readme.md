# Session Management in Java Servlet

## Introduction
HTTP is a **stateless protocol**, which means the server does not remember previous requests from the client.

To maintain user data and track user activity between multiple requests, we use **Session Management**.

Example:
- User logs in
- Server remembers the user
- User accesses another page without logging in again

This process is called **Session Management**.

---

# Types of Session Management

Session management can be handled in two ways:

## 1. Client-Side Session Management
Data is stored on the client/browser side.

### Methods:
- Cookies
- URL Rewriting
- Hidden Form Fields

---

## 2. Server-Side Session Management
Data is stored on the server side.

### Method:
- HttpSession

---

# Client-Side Techniques

# 1. Cookies

Cookies are small text files stored in the browser.

## Create Cookie
```java
Cookie cookie = new Cookie("user", "admin");
response.addCookie(cookie);
```

## Retrieve Cookie
```java
Cookie[] cookies = request.getCookies();
```

## Important Point
- Browser automatically stores `JSESSIONID`
- Used to identify user session

---

# 2. URL Rewriting

Session data is passed through URL.

## Example
```text
/dashboard?JSESSIONID=343434
```

## Used When
- Cookies are disabled

---

# 3. Hidden Form Field

Hidden data is sent using form fields.

## Example
```html
<input type="hidden" name="user" value="admin">
```

---

# Server-Side Technique

# HttpSession

`HttpSession` stores data on the server side.

---

## Create Session
```java
HttpSession session = request.getSession();
```

---

## Store Data in Session
```java
session.setAttribute("user", "admin");
```

---

## Retrieve Session Data
```java
String user = (String) session.getAttribute("user");
```

---

## Destroy Session
```java
session.invalidate();
```

---

# Session Timeout

We can set session timeout manually.

## Using Java Code
```java
session.setMaxInactiveInterval(300);
```

- Time is in seconds
- `300 = 5 minutes`

---

## Using web.xml
```xml
<session-config>
    <session-timeout>10</session-timeout>
</session-config>
```

- Time is in minutes

---

# Session Flow

```text
Login
   ↓
Session Created
   ↓
Cookie Stored in Browser
   ↓
Next Request
   ↓
Cookie Sent to Server
   ↓
Session Identified
```

---

# Advantages of Session Management

- Maintains user login
- Tracks user activity
- Stores user-specific data
- Provides better security
- Improves user experience

---

# Conclusion

Session Management is used to maintain user state in web applications because HTTP is stateless.

It can be implemented using:
- Cookies
- URL Rewriting
- Hidden Form Fields
- HttpSession

Among these, `HttpSession` is the most commonly used server-side technique in Java Servlets.