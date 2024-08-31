INSERT INTO usuario (id, create_time, email, foto, password, username) VALUES(1, '2017-08-28', 'diebo@gmail.com', '', '1234', 'diebo');
INSERT INTO usuario (id, create_time, email, foto, password, username) VALUES(2, '2017-08-28', 'franco@gmail.com', '', '1234', 'franco');

INSERT INTO producto(id_producto, descripcion, estado, imagen, nombre, precio, stock) VAlUES(1, 'Teclado gamer', '1', '', 'Teclado Xsoul kx850', 4500, 2);
INSERT INTO producto(id_producto, descripcion, estado, imagen, nombre, precio, stock) VAlUES(2, 'Memoria RAM para notebook', '1', '', 'RAM 8gb Kingston', 6000, 12);
INSERT INTO producto(id_producto, descripcion, estado, imagen, nombre, precio, stock) VAlUES(3, 'Notebook Lenovo', '1', '', 'Lenovo Ideapad ', 90000, 3);

INSERT INTO carrito(id_carrito, id_usuario) VALUES(1, 1)
INSERT INTO carrito(id_carrito, id_usuario) VALUES(2, 2)