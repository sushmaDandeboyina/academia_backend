CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    roll_number VARCHAR(20) UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    photograph_path VARCHAR(255),
    cgpa DECIMAL(3,2) DEFAULT 0.0,
    total_credits INTEGER DEFAULT 0,
    graduation_year INT,
    domain INT,
    specialisation_id INT,
    placement_id INT
);

CREATE TABLE register (
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(1024) NOT NULL,
    PRIMARY KEY (email) -- Add a primary key constraint
);

CREATE TABLE bills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100),
    amount DECIMAL(10,2) NOT NULL,
    bill_date DATETIME NOT NULL,
    deadline DATETIME
);

CREATE TABLE student_bills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    bill_id INT
);

CREATE TABLE student_payment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    description VARCHAR(100),
    amount DECIMAL(10,2) NOT NULL,
    payment_date DATETIME NOT NULL,
    bill_id INT
);
