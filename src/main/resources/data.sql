INSERT INTO cities (id_city, name_of_city) VALUES (default, 'Gijón');
INSERT INTO cities (id_city, name_of_city) VALUES (default, 'Mieres');
INSERT INTO cities (id_city, name_of_city) VALUES (default, 'Amieva');
INSERT INTO cities (id_city, name_of_city) VALUES (default, 'Castropol');
INSERT INTO cities (id_city, name_of_city) VALUES (default, 'Oviedo');
INSERT INTO cities (id_city, name_of_city) VALUES (default, 'Avilés');
INSERT INTO cities (id_city, name_of_city) VALUES (default, 'Candamo');

/* Events */
INSERT INTO events (id_event, event_title, start_date, finish_date, event_image, max_participants, description, city_id) VALUES (default, 'Fiesta de los oricios', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'oricios.jpeg', 10, 'Comer oricios', 1);
INSERT INTO events (id_event, event_title, start_date, finish_date, event_image, max_participants, description, city_id) VALUES (default, 'Jornada de la matanza', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'matanza.jpg', 200, 'Matar cerdos y comerlos', 3);
INSERT INTO events (id_event, event_title, start_date, finish_date, event_image, max_participants, description, city_id) VALUES (default, 'Fiesta de la sidra', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'sidra.jpg', 3, 'Emborracharse y olvidarlo todo', 2);

/* Users */
INSERT INTO users (id_user, email, password) VALUES (default, 'admin@upcoming.com', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (id_user, email, password) VALUES (default, 'daisy@upcoming.com', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (id_user, email, password) VALUES (default, 'donald@upcoming.com', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');

/* Roles */
INSERT INTO roles (id_rol, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO roles (id_rol, name) VALUES (default, 'ROLE_USER');

/* Roles_Users */
INSERT INTO roles_users (user_id, role_id) VALUES (1, 1);
INSERT INTO roles_users (user_id, role_id) VALUES (2, 2);
INSERT INTO roles_users (user_id, role_id) VALUES (3, 2);