CREATE DATABASE `demo`;
use `demo`;

CREATE TABLE `user`(
id int AUTO_INCREMENT NOT NULL,
ndoc int UNIQUE,
nombre VARCHAR(50),
apellido VARCHAR(20),
fecha timestamp default current_timestamp,
PRIMARY KEY (id)
)
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `state` (
id INT AUTO_INCREMENT NOT NULL,
id_user INT,
state BOOLEAN,
PRIMARY KEY (id),
FOREIGN KEY (id_user) REFERENCES user(id),
UNIQUE (id_user)
)
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

DESCRIBE `user`;
DESCRIBE `state`;

INSERT INTO user (ndoc,nombre,apellido) VALUE (2,'Santiago','Pereira');
INSERT INTO state (id_user,state) VALUE (1,1),(2,1);
INSERT INTO state (id_user,state) VALUE (
	(SELECT id FROM user WHERE id = (SELECT MAX(id) FROM user)),
	1
);

SELECT ndoc FROM user WHERE id = (SELECT MAX(id) FROM user);

SELECT * FROM user;
SELECT * FROM state;

SELECT 
us.ndoc AS documento,
concat(us.nombre, ' ', us.apellido) AS Nombre,
CASE
	WHEN est.state = 1 THEN 'Activo'
	WHEN est.state = 0 THEN 'Inactivo'
END AS Estado
FROM state est
INNER JOIN user us ON est.id_user = us.id;

UPDATE state set state = 0 WHERE id_user = 2;

TRUNCATE TABLE state;
TRUNCATE TABLE user;

DROP TABLE state;
DROP TABLE user;

