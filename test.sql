SELECT * FROM mp_board;

create table upload(
num number(10) primary key,
fileName varchar2(30),
orgFileName varchar2(30)
);

commit;