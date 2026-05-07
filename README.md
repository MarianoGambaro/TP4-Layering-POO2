Tablas de sql punto 3

CREATE database poo2_tp4_LayersPt3;

create table concursos(
	id_concurso INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL
);

create table inscripciones(
dni varchar(20) NOT NULL,
apellido varchar(50) NOT NULL,
nombre varchar(50) NOT NULL,
telefono varchar(30) NOT NULL,
email varchar(50) NOT NULL,
id_concurso INT,
PRIMARY KEY(dni),

CONSTRAINT fk_concurso
	FOREIGN KEY(id_concurso)
	REFERENCES concursos(id_concurso) 
);
