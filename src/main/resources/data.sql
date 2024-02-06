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