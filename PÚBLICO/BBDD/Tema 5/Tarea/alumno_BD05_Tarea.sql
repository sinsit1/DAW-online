
-- 1. Inserta un registro nuevo en la tabla PROFESORADO utilizando la herramienta gráfica SQLDeveloper Los datos deben ser los siguientes:
INSERT INTO PROFESORADO VALUES(1, 'NURIA', 'MARTINEZ GONZALEZ', '58328066X', 'MATEMATICAS', '22/02/1962', 19);

-- 2. . Inserta varios registros más en la tabla PROFESORADO utilizando sentencias SQL. En la entrega de la tarea debes copiar las sentencias que has utilizado. Los datos deben ser los siguientes:

INSERT INTO PROFESORADO VALUES (2, 'MARIA LUISA', 'FABRE BERDUN', '51083099F', 'TECNOLOGIA', '31/03/1978', 8);

INSERT INTO PROFESORADO (Codigo, Nombre, Apellidos, Especialidad, Fecha_Nac, Antiguedad) VALUES (3, 'JAVIER', 'PEREZ HERNANDO', 'LENGUA', '04/05/1965', 10);

INSERT INTO PROFESORADO VALUES (4, 'ESTEFANIA', 'FERNANDEZ LOPEZ', '19964324W', 'INGLES', '22/06/1971', 3);

INSERT INTO PROFESORADO (Codigo, Nombre, Apellidos) VALUES (5, 'JOSE M.', 'DIAZ PAYAN');

-- 3.Modifica los registros de la tabla CURSOS para asignar a cada curso un profesor o profesora. Utiliza para ello la herramienta gráfica, entregando con la tarea una captura de pantalla de la pestaña Datos de esa tabla, donde se aprecien todos los cambios que has realizado. El profesorado que debes asignar a cada curso es:

-- adjunto capturas en el pdf

-- 4.  Modifica el registro del profesor cuyo Codigo es 4  usando sentencias SQL, y cambia su especialidad a LENGUA y su DNI a 9876522C. En la entrega de la tarea debes copiar la sentencia que has utilizado. 

UPDATE PROFESORADO SET Especialidad = 'LENGUA', DNI = '9876522C' WHERE Codigo = 4;

-- 5. Modifica las antigüedades de todos los profesores y profesoras aumentándolas en 3 en todos los registros en los que la antigüedad sea superior a 5. Debes hacerlo usando un sola sentencia SQL que debes copiar para la entrega de la tarea.

UPDATE PROFESORADO SET antiguedad = CASE WHEN antiguedad > 5 THEN antiguedad + 3 ELSE antiguedad END;

-- 6.  Elimina, de la tabla CURSOS, el registro del curso que tiene el código 6. Debes realizar esta acción desde la herramienta gráfica. Debes entregar una captura de pantalla de la ventana en la que vas a borrar el registro, justo antes de pulsar el botón Aceptar para confirmar el borrado.

--adjunto captura en el pdf

--7. Elimina, de la tabla ALUMNADO, aquellos registros asociados al curso con código 2 cuyo sexo sea H. Debes hacerlo usando un sola sentencia SQL que debes copiar para la entrega de la tarea.

DELETE FROM ALUMNADO WHERE cod_curso = 2 AND sexo = 'H';

-- 8. Inserta los registros de la tabla ALUMNADO_NUEVO en la tabla ALUMNADO asociándole el código de curso 2, es decir, cod_curso con el valor 2. Debes hacerlo usando un sola sentencia SQL que debes copiar para la entrega de la tarea.

INSERT INTO alumnado SELECT nombre, Apellidos, Sexo, Fecha_Nac, 2 AS cod_curso FROM alumnado_nuevo;


-- 9. En la tabla CURSOS, actualiza el campo Max_Alumn del registro del curso con código 1, asignándole el valor correspondiente al número total de alumnos y alumnas que hay en la tabla ALUMNADO y que tienen asignado ese mismo curso.

UPDATE CURSOS SET max_alumn = (SELECT COUNT(*) FROM ALUMNADO WHERE cod_curso = 1) where codigo = 1;

-- 10. Elimina de la tabla ALUMNADO todos los registros asociados a los cursos que imparte el profesor cuyo código es 5.
--!OJO! no hay ningun curso impartido por un profe con codigo 5, no va a modificar ningun regitro
DELETE FROM ALUMNADO WHERE cod_curso IN (SELECT codigo FROM cursos WHERE cod_profe = 5);

