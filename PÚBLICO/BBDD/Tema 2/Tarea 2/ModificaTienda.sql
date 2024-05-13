--EJERCICIO 2:

--A)  Modificar las tablas creadas en el ejercicio anterior siguiendo las indicaciones. Los ejercicios se incluirán en un script llamado ModificaTienda.sql. Cada uno de ellos, como en el ejercicio anterior, irá precedido de un comentario con el enunciado.

--Añadir a la tabla STOCK

    --Una columna de tipo fecha llamada FechaUltimaEntrada que por defecto tome el valor de la fecha actual
    ALTER TABLE STOCK ADD FechaUltimaEntrada DATE DEFAULT SYSDATE;
    
    --Una columna llamada Beneficio que contendrá el tipo de porcentaje de beneficio que esa tienda aplica en ese producto. Se debe controlar que el valor que almacene sea 1,2, 3, 4, 5 o 6.
    ALTER TABLE STOCK ADD Beneficio NUMBER(1,0);
    ALTER TABLE STOCK ADD CONSTRAINT CHK_BENEFICIO CHECK(Beneficio BETWEEN 0 AND 6);

--En la tabla PRODUCTO

    -- Eliminar de la tabla producto la columna Descripción.
    ALTER TABLE PRODUCTO DROP COLUMN Descripcion;
    
    --Añadir una columna llamada perecedero que únicamente acepte los valores: Si o No.
    ALTER TABLE PRODUCTO ADD perecedero VARCHAR2(2);
    ALTER TABLE PRODUCTO ADD CONSTRAINT CHK_PERECEDERO CHECK(perecedero IN('Si', 'No'));
    
    --Modificar el tamaño de la columna Deno_producto a 50.
    ALTER TABLE PRODUCTO MODIFY Deno_producto VARCHAR2(50);
    
--En la tabla FAMILIA
    
    --Añadir una columna llamada IVA, que represente el porcentaje de IVA 
    ALTER TABLE FAMILIA ADD IVA NUMBER(2, 0);
    --y únicamente pueda contener los valores 21,10,ó 4.
    ALTER TABLE FAMILIA ADD CONSTRAINT CHK_IVA CHECK( IVA IN (21,10,4));

-- En la tabla TIENDA

    --La empresa desea restringir el número de tiendas con las que trabaja, de forma que no pueda haber más de una tienda en una misma zona (la zona se identifica por el código postal). Definir mediante DDL las restricciones necesarias para que se cumpla en el campo correspondiente..
     ALTER TABLE TIENDA ADD CONSTRAINT UNIQUE_COD_POSTAL  UNIQUE (Codigo_Postal);
    
-- B) Renombra la tabla STOCK por PRODXTIENDAS.
    RENAME STOCK TO PRODXTIENDAS;

--C) Elimina la tabla FAMILIA y su contenido si lo tuviera.
    ALTER TABLE PRODUCTO DROP CONSTRAINT FK_FAMILIA;
    DROP TABLE FAMILIA;
    
-- D) Crea un usuario llamado C##INVITADO siguiendo los pasos de la unidad 1
    CREATE USER C##INVITADO IDENTIFIED BY invitado;
    -- y dale todos los privilegios sobre la tabla PRODUCTO.
    GRANT ALL ON PRODUCTO TO C##INVITADO;

-- E) Retira los permisos de modificar la estructura de la tabla y borrar contenido de la tabla PRODUCTO al usuario anterior.
    REVOKE ALTER, DELETE ON PRODUCTO FROM C##INVITADO;


 

