CREATE DATABASE videojuego;

use videojuego;

CREATE TABLE habilidad(
	vida INT,
    energia INT,
    tipo VARCHAR(20),
    nombre VARCHAR(20) PRIMARY KEY NOT NULL
);

CREATE TABLE personaje(
    nombre VARCHAR(20) PRIMARY KEY NOT NULL,
    clase VARCHAR(20),
    vida_max INT,
    vida_actual INT,
    energia_max INT,
    energia_actual INT,
    monedas INT,
    npc BOOLEAN,
    hostil BOOLEAN,
    num_habilidades INT,
    num_equipo INT
);

CREATE TABLE personaje_habilidades(
	id INT PRIMARY KEY AUTO_INCREMENT,
    personaje VARCHAR(20) NOT NULL,
    habilidad VARCHAR(20) NOT NULL,
    CONSTRAINT per_fk FOREIGN KEY (personaje) REFERENCES personaje(nombre),
    CONSTRAINT hab_fk FOREIGN KEY (habilidad) REFERENCES habilidad(nombre)
);
/*
	protected String nombre;
	
	protected int valor;
	
	protected Habilidad acciones[];
	private int num_acciones;*/
CREATE TABLE item(
	nombre VARCHAR(20) NOT NULL PRIMARY KEY,
    item_type ENUM("Consumible", "Arma", "Armadura") NOT NULL,
    valor INT,
    acciones INT
);

CREATE TABLE item_habilidad(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    item VARCHAR(20) NOT NULL,
    habilidad VARCHAR(20) NOT NULL,
    CONSTRAINT item_habilidad_item_fk FOREIGN KEY (item) REFERENCES item(nombre),
    CONSTRAINT item_habilidad_habilidad_fk FOREIGN KEY (habilidad) REFERENCES habilidad(nombre)
);

CREATE TABLE consumible(
	nombre_item VARCHAR(20) NOT NULL PRIMARY KEY,
    cantidad INT,
    CONSTRAINT consumible_item FOREIGN KEY (nombre_item) REFERENCES item(nombre)
);

CREATE TABLE arma(
	nombre_item VARCHAR(20) NOT NULL PRIMARY KEY,
    agravio INT,
    peso INT,
    CONSTRAINT arma_item FOREIGN KEY (nombre_item) REFERENCES item(nombre)
);

CREATE TABLE armadura(
	nombre_item VARCHAR(20) NOT NULL PRIMARY KEY,
    armadura INT,
    peso INT,
    CONSTRAINT armadura_item FOREIGN KEY (nombre_item) REFERENCES item(nombre)
);

CREATE TABLE item_personaje(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item VARCHAR(20) NOT NULL,
    personaje VARCHAR(20) NOT NULL,
    CONSTRAINT item_personaje_item_fk FOREIGN KEY (item) REFERENCES item(nombre),
    CONSTRAINT item_personaje_personaje_fk FOREIGN KEY (personaje) REFERENCES personaje(nombre)
);