-- DROP TABLE AUTHOR_TB;
-- DROP TABLE BLOG_TB;
-- DROP TABLE POST_TB;
-- DROP TABLE TAG_TB;
-- DROP TABLE COMMENT_TB;

DROP SEQUENCE blog_seq;
DROP SEQUENCE post_seq;
DROP SEQUENCE tag_seq;
DROP SEQUENCE comment_seq;

CREATE SEQUENCE blog_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE post_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE tag_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE comment_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE author_tb (
  id varchar2(20),
  password varchar2(20),
  name varchar2(20) DEFAULT NULL,
  email varchar2(30) DEFAULT NULL,
 PRIMARY KEY (id)
);

CREATE TABLE blog_tb (
  id NUMBER NOT NULL,
  title varchar2(255) DEFAULT NULL,
  author_id varchar2(20) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE post_tb (
  id NUMBER NOT NULL,
  subject varchar2(255) DEFAULT NULL,
  contents varchar2(2000) DEFAULT NULL,
  author_id varchar2(20) DEFAULT NULL,
  blog_id NUMBER DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE comment_tb (
  id NUMBER NOT NULL,
  name varchar2(255) DEFAULT NULL,
  comment_contents varchar2(2000) DEFAULT NULL,
  post_id NUMBER DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE tag_tb (
  id NUMBER NOT NULL,
  name varchar2(255) DEFAULT NULL,
  post_id NUMBER DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into author_tb(id,password,name,email) values ('demonpark','111','�ڵ���','demonpark@nextree.co.kr');
insert into author_tb(id,password,name,email) values ('jhheo','111','����ȣ','jhheo@nextree.co.kr');
insert into author_tb(id,password,name,email) values ('syhan','111','�ѽ¿�','syhan@nextree.co.kr');
insert into author_tb(id,password,name,email) values ('eykim','111','������','eykim@nextree.co.kr');
insert into author_tb(id,password,name,email) values ('kimgisa','111','����','hyunohkim@nextree.co.kr');

insert into blog_tb(id,title,author_id) values (blog_seq.NEXTVAL,'�ϴùٶ���','demonpark');
insert into blog_tb(id,title,author_id) values (blog_seq.NEXTVAL,'�������κ�α�','eykim');
insert into blog_tb(id,title,author_id) values (blog_seq.NEXTVAL,'������ iT���丮','kimgisa');

insert into post_tb(id,subject,contents,blog_id) values (post_seq.NEXTVAL,'mybatis','mybatis�� ���ؿ� ����',1);
insert into post_tb(id,subject,contents,blog_id) values (post_seq.NEXTVAL,'mybatis3','mybatis 3.0 ������ �����ϱ�',1);
insert into post_tb(id,subject,contents,blog_id) values (post_seq.NEXTVAL,'hibernate','OR������ ���ؿ� Hibernate',2);

insert into comment_tb(id,name,comment_contents,post_id) values (comment_seq.NEXTVAL,'�����','���ذ� �� �ȵǿ�',1);
insert into comment_tb(id,name,comment_contents,post_id) values (comment_seq.NEXTVAL,'�̵���','�װ� ������?',2);
insert into comment_tb(id,name,comment_contents,post_id) values (comment_seq.NEXTVAL,'������','ORM����� ���� �������...',3);

insert into tag_tb(id,name,post_id) values (tag_seq.NEXTVAL,'mybatis',1);
insert into tag_tb(id,name,post_id) values (tag_seq.NEXTVAL,'mybatis3',2);
insert into tag_tb(id,name,post_id) values (tag_seq.NEXTVAL,'hibernate',3);