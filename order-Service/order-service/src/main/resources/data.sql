-- Insert dummy orders
INSERT INTO orders (id, order_status, total_price) VALUES (1, 'CONFIRMED', 120.50);
INSERT INTO orders (id, order_status, total_price) VALUES (2, 'PENDING', 250.75);
INSERT INTO orders (id, order_status, total_price) VALUES (3, 'DELIVERED', 89.99);

-- Insert dummy order items
INSERT INTO order_item (id, product_id, quantity, order_id) VALUES (1, 101, 2, 1);
INSERT INTO order_item (id, product_id, quantity, order_id) VALUES (2, 102, 1, 1);
INSERT INTO order_item (id, product_id, quantity, order_id) VALUES (3, 103, 3, 2);
INSERT INTO order_item (id, product_id, quantity, order_id) VALUES (4, 104, 5, 3);
