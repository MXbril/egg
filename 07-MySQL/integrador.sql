SHOW DATABASES;
USE nba;
SHOW TABLES;

SELECT * FROM equipos;

-- 01
SELECT Nombre, Peso FROM jugadores
WHERE Posicion = 'C' AND Peso > 200 ORDER BY Peso ASC
LIMIT 10;

-- 02
SELECT Nombre FROM equipos
WHERE Conferencia = 'East';

-- 03
SELECT Nombre, Ciudad FROM equipos
WHERE Ciudad LIKE 'C%' ORDER BY Nombre;

-- 04
SELECT e.Puntos_por_partido
FROM estadisticas e
JOIN jugadores j ON e.jugador = j.codigo  -- Relaciona la columna 'jugador' en 'estadisticas' con 'id' en 'jugadores'
WHERE j.Nombre = 'Pau Gasol'
  AND e.temporada = '04/05';

-- 05
SELECT j.Nombre,
    ROUND(SUM(e.Puntos_por_partido), 2) AS puntos_totales 
FROM estadisticas e
JOIN jugadores j ON e.jugador = j.codigo GROUP BY j.Nombre
ORDER BY puntos_totales DESC
LIMIT 10;

-- 06
SELECT e.Nombre AS equipo, e.Conferencia, e.Division
FROM jugadores j
JOIN equipos e ON j.Nombre_equipo = e.Nombre
WHERE j.Altura = (
    SELECT MAX(Altura)
    FROM jugadores
)
LIMIT 1;

SELECT codigo, Nombre, Altura 
FROM jugadores 
ORDER BY Altura DESC 
LIMIT 1;

-- 07
SELECT p.equipo_local, p.equipo_visitante,
ABS(p.puntos_local - p.puntos_visitante) AS diferencia
FROM partidos p ORDER BY diferencia DESC
LIMIT 10;

-- 08
SELECT 
    equipo, 
    SUM(puntos_local) AS total_puntos_local, 
    SUM(puntos_visitante) AS total_puntos_visitante,
    ABS(SUM(puntos_local) - SUM(puntos_visitante)) AS diferencia_total
FROM (
    SELECT 
        p.equipo_local AS equipo, 
        p.puntos_local, 
        0 AS puntos_visitante
    FROM partidos p
    WHERE p.temporada = '00/01'
    UNION ALL
    SELECT 
        p.equipo_visitante AS equipo, 
        0 AS puntos_local, 
        p.puntos_visitante
    FROM partidos p
    WHERE p.temporada = '00/01'
) AS resultados
GROUP BY equipo ORDER BY diferencia_total DESC
LIMIT 1;

-- 09
SELECT 
    e.Nombre AS equipo, 
    CONCAT(ROUND((SUM(CASE WHEN p.puntos_local > p.puntos_visitante THEN 1 ELSE 0 END) + 
           SUM(CASE WHEN p.puntos_visitante > p.puntos_local THEN 1 ELSE 0 END)) * 100.0 / COUNT(p.codigo), 2), '%') AS porcentaje_victorias
FROM partidos p
JOIN equipos e ON p.equipo_local = e.Nombre OR p.equipo_visitante = e.Nombre
WHERE p.temporada = '98/99'
GROUP BY e.Nombre
ORDER BY porcentaje_victorias DESC
LIMIT 10;

-- 10
SELECT ROUND(AVG(e.Puntos_por_partido), 2) AS promedio_puntos,
    COUNT(*) AS cantidad_jugadores
FROM jugadores j
JOIN estadisticas e ON j.codigo = e.jugador
WHERE j.Posicion = 'C' 
    AND (CAST(SUBSTRING_INDEX(j.Altura, '-', 1) AS UNSIGNED) > 7 OR 
         (CAST(SUBSTRING_INDEX(j.Altura, '-', 1) AS UNSIGNED) = 7 AND 
          CAST(SUBSTRING_INDEX(j.Altura, '-', -1) AS UNSIGNED) > 0));