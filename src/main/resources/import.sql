INSERT INTO test.supplier (id, name, date_of_creation) values (1, 'Sadia', NOW()),(2, 'Nestlé', NOW()),(3, 'PepsiCo', NOW());

/*CREATE TABLE supplier (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name varchar(200) NOT NULL,
	date_of_creation TIMESTAMP NOT NULL,
	date_of_the_last_update TIMESTAMP,
	PRIMARY KEY (id)
);*/

/*CREATE TABLE product (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name varchar(200) NOT NULL,
	quantity_in_stock INTEGER NOT NULL,
	unit_price DOUBLE(19,6) NOT NULL,
	supplier_id INTEGER NOT NULL,
	date_of_creation TIMESTAMP NOT NULL,
	date_of_the_last_update TIMESTAMP,
	PRIMARY KEY (id),
	FOREIGN KEY (supplier_id) REFERENCES supplier(id)
);*/