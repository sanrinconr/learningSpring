# Create schemas

# Create tables
CREATE TABLE IF NOT EXISTS Empleado
(
    nLegajo INT NOT NULL,
    dni INT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    f_nacimiento DATE,
    f_ingreso DATE,
    cargo VARCHAR(255),
    sueldo_neto DECIMAL(14, 2),
    departamento_id INT,
    PRIMARY KEY(nLegajo)
);

CREATE TABLE IF NOT EXISTS Departamento
(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(100),
    direccion VARCHAR(100),
    PRIMARY KEY(id)
);


# Create FKs
ALTER TABLE Empleado
    ADD    FOREIGN KEY (departamento_id)
    REFERENCES Departamento(id)
;
    

# Create Indexes

