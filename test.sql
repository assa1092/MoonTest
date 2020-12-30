SELECT * FROM mp_board;

create table upload(
num number(10) primary key,
fileName varchar2(30),
orgFileName varchar2(30)
);

commit;

CREATE TABLE boardtest(
	num number(10) PRIMARY KEY,
	writer VARCHAR2(20) NOT NULL,
	title VARCHAR2(30) NOT NULL,
	content VARCHAR2(100) NOT NULL,
	reg_date date default sysdate NOT NULL,
	cnt int default 0,
	file_name varchar(40)
);