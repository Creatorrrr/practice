DROP TABLE board_tb;
DROP TABLE article_tb;
DROP TABLE comment_tb;

CREATE TABLE board_tb (
id VARCHAR2(20) PRIMARY KEY,
name VARCHAR2(100),
create_date DATE,
creator_name VARCHAR2(50)
);

CREATE TABLE article_tb (
id VARCHAR2(20) PRIMARY KEY,
title VARCHAR2(100),
author_name VARCHAR2(50),
reg_date DATE,
contents VARCHAR2(500),
board_id VARCHAR2(20),
CONSTRAINT fk_article FOREIGN KEY (board_id) REFERENCES board_tb(id)
);

CREATE TABLE comment_tb (
id VARCHAR2(20) PRIMARY KEY,
author_name VARCHAR2(50),
reg_date DATE,
comm VARCHAR2(500),
article_id VARCHAR2(50),
CONSTRAINT fk_comment FOREIGN KEY (article_id) REFERENCES article_tb(id)
);

DROP SEQUENCE board_seq;
DROP SEQUENCE article_seq;
DROP SEQUENCE comment_seq;

CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE article_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE comment_seq START WITH 1 INCREMENT BY 1;

commit;
