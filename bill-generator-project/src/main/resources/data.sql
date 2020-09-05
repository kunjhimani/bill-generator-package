DROP TABLE IF EXISTS product;
 
CREATE TABLE product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category_id INT NOT NULL,
  name VARCHAR(250) NOT NULL,
  price INT DEFAULT NULL
);
 
INSERT INTO product (category_id, name, price ) VALUES
    (1, 'samsung', 12000),
    (1, 'iphone', 10000),
    (2, 'orange', 10000),
    (2, 'apple', 10000),
    (3, 'pencil', 10000),
    (3, 'pen', 10000);

    DROP TABLE IF EXISTS category;
 
CREATE TABLE category (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category  CHARACTER,
	levy INTEGER 
);
 
INSERT INTO category(category, levy ) VALUES
    ('A', 10),
    ('B', 20),
    ('C',0);