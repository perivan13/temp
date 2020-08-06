insert into usr (id, username, password, active)
values (111, 'admin', 'admin', true);

insert into user_role (user_id, roles)
values(111, 'ADMIN'), (111, 'USER');