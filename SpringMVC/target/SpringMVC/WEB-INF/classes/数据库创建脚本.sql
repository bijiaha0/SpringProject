DROP DATABASE IF EXISTS springdb ;
CREATE DATABASE springdb CHARACTER SET UTF8 ;
USE springdb ;
CREATE TABLE news(
	nid			INT		AUTO_INCREMENT ,
	title		VARCHAR(50) ,
	pubdate		DATETIME ,
	note		TEXT ,
	CONSTRAINT pk_nid PRIMARY KEY(nid)
) ;