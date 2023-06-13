-- Creación de esquemas y usuarios:
CREATE SCHEMA juan;

-- Crear la base de datos
CREATE DATABASE nombre_basedatos;

-- Conectar a la base de datos
\c nombre_basedatos;

-- Crear la tabla Persona
CREATE TABLE Persona (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(50),
  tipo_usuario VARCHAR(10) NOT NULL
);

-- Crear la tabla Cliente
CREATE TABLE Cliente (
  id SERIAL PRIMARY KEY,
  persona_id INT REFERENCES Persona(id),
  CONSTRAINT cliente_persona_fk FOREIGN KEY (persona_id) REFERENCES Persona(id)
);

-- Crear la tabla Trabajador
CREATE TABLE Trabajador (
  id SERIAL PRIMARY KEY,
  persona_id INT REFERENCES Persona(id),
  CONSTRAINT trabajador_persona_fk FOREIGN KEY (persona_id) REFERENCES Persona(id)
);

-- Crear la tabla CCorriente
CREATE TABLE CCorriente (
  id SERIAL PRIMARY KEY,
  cliente_id INT REFERENCES Cliente(id),
  saldo DECIMAL(10, 2) DEFAULT 0,
  CONSTRAINT ccorriente_cliente_fk FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

-- Crear la tabla CAhorro
CREATE TABLE CAhorro (
  id SERIAL PRIMARY KEY,
  cliente_id INT REFERENCES Cliente(id),
  saldo DECIMAL(10, 2) DEFAULT 0,
  CONSTRAINT cahorro_cliente_fk FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

-- Crear la tabla Seguro
CREATE TABLE Seguro (
  id SERIAL PRIMARY KEY,
  cahorro_id INT REFERENCES CAhorro(id),
  CONSTRAINT seguro_cahorro_fk FOREIGN KEY (cahorro_id) REFERENCES CAhorro(id)
);

-- Crear los usuarios
CREATE ROLE admin LOGIN PASSWORD 'admin_password';
CREATE ROLE cliente LOGIN PASSWORD 'cliente_password';
CREATE ROLE trabajador LOGIN PASSWORD 'trabajador_password';

-- Asignar los permisos a los usuarios
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO admin;
GRANT SELECT ON TABLE Persona TO cliente, trabajador;
GRANT SELECT, UPDATE ON TABLE CCorriente, CAhorro TO cliente, trabajador;
GRANT SELECT, INSERT, UPDATE ON TABLE Seguro TO cliente, trabajador;

-- Crear la función ingresar() (aquí solo se define la llamada, no el cuerpo de la función)
CREATE FUNCTION ingresar() RETURNS VOID LANGUAGE plpgsql AS $$
BEGIN
  RAISE NOTICE 'Se ha llamado al método ingresar() con los argumentos: %', TG_ARGV;
END;
$$;

-- Crear la función sacar() (aquí solo se define la llamada, no el cuerpo de la función)
CREATE FUNCTION sacar() RETURNS VOID LANGUAGE plpgsql AS $$
BEGIN
  RAISE NOTICE 'Se ha llamado al método sacar() con los argumentos: %', TG_ARGV;
END;
$$;

-- Asignar los permisos para ejecutar las funciones a los usuarios
GRANT EXECUTE ON FUNCTION ingresar() TO cliente;
GRANT EXECUTE ON FUNCTION sacar() TO cliente, trabajador;
