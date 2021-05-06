CREATE TABLE IF NOT EXISTS types (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80),
    INDEX(name)
    ) engine=InnoDB;

INSERT IGNORE INTO types VALUES (1, '서비스');
INSERT IGNORE INTO types VALUES (2, '판매');
INSERT IGNORE INTO types VALUES (3, '시공');
INSERT IGNORE INTO types VALUES (4, '쇼핑몰');

CREATE TABLE IF NOT EXISTS products (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    sales_date DATE,
    type_id INT(4) UNSIGNED NOT NULL,
    customer_id INT(4) UNSIGNED NOT NULL,
    price INT(10),
    qty INT(10),
    amount INT(10),
    billing_type INT(4),
    address1 VARCHAR(200),
    address2 VARCHAR(200),
    memo TEXT,
    INDEX(name),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (type_id) REFERENCES types(id)
    ) engine=InnoDB;


CREATE TABLE IF NOT EXISTS specialties (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80),
    INDEX(name)
    ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS worker_specialties (
    worker_id INT(4) UNSIGNED NOT NULL,
    specialty_id INT(4) UNSIGNED NOT NULL,
    FOREIGN KEY (worker_id) REFERENCES workers(id),
    FOREIGN KEY (specialty_id) REFERENCES specialties(id),
    UNIQUE (vet_id,specialty_id)
    ) engine=InnoDB;


CREATE TABLE IF NOT EXISTS workers (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    worker_name VARCHAR(30),
    worker_number VARCHAR(30),
    worker_division VARCHAR(30),
    INDEX(worker_name)
    ) engine=InnoDB;
