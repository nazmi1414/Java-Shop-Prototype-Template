CREATE SCHEMA item;
USE item;

CREATE TABLE IF NOT EXISTS shop (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS menu_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    image_link VARCHAR(255),
    shop_id BIGINT,
    price DECIMAL(10,2)
);


INSERT INTO shop (name, email)
VALUES
    ('Bikers Heaven', 'bikersss@example.com');

-- Menu items for shop 1
INSERT INTO menu_item (name, description,image_link, shop_id, price)
VALUES
    ('R1 Headlight', 'Red RingLight with bright white light','https://example.com/soda.jpg', 1, 10.99),
    ('R15M Slider', 'All Colors available match your coverset','https://example.com/soda.jpg', 1, 12.49),
    ('Nolan Fullface LS2', 'Fullfaced helmet limited stock available Nolan from Germany','https://example.com/soda.jpg', 1, 9.99),
    ('Kriss Carburator', 'High Qulaity carburator GP Standard','https://example.com/soda.jpg', 1, 7.99),
    ('Eztwo Jacket', 'Breathable Jacket comes with 2 ostrich legs.','https://example.com/soda.jpg', 1, 2.49);
