DROP TABLE person IF EXISTS;
DROP TABLE producto IF EXISTS;
DROP TABLE invoice IF EXISTS;
DROP TABLE detalle IF EXISTS;


CREATE TABLE person (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30)
);
CREATE INDEX person_last_name ON person (last_name);

CREATE TABLE producto (
  id   INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(80),
  stock DECIMAL(18,2),
  precio DECIMAL(18,2)
);
CREATE INDEX producto_name ON producto (first_name);

CREATE TABLE invoice (
  id       INTEGER IDENTITY PRIMARY KEY,
  client_id INTEGER NOT NULL,
  descripcion VARCHAR(80),
  fecha DATE
);
ALTER TABLE invoice ADD CONSTRAINT fk_invoice_client_id FOREIGN KEY (client_id) REFERENCES person (id);

CREATE TABLE detalle (
  id   INTEGER IDENTITY PRIMARY KEY,
  cantidad DECIMAL(18,2),
  invoice_id INTEGER NOT NULL,
  producto_id INTEGER NOT NULL
);
ALTER TABLE detalle ADD CONSTRAINT fk_detalle_client_id FOREIGN KEY (invoice_id) REFERENCES invoice (id);
ALTER TABLE detalle ADD CONSTRAINT fk_detalle_product_id FOREIGN KEY (producto_id) REFERENCES producto (id);

