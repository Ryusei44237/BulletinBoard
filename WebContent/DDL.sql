create database BulletinBoard;
  create table Board(
    id int(32) AUTO_INCREMENT,
    Name varchar(32),
    value varchar(256),
    mail varchar(128),
    create_time varchar(128),
    editing_time varchar(128),
    address varchar(128),
    picture varchar(256),
    primary key(id)
  );
  SET @i := 0;
  UPDATE `board` SET id = (@i := @i +1) ;
