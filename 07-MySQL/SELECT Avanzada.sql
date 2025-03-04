-- Cláusula DISTINCT

SELECT DISTINCT nombre FROM empleados;
SELECT DISTINCT correo_electronico FROM empleados;
SELECT DISTINCT edad FROM empleados;

-- Operadores relacionales

SELECT nombre FROM empleados WHERE salario > 3200;
SELECT nombre FROM empleados WHERE edad = 28;
SELECT nombre FROM empleados WHERE salario < 2700;
SELECT * FROM ventas WHERE cantidad > 2;
SELECT * FROM ventas WHERE precio_unitario = 480.00;
SELECT * FROM ventas WHERE monto_total < 1000.00;
SELECT * FROM ventas WHERE empleado_id = 1;

-- Operadores lógicos

SELECT nombre FROM empleados WHERE departamento_id = 1 AND salario > 3000.00;
SELECT nombre FROM empleados WHERE edad = 32 OR departamento_id = 3;
SELECT * FROM ventas WHERE producto_id = 1 AND cantidad >= 2;
SELECT * FROM ventas WHERE cliente_id = 1 OR empleado_id = 2;
SELECT * FROM ventas WHERE cliente_id = 2 AND cantidad > 2;
SELECT * FROM ventas WHERE empleado_id = 1 AND monto_total > 2000.00;

-- Cláusula BETWEEN

SELECT nombre, edad FROM empleados WHERE edad BETWEEN 29 AND 33;
SELECT * FROM ventas WHERE cantidad BETWEEN 2 AND 3;
SELECT * FROM ventas WHERE precio_unitario BETWEEN 300.00 AND 500.00;