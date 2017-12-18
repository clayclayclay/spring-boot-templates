insert into users (username, password, enabled) values ('user1', 'password', true);
insert into users (username, password, enabled) values ('user2', 'password', true);

insert into authorities (username, authority) values ('user1', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('user2', 'ROLE_USER');
