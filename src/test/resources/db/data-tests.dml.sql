/*
 * DML = Data Manipulation Language
 * pour se connecter a cette database saisir cette commande : psql -h localhost -p 5432 -U postgres -d stoparnaques
 *  se connecter à la base : c\ stoparnaques
 * \i data.dml.sql
 * \q
 */


DELETE FROM categories;
DELETE FROM articles; 
DELETE FROM users;
DELETE FROM roles;


INSERT INTO categories (name)
VALUES ('Actualites'), ('Conseils');


INSERT INTO articles (title, subtitle, editor, description, introduction, image_url, date_of_publication,created_at, category_id) 
	VALUES
('Ecommerce','Tuto descriptage fiabilité du site marchand','manal','Lorem ipsum','Lorem ipsuddm','assets/IMG/ampoule/conseils1.png','2022-05-19', now(),(select c.id FROM categories c where c.name = 'Actualités')),
('Les réseaux sociaux','contrefacon','thomas','Lorem ipsum blabla', 'Lorem ipsuddm','assets/IMG/ampoule/conseils1.png','2022-03-29', now(),(select c.id FROM categories c where c.name = 'Actualités')),
('Influenceur et justice', 'Des influenceurs dans le collimateur de la justice!','eva','Lorem ipsum balbla.', 'Lorem ipsuddm','assets/IMG/ampoule/conseils1.png','2022-03-13', now(),(select c.id FROM categories c where c.name = 'Actualités')),
('Nos conseils à  suivre', 'Nos 10 conseils','Massy','Lorem ipsum','Lorem ipsuddm','assets/IMG/ampoule/conseils1.png','2022-01-13', now(),(select c.id FROM categories c where c.name = 'Conseils')),
('Notre lettre de reclamation', 'Lettre marchandise non conforme','laurine','Lorem ipsum balbla','Lorem ipsuddm','assets/IMG/ampoule/conseils1.png','2022-03-13', now(),(select c.id FROM categories c where c.name = 'Conseils')),
('Sept ans de prison pour un ex-influenceur','Detournement de fonds publics', 'lisa','Lorem ipsum balbla', 'assets/IMG/ampoule/conseils1.png','2022-03-13', now(),(select c.id FROM categories c where c.name = 'Actualités')),
('Obtenez répératation','Lettre non livraison','maroua','Lorem ipsum','assets/IMG/ampoule/conseils1.png','2022-10-13',now(),(select c.id FROM categories c where c.name = 'Conseils'));

	
	/* créer l'utilisateur admin = 1 seul role admin mais ajout de plusieurs roles dans un future proche*
	 * mot de passe est différent du token, le token est un jeton unique pr un utilisateur qui lui permet...  */
    
INSERT INTO roles (name) 
	VALUES ('admin'),('user');

	/* créer utilisateur admin test */
	 
INSERT INTO users (first_name, last_name, username, password, role_id) VALUES ('manal','benallal','admind2@domain.com', '$2a$12$9BXonP0NXZ48gUwP2Z84dOexo8DPdcWh8uXCoRRLjXHsSjM/9TfRm', (SELECT r.id FROM roles r WHERE r.name = 'user'));