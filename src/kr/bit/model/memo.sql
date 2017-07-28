create table memo(
mnum int not null primary key auto_increment,
mname varchar(30) not null,
mcontent varchar(2000) not null,
mday datetime default now()


)
insert into memo(mname,mcontent)values('관리자','테스트입니다.');

select*from memo;
;

select*from mysql;
show databases;