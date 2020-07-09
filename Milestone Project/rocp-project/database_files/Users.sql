drop table if exists Users;

create table Users(
  userId INT primary key NOT NULL,
  username varchar (100) NOT NULL,
  password varchar (100) NOT NULL,
  firstName varchar (100) NOT NULL,
  lastName varchar (100) NOT NULL,
  email varchar (100) NOT NULL,
  roleId INT REFERENCES Role (roleId)
);