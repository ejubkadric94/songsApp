INSERT INTO APP_USER (id, email, password, first_name, last_name, created_at, modified_at)
VALUES (0, 'ejubkadric@gmail.com', 'letmein', 'Ejub', 'Kadric', NOW(), NOW());

INSERT INTO PUBLISHER (id, name, created_at, modified_at)
VALUES (0, 'DM Production', NOW(), NOW());
INSERT INTO PUBLISHER (id, name, created_at, modified_at)
VALUES (1, 'Kobalt', NOW(), NOW());

INSERT INTO ARTIST (id, name, created_at, modified_at)
VALUES (0, 'Akon', NOW(), NOW());
INSERT INTO ARTIST (id, name, created_at, modified_at)
VALUES (1, 'Basshunter', NOW(), NOW());
INSERT INTO ARTIST (id, name, created_at, modified_at)
VALUES (2, 'Dizzy Gillespie', NOW(), NOW());
INSERT INTO ARTIST (id, name, created_at, modified_at)
VALUES (3, 'Alice Cooper', NOW(), NOW());

INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id, created_at, modified_at)
VALUES (0, 'Beautiful', 'POP','USA', 0, 0, NOW(), NOW());
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id, created_at, modified_at)
VALUES (1, 'Dota', 'EURO_DANCE','Sweden', 0, 1, NOW(), NOW());
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id, created_at, modified_at)
VALUES (2, 'Poison', 'ROCK','USA', 1, 3, NOW(), NOW());
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id, created_at, modified_at)
VALUES (3, 'A night in Tunisia', 'JAZZ','USA', 1, 2, NOW(), NOW());
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id, created_at, modified_at)
VALUES (4, 'Now you are gone', 'EURO_DANCE','Sweden', 1, 1, NOW(), NOW());
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id, created_at, modified_at)
VALUES (5, 'Smack that', 'POP','USA', 0, 0, NOW(), NOW());

