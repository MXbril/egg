-- Lenguaje DDL

CREATE DATABASE mi_bd;
CREATE DATABASE mi_bd_2;
DROP DATABASE mi_bd_2;
SHOW DATABASES;

USE mi_bd;
CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    salario Decimal(10, 2) NOT NULL,
    fecha_contratacion DATE NOT NULL
);

SHOW TABLES;
DESCRIBE empleados;
DESCRIBE departamentos;

ALTER TABLE empleados
MODIFY COLUMN edad INT NOT NULL;

ALTER TABLE empleados
MODIFY COLUMN salario DECIMAL(10, 2) NOT NULL DEFAULT 0;

ALTER TABLE empleados
ADD COLUMN departamento VARCHAR(50);

ALTER TABLE empleados
ADD COLUMN correo_electronico VARCHAR(100);

ALTER TABLE empleados
DROP COLUMN fecha_contratacion;

ALTER TABLE empleados
ADD COLUMN fecha_contratacion DATE DEFAULT (CURRENT_DATE);

CREATE TABLE departamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

ALTER TABLE empleados
ADD COLUMN departamento_id INT;

ALTER TABLE empleados
ADD CONSTRAINT fk_departamento
FOREIGN KEY (departamento_id) REFERENCES departamentos(id);

ALTER TABLE empleados
DROP COLUMN departamento;