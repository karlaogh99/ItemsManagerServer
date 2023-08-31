


CREATE TABLE item (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    item_code INT UNIQUE,
    description VARCHAR(255),
    price DECIMAL(10, 2),
    state VARCHAR(10),
    creation_date DATE,
    creator_id INT,
    FOREIGN KEY (creator_id) REFERENCES "user"(user_id)
);

CREATE TABLE supplier (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    country VARCHAR(255)
);
CREATE TABLE price_reduction (
    reduction_id INT PRIMARY KEY AUTO_INCREMENT,
    reduced_price DECIMAL(10, 2),
    start_date DATE,
    end_date DATE,
    item_id INT,
    FOREIGN KEY (item_id) REFERENCES item(item_id)
);
CREATE TABLE item_supplier (
    item_supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    item_id INT,
    supplier_id INT,
    FOREIGN KEY (item_id) REFERENCES item(item_id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
);