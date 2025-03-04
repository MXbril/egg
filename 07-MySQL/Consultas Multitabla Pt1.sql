-- consultas multitabla
SELECT nombre, apellido, edad, salario,
       (SELECT nombre FROM departamentos d WHERE d.id = e.departamento_id) AS departamento
FROM empleados e;

SELECT v.id, v.producto_id, v.cliente_id, v.cantidad, v.precio_unitario, v.monto_total,
CONCAT(e.nombre, " ", e.apellido) "Nombre empleado"
FROM ventas v, empleados e
WHERE v.empleado_id = e.id;

SELECT v.id, v.cliente_id, v.cantidad, v.precio_unitario, v.empleado_id, 
       (SELECT nombre FROM productos p WHERE p.id = v.producto_id) AS Nombre_producto
FROM ventas v;

SELECT v.id, v.producto_id, v.cantidad, v.precio_unitario, v.empleado_id,
    (SELECT nombre FROM clientes c WHERE c.id = v.cliente_id) AS nombre_cliente
FROM ventas v;

SELECT v.id, v.producto_id, v.cantidad, v.precio_unitario, v.monto_total,
CONCAT(e.nombre, ' ', e.apellido) "Nombre_empleado", d.nombre "Nombre_departamento"
FROM ventas v, empleados e, departamentos d
WHERE v.empleado_id = e.id AND e.departamento_id = d.id;

SELECT v.id, p.nombre "Nombre producto", c.nombre "Nombre cliente",
v.cantidad, v.precio_unitario, v.monto_total, CONCAT(e.nombre, " ",
e.apellido) "Nombre empleado"
FROM ventas v, productos p, clientes c, empleados e
WHERE v.empleado_id = e.id AND v.producto_id = p.id AND v.cliente_id =
c.id;

SELECT d.nombre AS Departamento,
       (SELECT MAX(e.salario)
        FROM empleados e
        WHERE e.departamento_id = d.id) AS Salario_Maximo
FROM departamentos d;