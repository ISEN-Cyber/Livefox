CREATE DATABASE IF NOT EXISTS livefoxdb;
USE livefoxdb;

CREATE TABLE IF NOT EXISTS video (
id INT,
name CHAR(100),
path CHAR(200),
picturePath CHAR(200),
PRIMARY KEY(id));


INSERT INTO video VALUES(1,"fail_army","/livefox/video/fail_army.mp4","/livefox/img/fail_army.jpg");

SELECT * FROM video;