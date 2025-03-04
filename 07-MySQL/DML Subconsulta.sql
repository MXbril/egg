-- DML Subconsulta

INSERT INTO productos (nombre, precio) VALUES ('Telefono móvil', 450.00);

INSERT INTO clientes (nombre, direccion) VALUES ('María García', 'Constitución 456, Luján');

ALTER TABLE empleados
MODIFY correo_electronico VARCHAR(100) GENERATED ALWAYS AS (CONCAT(nombre, apellido, '@mail.com')) STORED;

SELECT id FROM departamentos WHERE nombre = 'Ventas';

INSERT INTO empleados (nombre, apellido, edad, salario, departamento_id)
VALUES ('Luis', 'Fernández', 28, 2800.00, 1);

UPDATE productos SET precio = 1350.00 WHERE nombre = 'laptop';

UPDATE clientes SET direccion = 'Alberti 1789, Mar del Plata' WHERE nombre = 'Juan Pérez';

UPDATE empleados SET salario = salario * 1.05;

INSERT INTO productos (nombre, precio) VALUES ('Tablet', 350.00);

INSERT INTO clientes (nombre, direccion) VALUES ('Ana López', 'Beltrán 1452, Godoy Cruz');

INSERT INTO empleados (nombre, apellido, edad, salario, departamento_id)
VALUES ('Marta', 'Ramírez', 32, 3100.00, 1);

ALTER TABLE ventas DROP FOREIGN KEY ventas_ibfk_3;
DROP TABLE empleados;

UPDATE productos SET precio = 480.00 WHERE nombre = 'Telefono móvil';

UPDATE clientes SET direccion = 'Avenida 789, Ciudad del Este' WHERE nombre = 'María García';

UPDATE empleados SET salario = salario * 1.07 WHERE departamento_id = 1;

INSERT INTO productos (nombre, precio) VALUES ('Impresora', 280.00);

INSERT INTO clientes (nombre, direccion) VALUES ('Carlos Sánchez', 'Saavedra 206, Las Heras');

INSERT INTO empleados (nombre, apellido, edad, salario, departamento_id)
VALUES ('Lorena', 'Guzmán', 26, 2600.00, 1);

-- complementarias

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (1, 1, 2, 1350.00, 1);

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (2, 2, 3, 480.00, 2);

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (4, 4, 1, 280.00, 5);

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (1, 3, 1, 1350.00, 2);

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (3, 1, 2, 350.00, 4);

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (2, 2, 1, 480.00, 5);

INSERT INTO ventas (producto_id, cliente_id, cantidad, precio_unitario, empleado_id)
VALUES (4, 4, 2, 280.00, 6);