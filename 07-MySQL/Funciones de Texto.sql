-- Introducción Funciones de Texto

-- 01

CREATE TABLE estudiantes (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    edad INT,
    promedio FLOAT
);
INSERT INTO estudiantes (id, nombre, apellido, edad, promedio) VALUES
(1, 'Juan', 'Pérez', 22, 85.5),
(2, 'María', 'Gómez', 21, 90.0),
(3, 'Luis', 'Rodríguez', 20, 88.5),
(4, 'Ana', 'Martínez', 23, 92.0),
(5, 'Carlos', 'López', 22, 86.5);

-- 02
-- En MySQL, LENGTH cuenta la cantidad de bytes que usa un caracter y CHAR_LENGTH mide cuántos caracteres hay, no cuántos bytes se usan.
SELECT CHAR_LENGTH(nombre) AS longitud_nombre
FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

-- 03
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- 04
SELECT LOCATE('e', apellido) AS posicion_e FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

-- 05
SELECT INSERT(nombre, 3, 0, ' García') FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- 06 - comvierte todos los caracteres en la cadena en minúsculas
SELECT LOWER(nombre) AS nombre_en_minusculas FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

-- 07 - comvierte todos los caracteres en la cadena en mayúsculas
SELECT UPPER(apellido) AS apellido_en_mayusculas FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

-- 08 La función LEFT() devuelve la cantidad especificada de caracteres del lado izquierdo
SELECT LEFT(apellido, 4) AS primeros_4_caracteres FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- 09 La función RIGHT() devuelve la cantidad especificada de caracteres del lado derecho
SELECT RIGHT(apellido, 3) AS ultimos_3_caracteres FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- 10 - La función LOCATE() Devuelve la posición de la primera aparición de una subcadena, tambien permite ser mas especifica.
SELECT LOCATE('o', nombre) AS posicion_de_o FROM estudiantes
WHERE nombre = 'Carlos' AND apellido = 'López';

-- 11
SELECT LOCATE('a', nombre) AS posicion_de_a FROM estudiantes 
WHERE nombre = 'María' AND apellido = 'Gómez';

-- 12 La función REPLACE() busca todas las ocurrencias de 'a' en la cadena nombre y las reemplaza por 'X
SELECT REPLACE(nombre, 'a', 'x') AS nombre_modificado FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- 13
SELECT SUBSTRING(nombre, 2, 3) AS subcadena FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- 14 - GROUP_CONCAT(nombre SEPARATOR '-'): La función GROUP_CONCAT() concatena los valores de la columna nombre y los separa por el carácter especificado, en este caso, un guion (-).
SELECT GROUP_CONCAT(nombre SEPARATOR '-') AS nombres_combinados FROM estudiantes;

-- 15
SELECT GROUP_CONCAT(CONCAT(nombre, ' ', apellido) SEPARATOR '|') AS nombres_apellidos_combinados FROM estudiantes;

-- 16
SELECT LTRIM('          .. SE SUPONE DEBE ELIMINAR LOS ESPACIOS AL PRINCIPIO      ') AS Texto_limpio;

-- 17
SELECT RTRIM('    … usé muchos espacios      ') AS texto_limpio_final;

-- 18
SELECT QUOTE(LTRIM("       ... usé muchos espacios       ")), QUOTE(RTRIM("      ... usé
muchos espacios       "));

-- 19
SELECT REPEAT(CONCAT(nombre, ' ', apellido, ' '), 3) AS repetido FROM estudiantes
WHERE nombre = 'Juan' AND apellido = 'Pérez';

-- 20 Invierte la cadena resultante
SELECT REVERSE(CONCAT(nombre)) AS invertido FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- 21
SELECT QUOTE(SPACE(8));

-- 22 - Extrae la parte de la cadena que se encuentra antes de la segunda aparición de la letra 'a' en el nombre "María".
SELECT SUBSTRING_INDEX(nombre, 'a', 2) AS subcadena
FROM estudiantes
WHERE nombre = 'María' AND apellido = 'Gómez';

-- 23
SELECT GROUP_CONCAT(edad ORDER BY edad DESC SEPARATOR ', ') AS edades_combinadas FROM estudiantes;

-- 24 - elimina solo las letras especificadas
SELECT REPLACE(nombre, 'a', '') AS nombre_sin_a FROM estudiantes
WHERE nombre = 'Ana' AND apellido = 'Martínez';

-- 25 - Rellena el valor de promedio a la derecha con asteriscos hasta que la longitud total sea de 10 caracteres.
SELECT RPAD(promedio, 10, '*') AS promedio_relleno FROM estudiantes
WHERE nombre = 'Luis' AND apellido = 'Rodríguez';

-- 26 - Esta función formatea el promedio a dos decimales utilizando la configuración regional especificada (en este caso, 'es_AR' para Argentina).
SELECT FORMAT(promedio, 2, 'es_AR') AS promedio_formatiado FROM estudiantes
WHERE nombre = 'Carlos' AND apellido = 'López';