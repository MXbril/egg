-- Funciones clave en MySQL. Subconsultas - Ejercicios Prácticos con Tablas Temporales 

TABLE productos
ORDER BY precio DESC
LIMIT 10;

-- 02
DROP TEMPORARY TABLE IF EXISTS empleados_temporal;

CREATE TEMPORARY TABLE empleados_temporal AS
SELECT CONCAT(nombre, ' ', apellido) AS nombre
FROM empleados;

TABLE empleados_temporal;

-- 03

DROP TEMPORARY TABLE IF EXISTS clientes_temporal;

CREATE TEMPORARY TABLE clientes_temporal AS
SELECT nombre
FROM clientes;
TABLE clientes_temporal;

-- 04
-- Con TABLE
TABLE empleados_temporal UNION TABLE clientes_temporal;
-- Con SELECT
SELECT nombre FROM empleados_temporal
UNION
SELECT nombre FROM clientes_temporal;

-- 05

DROP TEMPORARY TABLE IF EXISTS escuelas_primaria;
CREATE TEMPORARY TABLE escuelas_primaria (
  id INT,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  edad INT,
  grado INT
);

INSERT INTO escuelas_primaria (id, nombre, apellido, edad, grado) VALUES
(1, 'Alejandro', 'González', 11, 5),
(2, 'Isabella', 'López', 10, 4),
(3, 'Lucas', 'Martínez', 11, 5),
(4, 'Sofía', 'Rodríguez', 10, 4),
(5, 'Mateo', 'Pérez', 12, 6),
(6, 'Valentina', 'Fernández', 12, 6),
(7, 'Diego', 'Torres', 10, 4),
(8, 'Martina', 'Gómez', 11, 5),
(9, 'Joaquín', 'Hernández', 10, 4),
(10, 'Valeria', 'Díaz', 11, 5);
TABLE escuelas_primaria;

-- COMPLEMENTARIOS
--01
DROP TEMPORARY TABLE IF EXISTS clientes_temporal;
-- Crea la tabla temporal de clientes
CREATE TEMPORARY TABLE clientes_temporal (
  id INT,
  nombre VARCHAR(50),
  direccion VARCHAR(100)
);
INSERT INTO clientes_temporal (id, nombre, direccion) VALUES
(1, 'Ana Rodríguez', 'San Martín 2515, Mar del Plata');
TABLE clientes_temporal;

SELECT nombre FROM empleados_temporal
INTERSECT
SELECT nombre FROM clientes_temporal;
-- 02
SELECT nombre FROM clientes_temporal
EXCEPT
SELECT nombre FROM empleados_temporal;
-- Alternativa EXCEPT no funciona
SELECT c.nombre
FROM clientes_temporal c
LEFT JOIN empleados_temporal e ON c.nombre = e.nombre
WHERE e.nombre IS NULL;

-- 03
DROP TEMPORARY TABLE IF EXISTS escuela_secundaria;
CREATE TEMPORARY TABLE escuela_secundaria (
    id INT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad INT,
    grado INT
);

INSERT INTO escuela_secundaria (id, nombre, apellido, edad, grado) VALUES
(1, 'Eduardo', 'Sánchez', 16, 10),
(2, 'Camila', 'Martín', 17, 11),
(3, 'Manuel', 'Gutiérrez', 15, 9),
(4, 'Laura', 'García', 16, 10),
(11, 'Pablo', 'Ortega', 17, 11),
(12, 'Carmen', 'Ramírez', 15, 9),
(13, 'Carlos', 'Molina', 16, 10),
(14, 'Ana', 'Ruiz', 17, 11),
(15, 'Luis', 'Fernández', 15, 9),
(16, 'María', 'López', 16, 10);
TABLE escuela_secundaria;

-- 04
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM escuelas_primaria
INTERSECT
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM escuela_secundaria;

-- 05
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM escuelas_primaria
EXCEPT
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM escuela_secundaria;

-- 06
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM escuela_secundaria
EXCEPT
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM escuelas_primaria;

-- 07
SELECT grado FROM escuelas_primaria
UNION
SELECT grado FROM escuela_secundaria
ORDER BY grado DESC;