drop table if exists Role;

create table Role (
  roleId SERIAL  primary key,
  role varchar (100) NOT NULL
 
);

insert into role(roleId, role) values (default, 'Employee');
insert into role(roleId, role) values (default, 'Admin');