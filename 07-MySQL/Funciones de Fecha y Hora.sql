-- Iniciando con la práctica de funciones de fecha y hora

-- 01
DROP TABLE IF EXISTS envios;
CREATE TABLE envios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_envio DATETIME,
    fecha_entrega DATETIME,
    codigo_producto VARCHAR(10)
);
INSERT INTO envios (fecha_envio, fecha_entrega, codigo_producto) VALUES
('2022-01-15 08:00:00', '2022-01-20 12:30:00', 'ABC123'),
('2022-02-10 10:15:00', '2022-02-15 14:45:00', 'XYZ789'),
('2022-03-05 09:30:00', '2022-03-10 13:20:00', 'PQR456'),
('2022-04-20 11:45:00', '2022-04-25 15:10:00', 'LMN001'),
('2022-05-12 07:55:00', '2022-05-17 10:25:00', 'DEF777'),
('2022-06-08 08:20:00', '2022-06-13 12:40:00', 'GHI888'),
('2022-07-03 10:05:00', '2022-07-08 14:15:00', 'JKL999');

-- 02
SELECT DATE_ADD(fecha_envio, INTERVAL 5 DAY) AS fecha_de_entrega_programada FROM envios
WHERE codigo_producto = 'ABC123';

-- 03 - Esta función suma un intervalo de tiempo (4 horas y 30 minutos) a la fecha_entrega.
SELECT ADDTIME(fecha_entrega, '04:30:00') AS hora_entrega_estimada FROM envios
WHERE codigo_producto = 'XYZ789';

-- 04
SELECT CONVERT_TZ(fecha_envio, '+00:00', '-03:00') AS fecha_envio_argentina FROM envios
WHERE codigo_producto = 'PQR456';

-- 05
SELECT DATEDIFF(fecha_entrega, fecha_envio) AS dias_diferencia FROM envios
WHERE codigo_producto = 'LMN001';

-- 06
SELECT codigo_producto, fecha_entrega, CURDATE() AS fecha_actual,
DATEDIFF(CURDATE(), fecha_entrega) AS dias_diferencias FROM envios
WHERE codigo_producto = 'DEF777';

-- 07 - obtén la hora actual
SELECT CURTIME() AS hora_actual;

-- 08
SELECT id, DATE(fecha_envio) AS fecha_envio_solo FROM envios
WHERE id = 3;

-- 09
SELECT DATE_ADD(fecha_envio, INTERVAL 3 DAY) AS fecha_entrega_programada FROM envios
WHERE codigo_producto = 'XYZ789';

-- 10
SELECT id, DATE_FORMAT(fecha_envio, '%d-%m-%Y') AS fecha_envio_formateada FROM envios
WHERE id = 6;

-- 11
SELECT DATE_SUB(fecha_envio, INTERVAL 2 DAY) AS fecha_envio_reducida FROM envios
WHERE id = 4;

-- 12
SELECT DATEDIFF(fecha_entrega, fecha_envio) AS diferencia_dias FROM envios
WHERE codigo_producto = 'PQR456';

-- 13
SELECT DAY(fecha_envio) AS dia_del_mes FROM envios
WHERE id = 2;

-- 14
SELECT DAYNAME(fecha_entrega) AS nombre_dia FROM envios
WHERE codigo_producto = 'DEF777';

-- 15 - dia correspondiente a la fecha de entrega
SELECT DAYOFMONTH(fecha_entrega) AS dia_del_mes_entrega FROM envios
WHERE codigo_producto = 'GHI888';

-- 16
SELECT PERIOD_ADD('202207', 3) AS nuevo_periodo;

-- 17
SELECT PERIOD_DIFF(202212, 202203) AS meses_diferencias;

-- 18
SELECT QUARTER(fecha_entrega) AS trimestre FROM envios
WHERE codigo_producto = 'PQR456';

-- 19 -  Convierte 3665 segundos a formato de tiempo, devolviendo el resultado en hh:mm:ss.
SELECT SEC_TO_TIME(3665) AS tiempo_formateado;

-- 20
SELECT SECOND(fecha_envio) AS segundos FROM envios
WHERE id = 2;

-- 21 - Convierte la cadena a una fecha utilizando el formato especificado.
SELECT STR_TO_DATE('2022()08()15', '%Y()%m()%d') AS fecha_convertida;

-- 22
SELECT DATE_SUB(fecha_entrega, INTERVAL 5 DAY) AS nueva_fecha_entrega
FROM envios
WHERE codigo_producto = 'GHI888';

-- 23
SELECT SUBTIME(fecha_envio, '2:15:00') AS nueva_hora_envio
FROM envios
WHERE id = 7;

-- 24
SELECT TIME(fecha_envio) AS porcion_tiempo
FROM envios
WHERE id = 1;

-- 25
SELECT TIME_FORMAT(fecha_envio, '%H:%i:%s') AS hora_formateada
FROM envios
WHERE id = 2;

-- 26 convierte las horas en segundos
SELECT TIME_TO_SEC(TIME(fecha_envio)) AS segundos
FROM envios
WHERE id = 3;

-- 27 diferencia de horas
SELECT TIMEDIFF(fecha_entrega, fecha_envio) AS diferencia_horas
FROM envios
WHERE id = 4;

-- 28 - intervalo de 5s, un inicio y final de la hora actual.
SELECT 
    SYSDATE() AS hora_inicio,
    SLEEP(5) AS dormir,
    SYSDATE() AS hora_fin,
    TIMEDIFF(SYSDATE(), NOW()) AS diferencia_tiempo;

-- 29
SELECT TIMESTAMP(fecha_envio + INTERVAL 12 HOUR) AS fecha_envio_con_horas
FROM envios;

-- 30
SELECT TIMESTAMPADD(HOUR, 3, fecha_entrega) AS fecha_entrega_con_horas
FROM envios
WHERE codigo_producto = 'XYZ789';