drop table if exists account;

create table account(
  accountId SERIAL primary key,
  balance Decimal not null,
  statusId INT REFERENCES account_status (statusId),
  typeId INT REFERENCES account_type (typeId)
);