INSERT INTO APP_USER (id, email, password, first_name, last_name)
VALUES (0, 'ejubkadric@gmail.com', 'letmein', 'Ejub', 'Kadric');

INSERT INTO PUBLISHER (id, name)
VALUES (0, 'DM Production');
INSERT INTO PUBLISHER (id, name)
VALUES (1, 'Kobalt');

INSERT INTO ARTIST (id, name)
VALUES (0, 'Akon');
INSERT INTO ARTIST (id, name)
VALUES (1, 'Basshunter');
INSERT INTO ARTIST (id, name)
VALUES (2, 'Dizzy Gillespie');
INSERT INTO ARTIST (id, name)
VALUES (3, 'Alice Cooper');

INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id)
VALUES (0, 'Beautiful', 'USA', 'POP', 0, 0);
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id)
VALUES (1, 'Dota', 'Sweden', 'EURO_DANCE', 0, 1);
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id)
VALUES (2, 'Poison', 'USA', 'POP', 1, 3);
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id)
VALUES (3, 'A night in Tunisia', 'USA', 'JAZZ', 1, 2);
INSERT INTO SONG (id, title, originating_country, genre, publisher_id, artist_id)
VALUES (4, 'Now you are gone', 'Sweden', 'EURO_DANCE', 1, 1);

-- INSERT INTO SONG (id, title, originating_country, publisher_id, artist_id)
-- VALUES (0, 'Beautiful', 'USA', 0, 0);
-- INSERT INTO SONG (id, title, originating_country, publisher_id, artist_id)
-- VALUES (1, 'Dota', 'Sweden', 0, 1);
-- INSERT INTO SONG (id, title, originating_country, publisher_id, artist_id)
-- VALUES (2, 'Poison', 'USA', 1, 3);
-- INSERT INTO SONG (id, title, originating_country, publisher_id, artist_id)
-- VALUES (3, 'A night in Tunisia', 'USA', 1, 2);
-- INSERT INTO SONG (id, title, originating_country, publisher_id, artist_id)
-- VALUES (4, 'Now you are gone', 'Sweden', 1, 1);