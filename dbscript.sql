CREATE DATABASE req;
\c req;

CREATE TABLE roles (
    role_id serial PRIMARY KEY,
    role_name varchar(255) UNIQUE NOT NULL
);

CREATE TABLE users (
    user_id  serial PRIMARY KEY,
    username varchar(50) UNIQUE NOT NULL,
    password varchar(50) NOT NULL,
    full_name varchar(100) NOT NULL,
    email varchar(255) UNIQUE NOT NULL,
    role_id INT NOT NULL,
    CONSTRAINT fk_user_role FOREIGN KEY(role_id) REFERENCES roles(role_id)
);


CREATE TABLE request_type(
    type_id serial PRIMARY KEY,
    req_type TEXT NOT NULL
);

CREATE TABLE request_status(
    status_id serial PRIMARY KEY,
    req_status varchar(50) NOT NULL
);

CREATE TABLE request_details(
    req_id serial PRIMARY KEY,
    user_id INT NOT NULL,
    type INT NOT NULL,
    request_amount INT NOT NULL,
    submit_date DATE NOT NULL DEFAULT CURRENT_DATE,
    approve_date DATE NOT NULL DEFAULT CURRENT_DATE,
    manager INT,
    status INT NOT NULL,
    CONSTRAINT fk_req_user FOREIGN KEY(user_id) REFERENCES users(user_id),
    CONSTRAINT fk_req_manager FOREIGN KEY(manager) REFERENCES users(user_id),
    CONSTRAINT fk_req_status FOREIGN KEY(status) REFERENCES request_status(status_id),
    CONSTRAINT fk_req_type FOREIGN KEY(type) REFERENCES request_type(type_id)
); 
pancakes — Yesterday at 11:03 PM
INSERT INTO roles(role_name) VALUES('manager');
INSERT INTO roles(role_name) VALUES('associate');
SELECT * FROM roles;
---------------------------------------------------------------------------------------------------------------------------------- 
INSERT INTO users(username, password, full_name, email, role_id) VALUES('bruno', 'bruno123', 'Bruno Fly', 'bruno@business.com', 1);
INSERT INTO users(username, password, full_name, email, role_id) VALUES('levi', 'levi631', 'Levi Arckerman', 'levi@business.com', 1); 
INSERT INTO users(username, password, full_name, email, role_id) VALUES('sunny', 'cloudy', 'Sunny S', 'sunny@business.com', 2);
INSERT INTO users(username, password, full_name,  email, role_id) VALUES('puppy', '420', 'Puppy Cool', 'puppy@business.com', 2);
INSERT INTO users(username, password, full_name,  email, role_id) VALUES('knight', 'dark', 'Dark Knight', 'darknight@business.com', 2);
INSERT INTO users(username, password, full_name,  email, role_id) VALUES('storm', 'storm3', 'Snow Storm',  'storm@business.com', 2); 
SELECT * FROM users;
------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO request_type(req_type) VALUES( 'travel');
INSERT INTO request_type(req_type) VALUES('certification');
SELECT * FROM request_type;
------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO request_status(req_status) VALUES('pending');
INSERT INTO request_status(req_status) VALUES('approved');
INSERT INTO request_status(req_status) VALUES('denied');
SELECT * FROM request_status;
----------------------------------------------------------------------------------------------------------------------------------
INSERT INTO request_details(user_id, type, request_amount, manager, status) VALUES(4, 1, 50, 2, 1);
INSERT INTO request_details(user_id, type, request_amount, manager, status) VALUES(7, 1, 500, 1, 3);
INSERT INTO request_details(user_id, type, request_amount, manager, status) VALUES(6, 2, 100, 2, 2);
SELECT * FROM request_details; 
