CREATE TABLE Person(
                       id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                       username varchar(100) not null,
                       year_of_birth int not null,
                       password varchar not null
);

insert into Person (username, year_of_birth, password) values ('test_user1', 1960, '1234');
insert into Person (username, year_of_birth, password) values ('test_user2', 1960, '1234');
insert into Person (username, year_of_birth, password) values ('test_user3', 1960, '1234');