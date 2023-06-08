drop table member1;
drop sequence member1_seq;

create sequence member1_seq
    start with 1
    maxvalue 9999999
    increment by 1
    nocache
    nocycle;
    
create table member1 (
    idx         number           default member1_seq.nextval primary key,
    userid      varchar2(100)    unique not null,
    userpw      varchar2(100)    not null,
    username    varchar2(100)    not null,
    email       varchar2(100)    not null,
    birth       varchar2(100)    default sysdate,
    gender      varchar2(20)     check(gender in ('����', '����')),
    age         number           check(age between 0 and 100)
);

insert into
    member1(userid, userpw, username, email, gender, age)
    values ('itbank', 'it', '����Ƽ��ũ', 'itbank@gmail.com', '����', '35');

insert into
    member1(userid, userpw, username, email, gender, age)
    values ('root', 'qwe', '������', 'root@kakao.com', '����', '45');
    
insert into
    member1(userid, userpw, username, email, gender, age)
    values ('test1', '1', '�׽���', 'test1@daum.com', '����', '31');

select * from member1 where userid='itbank' and userpw='it';

select * from member1;

update member1 set
    userPw='i23', email='test1@daum.com', age=27
    where idx=6;

desc member1;