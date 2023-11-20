--Belén Robustillo Carmona

CREATE DATABASE IF NOT EXISTS `rutas` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `rutas`;

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS foto_perfil(
    id_foto_perfil  INTEGER         PRIMARY KEY AUTOINCREMENT,
    nombre_foto     VARCHAR(100)    NOT NULL,
    resolucion_mpx  INTEGER         NOT NULL    CHECK (resolucion_mpx > 0),
    tamanio_kb      INTEGER         NOT NULL    CHECK (tamanio_kb > 0)
) LIKE rutas.foto_perfil;

CREATE TABLE IF NOT EXISTS usuario(
    id_usuario      INTEGER         PRIMARY KEY AUTOINCREMENT,
    nombre          VARCHAR(50)     NOT NULL,
    apellido1       VARCHAR(50)     NOT NULL,
    apellido2       VARCHAR(50),
    email           VARCHAR(100)    NOT NULL    CHECK (validarEmail(email)),
    password        VARCHAR(100)    NOT NULL,
    dni             VARCHAR(9)      NOT NULL    CHECK (validarDNI(dni))    UNIQUE,
    id_foto_perfil  INTEGER                     ,   -- Optimización 1:1
    FOREIGN KEY (id_foto_perfil)   REFERENCES foto_perfil(id_foto_perfil)
);

CREATE TABLE IF NOT EXISTS ruta(
    id_ruta             INTEGER         PRIMARY KEY AUTOINCREMENT,
    nombre_ruta         VARCHAR(100)    NOT NULL,
    descripcion         VARCHAR(500),
    distancia_km        DECIMAL(3,2)    NOT NULL    CHECK (distancia_km > 0),
    dificultad          VARCHAR(5)      NOT NULL    CHECK (dificultad IN ('BAJA', 'MEDIA', 'ALTA')),
    tiempo_h            DECIMAL(2,2)    NOT NULL    CHECK (tiempo_h > 0),
    puntuacion_media    DECIMAL(2,2)                CHECK (puntuacion_media >= 0 AND puntuacion_media <= 5),
    id_usuario          INTEGER         NOT NULL,   -- Optimización 1:N
    UNIQUE (nombre_ruta, id_usuario),               -- Asegurar que no hay dos rutas con el mismo nombre para un mismo usuario
    FOREIGN KEY (id_usuario)    REFERENCES usuario(id_usuario)
);

CREATE TABLE IF NOT EXISTS categoria(
    id_categoria    INTEGER         PRIMARY KEY AUTOINCREMENT,
    nombre          VARCHAR(50)     NOT NULL    UNIQUE  CHECK (nombre LIKE '%[a-zA-Z]%')
);

CREATE TABLE IF NOT EXISTS valoracion(                          -- Relación N:M
    id_usuario      INTEGER             NOT NULL,
    id_ruta         INTEGER             NOT NULL,
    comentario      VARCHAR(500),
    puntuacion      INTEGER             NOT NULL    CHECK (puntuacion >= 1 AND puntuacion <= 5),
    PRIMARY KEY (id_usuario, id_ruta),
    FOREIGN KEY (id_usuario)    REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_ruta)       REFERENCES ruta(id_ruta)
);

CREATE TABLE IF NOT EXISTS clasificacion(                       -- Relación N:M
    id_categoria        INTEGER             NOT NULL,
    id_ruta             INTEGER             NOT NULL,
    PRIMARY KEY (id_categoria, id_ruta),
    FOREIGN KEY (id_categoria)  REFERENCES categoria(id_categoria),
    FOREIGN KEY (id_ruta)       REFERENCES ruta(id_ruta)
);

-- -----------------------------------------------------

CREATE FUNCTION IF NOT EXISTS validarDNI(dni VARCHAR(9)) RETURNS BOOLEAN AS
BEGIN
    DECLARE letras          VARCHAR(23)     DEFAULT 'TRWAGMYFPDXBNJZSQVHLCKE';
    DECLARE letra           VARCHAR(1)      DEFAULT UPPER(SUBSTR(dni, -1));
    DECLARE numero          INTEGER         DEFAULT CAST(SUBSTR(dni, 1, LENGTH(dni) - 1) AS INTEGER);
    DECLARE resto           INTEGER         DEFAULT numero % 23;
    DECLARE letra_correcta  VARCHAR(1)      DEFAULT SUBSTR(letras, resto + 1, 1);
    RETURN  letra = letra_correcta;
END;

CREATE FUNCTION IF NOT EXISTS validarEmail(email VARCHAR(100)) RETURNS BOOLEAN AS
'SELECT email REGEXP ''^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$''';

-- -----------------------------------------------------

INSERT INTO foto_perfil(nombre_foto, resolucion_mpx, tamanio_kb) VALUES
    ('foto_perfil_1.jpg', 12, 100),
    ('foto_perfil_2.jpg', 8, 80),
    ('foto_perfil_3.jpg', 10, 90),
    ('foto_perfil_4.jpg', 15, 120),
    ('foto_perfil_5.jpg', 20, 150);

INSERT INTO usuario(nombre, apellido1, apellido2, email, password, dni, id_foto_perfil) VALUES
    ('Belén', 'Robustillo', 'Carmona', 'brc@gmail.com', '1234', '00000001R', 1),
    ('Juan', 'García', 'Pérez', 'jgp@gmail.com', '1234', '00000002W', 2),
    ('María', 'Pérez', 'Ruiz', 'mgp@gmail.com', '1234', '00000003A', 3),
    ('Pedro', 'Robles', 'Paz', 'prp@gmail.com', '1234', '00000004G', 4),
    ('Ana', 'López', 'Tena', 'alt@gmail.com', '1234', '00000005M', 5),
    ('Sara', 'Hash', null, 'sh@gmail.com', '1234', '00000006Y', null),
    ('Juan', 'García', 'Pérez', 'jgperez@gmail.com', '1234', '00000007F', null);

INSERT INTO ruta(nombre_ruta, descripcion, distancia_km, dificultad, tiempo_h, puntuacion_media, id_usuario) VALUES
    ('Ruta 1', 'Ruta por el bosque helado', 10, 'BAJA', 2, null, 1),
    ('Ruta 2', 'Ruta por la playa', 5, 'BAJA', 1, null, 2),
    ('Ruta 3', 'Ruta por la montaña', 15, 'MEDIA', 3, null, 3),
    ('Ruta 4', 'Ruta por el bosque', 10, 'BAJA', 2, null, 5),
    ('Ruta 5', 'Ruta navideña', 21, 'ALTA', 4, null, 6),
    ('Ruta 6', 'Ruta por el bosque', 10, 'BAJA', 2, null, 7),
    ('Ruta 7', 'Ruta por el bosque', 10, 'BAJA', 2, null, 7);

INSERT INTO categoria(nombre) VALUES
    ('Bosque'),
    ('Montaña'),
    ('Playa'),
    ('Nieve'),
    ('Navidad'),
    ('Verano'),
    ('Invierno'),
    ('Primavera'),
    ('Otoño'),
    ('Pet Friendly'),
    ('Accesible'),
    ('Familiar');

INSERT INTO valoracion(id_usuario, id_ruta, comentario, puntuacion) VALUES
    (1, 1, 'Me ha encantado', 5),
    (3, 1, 'Me ha gustado', 3),
    (5, 1, 'No me ha gustado', 1),
    (7, 1, 'Me ha encantado', 5),
    (1, 2, 'Me ha encantado', 5),
    (2, 2, 'Muy bonita', 4),
    (3, 2, 'Me ha gustado', 3),
    (4, 2, 'No me ha gustado', 2),
    (6, 2, 'Me ha encantado', 5),
    (7, 2, 'Me ha encantado', 5),
    (2, 3, 'Muy bonita', 4),
    (3, 3, 'Me ha gustado', 3),
    (5, 3, 'No me ha gustado', 1),
    (7, 3, 'Me ha encantado', 5),
    (2, 4, 'Muy bonita', 4),
    (3, 4, 'Me ha gustado', 3),
    (5, 4, 'No me ha gustado', 1),
    (7, 4, 'Me ha encantado', 5),
    (1, 5, 'Me ha encantado', 5),
    (2, 5, 'Muy bonita', 4),
    (3, 5, 'Me ha gustado', 3),
    (4, 5, 'No me ha gustado', 2),
    (2, 6, 'Muy bonita', 4),
    (3, 6, 'Me ha gustado', 3),
    (7, 7, 'Me ha encantado', 5);

INSERT INTO clasificacion(id_categoria, id_ruta) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 6),
    (3, 2),
    (3, 7),
    (4, 1),
    (6, 4),
    (6, 7),
    (7, 5),
    (7, 6),
    (7, 7),
    (8, 4),
    (8, 5),
    (8, 6),
    (8, 7),
    (9, 6),
    (9, 7),
    (10, 1),
    (12, 1),
    (12, 7);

-- -----------------------------------------------------