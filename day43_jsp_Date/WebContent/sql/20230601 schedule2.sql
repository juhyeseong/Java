drop table schedule2 purge;
create table schedule2(
    title   varchar2(100)   not null,
    sdate   date            not null,
    edate   date            not null
);

insert into schedule2 values('���������', '2023-03-08', '2023-09-04');
insert into schedule2 values('����', '2023-06-03', '2023-06-06');

commit;

select * from schedule2;

select title, sdate, edate, edate - sdate + 1 as days from schedule2 where title='����';

select title, sdate, edate, edate - sdate + 1 as days from schedule2 order by sdate;

select * from schedule2;

desc schedule2;