drop table product purge;
drop table sales purge;

drop sequence product_seq;
drop sequence sales_seq;

create sequence product_seq
    start with 1
    maxvalue 9999
    increment by 1
    nocache
    nocycle;
    
create sequence sales_seq
    start with 1
    maxvalue 9999
    increment by 1
    nocache
    nocycle;

create table product(
    idx       number            default product_seq.nextval primary key,
    name      varchar2(100)     not null,
    price     number            check(price > 0)
);
create table sales(
    idx     number              default sales_seq.nextval primary key,
    product number              not null,
    sDate   date                default sysdate,
    cnt     number              check(cnt > 0),
    
    constraint sales_product_fk         -- ���������� �����. �̸��� sales_product_fk
        foreign key(product)            -- ���� ���̺��� ���������� ������ �÷��� product
        references product(idx)         -- �ܷ�Ű�ν� �����ϴ� ��� �÷��� product���̺��� idx
        on delete cascade               -- ���� �� ���� ����(��ǰ�� ���ŵǸ� ���⵵ ���ŵȴ�
);

insert into product(name, price) values('������', 1700);         
insert into product(name, price) values('��Ĩ', 1500);          
insert into product(name, price) values('�׶� (ĵ)', 2700);
insert into product(name, price) values('�뼱', 2200);

insert into sales(product, cnt) values(1, 5);
insert into sales(product, cnt) values(3, 6);
insert into sales(product, cnt) values(4, 10);
insert into sales(product, cnt) values(2, 1);

commit;

select * from product;
select * from sales;

desc product;
desc sales;

select
    sales.idx,
    product.name,
    product.price,
    sales.sdate,
    sales.cnt
        from sales 
        join product 
            on sales.idx = product.idx
        order by idx;