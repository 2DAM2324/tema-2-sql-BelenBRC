PRAGMA foreign_keys = ON;
BEGIN TRANSACTION;
CREATE TABLE foto_perfil(
    id_foto_perfil  INTEGER         PRIMARY KEY AUTOINCREMENT,
    nombre_foto     VARCHAR(100)    NOT NULL,
    resolucion_mpx  INTEGER         NOT NULL    CHECK (resolucion_mpx > 0),
    tamanio_kb      INTEGER         NOT NULL    CHECK (tamanio_kb > 0)
);
INSERT INTO foto_perfil VALUES(1,'foto_perfil_1.jpg',12,100);
INSERT INTO foto_perfil VALUES(2,'foto_perfil_2.jpg',8,80);
INSERT INTO foto_perfil VALUES(3,'foto_perfil_3.jpg',10,90);
INSERT INTO foto_perfil VALUES(4,'foto_perfil_4.jpg',15,120);
INSERT INTO foto_perfil VALUES(5,'foto_perfil_5.jpg',20,150);
CREATE TABLE usuario(
    id_usuario      INTEGER         PRIMARY KEY AUTOINCREMENT,
    nombre          VARCHAR(50)     NOT NULL,
    apellido1       VARCHAR(50)     NOT NULL,
    apellido2       VARCHAR(50),
    email           VARCHAR(100)    NOT NULL    CHECK (email GLOB '*@*.*'),
    password        VARCHAR(100)    NOT NULL    CHECK (LENGTH(password) > 3),
    dni             VARCHAR(9)      NOT NULL    CHECK (LENGTH(dni) = 9) UNIQUE,
    id_foto_perfil  INTEGER,   -- OptimizaciÃ³n 1:1
    FOREIGN KEY (id_foto_perfil)   REFERENCES foto_perfil(id_foto_perfil)
);
INSERT INTO usuario VALUES(1,'Belén','Robustillo','Carmona','brc@gmail.com','1234','00000001R',1);
INSERT INTO usuario VALUES(2,'Juan', 'García', 'Pérez', 'jgp@gmail.com', '1234', '00000002W', 2);
INSERT INTO usuario VALUES(3,'María', 'Pérez', 'Ruiz', 'mgp@gmail.com', '1234', '00000003A', 3);
INSERT INTO usuario VALUES(4,'Pedro','Robles','Paz','prp@gmail.com','1234','00000004G',4);
INSERT INTO usuario VALUES(5,'Ana', 'López', 'Tena', 'alt@gmail.com', '1234', '00000005M', 5);
INSERT INTO usuario VALUES(6,'Sara','Hash',NULL,'sh@gmail.com','1234','00000006Y',NULL);
INSERT INTO usuario VALUES(7,'Juan', 'García', 'Pérez','jgperez@gmail.com','1234','00000007F',NULL);
CREATE TABLE ruta(
    id_ruta             INTEGER         PRIMARY KEY AUTOINCREMENT,
    nombre_ruta         VARCHAR(100)    NOT NULL,
    descripcion         VARCHAR(500),
    distancia_km        DECIMAL(3,2)    NOT NULL    CHECK (distancia_km > 0),
    dificultad          VARCHAR(5)      NOT NULL    CHECK (dificultad IN ('BAJA', 'MEDIA', 'ALTA')),
    tiempo_h            DECIMAL(2,2)    NOT NULL    CHECK (tiempo_h > 0),
    puntuacion_media    DECIMAL(2,2)                CHECK (puntuacion_media >= 0 AND puntuacion_media <= 5),
    id_usuario          INTEGER         NOT NULL,   -- OptimizaciÃ³n 1:N
    UNIQUE (nombre_ruta, id_usuario),               -- Asegurar que no hay dos rutas con el mismo nombre para un mismo usuario
    FOREIGN KEY (id_usuario)    REFERENCES usuario(id_usuario)
);
INSERT INTO ruta VALUES(1,'Ruta 1','Ruta por el bosque helado',10,'BAJA',2,NULL,1);
INSERT INTO ruta VALUES(2,'Ruta 2','Ruta por la playa',5,'BAJA',1,NULL,2);
INSERT INTO ruta VALUES(3,'Ruta 3','Ruta por la montaña',15,'MEDIA',3,NULL,3);
INSERT INTO ruta VALUES(4,'Ruta 4','Ruta por el bosque',10,'BAJA',2,NULL,5);
INSERT INTO ruta VALUES(5,'Ruta 5','Ruta navideña',21,'ALTA',4,NULL,6);
INSERT INTO ruta VALUES(6,'Ruta 6','Ruta por el bosque',10,'BAJA',2,NULL,7);
INSERT INTO ruta VALUES(7,'Ruta 7','Ruta por el bosque',10,'BAJA',2,NULL,7);
CREATE TABLE categoria(
    id_categoria    INTEGER         PRIMARY KEY AUTOINCREMENT,
    nombre          VARCHAR(50)     NOT NULL    UNIQUE  CHECK (nombre GLOB '*[a-zA-Z]*')
);
INSERT INTO categoria VALUES(1,'Bosque');
INSERT INTO categoria VALUES(2,'Montaña');
INSERT INTO categoria VALUES(3,'Playa');
INSERT INTO categoria VALUES(4,'Nieve');
INSERT INTO categoria VALUES(5,'Navidad');
INSERT INTO categoria VALUES(6,'Verano');
INSERT INTO categoria VALUES(7,'Invierno');
INSERT INTO categoria VALUES(8,'Primavera');
INSERT INTO categoria VALUES(9,'Otoño');
INSERT INTO categoria VALUES(10,'Pet Friendly');
INSERT INTO categoria VALUES(11,'Accesible');
INSERT INTO categoria VALUES(12,'Familiar');
CREATE TABLE valoracion(                          -- RelaciÃ³n N:M
    id_usuario      INTEGER             NOT NULL,
    id_ruta         INTEGER             NOT NULL,
    comentario      VARCHAR(500),
    puntuacion      INTEGER             NOT NULL    CHECK (puntuacion >= 1 AND puntuacion <= 5),
    PRIMARY KEY (id_usuario, id_ruta),
    FOREIGN KEY (id_usuario)    REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_ruta)       REFERENCES ruta(id_ruta)
);
INSERT INTO valoracion VALUES(1,1,'Me ha encantado',5);
INSERT INTO valoracion VALUES(3,1,'Me ha gustado',3);
INSERT INTO valoracion VALUES(5,1,'No me ha gustado',1);
INSERT INTO valoracion VALUES(7,1,'Me ha encantado',5);
INSERT INTO valoracion VALUES(1,2,'Me ha encantado',5);
INSERT INTO valoracion VALUES(2,2,'Muy bonita',4);
INSERT INTO valoracion VALUES(3,2,'Me ha gustado',3);
INSERT INTO valoracion VALUES(4,2,'No me ha gustado',2);
INSERT INTO valoracion VALUES(6,2,'Me ha encantado',5);
INSERT INTO valoracion VALUES(7,2,'Me ha encantado',5);
INSERT INTO valoracion VALUES(2,3,'Muy bonita',4);
INSERT INTO valoracion VALUES(3,3,'Me ha gustado',3);
INSERT INTO valoracion VALUES(5,3,'No me ha gustado',1);
INSERT INTO valoracion VALUES(7,3,'Me ha encantado',5);
INSERT INTO valoracion VALUES(2,4,'Muy bonita',4);
INSERT INTO valoracion VALUES(3,4,'Me ha gustado',3);
INSERT INTO valoracion VALUES(5,4,'No me ha gustado',1);
INSERT INTO valoracion VALUES(7,4,'Me ha encantado',5);
INSERT INTO valoracion VALUES(1,5,'Me ha encantado',5);
INSERT INTO valoracion VALUES(2,5,'Muy bonita',4);
INSERT INTO valoracion VALUES(3,5,'Me ha gustado',3);
INSERT INTO valoracion VALUES(4,5,'No me ha gustado',2);
INSERT INTO valoracion VALUES(2,6,'Muy bonita',4);
INSERT INTO valoracion VALUES(3,6,'Me ha gustado',3);
INSERT INTO valoracion VALUES(7,7,'Me ha encantado',5);
CREATE TABLE clasificacion(                       -- RelaciÃ³n N:M
    id_categoria        INTEGER             NOT NULL,
    id_ruta             INTEGER             NOT NULL,
    PRIMARY KEY (id_categoria, id_ruta),
    FOREIGN KEY (id_categoria)  REFERENCES categoria(id_categoria),
    FOREIGN KEY (id_ruta)       REFERENCES ruta(id_ruta)
);
INSERT INTO clasificacion VALUES(1,1);
INSERT INTO clasificacion VALUES(1,2);
INSERT INTO clasificacion VALUES(1,3);
INSERT INTO clasificacion VALUES(2,6);
INSERT INTO clasificacion VALUES(3,2);
INSERT INTO clasificacion VALUES(3,7);
INSERT INTO clasificacion VALUES(4,1);
INSERT INTO clasificacion VALUES(6,4);
INSERT INTO clasificacion VALUES(6,7);
INSERT INTO clasificacion VALUES(7,5);
INSERT INTO clasificacion VALUES(7,6);
INSERT INTO clasificacion VALUES(7,7);
INSERT INTO clasificacion VALUES(8,4);
INSERT INTO clasificacion VALUES(8,5);
INSERT INTO clasificacion VALUES(8,6);
INSERT INTO clasificacion VALUES(8,7);
INSERT INTO clasificacion VALUES(9,6);
INSERT INTO clasificacion VALUES(9,7);
INSERT INTO clasificacion VALUES(10,1);
INSERT INTO clasificacion VALUES(12,1);
INSERT INTO clasificacion VALUES(12,7);
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('foto_perfil',5);
INSERT INTO sqlite_sequence VALUES('usuario',7);
INSERT INTO sqlite_sequence VALUES('ruta',7);
INSERT INTO sqlite_sequence VALUES('categoria',12);
COMMIT;