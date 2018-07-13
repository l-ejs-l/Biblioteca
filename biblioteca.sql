drop DATABASE biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;
CREATE TABLE Autor (
    id_autor         INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre_autor     VARCHAR(30) NOT NULL,
    apaterno_autor   VARCHAR(30) NOT NULL,
    amaterno_autor   VARCHAR(30)
);

CREATE TABLE Comuna (
    id_comuna   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    comuna      VARCHAR(50) NOT NULL,
    id_region   INTEGER NOT NULL
);

CREATE TABLE Copia_Recurso (
    id_copia       INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    estado_copia   INTEGER NOT NULL,
    id_recurso     INTEGER NOT NULL,
    cod_sucursal   INTEGER NOT NULL
);



CREATE TABLE Detalle_Factura (
	id_detalle_factura INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_factura   INTEGER NOT NULL,
    id_pedido    INTEGER NOT NULL
);

CREATE TABLE Detalle_Prestamo (
    id_detalle_prestamo   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    estado_prestamo       INTEGER NOT NULL,
    cod_prestamo          INTEGER NOT NULL,
    id_copia              INTEGER NOT NULL,
    cod_sucursal          INTEGER NOT NULL
);

CREATE TABLE Editorial (
    id_editorial   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    editorial      VARCHAR(30) NOT NULL
);

CREATE TABLE Factura (
    id_factura         INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipo_factura       INTEGER NOT NULL,
    cod_sucursal       INTEGER NOT NULL,
    sucursal_destino   INTEGER NOT NULL,
    sucursal_origen    INTEGER NOT NULL,
    id_proveedor       INTEGER NOT NULL,
    total              INTEGER
);

CREATE TABLE Libro (
    id_recurso      INTEGER NOT NULL,
    isbn            VARCHAR(30) NOT NULL,
    lomo            VARCHAR(30),
    contraportada   VARCHAR(30),
    portada         VARCHAR(30)
);

ALTER TABLE Libro ADD CONSTRAINT libro_pk PRIMARY KEY ( id_recurso );

CREATE TABLE Multa (
    id_multa      INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    valor_multa   INTEGER NOT NULL
);

CREATE TABLE Pedido (
    id_pedido    INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    total        INTEGER NOT NULL,
    id_recurso   INTEGER NOT NULL
);

CREATE TABLE Periodico (
    id_recurso   INTEGER NOT NULL,
    lema         VARCHAR(30)
);

ALTER TABLE Periodico ADD CONSTRAINT periodico_pk PRIMARY KEY ( id_recurso );

CREATE TABLE Prestamo (
    cod_prestamo       INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    uso_total          DATE NOT NULL,
    cod_sucursal       INTEGER NOT NULL,
    id_usuario         INTEGER NOT NULL,
    fecha_prestamo     DATE NOT NULL,
    fecha_devolución   DATE NOT NULL
);

CREATE TABLE Proveedor (
    id_proveedor       INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre_proveedor   VARCHAR(30) NOT NULL,
    dir_calle          VARCHAR(40) NOT NULL,
    dir_numero         INTEGER NOT NULL,
    id_comuna          INTEGER NOT NULL
);

CREATE TABLE Recurso (
    id_recurso      INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo          VARCHAR(50) NOT NULL,
    tipo_recurso    INTEGER NOT NULL,
    tipo_texto      INTEGER NOT NULL,
    id_editorial    INTEGER NOT NULL,
    total_paginas   INTEGER
);

CREATE TABLE Recurso_Autor (
    id_autor     INTEGER NOT NULL,
    id_recurso   INTEGER NOT NULL
);

CREATE TABLE Region (
    id_region   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    region      VARCHAR(30) NOT NULL
);

CREATE TABLE Revista (
    id_recurso   INTEGER NOT NULL
);

ALTER TABLE Revista ADD CONSTRAINT revista_pk PRIMARY KEY ( id_recurso );

CREATE TABLE Sucursal (
    cod_sucursal   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre         VARCHAR(50) NOT NULL,
    es_central     SMALLINT DEFAULT 0,
    dir_calle      VARCHAR(40) NOT NULL,
    dir_numero     INTEGER NOT NULL,
    id_usuario     INTEGER NOT NULL,
    id_comuna      INTEGER NOT NULL
);

CREATE UNIQUE INDEX sucursal__idx ON
    Sucursal (
        id_usuario
    ASC );

CREATE TABLE Topico (
    id_topico   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    topico      VARCHAR(30) NOT NULL
);

CREATE TABLE Topico_Recurso (
    id_topico    INTEGER NOT NULL,
    id_recurso   INTEGER NOT NULL
);

CREATE TABLE Usuario (
    id_usuario     INTEGER NOT NULL,
    nombre         VARCHAR(30) NOT NULL,
    usuario      VARCHAR(30) NOT NULL,
    clave        VARCHAR(30) NOT NULL,
    es_miembro   SMALLINT DEFAULT 0,
    apellido     VARCHAR(30),
    correo       VARCHAR(50)NOT NULL,
    cod_sucursal   INTEGER NOT NULL,
    activo         SMALLINT NOT NULL
);

CREATE UNIQUE INDEX usuario__idx ON
    Usuario (
        cod_sucursal
    ASC );

ALTER TABLE Usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

CREATE TABLE Usuario_Multa (
    id_usuario_multa   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    activa             SMALLINT NOT NULL,
    id_multa           INTEGER NOT NULL,
    id_usuario         INTEGER NOT NULL
);

CREATE TABLE Usuario_Rol (
    rol          INTEGER NOT NULL,
    id_usuario   INTEGER NOT NULL
);

ALTER TABLE Recurso_Autor
    ADD CONSTRAINT autor_libro_autor FOREIGN KEY ( id_autor )
        REFERENCES Autor ( id_autor );

ALTER TABLE Detalle_Prestamo
    ADD CONSTRAINT biblioteca_devolucion FOREIGN KEY ( cod_sucursal )
        REFERENCES Sucursal ( cod_sucursal );

ALTER TABLE Detalle_Factura
    ADD CONSTRAINT compra_detalle FOREIGN KEY ( id_factura )
        REFERENCES Factura ( id_factura );

ALTER TABLE Proveedor
    ADD CONSTRAINT comuna_proveedor FOREIGN KEY ( id_comuna )
        REFERENCES Comuna ( id_comuna );

ALTER TABLE Detalle_Prestamo
    ADD CONSTRAINT copia_prestamo FOREIGN KEY ( id_copia )
        REFERENCES Copia_Recurso ( id_copia );

ALTER TABLE Factura
    ADD CONSTRAINT actura_proveedor FOREIGN KEY ( id_proveedor )
        REFERENCES Proveedor ( id_proveedor );

ALTER TABLE Detalle_Prestamo
    ADD CONSTRAINT libro_prestamo FOREIGN KEY ( cod_prestamo )
        REFERENCES Prestamo ( cod_prestamo );

ALTER TABLE Libro
    ADD CONSTRAINT libro_recurso_fk FOREIGN KEY ( id_recurso )
        REFERENCES Recurso ( id_recurso );

ALTER TABLE Usuario_Multa
    ADD CONSTRAINT multa_usuario FOREIGN KEY ( id_multa )
        REFERENCES Multa ( id_multa );

ALTER TABLE Detalle_Factura
    ADD CONSTRAINT pedido_factura FOREIGN KEY ( id_pedido )
        REFERENCES Pedido ( id_pedido );

ALTER TABLE Periodico
    ADD CONSTRAINT periodico_recurso_fk FOREIGN KEY ( id_recurso )
        REFERENCES Recurso ( id_recurso );

ALTER TABLE Prestamo
    ADD CONSTRAINT prestamo_sucursal FOREIGN KEY ( cod_sucursal )
        REFERENCES Sucursal ( cod_sucursal );

ALTER TABLE Recurso_Autor
    ADD CONSTRAINT recurso_autor FOREIGN KEY ( id_recurso )
        REFERENCES Recurso ( id_recurso );

ALTER TABLE Copia_Recurso
    ADD CONSTRAINT recurso_copia FOREIGN KEY ( id_recurso )
        REFERENCES Recurso ( id_recurso );

ALTER TABLE Recurso
    ADD CONSTRAINT recurso_editorial FOREIGN KEY ( id_editorial )
        REFERENCES Editorial ( id_editorial );

ALTER TABLE Pedido
    ADD CONSTRAINT recurso_pedido FOREIGN KEY ( id_recurso )
        REFERENCES Recurso ( id_recurso );

ALTER TABLE Topico_Recurso
    ADD CONSTRAINT recurso_topico FOREIGN KEY ( id_recurso )
        REFERENCES Recurso ( id_recurso );

ALTER TABLE Comuna
    ADD CONSTRAINT region_comuna FOREIGN KEY ( id_region )
        REFERENCES Region ( id_region );

ALTER TABLE Revista
    ADD CONSTRAINT revista_recurso_fk FOREIGN KEY ( id_recurso )
        REFERENCES Recurso ( id_recurso );

ALTER TABLE Factura
    ADD CONSTRAINT sucursal_compra FOREIGN KEY ( cod_sucursal )
        REFERENCES Sucursal ( cod_sucursal );

ALTER TABLE Sucursal
    ADD CONSTRAINT sucursal_comuna FOREIGN KEY ( id_comuna )
        REFERENCES Comuna ( id_comuna );

ALTER TABLE Copia_Recurso
    ADD CONSTRAINT sucursal_copia_recurso FOREIGN KEY ( cod_sucursal )
        REFERENCES Sucursal ( cod_sucursal );

ALTER TABLE Topico_Recurso
    ADD CONSTRAINT topico_libro FOREIGN KEY ( id_topico )
        REFERENCES Topico ( id_topico );

ALTER TABLE Usuario_Multa
    ADD CONSTRAINT usuario_multa FOREIGN KEY ( id_usuario )
        REFERENCES Usuario ( id_usuario );

ALTER TABLE Prestamo
    ADD CONSTRAINT usuario_prestamo FOREIGN KEY ( id_usuario )
        REFERENCES Usuario ( id_usuario );

ALTER TABLE Usuario_Rol
    ADD CONSTRAINT usuario_rol FOREIGN KEY ( id_usuario )
        REFERENCES Usuario ( id_usuario );

ALTER TABLE Factura
	ADD CONSTRAINT factura_destino FOREIGN KEY ( sucursal_destino )
		REFERENCES Sucursal ( cod_sucursal );

ALTER TABLE Factura
	ADD CONSTRAINT factura_origen FOREIGN KEY ( sucursal_origen )
		REFERENCES Sucursal ( cod_sucursal );
