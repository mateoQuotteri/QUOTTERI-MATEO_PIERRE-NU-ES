DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS (
                             ID INT AUTO_INCREMENT PRIMARY KEY,
                             NOMBRE VARCHAR(50) NOT NULL,
                             APELLIDO VARCHAR(50) NOT NULL,
                             NUMERO_MATRICULA INT NOT NULL
);
