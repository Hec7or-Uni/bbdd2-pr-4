DROP TABLE SYSTEM.TIENEN;
DROP TABLE SYSTEM.OPERACIONES;
DROP TABLE SYSTEM.CUENTAS;
DROP TABLE SYSTEM.OFICINAS;
DROP TABLE SYSTEM.CLIENTES;

CREATE TABLE CLIENTES (
    DNI             VARCHAR(9)      PRIMARY KEY,
    nombre          VARCHAR(30)     NOT NULL,
    apellido        VARCHAR(30)     NOT NULL,
    email           VARCHAR(75),
    telefono        VARCHAR(15)     NOT NULL,
    fechaNacimiento DATE            NOT NULL ,
    direccion       VARCHAR(50)     NOT NULL,
    edad            INTEGER         NOT NULL
);

CREATE TABLE OFICINAS (
    codigo          INTEGER         PRIMARY KEY,
    telefono        VARCHAR(15)     NOT NULL,
    direccion       VARCHAR(255)    NOT NULL
);

CREATE TABLE CUENTAS (
    IBAN            VARCHAR(40)     PRIMARY KEY,
    fechaCreacion   TIMESTAMP       NOT NULL,
    saldo           NUMBER          DEFAULT(0),
    tipoCuenta      VARCHAR(9)      NOT NULL,
    interes         DECIMAL(4,3),
    oficina         INTEGER         NULL,
    CHECK (tipoCuenta IN ('AHORRO', 'CORRIENTE')),
    CHECK ((tipoCuenta = 'AHORRO' AND oficina IS NULL AND interes IS NOT NULL) OR (tipoCuenta = 'CORRIENTE' AND oficina IS NOT NULL AND interes IS NULL)),
    FOREIGN KEY (oficina)   REFERENCES oficinas(codigo)
);

CREATE TABLE OPERACIONES (
    codigo          VARCHAR(36),
    cantidad        NUMBER			NOT NULL,
    timestamp       TIMESTAMP       NOT NULL,
    tipoOp          VARCHAR(15) NOT NULL,
    descripcion     VARCHAR(255),
    cuentaEmisora   VARCHAR(40)		NOT NULL,
    cuentaReceptora VARCHAR(40)		NULL,
    oficina         INTEGER         NULL,
    CHECK ((tipoOp = 'INGRESO' AND cuentaReceptora IS NULL AND oficina IS NOT NULL) OR (tipoOp = 'RETIRADA' AND cuentaReceptora IS NULL AND oficina IS NOT NULL) OR (tipoOp = 'TRANSFERENCIA' AND cuentaReceptora IS NOT NULL AND oficina IS NULL)),
    PRIMARY KEY (codigo),
    FOREIGN KEY (cuentaEmisora)     REFERENCES CUENTAS(IBAN),
    FOREIGN KEY (cuentaReceptora)   REFERENCES CUENTAS(IBAN),
    FOREIGN KEY (oficina)           REFERENCES OFICINA(codigo)
);

CREATE TABLE TIENEN (
    DNI     VARCHAR(9),
    IBAN    VARCHAR(40),
    PRIMARY KEY (DNI, IBAN),
    FOREIGN KEY (DNI)       REFERENCES clientes(DNI),
    FOREIGN KEY (IBAN)		REFERENCES cuentas(IBAN)
);
