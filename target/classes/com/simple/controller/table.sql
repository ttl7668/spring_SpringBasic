create table score(
    num number(10,0),
    name VARCHAR2(50),
    kor VARCHAR2(50),
    eng VARCHAR2(50),
    math VARCHAR2(50)
);

alter table score add CONSTRAINT score_pk PRIMARY key(num);

create SEQUENCE score_seq INCREMENT by 1 start with 1;

create table board(
    num number(10,0),
    name VARCHAR2(50),
    title VARCHAR2(50),
    content VARCHAR2(50)
);

alter table board add CONSTRAINT board_pk PRIMARY key(num);

create SEQUENCE board_seq INCREMENT by 1 start with 1 nocache;