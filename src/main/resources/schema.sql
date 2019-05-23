DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS USERS_ROLES;
DROP TABLE IF EXISTS JOB;

CREATE TABLE IF NOT EXISTS USERS (
  id int NOT NULL AUTO_INCREMENT,
  username VARCHAR(30),
  email VARCHAR(50),
  password VARCHAR(30),
  picture VARBINARY(MAX),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ROLES (
	id int NOT NULL AUTO_INCREMENT,
	name VARCHAR(30),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS USERS_ROLES(
	id_user int,
	id_role int,
	FOREIGN KEY (id_user) REFERENCES USERS(id),
	FOREIGN KEY (id_role) REFERENCES ROLES(id)
);

CREATE TABLE IF NOT EXISTS JOB(
	id int NOT NULL AUTO_INCREMENT,
	id_user int,
	name VARCHAR(30),
	description VARCHAR(500),
	price DECIMAL(5,2),
	FOREIGN KEY (id_user) REFERENCES USERS(id)
);
