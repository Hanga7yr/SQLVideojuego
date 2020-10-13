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

