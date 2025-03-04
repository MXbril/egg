CREATE DATABASE libreria
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS libro (
    isbn BIGINT NOT NULL AUTO_INCREMENT,  -- 'isbn' como clave primaria auto-incremental
    titulo VARCHAR(255) NOT NULL,         -- El título del libro
    anio INT,                             -- El año de publicación
    ejemplares INT,                       -- La cantidad de ejemplares
    alta BOOLEAN,                         -- Si el libro está disponible
    autor_id BIGINT,                      -- Clave foránea hacia la tabla 'autor'
    editorial_id BIGINT,                  -- Clave foránea hacia la tabla 'editorial'
    PRIMARY KEY (isbn),                   -- 'isbn' como clave primaria
    FOREIGN KEY (autor_id) REFERENCES autor(id),         -- Relación con la tabla 'autor'
    FOREIGN KEY (editorial_id) REFERENCES editorial(id)  -- Relación con la tabla 'editorial'
);

USE libreria;
SHOW TABLES;
SELECT * FROM autor;
