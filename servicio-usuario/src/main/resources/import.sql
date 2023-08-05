INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('andres','$2a$10$75W//tiYDorCynIzeNkS6uwNwxG/Regfbj.Wwt.PcM1HyR/W0CuyO',1, 'Camilo', 'Rodriguez','profesor@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$rqCzLsSiykCEfiTYkt5T0.h7fOF2Sy/c8ibWX0Vm8NRD57sEAwlzO',1, 'John', 'Doe','jhon.doe@gmail.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);