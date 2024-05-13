--TABLA FAMILIA=> Contiene las familias a las que pertenecen los productos, como por ejemplo ordenadores, impresoras,etc.


CREATE TABLE familia (
cod_familia NUMBER(4, 0) primary key,
deno_familia VARCHAR2(100)
)

--TABLA PRODUCTO => contendrá información general sobre los productos que distribuye la empresa a las tiendas.

CREATE TABLE PRODUCTO (
COD_PRODUCTO NUMBER(5,0) PRIMARY KEY,
DENO_PRODUCTO VARCHAR2(100) NOT NULL,
DESCRIPCION VARCHAR2(200),
PRECIO_BASE NUMBER(8,2) NOT NULL,
PORC_REPOSICION NUMBER(3,0),
UNIDADES_MINIMAS NUMBER(4,0) NOT NULL,
COD_FAMILIA NUMBER(5, 0),
CONSTRAINT FK_PRODUCTO FOREIGN KEY(COD_FAMILIA) REFERENCES FAMILIA(COD_FAMILIA)
)

-- TABLA TIENDA=> contendrá información básica sobre las tiendas que distribuyen los productos.

CREATE TABLE TIENDA(
COD_TIENDA NUMBER(4,0) PRIMARY KEY,
DENO_TIENDA VARCHAR2(20) NOT NULL,
TELEFONO VARCHAR2(9),
CODIGO_POSTAL VARCHAR2(5) NOT NULL,
PROVINCIA VARCHAR2(5) NOT NULL
)

-- TABLA STOCK => Contendrá para cada tienda el número de unidades disponibles de cada producto. La clave primaria está formada por la concatenación de los campos Codtienda y Codproducto

CREATE TABLE STOCK(
UNIDADES NUMBER(6, 0) NOT NULL,
COD_TIENDA NUMBER(4,0),
COD_PRODUCTO NUMBER(5,0),
CONSTRAINT FK_COD_TIENDA FOREIGN KEY(COD_TIENDA) REFERENCES TIENDA(COD_TIENDA),
CONSTRAINT FK_COD_PRODUCTO FOREIGN KEY(COD_PRODUCTO) REFERENCES PRODUCTO(COD_PRODUCTO),
CONSTRAINT PK_STOCK PRIMARY KEY(COD_TIENDA, COD_PRODUCTO)
)

