-- Ejercicios Función MAX()

SELECT MAX(salario) FROM empleados;
SELECT MAX(cantidad) FROM ventas;
SELECT MAX(edad) FROM empleados;

-- Ejercicios Función MIN()

SELECT MIN(salario) FROM empleados;
SELECT MIN(cantidad) FROM ventas;
SELECT MIN(edad) FROM empleados;

-- Ejercicios de Función COUNT()

SELECT COUNT(*) AS total_empleados FROM empleados;
SELECT COUNT(*) AS total_ventas_realizadas FROM ventas;
SELECT COUNT(*) AS producto_superior FROM productos WHERE precio > 500.00;

-- Ejercicios de la Función SUM()

SELECT SUM(salario) AS suma_salarios FROM empleados;
SELECT SUM(monto_total) AS suma_monto_total FROM ventas;
SELECT SUM(precio) AS suma_precio_id_par FROM productos WHERE id % 2 = 0;

-- Ejercicios Función AVG()

SELECT AVG(salario) FROM empleados;
SELECT AVG(precio_unitario) FROM ventas;
SELECT AVG(edad) FROM empleados;

-- Ejercicios GROUP BY()

SELECT empleado_id, COUNT(*) FROM ventas GROUP BY empleado_id;
SELECT precio, COUNT(*) FROM productos GROUP BY precio;
SELECT departamento_id, COUNT(*) FROM empleados GROUP BY departamento_id;

-- Ejercicios HAVING 

SELECT departamento_id, AVG(salario) AS salario_promedio FROM empleados GROUP BY departamento_id HAVING salario_promedio > 3000;
SELECT producto_id, COUNT(*) FROM ventas GROUP BY producto_id HAVING COUNT(*) >= 5;
SELECT departamento_id, nombre, apellido, salario
FROM empleados
WHERE (nombre LIKE '%o%' OR apellido LIKE '%o%')
AND salario = (
    SELECT MAX(salario)
    FROM empleados AS e2
    WHERE (e2.nombre LIKE '%o%' OR e2.apellido LIKE '%o%')
    AND e2.departamento_id = empleados.departamento_id
);