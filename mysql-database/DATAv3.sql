CREATE DATABASE IF NOT EXISTS livefoxdb;
USE livefoxdb;

CREATE TABLE IF NOT EXISTS video (
id INT,
name CHAR(100),
path CHAR(200),
picturePath CHAR(200),
PRIMARY KEY(id));


INSERT INTO video VALUES(1,"Video drole","video drole path","pictDrole.jpg");
INSERT INTO video VALUES(2,"Video triste","video triste path","pictTriste.jpg");
INSERT INTO video VALUES(3,"Video romantique","video romantique path","pictRomantique.jpg");
INSERT INTO video VALUES(4,"Video sympa","video sympa path","pictSympa.jpg");
INSERT INTO video VALUES(5,"Video horreur","video horreur path","pictHorreur.jpg");

SELECT * FROM video;