CREATE DATABASE devsu CHARACTER SET utf8 COLLATE utf8_general_ci;

USE devsu;

CREATE TABLE person (
    person_id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    age INT(3) NOT NULL,
    identification VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE client (
    client_id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    person_id INT(8) UNSIGNED NOT NULL,
    password VARCHAR(100) NOT NULL,
    status BOOLEAN NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(person_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE account (
    account_id INT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    account_number INT(16) UNSIGNED NOT NULL,
    type INT(2) UNSIGNED NOT NULL,
    initial_balance INT(20) UNSIGNED NOT NULL,
    status BOOLEAN NOT NULL,
    client_id INT(8) UNSIGNED NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(client_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE movement (
    movement_id INT(12) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    type INT(2) UNSIGNED NOT NULL,
    value INT(20) UNSIGNED NOT NULL,
    status BOOLEAN NOT NULL,
    initial_balance INT(20) NOT NULL,
    current_balance INT(20) NOT NULL,
    account_id INT(8) UNSIGNED NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account(account_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;