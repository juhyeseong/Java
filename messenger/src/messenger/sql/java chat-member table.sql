drop table member purge;
drop sequence member_seq;

create sequence member_seq
    start with 1
    maxvalue 9999
    increment by 1
    nocache
    nocycle;
    
create table member(
    idx         number          default member_seq.nextval primary key,
    userId      varchar2(200)   ,
    userPw      varchar2(300)   ,
    nick        varchar2(500)   
);