CREATE SCHEMA ppa_disenio;

CREATE TABLE ppa_disenio.Paises (
    pais_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    pais_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (pais_id)
);

CREATE TABLE ppa_disenio.Categorias (
    categoria_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    categoria_precio FLOAT NOT NULL,
    PRIMARY KEY (categoria_id)
);

CREATE TABLE ppa_disenio.Provincias (
    provincia_id INTEGER UNSIGNED NOT NULL  AUTO_INCREMENT,
    Paises_pais_id INTEGER UNSIGNED NOT NULL,
    provincia_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (provincia_id),
    INDEX Provincias_FKIndex2 (Paises_pais_id),
    FOREIGN KEY (Paises_pais_id)
        REFERENCES Paises (pais_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Bandas (
    banda_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    Categorias_categoria_id INTEGER UNSIGNED NOT NULL,
    banda_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (banda_id),
    INDEX Bandas_FKIndex1 (Categorias_categoria_id),
    FOREIGN KEY (Categorias_categoria_id)
        REFERENCES Categorias (categoria_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);



CREATE TABLE ppa_disenio.Localidades (
    localidad_id INTEGER UNSIGNED NOT NULL  AUTO_INCREMENT,
    Provincias_provincia_id INTEGER UNSIGNED NOT NULL,
    localidad_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (localidad_id),
    INDEX Localidades_FKIndex1 (Provincias_provincia_id),
    FOREIGN KEY (Provincias_provincia_id)
        REFERENCES Provincias (provincia_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Estadios (
    estadio_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    Localidades_localidad_id INTEGER UNSIGNED NOT NULL,
    estadio_nombre VARCHAR(45) NOT NULL,
    PRIMARY KEY (estadio_id),
    INDEX Estadios_FKIndex1 (Localidades_localidad_id),
    FOREIGN KEY (Localidades_localidad_id)
        REFERENCES Localidades (localidad_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Sectores (
    sector_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    Estadios_estadio_id INTEGER UNSIGNED NOT NULL,
    sector_color VARCHAR(20) NOT NULL,
    precio_base FLOAT NOT NULL,
    PRIMARY KEY (sector_id),
    INDEX Sectores_FKIndex1 (Estadios_estadio_id),
    FOREIGN KEY (Estadios_estadio_id)
        REFERENCES Estadios (estadio_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Festival (
    festival_id INTEGER UNSIGNED AUTO_INCREMENT,
    Estadios_estadio_id INTEGER UNSIGNED NOT NULL,
    fecha_inicio DATE,
    fest_nombre varchar(30),
    PRIMARY KEY (festival_id),
    FOREIGN KEY (Estadios_estadio_id)
        REFERENCES Estadios (estadio_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Noches (
    noche_id INTEGER UNSIGNED AUTO_INCREMENT,
    Festival_festival_id INTEGER UNSIGNED,
    noche_fecha DATE NOT NULL,
    noche_hora_inicio TIME NOT NULL,
    noche_numero INTEGER UNSIGNED NOT NULL,
    PRIMARY KEY (noche_id)
  /*  FOREIGN KEY (Festival_festival_id)
        REFERENCES Festival (festival_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION*/
);

CREATE TABLE ppa_disenio.Filas (
    fila_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    Sectores_sector_id INTEGER UNSIGNED NOT NULL,
    fila_numero INTEGER UNSIGNED NOT NULL,
    precio_base FLOAT NOT NULL,
    PRIMARY KEY (fila_id),
    INDEX Filas_FKIndex1 (Sectores_sector_id),
    FOREIGN KEY (Sectores_sector_id)
        REFERENCES Sectores (sector_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Butacas (
    butaca_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    Filas_fila_id INTEGER UNSIGNED NOT NULL,
    butaca_numero INTEGER UNSIGNED NOT NULL,
    PRIMARY KEY (butaca_id),
    INDEX Butacas_FKIndex1 (Filas_fila_id),
    FOREIGN KEY (Filas_fila_id)
        REFERENCES Filas (fila_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);



CREATE TABLE ppa_disenio.banda_noche (
    bano_id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Noches_noche_id INTEGER UNSIGNED NOT NULL,
    Bandas_banda_id INTEGER UNSIGNED NOT NULL,
    orden INTEGER UNSIGNED NOT NULL,
    
    UNIQUE INDEX banda_noche_unique_banda_per_noche (Bandas_banda_id , Noches_noche_id)
);

CREATE TABLE ppa_disenio.Puntos_venta (
    puntos_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    Localidades_localidad_id INTEGER UNSIGNED NOT NULL,
    punto_name VARCHAR(50) NOT NULL,
    punto_direccion VARCHAR(45) NULL,
    punto_fest_id INTEGER UNSIGNED,
    PRIMARY KEY (puntos_id),
    INDEX Puntos_venta_FKIndex1 (Localidades_localidad_id),
    
    FOREIGN KEY (Localidades_localidad_id)
        REFERENCES Localidades (localidad_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
    
);

CREATE TABLE ppa_disenio.Entradas (
    entrada_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    Noches_noche_id INTEGER UNSIGNED NOT NULL,
    codigo_barra INTEGER UNSIGNED NOT NULL,
    entrada_fecha DATE NOT NULL,
    entrada_precio FLOAT NOT NULL,
    entrada_tipo VARCHAR(1) NOT NULL,
    cliente_name VARCHAR(50) NOT NULL,
    cliente_dni INTEGER UNSIGNED NOT NULL,
    entrada_anticipada BOOL NULL,
    PRIMARY KEY (entrada_id),
    INDEX Entradas_FKIndex1 (Noches_noche_id),
    FOREIGN KEY (Noches_noche_id)
        REFERENCES `Noches` (`noche_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Vendedores (
    vendedor_id integer unsigned primary key AUTO_INCREMENT,
    vendedor_nombre varchar(50),
    vendedor_user varchar(15) not null,
    vendedor_pass varchar(15) not null,
    punto_venta_id integer unsigned not null,
    INDEX Puntos_venta_FKIndex (punto_venta_id),
    unique (vendedor_user),
    foreign key (punto_venta_id)
        references Puntos_venta (puntos_id)
        on delete no action
);

CREATE TABLE ppa_disenio.Organizadores (
    orga_id integer unsigned primary key AUTO_INCREMENT,
    orga_nombre varchar(50),
    orga_user varchar(15) not null,
    orga_pass varchar(15) not null,
    orga_fest_id integer unsigned not null,
    INDEX Festival_FKIndex (orga_fest_id),
    unique (orga_user),
    foreign key (orga_fest_id)
        references Festival (festival_id)
        on delete no action
);

INSERT INTO ppa_disenio.paises (pais_name) values ('Argentina');
/*provincias*/
INSERT INTO ppa_disenio.provincias (Paises_pais_id,provincia_name)
VALUES (1,'Buenos Aires') ;
insert into ppa_disenio.provincias (Paises_pais_id,provincia_name)
 values (1,'CABA'); 
/*localidades*/
INSERT INTO ppa_disenio.localidades (Provincias_provincia_id,localidad_name) 
VALUES (1,'Banfield');
INSERT INTO ppa_disenio.localidades (Provincias_provincia_id,localidad_name) 
values (2,'CABA'); 
/*estadios*/
INSERT INTO ppa_disenio.estadios (Localidades_localidad_id,estadio_nombre)
values (1,'Lanu');
	/* Sectores Lanu */
	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (1,'Verde',30.0);
		/* filas sector verde */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (1,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (1,1);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero)  values (1,2);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero)  values (1,3);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero)  values (1,4);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero)  values (1,5);

	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (1,'Azul',60.0);
		/* filas sector azul */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (2,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (2,1);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (2,2);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (2,3);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (2,4);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (2,5);
	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (1,'Dorado',120.0);
		/* filas sector dorado */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (3,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (3,1);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (3,2);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (3,3);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (3,4);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (3,5);


insert into ppa_disenio.estadios (Localidades_localidad_id,estadio_nombre) values (2,'River');
	/* Sectores River */
	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (2,'Rojo',50.0);
		/* filas sector rojo */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (4,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (4,1);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (4,2);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (4,3);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (4,4);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (4,5);

	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (2,'Blanco',80.0);
		/* filas sector blanco */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (5,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas(Filas_fila_id,butaca_numero)  values (5,1);
			insert into ppa_disenio.butacas(Filas_fila_id,butaca_numero)  values (5,2);
			insert into ppa_disenio.butacas(Filas_fila_id,butaca_numero)  values (5,3);
			insert into ppa_disenio.butacas(Filas_fila_id,butaca_numero)  values (5,4);
			insert into ppa_disenio.butacas(Filas_fila_id,butaca_numero)  values (5,5);

	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (2,'Plateado',150.0);
		/* filas sector plateado */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (6,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (6,1);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (6,2);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (6,3);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (6,4);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (6,5);

insert into ppa_disenio.estadios (Localidades_localidad_id,estadio_nombre) values (2,'Obras'); 
	/* Sectores Obras */
	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (3,'Amarillo',60.0);
		/* filas sector amarillo */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (7,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (7,1);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (7,2);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (7,3);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (7,4);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (7,5);

	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (3,'Naranja',85.0);
		/* filas sector naraja */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (8,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (8,1);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (8,2);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (8,3);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (8,4);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (8,5);

	insert into ppa_disenio.Sectores (Estadios_estadio_id,sector_color,precio_base) values (3,'Oro',170.0);
		/* filas sector oro */
		insert into ppa_disenio.filas (Sectores_sector_id,fila_numero,precio_base) values (8,1,30.0);
			/* butacas */
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (9,1);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (9,2);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (9,3);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (9,4);
			insert into ppa_disenio.butacas (Filas_fila_id,butaca_numero) values (9,5);

/* categorias */
insert into ppa_disenio.categorias (categoria_precio) values (0);
insert into ppa_disenio.categorias (categoria_precio) values (50);
insert into ppa_disenio.categorias (categoria_precio) values (100);
insert into ppa_disenio.categorias (categoria_precio) values (200);
/*bandas*/
insert into ppa_disenio.bandas (Categorias_categoria_id,banda_name) values (3,'Black Sabbat');
insert into ppa_disenio.bandas (Categorias_categoria_id,banda_name) values (3,'Metallica');
insert into ppa_disenio.bandas (Categorias_categoria_id,banda_name) values (2,'Almafuerte');
insert into ppa_disenio.bandas (Categorias_categoria_id,banda_name) values (2,'Rata Blanca');
insert into ppa_disenio.bandas (Categorias_categoria_id,banda_name) values (1,'Tren Loco');
insert into ppa_disenio.bandas (Categorias_categoria_id,banda_name) values (2,'Damas Gratis');
insert into ppa_disenio.bandas (Categorias_categoria_id,banda_name) values (3,'Sonora Dinamita');
insert into ppa_disenio.bandas (Categorias_categoria_id,banda_name) values (2,'La Liga');

/* festvales */
insert into ppa_disenio.festival (Estadios_estadio_id,fecha_inicio,fest_nombre) values (2,'2013-12-18','Isenbeck Cumbia'); 
/* puntos de venta */
insert into ppa_disenio.puntos_venta (Localidades_localidad_id,punto_name,punto_direccion,punto_fest_id) values (2,'estadio','direccion estadio',1); 

/* noches de "Isenbeck Cumbia" */
insert into ppa_disenio.noches (Festival_festival_id,noche_fecha,noche_hora_inicio,noche_numero) 
values (1,'2013-12-18','20:00',1);
insert into ppa_disenio.noches (Festival_festival_id,noche_fecha,noche_hora_inicio,noche_numero) 
values (1,'2013-12-19','20:00',2); 

/* bandas noche 1 "Isenbeck Cumbia" */
insert into ppa_disenio.banda_noche (Noches_noche_id,bandas_banda_id,orden) values (1,7,1);
insert into ppa_disenio.banda_noche (Noches_noche_id,bandas_banda_id,orden) values (1,5,2);
/* bandas noche 2 "Isenbeck Cumbia" */
insert into ppa_disenio.banda_noche (Noches_noche_id,bandas_banda_id,orden) values (2,6,1);

/* vendedores */


insert into ppa_disenio.vendedores (vendedor_nombre,vendedor_user,vendedor_pass,punto_venta_id) 
values ('Diego Barchiesi','diegob','bugaboo',1);
insert into ppa_disenio.vendedores (vendedor_nombre,vendedor_user,vendedor_pass,punto_venta_id) 
values ('Dani Barros','danib','bugaboo',1);
insert into ppa_disenio.vendedores (vendedor_nombre,vendedor_user,vendedor_pass,punto_venta_id) 
values ('Ger Berra','gerb','bugaboo',1);
insert into ppa_disenio.vendedores (vendedor_nombre,vendedor_user,vendedor_pass,punto_venta_id) 
values ('Emi Cortese','emic','bugaboo',1);
insert into ppa_disenio.vendedores (vendedor_nombre,vendedor_user,vendedor_pass,punto_venta_id) 
values ('Nacho Varela','nachov','bugaboo',1);

insert into ppa_disenio.organizadores (orga_nombre,orga_user,orga_pass,orga_fest_id) 
values ('Diego Barchiesi','diegob','bugaboo',1);
insert into ppa_disenio.organizadores (orga_nombre,orga_user,orga_pass,orga_fest_id) 
values ('Dani Barros','danib','bugaboo',1);
insert into ppa_disenio.organizadores (orga_nombre,orga_user,orga_pass,orga_fest_id) 
values ('Ger Berra','gerb','bugaboo',1);
insert into ppa_disenio.organizadores (orga_nombre,orga_user,orga_pass,orga_fest_id) 
values ('Emi Cortese','emic','bugaboo',1);
insert into ppa_disenio.organizadores (orga_nombre,orga_user,orga_pass,orga_fest_id) 
values ('Nacho Varela','nachov','bugaboo',1);

select * from festival;
select * from noches;