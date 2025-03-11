-- INSERT INTO users (user_id, user_name, user_email, user_password, user_type, user_phone, user_profile_picture, user_bio, skill, created_by, created_date, updated_by, updated_date) 
-- VALUES
-- (1, 'John Doe', 'john@example.com', 'password123', 'CLIENT', '+1234567890', 'john.jpg', 'I need expert developers.', '', 'system', NOW(), 'system', NOW()),

-- (2, 'Alice Smith', 'alice@example.com', 'securepass', 'FREELANCER', '+9876543210', 'alice.jpg', 'Web Developer with 5 years of experience.', 'HTML, CSS, JavaScript, PHP', 'system', NOW(), 'system', NOW()),

-- (3, 'Mark Lee', 'mark@example.com', 'pass123', 'FREELANCER', '+1112223333', 'mark.jpg', 'Graphic designer & logo expert.', 'Photoshop, Illustrator, Branding', 'system', NOW(), 'system', NOW());


INSERT INTO user (user_id, user_name, user_email, user_password, user_type, user_phone, user_profile_picture, user_bio, created_date, updated_date, created_by, updated_by)
VALUES 
(1, 'John Doe', 'johndoe@example.com', 'securepassword123', 'CLIENT', '+1234567890', '', 'Entrepreneur looking for tech solutions.', NOW(), NOW(), 'admin', 'admin'),
(2, 'Jane Smith', 'janesmith@example.com', 'mypassword789', 'FREELANCER', '+1987654321', '', 'Freelance graphic designer.', NOW(), NOW(), 'admin', 'admin'),
(3, 'Michael Johnson', 'michaelj@example.com', 'pass1234', 'CLIENT', '+1122334455', '', 'Business owner in need of automation.', NOW(), NOW(), 'admin', 'admin'),
(4, 'Emily Davis', 'emilyd@example.com', 'password5678', 'FREELANCER', '+1567890123', '', 'Software engineer specializing in AI and ML.', NOW(), NOW(), 'admin', 'admin'),
(5, 'Alice Brown', 'aliceb@example.com', 'alicepass789', 'CLIENT', '+1456789012', '', 'Startup founder seeking developers.', NOW(), NOW(), 'admin', 'admin'),
(6, 'Michael Brown', 'michaelb@example.com', 'michaelpass123', 'FREELANCER', '+1122334455', '', 'Experienced web developer.', NOW(), NOW(), 'admin', 'admin'),
(7, 'Sophia Wilson', 'sophiaw@example.com', 'sophiapass456', 'FREELANCER', '+1678901234', '', 'Digital marketing expert.', NOW(), NOW(), 'admin', 'admin'),
(8, 'Rajesh Kumar', 'rajeshk@example.com', 'rajeshpass789', 'FREELANCER', '+919876543210', '', 'Full-stack developer with a passion for coding.', NOW(), NOW(), 'admin', 'admin');

INSERT INTO freelancer (user_id, rating, location, language, completed_projects, total_clients, years_experience, specialization, skills, joined_date)
VALUES 
(2, 4.75, 'New York, USA', 'English, Spanish', 15, 10, 5, 'Graphic Design & UI/UX', 'Adobe Photoshop, Illustrator, Figma, Sketch', '2020-06-15'),
(4, 4.90, 'San Francisco, USA', 'English', 20, 15, 7, 'AI & Machine Learning', 'Python, TensorFlow, PyTorch, NLP', '2018-09-10'),
(6, 4.80, 'Berlin, Germany', 'German, English', 12, 8, 4, 'Web Development', 'HTML, CSS, JavaScript, React, Node.js', '2021-03-22'),
(7, 4.65, 'Toronto, Canada', 'English, French', 10, 7, 3, 'Digital Marketing', 'SEO, Google Ads, Facebook Ads, Analytics', '2022-01-05'),
(8, 4.85, 'Bangalore, India', 'English, Hindi', 18, 14, 6, 'Full-Stack Development', 'Java, Spring Boot, Angular, MySQL', '2019-11-12');

-- INSERT INTO project (project_id, project_title, project_description, project_image_url, project_status, created_date, updated_date, created_by, updated_by)
-- VALUES 
-- ('P001', 'E-commerce Website', 'A full-fledged e-commerce website with payment gateway integration.', '', 'OPEN', NOW(), NOW(), 'John Doe', 'John Doe'),
-- ('P002', 'AI Chatbot', 'An AI-powered chatbot for customer support automation.', '', 'IN_PROGRSS', NOW(), NOW(), 'Michael Johnson', 'Emily Davis'),
-- ('P003', 'Marketing Campaign', 'A digital marketing campaign focused on social media advertising.', '', 'COMPLETED', NOW(), NOW(), 'Alice Brown', 'Sophia Wilson'),
-- ('P004', 'Portfolio Website', 'A personal portfolio website for a freelance designer.', '', 'OPEN', NOW(), NOW(), 'Jane Smith', 'Jane Smith'),
-- ('P005', 'Mobile App Development', 'A cross-platform mobile app for a food delivery service.', '', 'IN_PROGRESS', NOW(), NOW(), 'Rajesh Kumar', 'Rajesh Kumar');

INSERT INTO project (project_id, project_title, project_description, project_image_url, project_status, client_id, freelancer_id, category_id)
VALUES 
(UUID(), 'E-commerce Website', 'A fully functional e-commerce platform with payment integration.', '', 'OPEN', 1, 2, 101),
(UUID(), 'AI Chatbot', 'An AI-powered chatbot for customer service automation.', '', 'IN_PROGRESS', 3, 4, 102),
(UUID(), 'Marketing Campaign', 'A digital marketing strategy focusing on social media ads.', '', 'COMPLETED', 5, 7, 103),
(UUID(), 'Portfolio Website', 'A personal website for showcasing design work.', '', 'OPEN', 1, 6, 101),
(UUID(), 'Food Delivery App', 'A cross-platform mobile app for online food delivery.', '', 'IN_PROGRESS', 5, 8, 104);

INSERT INTO payment (payment_id, project_id, client_id, freelancer_id, amount, payment_status, payment_method, transaction_id, created_by, updated_by)
VALUES 
(UUID(), 'P001', 1, 2, 1500.00, 'COMPLETED', 'PAYPAL', 'TXN123456', 'John Doe', 'John Doe'),
(UUID(), 'P002', 3, 4, 2500.50, 'PENDING', 'CREDIT_CARD', 'TXN789012', 'Michael Johnson', 'Michael Johnson'),
(UUID(), 'P003', 5, 7, 800.75, 'FAILED', 'BANK_TRANSFER', 'TXN345678', 'Alice Brown', 'Sophia Wilson'),
(UUID(), 'P004', 1, 6, 1200.00, 'COMPLETED', 'PAYPAL', 'TXN901234', 'Jane Smith', 'Jane Smith'),
(UUID(), 'P005', 5, 8, 1800.30, 'PENDING', 'CREDIT_CARD', 'TXN567890', 'Rajesh Kumar', 'Rajesh Kumar');

INSERT INTO category (category_id, category_name, category_description, category_status, created_by, updated_by) VALUES
(UUID(), 'Web Development', 'Building websites, front-end, back-end, and full-stack development','open', 'Admin', 'Admin'),
(UUID(), 'Graphic Design', 'Creating logos, branding, UI/UX, and digital illustrations','open', 'Admin', 'Admin'),
(UUID(), 'Writing & Translation', 'Content writing, copywriting, blogging, and language translation','in progress', 'Admin', 'Admin'),
(UUID(), 'Digital Marketing', 'SEO, social media marketing, PPC campaigns, and email marketing','open', 'Admin', 'Admin'),
(UUID(), 'Video & Animation', 'Explainer videos, video editing, animation, and motion graphics','canceled', 'Admin', 'Admin'),
(UUID(), 'Business Consulting', 'Financial planning, market research, and business strategy','open', 'Admin', 'Admin'),
(UUID(), 'Mobile App Development', 'Developing iOS and Android applications, including UI/UX design','in progress', 'Admin', 'Admin'),  
(UUID(), 'Cybersecurity', 'Protecting systems, networks, and data from cyber threats and attacks','open', 'Admin', 'Admin'),  
(UUID(), 'E-commerce & Dropshipping', 'Building online stores, managing dropshipping, and product listing optimization','completed', 'Admin', 'Admin'),  
(UUID(), 'Game Development', 'Designing and developing games for PC, mobile, and consoles using various engines','in progress', 'Admin', 'Admin'),  
(UUID(), 'Artificial Intelligence & Machine Learning', 'Creating AI models, chatbots, automation, and predictive analytics','completed', 'Admin', 'Admin');  

-- INSERT INTO projects (client_id, title, description, budget, status) VALUES
-- (1, 'Website Development', 'Need a responsive website for my business.', 500.00, 'open'),
-- (1, 'Logo Design', 'Create a modern logo for my startup.', 100.00, 'open');

-- INSERT INTO payment (
--     payment_id, client_id, freelancer_id, amount, payment_status, 
--     payment_method, transaction_id, created_at, created_date, updated_date, 
--     created_by, updated_by) VALUES
-- (UUID(), 101, 201, 500.00, 'COMPLETED', 'PAYPAL', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 102, 202, 1200.50, 'PENDING', 'CREDIT_CARD', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 103, 203, 750.75, 'FAILED', 'BANK_TRANSFER', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 104, 204, 300.00, 'COMPLETED', 'PAYPAL', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 105, 205, 950.25, 'PENDING', 'CREDIT_CARD', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 106, 206, 425.00, 'COMPLETED', 'BANK_TRANSFER', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 107, 207, 1100.00, 'FAILED', 'PAYPAL', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 108, 208, 620.90, 'COMPLETED', 'CREDIT_CARD', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 109, 209, 850.00, 'PENDING', 'BANK_TRANSFER', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin'),
-- (UUID(), 110, 210, 275.50, 'COMPLETED', 'PAYPAL', UUID(), NOW(), NOW(), NOW(), 'Admin', 'Admin');

-- INSERT INTO profiles  (name, skills, experience, email, location) 
-- VALUES 
-- ('John Doe', 'HTML, CSS, JavaScript', 5, 'john@example.com', 'New York, USA'),
-- ('Jane Smith', 'React, Node.js, MongoDB', 3, 'jane@example.com', 'London, UK'),
-- ('Michael Brown', 'Python, Django, PostgreSQL', 7, 'michael@example.com', 'Toronto, Canada'),
-- ('Emily White', 'Java, Spring Boot, MySQL', 6, 'emily@example.com', 'Berlin, Germany'),
-- ('David Lee', 'C++, Rust, Embedded Systems', 8, 'david@example.com', 'San Francisco, USA'),
-- ('Sophia Patel', 'Vue.js, Laravel, PHP', 4, 'sophia@example.com', 'Mumbai, India'),
-- ('Carlos Ramirez', 'Flutter, Dart, Firebase', 2, 'carlos@example.com', 'Madrid, Spain'),
-- ('Linda Kim', 'Swift, Kotlin, Mobile Development', 5, 'linda@example.com', 'Seoul, South Korea');


-- INSERT INTO reviews (project_id, client_id, freelancer_id, rating, review_text) VALUES
-- (1, 1, 2, 5, 'Excellent work! The website was delivered on time and looks great.'),
-- (2, 1, 3, 4, 'Good logo, but needed some revisions.');


-- INSERT INTO contact_messages (name, email, phone, message) VALUES
-- ('Michael Johnson', 'michael@example.com', '+1987654321', 'I need help with my account.'),
-- ('Samantha Brown', 'samantha@example.com', '+1122334455', 'Looking for more details about your services.');

-- INSERT INTO freelancer (freelancer_id, full_name, rating, location, language, completed_projects, total_clients, years_experience, specialization, skills, profile_description, profile_picture, joined_date)
-- VALUES
-- (1, 'David Michael', 4.97, 'Stirling, United Kingdom', 'English', 184, 79, 5, 
--  'WordPress Development', 
--  'AFFILIATEWP, ANYTHING BACKEND, BUSINESS DEVELOPMENT, CUSTOM API INTEGRATION, CUSTOM THEMES, EASY DIGITAL DOWNLOADS, FULL STACK, GAMIPRESS, GRAVITY FORMS, KINSTA',
--  'Hey, I’m David – I specialise in building high-performance, secure, and scalable plugins for Easy Digital Downloads, AffiliateWP, Restrict Content Pro, Sugar Calendar, WP Simple Pay Pro, Gravity Forms, and WooCommerce.', 
--  'https://storage.googleapis.com/a1aa/image/YUJ8Vx4VaDwXUmykoc4yuuqjUwRnVhP129llgDGhLwA.jpg', 
--  '2020-08-07'),

-- (2, 'Sarah Johnson', 4.85, 'New York, USA', 'English, Spanish', 210, 90, 7, 
--  'Full Stack Development', 
--  'REACT, NODE.JS, DATABASES, API DEVELOPMENT, CLOUD COMPUTING', 
--  'Passionate full-stack developer with expertise in building scalable applications, APIs, and cloud-based solutions.', 
--  'https://storage.googleapis.com/a1aa/image/sample_sarah.jpg', 
--  '2018-06-15'),

-- (3, 'Emily Johnson', 4.85, 'Los Angeles, USA', 'English, Spanish', 150, 65, 6, 
--  'Full Stack Web Development', 
--  'React, Node.js, Express, MongoDB, Tailwind CSS, API Development', 
--  'I’m a passionate full-stack developer helping businesses build high-performance, user-friendly web applications.', 
--  'https://randomuser.me/api/portraits/women/45.jpg', 
--  '2018-06-15'),

-- (4, 'Michael Smith', 4.90, 'Toronto, Canada', 'English, French', 210, 90, 7, 
--  'E-commerce & Shopify Expert', 
--  'Shopify, Magento, PHP, UI/UX Design, SEO Optimization', 
--  'Helping brands scale their online stores through effective Shopify solutions and SEO strategies.', 
--  'https://randomuser.me/api/portraits/men/52.jpg', 
--  '2016-04-22'),

-- (5, 'Sophia Brown', 4.80, 'Berlin, Germany', 'German, English', 120, 50, 4, 
--  'Mobile App Development', 
--  'Flutter, Dart, Android, iOS, Firebase, Cloud Functions', 
--  'Expert in developing cross-platform mobile applications using Flutter and Firebase.', 
--  'https://randomuser.me/api/portraits/women/29.jpg', 
--  '2019-11-10'),

-- (6, 'James Wilson', 4.88, 'Sydney, Australia', 'English', 175, 85, 6, 
--  'Cybersecurity & Ethical Hacking', 
--  'Penetration Testing, Network Security, Ethical Hacking, Python, Cloud Security', 
--  'Certified ethical hacker with extensive experience in securing web applications and networks.', 
--  'https://randomuser.me/api/portraits/men/60.jpg', 
--  '2017-03-05');
