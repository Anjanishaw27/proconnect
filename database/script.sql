CREATE SCHEMA pro_connect
USE pro_connect
--table


CREATE TABLE user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) UNIQUE NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    user_type ENUM('CLIENT', 'FREELANCER') NOT NULL,
    user_phone VARCHAR(20),
    user_profile_picture image,
    user_bio TEXT,
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by  VARCHAR(255),
);

CREATE TABLE freelancer (
    freelancer_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255),
    user_id INT NOT NULL,
    rating DOUBLE(3,2),
    location VARCHAR(255), 
    language VARCHAR(100),
    completed_projects INT DEFAULT 0,
    total_clients INT DEFAULT 0,
    years_experience INT,
    specialization TEXT,
    skills TEXT,
    profile_description TEXT,
    profile_picture VARCHAR(255),
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
-- cat_001	admin		admin		All web-based projects including frontend and backend development.	web_dev.jpg	Web Development	AVAILABLE
-- cat_002	admin		admin		Graphic design projects including logos, branding, and UI/UX.	graphic_design.jpg	Graphic Design	AVAILABLE
-- cat_003	admin		admin		Content writing, blogging, and SEO article writing.	content_writing.jpg	Content Writing	AVAILABLE
-- cat_004	admin		admin		SEO, social media marketing, and PPC campaigns.	digital_marketing.jpg	Digital Marketing	AVAILABLE
-- cat_005	admin		admin		Data analysis, machine learning, and AI projects.	data_science.jpg	Data Science	AVAILABLE
-- cat_006	admin		admin		Video production, animation, and motion graphics.	video_editing.jpg	Video Editing	AVAILABLE
-- cat_007	admin		admin		Android and iOS app development.	mobile_dev.jpg	Mobile App Development	AVAILABLE
-- cat_008	admin		admin		Ethical hacking, penetration testing, and security audits.	cybersecurity.jpg	Cybersecurity	UNAVAILABLE
-- dc899645-fd2e-4e75-832d-e22f477ecfed					API,JPA REACT		Operating System developer	AVAILABLE
								
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

CREATE TABLE skill (
    skill_id INT AUTO_INCREMENT PRIMARY KEY,
    skill_name VARCHAR(255) UNIQUE NOT NULL,
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by  VARCHAR(255),
);

CREATE TABLE freelancer_skill (
    freelancer_id INT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (freelancer_id, skill_id),
    FOREIGN KEY (freelancer_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skills(skill_id) ON DELETE CASCADE,
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