DELETE FROM categories;
DELETE FROM users;
DELETE FROM roles;
DELETE FROM disputes;

INSERT INTO categories (name)
VALUES ('Actualites'), ('Conseils');

INSERT INTO roles
	(code_role, role_name)
	VALUES
    ('ROLE_ADMIN', 'ADMIN'),  ('ROLE_USER', 'USER');
   
   INSERT INTO users
	(first_name, last_name, username, password, role_id, is_enabled)
	VALUES
    ( 'Manal', 'Benallal', 'admin@admin.com', '$2y$10$v.8CVIY09L2BFyg1XXKwYOkXjZ6gn.6DsotJdZwjooesl0nVOaKGi', (SELECT r.id FROM roles r WHERE r.code_role = 'ROLE_ADMIN'), true);

    INSERT INTO disputes (label)
	VALUES 
	('origine frauduleuse');