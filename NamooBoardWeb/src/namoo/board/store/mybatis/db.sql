DROP TABLE comment_tb;
DROP TABLE article_tb;
DROP TABLE board_tb;

commit;

CREATE TABLE board_tb (
id NUMBER PRIMARY KEY,
name VARCHAR2(100),
create_date DATE,
creator_name VARCHAR2(50)
);

CREATE TABLE article_tb (
id NUMBER PRIMARY KEY,
title VARCHAR2(100),
author_name VARCHAR2(50),
reg_date DATE,
contents VARCHAR2(500),
board_id NUMBER,
CONSTRAINT fk_article FOREIGN KEY (board_id) REFERENCES board_tb(id)
);

CREATE TABLE comment_tb (
id NUMBER PRIMARY KEY,
author_name VARCHAR2(50),
reg_date DATE,
comm VARCHAR2(500),
article_id NUMBER,
CONSTRAINT fk_comment FOREIGN KEY (article_id) REFERENCES article_tb(id)
);

DROP SEQUENCE board_seq;
DROP SEQUENCE article_seq;
DROP SEQUENCE comment_seq;

commit;

CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE article_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE comment_seq START WITH 1 INCREMENT BY 1;

commit;
