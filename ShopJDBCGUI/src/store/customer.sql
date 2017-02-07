drop table customer_tb;

create table customer_tb(
id varchar2(20) primary key,
passwd varchar2(30) not null,
name varchar2(50),
age number(3),
address varchar2(128));

create table product_tb(
productId varchar2(20) primary key,
productName varchar(128),
category varchar2(50),
information varchar2(256));

create table order_tb(
id varchar2(20) not null,
productId varchar2(20) not null,
orderDate date,
quantity number,
constraint "order_pk"  primary key(id,productId));

insert into customer_tb values('kkjin@nextree.co.kr', '1234', 'Jin', 20, '서울');
insert into customer_tb values('jypark@nextree.co.kr', '1111', 'Park', 25, '인천');
insert into customer_tb values('eykim@nextree.co.kr', '7979', 'Kim', 22, '서울');
insert into customer_tb values('tksong@nextree.co.kr', '0001', 'Song', 19, '광주');
insert into customer_tb values('yhh@nextree.co.kr', '3535', 'Ha', 20, '부산');

insert into product_tb values('A0001', 'LG TV', '가전', '바보상자');
insert into product_tb values('A0002', '삼성 세탁기', '가전', '때가 그대로~~~');
insert into product_tb values('A0003', '셔츠', '의류', '속이 다보이는 19금 셔츠');
insert into product_tb values('A0004', '원피스', '의류', '튀는 원피스(못생김 회피용)');
insert into product_tb values('A0005', '삽겹살', '음식', '삼겹은 곧 진리~~');
insert into product_tb values('A0006', '초밥', '가전', '와사비가 맛나요!!');

insert into order_tb values('eykim@nextree.co.kr', 'A0003', '2011-03-05', 2);
insert into order_tb values('kkjin@nextree.co.kr', 'A0001', '2012-05-05', 1);
insert into order_tb values('kkjin@nextree.co.kr', 'A0005', '2013-07-07', 20);
insert into order_tb values('tksong@nextree.co.kr', 'A0006', '2010-02-15', 10);
insert into order_tb values('tksong@nextree.co.kr', 'A0002', '2016-05-05', 1);
insert into order_tb values('jypark@nextree.co.kr', 'A0003', '2016-12-25', 5);

commit;

