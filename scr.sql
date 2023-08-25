begin;
drop TABLE if exists  ikea_erp.alumno_carlosgarher CASCADE;
drop TABLE if exists  ikea_erp.telefonoalumno_carlosgarher CASCADE;

drop sequence if exists  ikea_erp.alumno_carlosgarher_id_seq CASCADE;
drop sequence if exists  ikea_erp.telefonoalumno_carlosgarher_id_seq CASCADE;
create sequence ikea_erp.alumno_carlosgarher_id_seq;
create sequence ikea_erp.telefonoalumno_carlosgarher_id_seq;


CREATE TABLE ikea_erp.alumno_carlosgarher (
	
	idAlumno bigint primary key default nextval('ikea_erp.alumno_carlosgarher_id_seq'),
	nombre varchar not null,
	apellido varchar not null,
	codigoAlumno varchar not null unique,
	fechaAlta timestamp,
	fechaNacimiento date,
	estado int
);
CREATE TABLE ikea_erp.telefonoalumno_carlosgarher (
	
	idTelefonoAlumno bigint primary key default nextval('ikea_erp.telefonoalumno_carlosgarher_id_seq'),
	numeroTelefono varchar,
	descripcion varchar,
	alumno_id bigint REFERENCES ikea_erp.alumno_carlosgarher(idAlumno)
);
end;

begin;
INSERT INTO ikea_erp.alumno_carlosgarher (nombre, apellido, codigoAlumno, fechaAlta, fechaNacimiento)
VALUES ('María', 'Gómez', 'ALU456', '2023-08-08', '1999-05-20');
INSERT INTO ikea_erp.alumno_carlosgarher (nombre, apellido, codigoAlumno, fechaAlta, fechaNacimiento)
VALUES ('Juan', 'Pérez', 'ALU123', '2023-08-08', '2000-01-15');

INSERT INTO ikea_erp.telefonoalumno_carlosgarher (numeroTelefono, descripcion, alumno_id)
VALUES ('123456789', 'Teléfono principal', 1);

INSERT INTO ikea_erp.telefonoalumno_carlosgarher (numeroTelefono, descripcion, alumno_id)
VALUES ('987654321', 'Teléfono alternativo', 1); 

INSERT INTO ikea_erp.telefonoalumno_carlosgarher (numeroTelefono, descripcion, alumno_id)
VALUES ('555555555', 'Teléfono único', 2);

end;




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