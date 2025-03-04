-- cláusula IN

SELECT * FROM empleados WHERE id IN (1, 3, 5);
SELECT * FROM productos WHERE id IN (2, 4, 6);
SELECT * FROM ventas WHERE cliente_id IN (1, 3, 5);

-- cláusula LIKE

SELECT * FROM empleados WHERE nombre LIKE 'L%';
SELECT * FROM productos WHERE nombre LIKE '%Teléfono%';
SELECT * FROM clientes WHERE direccion LIKE '%Calle%';

-- ORDER BY

SELECT * FROM empleados ORDER BY salario ASC;
SELECT * FROM productos ORDER BY nombre DESC;
SELECT * FROM ventas ORDER BY cantidad ASC, precio_unitario DESC;

-- LIMIT

SELECT * FROM  productos ORDER BY precio DESC LIMIT 5;
SELECT * FROM empleados ORDER BY apellido ASC LIMIT 10;
SELECT monto_total FROM ventas ORDER BY monto_total DESC LIMIT 3;

-- AS

SELECT nombre, salario, salario * 1.10 AS "Aumento del 10%" FROM empleados;
SELECT cliente_id, SUM(monto_total) AS "Monto total gastado" FROM ventas GROUP BY cliente_id;
SELECT CONCAT(nombre, ' ', apellido) AS "Nombre y Apellido" FROM empleados;

-- CASE

SELECT nombre,
    CASE
        WHEN precio >= 500.00 THEN 'Caro'
        WHEN precio >= 200.00 AND precio < 500.00 THEN 'Medio'
        ELSE 'Barato'
    END AS "Categoría de precio"
FROM productos;

SELECT nombre, apellido,
    CASE
        WHEN edad < 30 THEN 'Joven'
        WHEN edad BETWEEN 30 AND 40 THEN 'Adulto'
        ELSE 'Mayor'
    END AS "Categoría de edad"
FROM empleados;

SELECT id,
    CASE
        WHEN cantidad < 3 THEN 'Poca cantidad'
        WHEN cantidad >= 3 AND cantidad < 6 THEN 'Cantidad moderada'
        ELSE 'Mucha cantidad'
    END AS "Categoría de cantidad"
FROM ventas;

SELECT nombre,
    CASE
        WHEN nombre LIKE 'A%' THEN 'Comienza con A'
        WHEN Nombre LIKE 'M%' THEN 'Comienza con M'
        ELSE 'Otros'
    END AS "Categoría  de nombre"
FROM clientes;

SELECT nombre, apellido, salario,
       CASE
           WHEN salario >= 3500 THEN 'Salario alto'
           WHEN salario >= 3000 AND salario < 3500 THEN 'Salario medio'
           ELSE 'Salario bajo'
       END AS "Categoría de salario"
FROM empleados;