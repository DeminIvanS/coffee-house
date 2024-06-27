INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

INSERT INTO users(role_id, username, password, first_name, last_name, email, phone_number)
VALUES ((select id from role where name = 'ROLE_ADMIN'), 'admin123', '$2a$10$cAsFSpmiVV4DJPO125ULuuLVU4kofDnFJICHLdo5Eh.xUHm.tpWZm', 'admin', 'adminov', 'admin@mail.ru', '123123');

INSERT INTO users(role_id, username, password, first_name, last_name, email, phone_number)
VALUES ((select id from role where name = 'ROLE_USER'), 'user123', '$2a$10$UbDf1Ia.0laj4bNifcfUgePbIlD3WB5oWJugaXbQ48CH1xsGTcCWC', 'user', 'userov', 'user@mail.ru', '123123');