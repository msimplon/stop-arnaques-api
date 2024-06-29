DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS forms;
DROP TABLE IF EXISTS disputes;

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
	id SERIAL,
	first_name VARCHAR(300) NOT NULL,
	last_name VARCHAR(300) NOT NULL,
	username VARCHAR(300) UNIQUE NOT NULL,
	password VARCHAR(1000) NOT NULL,
	role_id INTEGER NOT NULL,
    is_enabled BOOLEAN NOT NULL,
	constraint pk_user_id primary key(id),
	constraint fk_role_id 
			foreign key (role_id)
			references roles(id)
);


CREATE TABLE disputes (    
	id SERIAL PRIMARY KEY,
	label VARCHAR(150) NOT NULL
);


CREATE TABLE forms (  
	id SERIAL PRIMARY KEY,
    subject VARCHAR(300) NOT NULL,
    email VARCHAR(300) UNIQUE NOT NULL,
    incidentNumber VARCHAR(300) NOT NULL,
	description VARCHAR(255) NOT NULL,
	details VARCHAR(255) NOT NULL,
    dispute_id integer NOT NULL,
    CONSTRAINT fk_dispute_id 
	    FOREIGN KEY (dispute_id)
	    REFERENCES disputes(id)
	);