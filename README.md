# spring-app

This project is web application that operates a list of contacts. Each of them contains informations such as name, last name, e-mail, number and the date of birth. The application is secured and to gain access the user has to log in. After successfully loging in, the user can browse contacts saved in a database, add new, edit existing ones and delete them. In the loging in page, there is also an option to sign in as an guest, which results in limiting available options to only browsing the contacts list. A user which has administrator privileges can access an admin panel, where he can register new users or delete them.

Technologies used: Java, Spring, Hibernate, JDCB, PostgreSQL, JSP, JSTL, CSS. The code used to create database tables:
``` 
CREATE TABLE contacts
(
    id SERIAL PRIMARY KEY,
    name text NOT NULL,
    last_name text NOT NULL,
    mail text NOT NULL,
    number text NOT NULL,
    born text NOT NULL
);

CREATE TABLE users
(
    username text NOT NULL PRIMARY KEY,
    password text NOT NULL,
    enabled boolean NOT NULL DEFAULT true
);

CREATE TABLE user_roles
(
    user_role_id SERIAL PRIMARY KEY,
    username text NOT NULL REFERENCES users (username),
    role text NOT NULL,
    UNIQUE (username, role)
);
```
