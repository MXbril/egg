-- Lenguaje DML

INSERT INTO departamentos (nombre)
VALUES ('Ventas');

INSERT INTO departamentos (nombre)
VALUES ('Recursos Humanos');

SELECT * FROM departamentos;

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Ana', "Rodríguez", 28, 3000.00, 'anarodrigues@mail.com', 1);

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Carlos', 'López', 32, 3200.00, 'carloslopez@mail.com', 2);

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Laura', 'pérez', 25, 2600.00, 'lauraperez@mail.com', 1);

INSERT INTO empleados (nombre, apellido, edad, salario, correo_electronico, departamento_id)
VALUES ('Oscar', 'Gonzáles', 28, 2900.00, 'oscargonzales@mail.com', 2);

UPDATE empleados
SET salario = salario * 1.10
WHERE nombre = 'Ana';

INSERT INTO departamentos (nombre)
VALUES ('Contabilidad');

SELECT * FROM departamentos WHERE nombre = 'Contabilidad';

UPDATE empleados
SET departamento_id = 3
WHERE nombre = 'Carlos';

DELETE FROM empleados
WHERE nombre = 'Laura';

SELECT * FROM empleados;
SELECT * FROM departamentos;
SELECT * FROM clientes;

-- Repaso DML

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    direccion VARCHAR(100)
);

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    precio DECIMAL(10, 2)
);

CREATE TABLE ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT,
    cliente_id INT,
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    monto_total DECIMAL(10, 2),
    empleado_id INT,
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (empleado_id) REFERENCES empleados(id)
);

INSERT INTO clientes (nombre, direccion)
VALUES ('Juan Pérez', 'Libertad 3215, Mar del plata');

INSERT INTO productos (nombre, precio)
VALUES ('Laptop', 1200.00);

ALTER TABLE ventas
MODIFY monto_total DECIMAL(10, 2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED;

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (1, 1, 2, 1200.00, 1);

SELECT * FROM ventas;
SELECT * FROM productos;