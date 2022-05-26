drop table tmember;
drop table board;

create table tmember(
  id  				varchar(30)  primary key,	-- 아이디(id) 
  password			varchar(30)  not null,		-- 비밀번호(password)
  name				varchar(30)  not null,		-- 이름(name)
  email				varchar(255),				-- 이메일(email) 
  phone				varchar(20),				-- 전화번호(phone) 
  address			varchar(100),				-- 주소(address)
  withdraw			char(1)      default 'N'	-- 탈퇴여부(withdraw)
);


create table board(
  no        int auto_increment primary key,		-- 게시글 번호
  id        varchar(30),						-- 작성자 id
  title     varchar(100),						-- 제목
  regdate   timestamp default current_timestamp,-- 등록일
  contents  varchar(3000),						-- 내용
  foreign key (id) references tmember(id)
);

-- member data-----------------------------
insert into tmember(id, password, name, email, address) values('ssafy','1111','싸피','admin@ssafy.com', null);

-- board data ----------------------------- 
insert into board(id, title, regdate, contents) values('ssafy','01', now(), '1 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','02', now(), '2 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','03', now(), '3 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','04', now(), '4 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','05', now(), '5 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','06', now(), '6 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','07', now(), '7 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','08', now(), '8 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','09', now(), '9 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','10', now(), '10 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','11', now(), '11 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','12', now(), '12 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','13', now(), '13 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','14', now(), '14 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','15', now(), '15 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','16', now(), '16 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','17', now(), '17 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','18', now(), '18 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','19', now(), '19 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','20', now(), '20 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','21', now(), '21 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','22', now(), '22 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','23', now(), '23 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','24', now(), '24 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','25', now(), '25 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','26', now(), '26 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','27', now(), '27 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','28', now(), '28 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','29', now(), '29 처음하는 게시판');
insert into board(id, title, regdate, contents) values('ssafy','30', now(), '30 처음하는 게시판');


commit;