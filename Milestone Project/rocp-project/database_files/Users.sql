drop table if exists Users;

create table Users(
  userId SERIAL primary key,
  username varchar (100) NOT NULL,
  password varchar (100) NOT NULL,
  firstName varchar (100) NOT NULL,
  lastName varchar (100) NOT NULL,
  accountId INT REFERENCES account (accountId),
  roleId INT REFERENCES Role (roleId)
);