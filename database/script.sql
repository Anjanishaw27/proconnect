CREATE SCHEMA pro_connect
USE pro_connect
--table


CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL,
    user_type ENUM('CLIENT', 'FREELANCER') NOT NULL,
    user_phone VARCHAR(20),
    user_bio TEXT,
    user_profile_picture TEXT,
    location VARCHAR(255),
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by  VARCHAR(255),
);


CREATE TABLE freelancer (
    user_id INT PRIMARY KEY, 
    rating DOUBLE DEFAULT 0.0,
    location VARCHAR(255),
    language VARCHAR(100),
    completed_projects INT DEFAULT 0,
    total_clients INT DEFAULT 0,
    years_experience INT DEFAULT 0,
    specialization TEXT,
    skills TEXT,
    joined_date DATE,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);


CREATE TABLE category (
    category_id VARCHAR(255) PRIMARY KEY,
    category_name VARCHAR(255) UNIQUE NOT NULL,
    category_description description TEXT,
    category_image_url Text null,
    category_status ENUM('AVAILABLE', 'UNAVAILABLE') DEFAULT 'AVAILABLE',
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by  VARCHAR(255),
);

								
CREATE TABLE project (
    project_id VARCHAR(255) PRIMARY KEY,
    project_title VARCHAR(255) NOT NULL,
    project_description TEXT,
    project_image_url Text null,
    project_status ENUM('OPEN', 'IN_PROGRSS', 'COMPLETED', 'CANCELLED') DEFAULT 'OPEN',
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by  VARCHAR(255),

);

-- Bids Table (Freelancers bid on projects)
CREATE TABLE Bids (
    bid_id INT AUTO_INCREMENT PRIMARY KEY,
    project_id INT NOT NULL,
    freelancer_id INT NOT NULL,
    bid_amount DOUBLE(10,2) NOT NULL,
    proposal TEXT NOT NULL,
    status ENUM('pending', 'accepted', 'rejected') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id) REFERENCES Projects(project_id) ON DELETE CASCADE,
    FOREIGN KEY (freelancer_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

CREATE TABLE payment (
    payment_id VARCHAR(255),
    client_id INT NOT NULL,
    freelancer_id INT NOT NULL,
    amount DOUBLE(10,2) NOT NULL,
    payment_method ENUM('PAYPAL', 'CREDIT_CARD', 'BANK_TRANSFER') NOT NULL,
    transaction_id VARCHAR(255) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id) REFERENCES projects(project_id) ON DELETE CASCADE,
    FOREIGN KEY (client_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (freelancer_id) REFERENCES users(user_id) ON DELETE CASCADE,
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by  VARCHAR(255),
);

CREATE TABLE review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    project_id INT NOT NULL,
    client_id INT NOT NULL,
    freelancer_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review_text TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id) REFERENCES projects(project_id) ON DELETE CASCADE,
    FOREIGN KEY (client_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (freelancer_id) REFERENCES users(user_id) ON DELETE CASCADE,
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by  VARCHAR(255),
);



CREATE TABLE contact_message (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by  VARCHAR(255),
); 