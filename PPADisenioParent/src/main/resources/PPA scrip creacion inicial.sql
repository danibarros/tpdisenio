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

CREATE TABLE ppa_disenio.Entradas (
  entrda_id INTEGER UNSIGNED NOT NULL ,
  Noches_noche_id INTEGER UNSIGNED NOT NULL,
  codigo_barra INTEGER UNSIGNED NOT NULL,
  entrada_fecha DATE NOT NULL,
  entrada_precio FLOAT NOT NULL,
  entrada_tipo VARCHAR(1) NOT NULL,
  cliente_name VARCHAR(50) NOT NULL,
  cliente_dni INTEGER UNSIGNED NOT NULL,
  entrada_anticipada BOOL NULL,
  PRIMARY KEY(entrda_id),
  INDEX Entradas_FKIndex1(Noches_noche_id),
  FOREIGN KEY(Noches_noche_id)
    REFERENCES Noches(noche_id)
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
  Entradas_entrda_id INTEGER UNSIGNED NOT NULL,
  Localidades_localidad_id INTEGER UNSIGNED NOT NULL,
  punto_name VARCHAR(50) NOT NULL,
  punto_direccion VARCHAR(45) NULL,
  PRIMARY KEY(puntos_id),
  INDEX Puntos_venta_FKIndex1(Localidades_localidad_id),
  INDEX Puntos_venta_FKIndex2(Entradas_entrda_id),
  INDEX Puntos_venta_FKIndex3(Festival_festival_id),
  FOREIGN KEY(Localidades_localidad_id)
    REFERENCES Localidades(localidad_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Entradas_entrda_id)
    REFERENCES Entradas(entrda_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(Festival_festival_id)
    REFERENCES Festival(festival_id)
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