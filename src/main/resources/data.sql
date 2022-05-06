INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);

INSERT INTO CLIENT(id, name) VALUES (1, 'Sara');
INSERT INTO CLIENT(id, name) VALUES (2, 'Raúl');
INSERT INTO CLIENT(id, name) VALUES (3, 'Carla');


insert into load (id,game_id,client_id,date_loan,date_return) values (1,1,1,TO_DATE('02/02/2022', 'DD/MM/YYYY'),TO_DATE('05/02/2022', 'DD/MM/YYYY'));
insert into load (id,game_id,client_id,date_loan,date_return) values (2,2,2,TO_DATE('03/03/2022', 'DD/MM/YYYY'),TO_DATE('10/03/2022', 'DD/MM/YYYY'));
insert into load (id,game_id,client_id,date_loan,date_return) values (3,3,3,TO_DATE('04/04/2022', 'DD/MM/YYYY'),TO_DATE('10/04/2022', 'DD/MM/YYYY'));
