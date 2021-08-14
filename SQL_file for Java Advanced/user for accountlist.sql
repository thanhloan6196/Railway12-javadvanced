use Testingsystem3;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
id 	BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
email	VARCHAR(50) UNIQUE,
`password`	VARCHAR(120),
username	VARCHAR(20) UNIQUE
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles(
id 		INT(11) AUTO_INCREMENT PRIMARY KEY,
`name`	VARCHAR(20)
);

DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles(
user_id		BIGINT(20),
role_id		INT(11),
PRIMARY KEY(user_id, role_id)
);

INSERT INTO roles(`name`) VALUES('ROLE_USER');
INSERT INTO roles(`name`) VALUES('ROLE_VTI');
INSERT INTO roles(`name`) VALUES('ROLE_ADMIN');