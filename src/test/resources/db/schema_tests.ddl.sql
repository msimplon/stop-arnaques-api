/*
 * DDL = Data Definition Language
 * psql -h localhost -p 5432 -U postgres -d stoparnaques
 * \i schema.ddl.sql
 * \q
 */

DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;


CREATE TABLE categories (  
	id SERIAL PRIMARY KEY,
	name varchar(200) UNIQUE NOT NULL
);

CREATE TABLE articles (  
	id SERIAL PRIMARY KEY,
	title varchar(200) UNIQUE NOT NULL,
	subtitle varchar(200) NOT NULL,
	editor varchar(60) NOT NULL,
	description text NOT NULL,
	introduction text NOT NULL,
	image_url VARCHAR(255) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	date_of_publication date,
	category_id integer NOT NULL,
	CONSTRAINT fk_category_id
    	FOREIGN KEY (category_id)
    	REFERENCES categories(id)
);

CREATE TABLE roles (
	id SERIAL,
	code_role VARCHAR(300) UNIQUE NOT NULL,
	role_name VARCHAR(300) UNIQUE NOT null,
	constraint pk_role_id primary key(id)
);

CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(300) NOT NULL,
	last_name VARCHAR(300) NOT NULL,
	username varchar(255) UNIQUE NOT NULL,
	password varchar(60) NOT NULL,
	role_id integer, 
CONSTRAINT fk_role_id
  	FOREIGN KEY (role_id)
	REFERENCES roles(id)
);



