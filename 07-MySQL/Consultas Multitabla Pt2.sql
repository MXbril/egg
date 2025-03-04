-- consultas multitabla part-2

SELECT d.nombre AS Departamento,
       (SELECT SUM(monto_total)
        FROM ventas v
        WHERE v.empleado_id IN (SELECT e.id FROM empleados e WHERE e.departamento_id = d.id)
       ) AS Monto_Total_Ventas
FROM departamentos d;

SELECT d.nombre AS Departamento,
       (SELECT MIN(e.edad)
        FROM empleados e
        WHERE e.departamento_id = d.id
       ) AS Edad_Mas_Joven
FROM departamentos d;

SELECT p.nombre AS Nombre_Producto,
       SUM(v.cantidad) AS Total_Vendido,
       CASE
           WHEN SUM(v.cantidad) < 5 THEN 'Bajo'
           WHEN SUM(v.cantidad) BETWEEN 5 AND 7 THEN 'Medio'
           ELSE 'Alto'
       END AS Categoria_Volumen
FROM ventas v, productos p
WHERE v.producto_id = p.id GROUP BY p.nombre;

-- venta más alta. Esta consulta solo muestra una compra individual y no la suma total de todas sus compras.
SELECT c.nombre AS "Nombre del Cliente", v.monto_total AS "Monto Total de Compras"
FROM clientes c, ventas v
WHERE c.id = v.cliente_id
ORDER BY v.monto_total DESC
LIMIT 1;

-- muestra el cliente que ha gastado más en total, sumando todas sus compras.
SELECT c.nombre AS "Nombre del Cliente", SUM(v.monto_total) AS "Monto Total de Compras"
FROM clientes c
JOIN ventas v ON c.id = v.cliente_id
GROUP BY c.nombre
ORDER BY SUM(v.monto_total) DESC
LIMIT 1;

SELECT e.nombre "Nombre del Empleado", AVG(p.precio) "Precio Promedio de
Productos Vendidos"
FROM empleados e, ventas v, productos p
WHERE e.id = v.empleado_id AND v.producto_id = p.id
GROUP BY e.nombre;

-- Muestra el salario minimo de cada departamento
SELECT d.nombre "Nombre del Departamento", MIN(e.salario) "Salario Mínimo"
FROM departamentos d, empleados e
WHERE d.id = e.departamento_id
GROUP BY d.nombre;

-- solo muestra el departamento con el salario mas bajo
SELECT d.nombre AS "Nombre del Departamento", MIN(e.salario) AS "Salario Mínimo"
FROM departamentos d, empleados e
WHERE e.departamento_id = d.id
GROUP BY d.nombre
ORDER BY MIN(e.salario) ASC
LIMIT 1;

SELECT d.nombre AS "Nombre del Departamento", AVG(e.salario) AS "Salario Promedio"
FROM departamentos d, empleados e
WHERE e.departamento_id = d.id
  AND e.edad > 30
GROUP BY d.nombre
HAVING AVG(e.salario) > 3320
ORDER BY AVG(e.salario) DESC
LIMIT 1;