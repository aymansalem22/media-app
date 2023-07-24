
CREATE TABLE IF NOT EXISTS playlist (id bigint AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(250) NOT NULL,
                                     created_on DATE DEFAULT CURRENT_TIMESTAMP);


CREATE TABLE IF NOT EXISTS song
  (id bigint AUTO_INCREMENT PRIMARY KEY,
   playlist_id bigint NOT NULL,
   name VARCHAR(250) NOT NULL,
   cover_url VARCHAR(250) NOT NULL,
   created_on DATE DEFAULT CURRENT_TIMESTAMP,
   FOREIGN KEY(playlist_id) REFERENCES playlist(id) ON UPDATE CASCADE);


INSERT INTO playlist(id, name, created_on)
VALUES(1, 'guitar', CURRENT_TIMESTAMP);


INSERT INTO song(id, name, playlist_id, cover_url, created_on)
VALUES(2, 'guitar song', 1, 'https://www.dummies.com/wp-content/uploads/open-guitar-chords-chart.jpg', CURRENT_TIMESTAMP);