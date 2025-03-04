-- Ejercicios  Subconsultas All y Any

SELECT c.nombre AS "Nombre del Cliente"
FROM clientes c
WHERE c.id IN (
    SELECT DISTINCT v.cliente_id
    FROM ventas v
    WHERE v.precio_unitario > (
        SELECT AVG(precio)
        FROM productos
    )
);

SELECT CONCAT(e.nombre, " ", e.apellido) AS "Nombre del Empleado"
FROM empleados e
WHERE e.salario > ANY (
    SELECT e2.salario
    FROM empleados e2
    INNER JOIN departamentos d ON e2.departamento_id = d.id
    WHERE d.nombre = "Ventas"
);
-- muestra los nombres con su precio y id
SELECT *
FROM productos p
WHERE p.precio > ALL (
    SELECT p2.precio
    FROM productos p2
    WHERE p2.nombre LIKE '%Móvil%'
);
-- solo muestra los nombre
SELECT p.nombre "Nombre del Producto"
FROM productos p
WHERE p.precio > ALL (
SELECT precio
FROM productos
WHERE nombre LIKE '%Móvil%'
);

SELECT c.nombre "Nombre del Cliente", c.direccion "Dirección",
MAX(v.monto_total) "Monto Total de Compra"
FROM clientes c INNER JOIN ventas v ON c.id = v.cliente_id
GROUP BY c.nombre, c.direccion
ORDER BY "Monto Total de Compra" DESC
LIMIT 1;

SELECT d.nombre AS "Nombre del Departamento", e.nombre AS "Nombre del Empleado", e.salario
FROM empleados e
JOIN departamentos d ON e.departamento_id = d.id
WHERE e.salario = (
    SELECT MAX(salario)
    FROM empleados
    WHERE departamento_id = d.id
);

SELECT e.nombre AS "Nombre del Empleado", e.salario AS "Salario"
FROM empleados e
WHERE e.salario > (
    SELECT AVG(e2.salario)
    FROM empleados e2
    INNER JOIN departamentos d ON e2.departamento_id = d.id
    WHERE d.nombre = 'Contabilidad'
);

SELECT p.nombre
FROM productos p
WHERE precio > ANY (SELECT precio_unitario FROM ventas v
JOIN clientes c ON v.cliente_id = c.id
WHERE c.nombre = 'Juan Pérez');

SELECT d.nombre
FROM departamentos d
WHERE 0 < (
SELECT COUNT(*)
FROM empleados e
WHERE e.departamento_id = d.id
AND e.edad < 30
);

SELECT e.nombre, e.apellido, e.edad
FROM empleados e
JOIN (
    SELECT v.empleado_id, SUM(v.cantidad) AS total_productos
    FROM ventas v
    GROUP BY v.empleado_id
    ORDER BY total_productos DESC
    LIMIT 3
) AS top_vendedores ON e.id = top_vendedores.empleado_id
ORDER BY e.edad ASC
LIMIT 1;

SELECT DISTINCT c.nombre "Nombre cliente", CONCAT(e.nombre,' ',
e.apellido) "Nombre empleado", v.monto_total
FROM clientes c
INNER JOIN ventas v
ON c.id = v.cliente_id
INNER JOIN empleados e
ON v.empleado_id = e.id
WHERE (v.cliente_id, v.monto_total) = (
SELECT v2.cliente_id, MAX(v2.monto_total)
FROM ventas v2
WHERE v2.cliente_id = v.cliente_id
GROUP BY v2.cliente_id) ;