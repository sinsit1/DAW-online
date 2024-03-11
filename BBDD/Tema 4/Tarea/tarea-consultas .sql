-- 1- Obtener las localidades y n�mero de empleados de aquellas en las que viven m�s de 2 empleados

SELECT localidad, count(*) as num_empleados
FROM empleado
GROUP BY localidad
having count(*) > 2;

-- 2- Obtener para cada departamento cu�ntos empleados trabajan, la suma de sus salarios y comisiones para los departamentos en los que hay alg�n empleado cuyo sueldo es inferior a 2100 euros.
SELECT 
    d.coddpto,
    d.denominacion AS departamento,
    COUNT(e.codemple) AS num_empleados,
     SUM(e.salario + NVL(e.comision, 0)) AS total_salario_mas_comisiones
FROM dpto d
JOIN  empleado e ON d.coddpto = e.coddpto
WHERE e.salario < 2100
GROUP BY d.coddpto, d.denominacion;

-- 3- Obtener el departamento que menos empleados tiene.

SELECT tabla1.denominacion, tabla1.n_empleados
FROM (
    SELECT d.denominacion, count(*) as n_empleados
    FROM empleado e, dpto d
    WHERE d.coddpto = e.coddpto
    GROUP BY d.denominacion
) tabla1
WHERE tabla1.n_empleados = (
    SELECT min(tabla2.n_empleados) 
    FROM (
        SELECT d.denominacion, count(*) as n_empleados
        FROM empleado e, dpto d
        WHERE d.coddpto = e.coddpto
        GROUP BY d.denominacion) tabla2
    );

-- 4- Obtener un listado en el que aparezcan todos los departamentos existentes y el departamento del cual depende, si depende de alguno.

SELECT dep2.denominacion as dpto, nvl(dep1.denominacion, dep2.denominacion) as depende
FROM dpto dep1 right join dpto dep2 on dep1.coddpto = dep2.coddptodepende;

-- 5- Obtener los nombres de los empleados que viven en ciudades en las que hay alg�n centro de trabajo

SELECT nombre
FROM empleado
WHERE UPPER(localidad) = any(SELECT upper(localidad) FROM centro);

-- 6- Obtener en orden alfab�tico los salarios y nombres de los empleados cuyo salario sea inferior al 50% del m�ximo salario de la empresa.
SELECT nombre, salario
FROM empleado
WHERE salario < (SELECT MAX(salario)*0.5 FROM empleado)
order by nombre;

-- 7- Obtener el n�mero de ciudades distintas en las que viven los empleados.
SELECT COUNT(DISTINCT localidad) as localidades
FROM empleado;

-- 8- El nombre y direcci�n de empleado que menor salario cobra.
SELECT nombre, direccion
FROM empleado
WHERE salario = (SELECT MIN(salario) from empleado)

-- 9- Obtener el nombre de los empleados y comisi�n cuya comisi�n es superior al 15% de su salario.
SELECT nombre, comision
FROM empleado
WHERE comision >= salario * 0.15;

-- 10- Obtener el c�digo de empleado, c�digo de departamento, nombre y sueldo total en pesetas de aquellos empleados cuyo sueldo total (salario m�s comisi�n) supera los 1500 euros. Sacarlos ordenados por c�digo de departamento y nombre.
SELECT codemple as cod_empleado, coddpto as cod_departamento, nombre, salario * 166.386 AS SALARIO_PESETAS
FROM EMPLEADO
WHERE (SALARIO + COMISION) > 1500
ORDER BY coddpto, nombre;

-- 11- Obtener por orden alfab�tico los nombres de empleados cuyo salario sea menor en m�s de un 5% al salario de la empleada �BLANCA FLO�.
-- OJO no existe el empleado BLANCA FLO, ser�a BLANCA FLOR. Por eso salen 0 registros
SELECT nombre
FROM empleado
WHERE (salario * 1.05) < (
    SELECT salario
    FROM empleado 
    WHERE UPPER(nombre)='BLANCA' 
    AND UPPER(ape1)='FLO'
)
ORDER BY nombre;

-- 12-Obtener un listado con los nombres y apellidos de los empleados, as� como los a�os de que llevan en la empresa ordenados por ordenado por a�os en la empresa de forma descendente.

SELECT nombre, ape1 || ' ' || ape2 as apellidos, floor(months_between(SYSDATE, fechaingreso) /12) as antiguedad
FROM empleado
ORDER BY antiguedad DESC;

-- 13-Obtener los empleados que trabajan en un departamento con presupuesto inferior a 90.000 euros. (Hacer con subconsulta)

SELECT *
FROM empleado
WHERE coddpto = ANY(SELECT coddpto FROM DPTO WHERE presupuesto > 90000);

-- 14 - Obtener los 5 empleados (nombres y apellidos) que menos cobran en la empresa. Considerar el salario m�s la comisi�n.
SELECT nombre, ape1 || ' ' || ape2 as apellidos
FROM empleado
ORDER BY  salario + NVL(comision, 0)
FETCH FIRST 5 ROWS ONLY;


-- 15- Obtener los empleados que trabajan en el departamento del cu�l es jefe el empleado con c�digo 3.
--!!OJO, esta consulta devuelve 0 resultados porque el departamento 2 (jefe =3) solo tiene 1 empleado, que es a su vez jefe del dpto. 
SELECT nombre
FROM empleado
WHERE coddpto =(SELECT coddpto FROM dpto WHERE CODEMPLEJEFE = 3)
and codemple != 3;

-- 16-Obtener los empleados cuyo nombre de pila contenga AN en alguna parte del nombre.
SELECT *
FROM empleado
WHERE upper(nombre) LIKE '%AN%';

-- 17-Obtener un listado ordenado alfab�ticamente donde aparezcan los nombres de los empleados y a continuaci�n el literal "CON comision" si la tiene, y "no SIN comision" si no la tiene.
SELECT CASE WHEN 
    comision is null
        then nombre || ' CON comision' 
        else nombre || ' no SIN comision' end as info_emp
FROM empleado
order by nombre

-- 18-Obtener un listado de las localidades en las que hay centros y adem�s vive al menos un empleado ordenado alfab�ticamente.
SELECT c.localidad
FROM centro c, empleado e 
WHERE upper(c.localidad) = upper(e.localidad)
GROUP BY c.localidad
having count(*) >= 1
Order by c.localidad;

-- 19-Obtener un listado de los empleados en funci�n de su la antig�edad en la empresa. Sacar los que lleven entre 1 y 5 a�os y los que lleven entre 11 y 20 a�os. (con uni�n)
SELECT nombre,ape1 || ' ' || ape2 as apellidos, floor(MONTHS_BETWEEN(SYSDATE, fechaingreso) / 12) AS antiguedad
FROM  empleado
WHERE 
   floor(MONTHS_BETWEEN(SYSDATE, fechaingreso) / 12) >=1 AND floor(MONTHS_BETWEEN(SYSDATE, fechaingreso) / 12) <=5
UNION
SELECT nombre,ape1 || ' ' || ape2 as apellidos, floor(MONTHS_BETWEEN(SYSDATE, fechaingreso) / 12) AS antiguedad
FROM empleado
WHERE 
   floor(MONTHS_BETWEEN(SYSDATE, fechaingreso) / 12) >=11 AND floor(MONTHS_BETWEEN(SYSDATE, fechaingreso) / 12) <=20


-- 20-Obtener a los nombres, apellidos de los empleados que no son jefes de departamento.
SELECT nombre, ape1 || ' ' || ape2 as apellidos
FROM empleado
WHERE codemple not in (SELECT codemplejefe from dpto);



