-- Ejercicios Vistas y funciones
-- 01
CREATE TABLE triangulos_rectangulos (
    longitud_lado_adyacente INT,
    longitud_lado_opuesto INT
);

-- 02 - puede que el metodo ROW no sea aceptado por otros sistemas de mysql
INSERT INTO triangulos_rectangulos (longitud_lado_adyacente,
longitud_lado_opuesto)
SELECT FLOOR(RAND() * 100) + 1, FLOOR(RAND() * 100) + 1
FROM (VALUES
ROW(1),ROW(2),ROW(3),ROW(4),ROW(5),ROW(6),ROW(7),ROW(8),ROW(9),ROW(10)) AS
numbers;

-- 03
CREATE VIEW vista_triangulos AS
SELECT *,
    SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)) AS hipotenusa
FROM triangulos_rectangulos;

-- 04
CREATE OR REPLACE VIEW vista_triangulos AS
SELECT *,
    ATAN2(b, a) AS angulo_alfa_radianes,
    DEGREES(ATAN2(a, b)) AS angulo_alfa_grados
FROM (
    SELECT longitud_lado_opuesto b, longitud_lado_adyacente a,
        SQRT(POW(longitud_lado_opuesto, 2) + POW(longitud_lado_adyacente, 2)) h
    FROM triangulos_rectangulos
) tr;
TABLE vista_triangulos;

-- 05
CREATE OR REPLACE VIEW vista_triangulos AS
SELECT *,
       ATAN(longitud_lado_adyacente / SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2))) AS angulo_beta_radianes,
       DEGREES(ATAN(longitud_lado_adyacente / SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)))) AS angulo_beta_grados,
       SQRT(POW(longitud_lado_adyacente, 2) + POW(longitud_lado_opuesto, 2)) AS hipotenusa
FROM triangulos_rectangulos;

-- 06
CREATE OR REPLACE VIEW vista_triangulos AS
SELECT *,
       90 AS angulo_gamma_grados,
       DEGREES(ATAN2(longitud_lado_opuesto, longitud_lado_adyacente)) AS angulo_alfa_grados,
       DEGREES(ATAN2(longitud_lado_adyacente, longitud_lado_opuesto)) AS angulo_beta_grados
FROM triangulos_rectangulos;

-- 07
CREATE TABLE triangulos_rectangulos_2 (
    angulo_alfa INT,
    hipotenusa INT
);
TABLE triangulos_rectangulos_2;

-- 08
INSERT INTO triangulos_rectangulos_2 (angulo_alfa, hipotenusa)
SELECT 
    FLOOR(RAND() * 89) + 1 AS angulo_alfa, 
    FLOOR(RAND() * 100) + 1 AS hipotenusa
FROM 
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL 
     SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL 
     SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL 
     SELECT 10) AS numbers;

-- 09 - esto crea la vista del lado_adyacente
CREATE VIEW vista_triangulos_2 AS
SELECT hipotenusa,
       angulo_alfa,
       ROUND(COS(RADIANS(angulo_alfa)) * hipotenusa) AS lado_adyacente
FROM triangulos_rectangulos_2;
TABLE vista_triangulos_2;

-- 10 con esta tabla creo el lado opuesto y el lado adyacente.
CREATE OR REPLACE VIEW vista_triangulos_2 AS
SELECT hipotenusa,
       angulo_alfa,
       ROUND(COS(RADIANS(angulo_alfa)) * hipotenusa) AS lado_adyacente,
       SIN(RADIANS(angulo_alfa)) * hipotenusa AS lado_opuesto
FROM triangulos_rectangulos_2;
SELECT * FROM vista_triangulos_2;

-- con esto reinicie la vista para eliminar las columnas lado_adyacente y lado_opuesto.
CREATE OR REPLACE VIEW vista_triangulos_2 AS
SELECT hipotenusa,
       angulo_alfa
FROM triangulos_rectangulos_2;

-- 11
CREATE OR REPLACE VIEW vista_triangulos_2 AS
SELECT *,
       ROUND(COS(RADIANS(angulo_alfa)) * hipotenusa) AS lado_adyacente,
       ROUND(SIN(RADIANS(angulo_alfa)) * hipotenusa) AS lado_opuesto,
       DEGREES(ACOS(ROUND(COS(RADIANS(angulo_alfa)) * hipotenusa) / hipotenusa)) AS angulo_beta
FROM triangulos_rectangulos_2;

-- 12
CREATE OR REPLACE VIEW vista_triangulos_2 AS
SELECT *,
    180 - angulo_alfa - angulo_beta AS angulo_gamma
FROM (SELECT *,
    DEGREES(ACOS(lado_adyacente / hipotenusa)) AS angulo_beta
FROM (SELECT *,
    COS(RADIANS(angulo_alfa)) * hipotenusa AS lado_opuesto,
    SIN(RADIANS(angulo_alfa)) * hipotenusa AS lado_adyacente
FROM triangulos_rectangulos_2) tr) tr2;

-- 13 -- redondea los decimales
CREATE OR REPLACE VIEW vista_triangulos_2 AS
SELECT *,
       ROUND(180 - angulo_alfa - angulo_beta, 2) AS angulo_gamma
FROM (
    SELECT *,
           ROUND(DEGREES(ACOS(ROUND(lado_adyacente, 2) / ROUND(hipotenusa, 2))), 2) AS angulo_beta
    FROM (
        SELECT *,
               ROUND(COS(RADIANS(angulo_alfa)) * hipotenusa, 2) AS lado_opuesto,
               ROUND(SIN(RADIANS(angulo_alfa)) * hipotenusa, 2) AS lado_adyacente
        FROM triangulos_rectangulos_2
    ) AS tr
) AS tr2;