-- Ejercicios JOIN

--01
SELECT e.nombre, e.apellido, SUM(v.cantidad) AS cantidad_total_ventas
FROM empleados e
JOIN ventas v ON e.id = v.empleado_id
GROUP BY e.nombre, e.apellido;

-- 02
SELECT c.nombre, c.direccion, SUM(v.monto_total) AS Monto_Total_Ventas
FROM clientes c
JOIN ventas v ON c.id = v.cliente_id
GROUP BY c.nombre, c.direccion;

-- 03
SELECT e.nombre AS nombre_empleado, p.nombre AS nombre_producto
FROM empleados e
INNER JOIN departamentos d ON e.departamento_id = d.id
INNER JOIN ventas v ON e.id = v.empleado_id
INNER JOIN productos p ON v.producto_id = p.id
WHERE d.nombre = 'Ventas';

-- 04
SELECT c.nombre AS nombre_cliente, p.nombre AS nombre_producto, SUM(v.cantidad) "Cantidad comprada"
FROM clientes c
INNER JOIN ventas v ON c.id = v.cliente_id
INNER JOIN productos p ON v.producto_id = p.id
WHERE p.precio > 500.00 GROUP BY c.nombre, p.nombre;

-- 05
SELECT d.nombre AS nombre_departamento, COUNT(v.id) AS cantidad_ventas
FROM departamentos d
LEFT JOIN empleados e ON d.id = e.departamento_id
LEFT JOIN ventas v ON e.id = v.empleado_id
GROUP BY d.nombre;

-- 06
SELECT c.nombre AS nombre_cliente, c.direccion, COUNT(v.id) AS cantidad_compras
FROM clientes c
INNER JOIN ventas v ON c.id = v.cliente_id
GROUP BY c.id, c.nombre, c.direccion
HAVING COUNT(v.id) > 3;

--07
SELECT d.nombre AS nombre_departamento, SUM(v.monto_total) AS monto_total_ventas
FROM departamentos d
LEFT JOIN empleados e ON d.id = e.departamento_id
LEFT JOIN ventas v ON e.id = v.empleado_id
GROUP BY d.nombre;

-- COMPLEMENTARIOS

SELECT e.nombre, e.apellido
FROM empleados e
LEFT JOIN departamentos d ON e.departamento_id = d.id
LEFT JOIN ventas v ON e.id = v.empleado_id
WHERE d.nombre = 'Recursos Humanos'
GROUP BY e.id, e.nombre, e.apellido
HAVING COUNT(v.id) > 5;

SELECT e.nombre, e.apellido, COUNT(v.id) AS cantidad_ventas
FROM empleados e
LEFT JOIN ventas v ON e.id = v.empleado_id
GROUP BY e.id, e.nombre, e.apellido;