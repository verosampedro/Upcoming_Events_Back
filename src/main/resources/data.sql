INSERT INTO cities (id_city, city_name) VALUES (default, 'Gijón');
INSERT INTO cities (id_city, city_name) VALUES (default, 'Mieres');
INSERT INTO cities (id_city, city_name) VALUES (default, 'Amieva');
INSERT INTO cities (id_city, city_name) VALUES (default, 'Castropol');

INSERT INTO events (id_event, event_title, start_date, finish_date, event_image, max_participants, description, city_id) VALUES (default, 'Fiesta de los oricios', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, 10, 'Comer oricios', 1);
INSERT INTO events (id_event, event_title, start_date, finish_date, event_image, max_participants, description, city_id) VALUES (default, 'Jornada de la matanza', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, 200, 'Matar cerdos y comerlos', 3);
INSERT INTO events (id_event, event_title, start_date, finish_date, event_image, max_participants, description, city_id) VALUES (default, 'Fiesta de la cidra', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, 3, 'Emborracharse y olvidarlo todo', 2);