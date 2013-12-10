CREATE SCHEMA ppa_disenio;

CREATE TABLE ppa_disenio.Paises (
    pais_id INTEGER UNSIGNED NOT NULL ,
    pais_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (pais_id)
);

CREATE TABLE ppa_disenio.Categorias (
    categoria_id INTEGER UNSIGNED NOT NULL ,
    categoria_precio FLOAT NOT NULL,
    PRIMARY KEY (categoria_id)
);

CREATE TABLE ppa_disenio.Provincias (
    provincia_id INTEGER UNSIGNED NOT NULL  ,
    Paises_pais_id INTEGER UNSIGNED NOT NULL,
    provincia_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (provincia_id),
    INDEX Provincias_FKIndex2 (Paises_pais_id),
    FOREIGN KEY (Paises_pais_id)
        REFERENCES Paises (pais_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Bandas (
    banda_id INTEGER UNSIGNED NOT NULL ,
    Categorias_categoria_id INTEGER UNSIGNED NOT NULL,
    banda_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (banda_id),
    INDEX Bandas_FKIndex1 (Categorias_categoria_id),
    FOREIGN KEY (Categorias_categoria_id)
        REFERENCES Categorias (categoria_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);



CREATE TABLE ppa_disenio.Localidades (
    localidad_id INTEGER UNSIGNED NOT NULL  ,
    Provincias_provincia_id INTEGER UNSIGNED NOT NULL,
    localidad_name VARCHAR(45) NOT NULL,
    PRIMARY KEY (localidad_id),
    INDEX Localidades_FKIndex1 (Provincias_provincia_id),
    FOREIGN KEY (Provincias_provincia_id)
        REFERENCES Provincias (provincia_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Estadios (
    estadio_id INTEGER UNSIGNED NOT NULL ,
    Localidades_localidad_id INTEGER UNSIGNED NOT NULL,
    estadio_nombre VARCHAR(45) NOT NULL,
    PRIMARY KEY (estadio_id),
    INDEX Estadios_FKIndex1 (Localidades_localidad_id),
    FOREIGN KEY (Localidades_localidad_id)
        REFERENCES Localidades (localidad_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Sectores (
    sector_id INTEGER UNSIGNED NOT NULL ,
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
    festival_id INTEGER UNSIGNED ,
    Estadios_estadio_id INTEGER UNSIGNED NOT NULL,
    fecha_inicio DATE,
    fest_nombre varchar(30),
    PRIMARY KEY (festival_id),
    FOREIGN KEY (Estadios_estadio_id)
        REFERENCES Estadios (estadio_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Noches (
    noche_id INTEGER UNSIGNED ,
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
    fila_id INTEGER UNSIGNED NOT NULL ,
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
    butaca_id INTEGER UNSIGNED NOT NULL ,
    Filas_fila_id INTEGER UNSIGNED NOT NULL,
    butaca_numero INTEGER UNSIGNED NOT NULL,
    PRIMARY KEY (butaca_id),
    INDEX Butacas_FKIndex1 (Filas_fila_id),
    FOREIGN KEY (Filas_fila_id)
        REFERENCES Filas (fila_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);



CREATE TABLE ppa_disenio.banda_noche (
    bano_id INTEGER UNSIGNED NOT NULL PRIMARY KEY ,
	Noches_noche_id INTEGER UNSIGNED NOT NULL,
    Bandas_banda_id INTEGER UNSIGNED NOT NULL,
    orden INTEGER UNSIGNED NOT NULL,
    
    UNIQUE INDEX banda_noche_unique_banda_per_noche (Bandas_banda_id , Noches_noche_id)
);

CREATE TABLE ppa_disenio.Puntos_venta (
    puntos_id INTEGER UNSIGNED NOT NULL ,
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
    entrada_id INTEGER UNSIGNED NOT NULL ,
    Noches_noche_id INTEGER UNSIGNED NOT NULL,
    codigo_barra INTEGER UNSIGNED NOT NULL,
    entrada_fecha DATE NOT NULL,
    entrada_precio FLOAT NOT NULL,
    entrada_tipo VARCHAR(1) NOT NULL,
    cliente_name VARCHAR(50) NOT NULL,
    entrada_anticipada BOOL NULL,
    PRIMARY KEY (entrada_id),
    INDEX Entradas_FKIndex1 (Noches_noche_id),
    FOREIGN KEY (Noches_noche_id)
        REFERENCES `Noches` (`noche_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Vendedores (
    vendedor_id integer unsigned primary key ,
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
    orga_id integer unsigned primary key ,
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

INSERT INTO ppa_disenio.paises (pais_id,pais_name) values (0,'Argentina');
/*provincias*/
INSERT INTO ppa_disenio.provincias (provincia_id,Paises_pais_id,provincia_name)
VALUES (0,0,'Buenos Aires') ;
insert into ppa_disenio.provincias values (1,0,'CABA'); 
/*localidades*/
INSERT INTO ppa_disenio.localidades (localidad_id,Provincias_provincia_id,localidad_name) 
VALUES (0,0,'Banfield');
INSERT INTO ppa_disenio.localidades values (1,0,'CABA'); 
/*estadios*/
INSERT INTO ppa_disenio.estadios (estadio_id,Localidades_localidad_id,estadio_nombre)
values (0,0,'Lanu');
	/* Sectores Lanu */
	insert into ppa_disenio.Sectores values (0,0,'Verde',30.0);
		/* filas sector verde */
		insert into ppa_disenio.filas values (0,0,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (0,0,1);
			insert into ppa_disenio.butacas values (1,0,2);
			insert into ppa_disenio.butacas values (2,0,3);
			insert into ppa_disenio.butacas values (3,0,4);
			insert into ppa_disenio.butacas values (4,0,5);
	insert into ppa_disenio.Sectores values (1,0,'Azul',60.0);
		/* filas sector azul */
		insert into ppa_disenio.filas values (1,1,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (5,1,1);
			insert into ppa_disenio.butacas values (6,1,2);
			insert into ppa_disenio.butacas values (7,1,3);
			insert into ppa_disenio.butacas values (8,1,4);
			insert into ppa_disenio.butacas values (9,1,5);
	insert into ppa_disenio.Sectores values (2,0,'Dorado',120.0);
		/* filas sector dorado */
		insert into ppa_disenio.filas values (2,2,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (10,2,1);
			insert into ppa_disenio.butacas values (11,2,2);
			insert into ppa_disenio.butacas values (12,2,3);
			insert into ppa_disenio.butacas values (13,2,4);
			insert into ppa_disenio.butacas values (14,2,5);
insert into ppa_disenio.estadios values (1,1,'River'); 
	/* Sectores River */
	insert into ppa_disenio.Sectores values (3,1,'Rojo',50.0);
		/* filas sector rojo */
		insert into ppa_disenio.filas values (3,3,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (15,3,1);
			insert into ppa_disenio.butacas values (16,3,2);
			insert into ppa_disenio.butacas values (17,3,3);
			insert into ppa_disenio.butacas values (18,3,4);
			insert into ppa_disenio.butacas values (19,3,5);
	insert into ppa_disenio.Sectores values (4,1,'Blanco',80.0);
		/* filas sector blanco */
		insert into ppa_disenio.filas values (4,4,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (20,4,1);
			insert into ppa_disenio.butacas values (21,4,2);
			insert into ppa_disenio.butacas values (22,4,3);
			insert into ppa_disenio.butacas values (23,4,4);
			insert into ppa_disenio.butacas values (24,4,5);
	insert into ppa_disenio.Sectores values (5,1,'Plateado',150.0);
		/* filas sector plateado */
		insert into ppa_disenio.filas values (5,5,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (25,5,1);
			insert into ppa_disenio.butacas values (26,5,2);
			insert into ppa_disenio.butacas values (27,5,3);
			insert into ppa_disenio.butacas values (28,5,4);
			insert into ppa_disenio.butacas values (29,5,5);
insert into ppa_disenio.estadios values (2,1,'Obras'); 
	/* Sectores Obras */
	insert into ppa_disenio.Sectores values (6,2,'Amarillo',60.0);
		/* filas sector amarillo */
		insert into ppa_disenio.filas values (6,6,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (30,6,1);
			insert into ppa_disenio.butacas values (31,6,2);
			insert into ppa_disenio.butacas values (32,6,3);
			insert into ppa_disenio.butacas values (33,6,4);
			insert into ppa_disenio.butacas values (34,6,5);
	insert into ppa_disenio.Sectores values (7,2,'Naranja',85.0);
		/* filas sector naraja */
		insert into ppa_disenio.filas values (7,7,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (35,7,1);
			insert into ppa_disenio.butacas values (36,7,2);
			insert into ppa_disenio.butacas values (37,7,3);
			insert into ppa_disenio.butacas values (38,7,4);
			insert into ppa_disenio.butacas values (39,7,5);
	insert into ppa_disenio.Sectores values (8,2,'Oro',170.0);
		/* filas sector oro */
		insert into ppa_disenio.filas values (8,8,0,30.0);
			/* butacas */
			insert into ppa_disenio.butacas values (40,8,1);
			insert into ppa_disenio.butacas values (41,8,2);
			insert into ppa_disenio.butacas values (42,8,3);
			insert into ppa_disenio.butacas values (43,8,4);
			insert into ppa_disenio.butacas values (44,8,5);

/* categorias */
insert into ppa_disenio.categorias values (0,0);
insert into ppa_disenio.categorias values (1,50);
insert into ppa_disenio.categorias values (2,100);
insert into ppa_disenio.categorias values (3,200);
/*bandas*/
insert into ppa_disenio.bandas values (0,3,'Black Sabbat');
insert into ppa_disenio.bandas values (1,3,'Metallica');
insert into ppa_disenio.bandas values (2,2,'Almafuerte');
insert into ppa_disenio.bandas values (3,2,'Rata Blanca');
insert into ppa_disenio.bandas values (4,1,'Tren Loco');
insert into ppa_disenio.bandas values (5,2,'Damas Gratis');
insert into ppa_disenio.bandas values (6,3,'Sonora Dinamita');
insert into ppa_disenio.bandas values (7,2,'La Liga');

/* festvales */
insert into ppa_disenio.festival values (0,1,'2013-12-18','Isenbeck Cumbia'); 
/* puntos de venta */
insert into ppa_disenio.puntos_venta values (0,0,'estadio','direccion estadio',0); 

/* noches de "Isenbeck Cumbia" */
insert into ppa_disenio.noches values (0,0,'2013-12-18','20:00',1);
insert into ppa_disenio.noches values (1,0,'2013-12-19','20:00',2);

/* bandas noche 1 "Isenbeck Cumbia" */
insert into ppa_disenio.banda_noche values (0,0,7,0);
insert into ppa_disenio.banda_noche values (1,0,5,1);
/* bandas noche 2 "Isenbeck Cumbia" */
insert into ppa_disenio.banda_noche values (2,1,6,0);

/* vendedores */
insert into ppa_disenio.vendedores values (0,'Diego','diegob','bugaboo',0);
insert into ppa_disenio.vendedores values (1,'Dani','danib','bugaboo',0);
insert into ppa_disenio.vendedores values (2,'Ger','gerb','bugaboo',0);
insert into ppa_disenio.vendedores values (3,'Emi','emic','bugaboo',0);
insert into ppa_disenio.vendedores values (4,'Nacho','nachov','bugaboo',0);

insert into ppa_disenio.organizadores values (0,'Diego','diegob','bugaboo',0);
insert into ppa_disenio.organizadores values (1,'Dani','danib','bugaboo',0);
insert into ppa_disenio.organizadores values (2,'Ger','gerb','bugaboo',0);
insert into ppa_disenio.organizadores values (3,'Emi','emic','bugaboo',0);
insert into ppa_disenio.organizadores values (4,'Nacho','nachov','bugaboo',0);