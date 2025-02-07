INSERT INTO users (name, email, password, user_type, phone, profile_picture, bio, skills) VALUES
('John Doe', 'john@example.com', 'password123', 'client', '+1234567890', 'john.jpg', 'I need expert developers.', ''),
('Alice Smith', 'alice@example.com', 'securepass', 'freelancer', '+9876543210', 'alice.jpg', 'Web Developer with 5 years of experience.', 'HTML, CSS, JavaScript, PHP'),
('Mark Lee', 'mark@example.com', 'pass123', 'freelancer', '+1112223333', 'mark.jpg', 'Graphic designer & logo expert.', 'Photoshop, Illustrator, Branding');

INSERT INTO projects (client_id, title, description, budget, status) VALUES
(1, 'Website Development', 'Need a responsive website for my business.', 500.00, 'open'),
(1, 'Logo Design', 'Create a modern logo for my startup.', 100.00, 'open');

INSERT INTO payments (project_id, client_id, freelancer_id, amount, status, payment_method, transaction_id) VALUES
(1, 1, 2, 450.00, 'completed', 'paypal', 'TXN123456'),
(2, 1, 3, 90.00, 'completed', 'credit_card', 'TXN789012');

INSERT INTO reviews (project_id, client_id, freelancer_id, rating, review_text) VALUES
(1, 1, 2, 5, 'Excellent work! The website was delivered on time and looks great.'),
(2, 1, 3, 4, 'Good logo, but needed some revisions.');

INSERT INTO messages (sender_id, receiver_id, message) VALUES
(1, 2, 'Hi, I need a website developed. Can we discuss the details?'),
(2, 1, 'Sure! I can start immediately. Let’s discuss your requirements.');

INSERT INTO contact_messages (name, email, phone, message) VALUES
('Michael Johnson', 'michael@example.com', '+1987654321', 'I need help with my account.'),
('Samantha Brown', 'samantha@example.com', '+1122334455', 'Looking for more details about your services.');
