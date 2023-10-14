# SoftwareDesign

CREATE DATABASE restaurant;

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE restaurant_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    table_name VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE reservation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reservation_time DATETIME NOT NULL,
    table_id INT NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (table_id) REFERENCES restaurant_table (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE restaurant_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    table_name VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE reservation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reservation_time DATETIME NOT NULL,
    table_id INT NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (table_id) REFERENCES restaurant_table (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

