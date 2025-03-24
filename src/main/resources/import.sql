-- Modifications To user_type

INSERT INTO user_type (type) VALUES ('CUSTOMER'), ('SELLER'), ('ADMIN'), ('COSTUMER_VIP');

INSERT INTO app_user (id, user_type_id, email, lastname, name, address, password) VALUES (NEWID(), 3, 'admin@gmail.com', 'Admin', 'Admin', 'Direccion', 'admin');

INSERT INTO product (id, name, price, stock) VALUES (NEWID(), 'Simulator A', 1200.50, 10);
INSERT INTO product (id, name, price, stock) VALUES (NEWID(), 'Simulator B', 2200.50, 10);
INSERT INTO product (id, name, price, stock) VALUES (NEWID(), 'Simulator C', 3200.50, 10);
INSERT INTO product (id, name, price, stock) VALUES (NEWID(), 'Simulator D', 4200.50, 10);
