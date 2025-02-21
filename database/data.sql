INSERT INTO users (name, email, password, user_type, phone, profile_picture, bio, skills) VALUES
('John Doe', 'john@example.com', 'password123', 'client', '+1234567890', 'john.jpg', 'I need expert developers.', ''),
('Alice Smith', 'alice@example.com', 'securepass', 'freelancer', '+9876543210', 'alice.jpg', 'Web Developer with 5 years of experience.', 'HTML, CSS, JavaScript, PHP'),
('Mark Lee', 'mark@example.com', 'pass123', 'freelancer', '+1112223333', 'mark.jpg', 'Graphic designer & logo expert.', 'Photoshop, Illustrator, Branding');

INSERT INTO category (category_id, category_name, description, created_by, updated_by) VALUES
(UUID(), 'Web Development', 'Building websites, front-end, back-end, and full-stack development', 'Admin', 'Admin'),
(UUID(), 'Graphic Design', 'Creating logos, branding, UI/UX, and digital illustrations', 'Admin', 'Admin'),
(UUID(), 'Writing & Translation', 'Content writing, copywriting, blogging, and language translation', 'Admin', 'Admin'),
(UUID(), 'Digital Marketing', 'SEO, social media marketing, PPC campaigns, and email marketing', 'Admin', 'Admin'),
(UUID(), 'Video & Animation', 'Explainer videos, video editing, animation, and motion graphics', 'Admin', 'Admin'),
(UUID(), 'Business Consulting', 'Financial planning, market research, and business strategy', 'Admin', 'Admin');

INSERT INTO projects (client_id, title, description, budget, status) VALUES
(1, 'Website Development', 'Need a responsive website for my business.', 500.00, 'open'),
(1, 'Logo Design', 'Create a modern logo for my startup.', 100.00, 'open');

INSERT INTO payment (
    payment_id, client_id, freelancer_id, amount, payment_status, 
    payment_method, transaction_id, created_at, created_date, updated_date, 
    created_by, updated_by
) VALUES
(UUID(), 101, 201, 500.00, 'COMPLETED', 'PAYPAL', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 102, 202, 1200.50, 'PENDING', 'CREDIT_CARD', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 103, 203, 750.75, 'FAILED', 'BANK_TRANSFER', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 104, 204, 300.00, 'COMPLETED', 'PAYPAL', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 105, 205, 950.25, 'PENDING', 'CREDIT_CARD', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 106, 206, 425.00, 'COMPLETED', 'BANK_TRANSFER', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 107, 207, 1100.00, 'FAILED', 'PAYPAL', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 108, 208, 620.90, 'COMPLETED', 'CREDIT_CARD', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 109, 209, 850.00, 'PENDING', 'BANK_TRANSFER', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
(UUID(), 110, 210, 275.50, 'COMPLETED', 'PAYPAL', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin');

INSERT INTO profiles  (name, skills, experience, email, location) 
VALUES 
('John Doe', 'HTML, CSS, JavaScript', 5, 'john@example.com', 'New York, USA'),
('Jane Smith', 'React, Node.js, MongoDB', 3, 'jane@example.com', 'London, UK'),
('Michael Brown', 'Python, Django, PostgreSQL', 7, 'michael@example.com', 'Toronto, Canada'),
('Emily White', 'Java, Spring Boot, MySQL', 6, 'emily@example.com', 'Berlin, Germany'),
('David Lee', 'C++, Rust, Embedded Systems', 8, 'david@example.com', 'San Francisco, USA'),
('Sophia Patel', 'Vue.js, Laravel, PHP', 4, 'sophia@example.com', 'Mumbai, India'),
('Carlos Ramirez', 'Flutter, Dart, Firebase', 2, 'carlos@example.com', 'Madrid, Spain'),
('Linda Kim', 'Swift, Kotlin, Mobile Development', 5, 'linda@example.com', 'Seoul, South Korea');


INSERT INTO reviews (project_id, client_id, freelancer_id, rating, review_text) VALUES
(1, 1, 2, 5, 'Excellent work! The website was delivered on time and looks great.'),
(2, 1, 3, 4, 'Good logo, but needed some revisions.');


INSERT INTO contact_messages (name, email, phone, message) VALUES
('Michael Johnson', 'michael@example.com', '+1987654321', 'I need help with my account.'),
('Samantha Brown', 'samantha@example.com', '+1122334455', 'Looking for more details about your services.');
