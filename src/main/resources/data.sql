INSERT INTO APP_USER (id, email, password, first_name, last_name)
VALUES (1, 'ejubkadric@gmail.com', 'letmein', 'Ejub', 'Kadric');

INSERT INTO PUBLISHER (uuid, name)
VALUES ('70a956a0-3d98-48c6-b97a-5aba75dd610a', 'DM Production');
INSERT INTO PUBLISHER (uuid, name)
VALUES ('c0c00ac0-d595-42cb-9d37-475c41288ef4', 'Kobalt');

INSERT INTO ARTIST (uuid, name)
VALUES ('26c5179f-ca1d-4fab-b1c0-6580ab1a630a', 'Akon');
INSERT INTO ARTIST (uuid, name)
VALUES ('622f9b07-d696-4745-abfa-117597c68679', 'Basshunter');
INSERT INTO ARTIST (uuid, name)
VALUES ('eaa8a7e5-326f-42f7-9979-12e129e3274a', 'Dizzy Gillespie');
INSERT INTO ARTIST (uuid, name)
VALUES ('ttt8a7e5-326f-42f7-9979-12e129e3274b', 'Alice Cooper');

INSERT INTO SONG (uuid, title, originating_country, genre, publisher_uuid, artist_uuid)
VALUES ('d496b11e-7c3b-4d70-9314-20ea195160bb', 'Beautiful', 'USA', 10, '70a956a0-3d98-48c6-b97a-5aba75dd610a', '26c5179f-ca1d-4fab-b1c0-6580ab1a630a');
INSERT INTO SONG (uuid, title, originating_country, genre, publisher_uuid, artist_uuid)
VALUES ('04714e85-495e-41af-9892-8a31afbd6e41', 'Dota', 'Sweden', 20, '70a956a0-3d98-48c6-b97a-5aba75dd610a', '622f9b07-d696-4745-abfa-117597c68679');
INSERT INTO SONG (uuid, title, originating_country, genre, publisher_uuid, artist_uuid)
VALUES ('ff5a34cd-4155-4787-b829-3161ba51bd22', 'Poison', 'USA', 30, 'c0c00ac0-d595-42cb-9d37-475c41288ef4', 'ttt8a7e5-326f-42f7-9979-12e129e3274b');
INSERT INTO SONG (uuid, title, originating_country, genre, publisher_uuid, artist_uuid)
VALUES ('b67d912a-5ac3-4435-8754-0b1be776e2e3', 'A night in Tunisia', 'USA', 40, 'c0c00ac0-d595-42cb-9d37-475c41288ef4', 'eaa8a7e5-326f-42f7-9979-12e129e3274a');
INSERT INTO SONG (uuid, title, originating_country, genre, publisher_uuid, artist_uuid)
VALUES ('0ef57426-273c-4e41-acde-b1efc4099c05', 'Now you are gone', 'Sweden', 20, 'c0c00ac0-d595-42cb-9d37-475c41288ef4', '622f9b07-d696-4745-abfa-117597c68679');
