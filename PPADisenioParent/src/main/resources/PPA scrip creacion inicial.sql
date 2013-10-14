CREATE SCHEMA ppa_disenio;

CREATE TABLE ppa_disenio.Paises (
  pais_id INTEGER UNSIGNED NOT NULL ,
  pais_name VARCHAR(45) NOT NULL,
  PRIMARY KEY(pais_id)
);

CREATE TABLE ppa_disenio.Categorias (
  categoria_id INTEGER UNSIGNED NOT NULL ,
  categoria_precio FLOAT NOT NULL,
  PRIMARY KEY(categoria_id)
);

CREATE TABLE ppa_disenio.Provincias (
  provincia_id INTEGER UNSIGNED NOT NULL ,
  Paises_pais_id INTEGER UNSIGNED NOT NULL,
  provincia_name VARCHAR(45) NOT NULL,
  PRIMARY KEY(provincia_id),
  INDEX Provincias_FKIndex2(Paises_pais_id),
  FOREIGN KEY(Paises_pais_id)
    REFERENCES Paises(pais_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Bandas (
  banda_id INTEGER UNSIGNED NOT NULL ,
  Categorias_categoria_id INTEGER UNSIGNED NOT NULL,
  banda_name VARCHAR(20) NOT NULL,
  PRIMARY KEY(banda_id),
  INDEX Bandas_FKIndex1(Categorias_categoria_id),
  FOREIGN KEY(Categorias_categoria_id)
    REFERENCES Categorias(categoria_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);



CREATE TABLE ppa_disenio.Localidades (
  localidad_id INTEGER UNSIGNED NOT NULL ,
  Provincias_provincia_id INTEGER UNSIGNED NOT NULL,
  localidad_name VARCHAR(45) NOT NULL,
  PRIMARY KEY(localidad_id),
  INDEX Localidades_FKIndex1(Provincias_provincia_id),
  FOREIGN KEY(Provincias_provincia_id)
    REFERENCES Provincias(provincia_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Estadios (
  estadio_id INTEGER UNSIGNED NOT NULL ,
  Localidades_localidad_id INTEGER UNSIGNED NOT NULL,
  estadio_nombre VARCHAR(45) NOT NULL,
  PRIMARY KEY(estadio_id),
  INDEX Estadios_FKIndex1(Localidades_localidad_id),
  FOREIGN KEY(Localidades_localidad_id)
    REFERENCES Localidades(localidad_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Sectores (
  sector_id INTEGER UNSIGNED NOT NULL ,
  Estadios_estadio_id INTEGER UNSIGNED NOT NULL,
  sector_color VARCHAR(20) NOT NULL,
  precio_base FLOAT NOT NULL,
  PRIMARY KEY(sector_id),
  INDEX Sectores_FKIndex1(Estadios_estadio_id),
  FOREIGN KEY(Estadios_estadio_id)
    REFERENCES Estadios(estadio_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Festival (
  festival_id INTEGER UNSIGNED NOT NULL ,
  Estadios_estadio_id INTEGER UNSIGNED NOT NULL,
  fecha_inicio DATE,
  fest_nombre varchar(30),
  PRIMARY KEY(festival_id),
  INDEX Festival_FKIndex1(Estadios_estadio_id),
  FOREIGN KEY(Estadios_estadio_id)
    REFERENCES Estadios(estadio_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Noches (
  noche_id INTEGER UNSIGNED NOT NULL ,
  Festival_festival_id INTEGER UNSIGNED NOT NULL,
  Estadios_estadio_id INTEGER UNSIGNED NOT NULL,
  noche_fecha DATE NOT NULL,
  noche_hora_inicio TIME NOT NULL,
  noche_numero INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(noche_id),
  INDEX Noches_FKIndex1(Estadios_estadio_id),
  INDEX Noches_FKIndex2(Festival_festival_id),
  FOREIGN KEY(Estadios_estadio_id)
    REFERENCES Estadios(estadio_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Festival_festival_id)
    REFERENCES Festival(festival_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Filas (
  fila_id INTEGER UNSIGNED NOT NULL ,
  Sectores_sector_id INTEGER UNSIGNED NOT NULL,
  fila_numero INTEGER UNSIGNED NOT NULL,
  precio_base FLOAT NOT NULL,
  PRIMARY KEY(fila_id),
  INDEX Filas_FKIndex1(Sectores_sector_id),
  FOREIGN KEY(Sectores_sector_id)
    REFERENCES Sectores(sector_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Butacas (
  butaca_id INTEGER UNSIGNED NOT NULL ,
  Filas_fila_id INTEGER UNSIGNED NOT NULL,
  butaca_numero INTEGER UNSIGNED NOT NULL,
  disponible BOOL NULL,
  PRIMARY KEY(butaca_id),
  INDEX Butacas_FKIndex1(Filas_fila_id),
  FOREIGN KEY(Filas_fila_id)
    REFERENCES Filas(fila_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);



CREATE TABLE ppa_disenio.banda_noche (
  Noches_noche_id INTEGER UNSIGNED NOT NULL,
  Bandas_banda_id INTEGER UNSIGNED NOT NULL,
  hora_inicio TIME NOT NULL,
  hora_fin TIME NOT NULL,
  INDEX banda_noche_FKIndex1(Bandas_banda_id),
  INDEX banda_noche_FKIndex2(Noches_noche_id),
  UNIQUE INDEX banda_noche_unique_banda_per_noche(Bandas_banda_id, Noches_noche_id),
  FOREIGN KEY(Bandas_banda_id)
    REFERENCES Bandas(banda_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Noches_noche_id)
    REFERENCES Noches(noche_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Puntos_venta (
  puntos_id INTEGER UNSIGNED NOT NULL ,
  Festival_festival_id INTEGER UNSIGNED NOT NULL,
  Localidades_localidad_id INTEGER UNSIGNED NOT NULL,
  punto_name VARCHAR(50) NOT NULL,
  punto_direccion VARCHAR(45) NULL,
  PRIMARY KEY(puntos_id),
  INDEX Puntos_venta_FKIndex1(Localidades_localidad_id),
  INDEX Puntos_venta_FKIndex3(Festival_festival_id),
  FOREIGN KEY(Localidades_localidad_id)
    REFERENCES Localidades(localidad_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Festival_festival_id)
    REFERENCES Festival(festival_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE Punto_festival (
  pufe_id INTEGER UNSIGNED NOT NULL,
  Festival_festival_id INTEGER UNSIGNED NOT NULL,
  Puntos_venta_puntos_id INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(pufe_id, Festival_festival_id, Puntos_venta_puntos_id),
  INDEX Punto_festival_FKIndex1(Festival_festival_id),
  INDEX Punto_festival_FKIndex2(Puntos_venta_puntos_id),
  FOREIGN KEY(Festival_festival_id)
    REFERENCES Festival(festival_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Puntos_venta_puntos_id)
    REFERENCES Puntos_venta(puntos_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Entradas (
  entrada_id INTEGER UNSIGNED NOT NULL ,
  Noches_noche_id INTEGER UNSIGNED NOT NULL,
  Puntos_venta_punto_id INTEGER UNSIGNED NOT NULL,
  codigo_barra INTEGER UNSIGNED NOT NULL,
  entrada_fecha DATE NOT NULL,
  entrada_precio FLOAT NOT NULL,
  entrada_tipo VARCHAR(1) NOT NULL,
  cliente_name VARCHAR(50) NOT NULL,
  cliente_dni INTEGER UNSIGNED NOT NULL,
  entrada_anticipada BOOL NULL,
  PRIMARY KEY (entrada_id),
  INDEX Entradas_FKIndex1(Noches_noche_id),
  FOREIGN KEY (Noches_noche_id)
    REFERENCES `Noches`(`noche_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY (Puntos_venta_punto_id)
	REFERENCES `Puntos_venta`(`puntos_id`)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION
);

CREATE TABLE ppa_disenio.Vendedores (
	vendedor_id integer unsigned primary key,
	vendedor_nombre varchar(50),
	vendedor_user varchar(15) not null,
	vendedor_pass varchar(15) not null,
	punto_venta_id integer unsigned not null,
	INDEX Puntos_venta_FKIndex(punto_venta_id),
	unique(vendedor_user),
	foreign key (punto_venta_id)
		references Puntos_venta(puntos_id)
			on delete no action
);

INSERT INTO ppa_disenio.paises (pais_id,pais_name) values (1,'Argentina');
/*provincias*/
INSERT INTO ppa_disenio.provincias (provincia_id,Paises_pais_id,provincia_name)
VALUES (1,1,'Buenos Aires') ;
insert into provincias values (2,1,'CABA'); 
/*localidades*/
INSERT INTO ppa_disenio.localidades (localidad_id,Provincias_provincia_id,localidad_name) 
VALUES (1,1,'Banfield');
insert into localidades values (2,1,'CABA'); 
/*estadios*/
INSERT INTO ppa_disenio.estadios (estadio_id,Localidades_localidad_id,estadio_nombre)
values (1,1,'Lanu');
	/* Sectores Lanu */
	insert into Sectores values (1,1,'Verde',30.0);
		/* filas sector verde */
		insert into filas values (1,1,1,30.0);
			/* butacas */
			insert into butacas values (1,1,1,true);
			insert into butacas values (2,1,1,true);
			insert into butacas values (3,1,1,true);
			insert into butacas values (4,1,1,true);
			insert into butacas values (5,1,1,true);
	insert into Sectores values (2,1,'Azul',60.0);
		/* filas sector azul */
		insert into filas values (2,2,1,30.0);
			/* butacas */
			insert into butacas values (6,2,1,true);
			insert into butacas values (7,2,1,true);
			insert into butacas values (8,2,1,true);
			insert into butacas values (9,2,1,true);
			insert into butacas values (10,2,1,true);
	insert into Sectores values (3,1,'Dorado',120.0);
		/* filas sector dorado */
		insert into filas values (3,3,1,30.0);
			/* butacas */
			insert into butacas values (11,3,1,true);
			insert into butacas values (12,3,1,true);
			insert into butacas values (13,3,1,true);
			insert into butacas values (14,3,1,true);
			insert into butacas values (15,3,1,true);
insert into estadios values (2,2,'River'); 
	/* Sectores River */
	insert into Sectores values (4,2,'Rojo',50.0);
		/* filas sector rojo */
		insert into filas values (4,4,1,30.0);
			/* butacas */
			insert into butacas values (16,4,1,true);
			insert into butacas values (17,4,1,true);
			insert into butacas values (18,4,1,true);
			insert into butacas values (19,4,1,true);
			insert into butacas values (20,4,1,true);
	insert into Sectores values (5,2,'Blanco',80.0);
		/* filas sector blanco */
		insert into filas values (5,5,1,30.0);
			/* butacas */
			insert into butacas values (21,5,1,true);
			insert into butacas values (22,5,1,true);
			insert into butacas values (23,5,1,true);
			insert into butacas values (24,5,1,true);
			insert into butacas values (25,5,1,true);
	insert into Sectores values (6,2,'Plateado',150.0);
		/* filas sector plateado */
		insert into filas values (6,6,1,30.0);
			/* butacas */
			insert into butacas values (26,6,1,true);
			insert into butacas values (27,6,1,true);
			insert into butacas values (28,6,1,true);
			insert into butacas values (29,6,1,true);
			insert into butacas values (30,6,1,true);
insert into estadios values (3,2,'Obras'); 
	/* Sectores Obras */
	insert into Sectores values (7,3,'Amarillo',60.0);
		/* filas sector amarillo */
		insert into filas values (7,7,1,30.0);
			/* butacas */
			insert into butacas values (31,7,1,true);
			insert into butacas values (32,7,1,true);
			insert into butacas values (33,7,1,true);
			insert into butacas values (34,7,1,true);
			insert into butacas values (35,7,1,true);
	insert into Sectores values (8,3,'Naranja',85.0);
		/* filas sector naraja */
		insert into filas values (8,8,1,30.0);
			/* butacas */
			insert into butacas values (36,8,1,true);
			insert into butacas values (37,8,1,true);
			insert into butacas values (38,8,1,true);
			insert into butacas values (39,8,1,true);
			insert into butacas values (40,8,1,true);
	insert into Sectores values (9,3,'Oro',170.0);
		/* filas sector oro */
		insert into filas values (9,9,1,30.0);
			/* butacas */
			insert into butacas values (41,9,1,true);
			insert into butacas values (42,9,1,true);
			insert into butacas values (43,9,1,true);
			insert into butacas values (44,9,1,true);
			insert into butacas values (45,9,1,true);

/* categorias */
insert into categorias values (1,0);
insert into categorias values (2,50);
insert into categorias values (3,100);
insert into categorias values (4,200);
/*bandas*/
insert into bandas values (1,4,'Black Sabbat');
insert into bandas values (2,4,'Metallica');
insert into bandas values (3,3,'Almafuerte');
insert into bandas values (4,3,'Rata Blanca');
insert into bandas values (5,2,'Tren Loco');
insert into bandas values (6,3,'Damas Gratis');
insert into bandas values (7,4,'Sonora Dinamita');
insert into bandas values (8,3,'La Liga');

/* festvales */
insert into festival values (1,2,'2013-12-18','Isenbeck Cumbia'); 
/* puntos de venta */
insert into puntos_venta values (1,1,2,'estadio','direccion estadio'); 

/* puntos del "Isenbeck Cumbia" */
insert into punto_festival values (1,1,1);

/* noches de "Isenbeck Cumbia" */
insert into noches values (1,1,2,'2013-12-18','20:00',1);
insert into noches values (2,1,2,'2013-12-19','20:00',2);

/* bandas noche 1 "Isenbeck Cumbia" */
insert into banda_noche values (1,8,'20:00','20:59');
insert into banda_noche values (1,6,'21:00','21:59');
/* bandas noche 2 "Isenbeck Cumbia" */
insert into banda_noche values (2,7,'20:00','21:29');

/* vendedores */
insert into vendedores values (1,'Diego','diegob','bugaboo',1);
insert into vendedores values (2,'Dani','danib','bugaboo',1);
insert into vendedores values (3,'Ger','gerb','bugaboo',1);
insert into vendedores values (4,'Emi','emic','bugaboo',1);
insert into vendedores values (5,'Nacho','nachov','bugaboo',1);