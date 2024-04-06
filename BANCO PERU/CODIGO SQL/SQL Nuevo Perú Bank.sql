CREATE DATABASE PERU_BANK_NUEVO;

USE PERU_BANK_NUEVO;
DROP table  Historial_Crediticio;

CREATE TABLE Clientes (
    ID_Cliente INT PRIMARY KEY,
    DNI VARCHAR(8),
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Direccion VARCHAR(30),
    Teléfono VARCHAR(15),
    Correo VARCHAR(30),
    Fecha_Nacimiento VARCHAR(15)
);

CREATE TABLE Cuentas (
    ID_Cuenta INT PRIMARY KEY,
    Tipo_Cuenta VARCHAR(20),
    Fecha_Apertura VARCHAR(15),
    Estado VARCHAR(10)
);

CREATE TABLE Transacciones (
    ID_Transaccion INT PRIMARY KEY,
    ID_Cuenta VARCHAR(20),
    Tipo VARCHAR(20),
    Monto VARCHAR(15),
    Fecha VARCHAR(15),
    ID_Cuenta_Asociada VARCHAR(20) -- Aumenta el tamaño según sea necesario
);


DROP TABLE Transacciones;

CREATE TABLE Prestamos (
    ID_Préstamo INT PRIMARY KEY,
    ID_Cliente VARCHAR(8),
    Tipo_Prestamo VARCHAR(20),
    Monto_Otorgado VARCHAR(15),
    Tasa_Interes VARCHAR(20),
    Fecha_Inicio VARCHAR(15),
    Fecha_Termino VARCHAR(15)
);

CREATE TABLE Sucursales (
    ID_Sede INT PRIMARY KEY,
    Direccion VARCHAR(100),
    Telefono VARCHAR(9),
    Correo VARCHAR(30),
    Gerente VARCHAR(50)
);

CREATE TABLE Empleados (
    ID_Empleado INT PRIMARY KEY,
    DNI VARCHAR(8),
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Teléfono VARCHAR(9),
    Correo VARCHAR(30),
    Área_trabaja VARCHAR(40),
    ID_Sucursal VARCHAR(4),
    Fecha_Contratacion VARCHAR(15)
);

CREATE TABLE Operaciones_Bancarias (
    ID_Operacion INT PRIMARY KEY,
    Descripcion VARCHAR(30),
    Comisiones VARCHAR(15),
    Restricciones VARCHAR(40)
);

CREATE TABLE Historial_Crediticio (
    ID_Cliente INT,
    Puntuacion_Credito VARCHAR(20),
    Reportes_Credito VARCHAR(50),
    Historial_Pagos VARCHAR(20)
);

INSERT INTO Clientes (ID_Cliente, DNI, Nombre, Apellido, Direccion, Teléfono, Correo, Fecha_Nacimiento)
VALUES
    (001234, '00145678', 'Juan', 'Perez', 'Comas', '987654321', 'juanperez20@gmail.com', '21-11-1990'),
    (001235, '00145679', 'Pedro', 'Gomez', 'Miraflores', '987654322', 'pedrogomez21@gmail.com', '15-05-1985'),
    (001236, '00145680', 'Maria', 'Lopez', 'San Isidro', '987654323', 'marialopez22@gmail.com', '10-10-1995'),
    (001237, '00145681', 'Carlos', 'Rodriguez', 'La Molina', '987654324', 'carlosrodriguez23@gmail.com', '25-12-1980'),
    (001238, '00145682', 'Ana', 'Martinez', 'Surco', '987654325', 'anamartinez24@gmail.com', '08-08-1978'),
    (001239, '00145683', 'Luis', 'Sanchez', 'Jesus Maria', '987654326', 'luissanchez25@gmail.com', '03-03-1993'),
    (001240, '00145684', 'Laura', 'Garcia', 'Lince', '987654327', 'lauragarcia26@gmail.com', '20-07-1987'),
    (001241, '00145685', 'Diego', 'Hernandez', 'Barranco', '987654328', 'diegohernandez27@gmail.com', '18-06-1990'),
    (001242, '00145686', 'Sofia', 'Perez', 'San Borja', '987654329', 'sofiaperez28@gmail.com', '12-04-1983'),
    (001243, '00145687', 'Alejandro', 'Diaz', 'Chorrillos', '987654330', 'alejandrodiaz29@gmail.com', '05-09-1975'),
    (001244, '00145688', 'Julia', 'Fernandez', 'Pueblo Libre', '987654331', 'juliafernandez30@gmail.com', '30-01-1998');
--
SELECT * FROM Clientes;
--


INSERT INTO Cuentas (ID_Cuenta, Tipo_Cuenta, Fecha_Apertura, Estado)
VALUES
    (123456789, 'Debito', '01-01-2021', 'Activa'),
    (123456790, 'Crédito', '02-01-2021', 'Inactiva'),
    (123456791, 'Ahorros', '03-01-2021', 'Activa'),
    (123456792, 'Débito', '04-01-2021', 'Activa'),
    (123456793, 'Ahorros', '05-01-2021', 'Inactiva'),
    (123456794, 'Crédito', '06-01-2021', 'Activa'),
    (123456795, 'Débito', '07-01-2021', 'Inactiva'),
    (123456796, 'Ahorros', '08-01-2021', 'Activa'),
    (123456797, 'Crédito', '09-01-2021', 'Activa'),
    (123456798, 'Débito', '10-01-2021', 'Inactiva'),
    (123456799, 'Crédito', '11-01-2021', 'Activa');
--
SELECT * FROM Cuentas;
--


INSERT INTO Transacciones (ID_Transaccion, ID_Cuenta, Tipo, Monto, Fecha, ID_Cuenta_Asociada)
VALUES
    (013, 123456790, 'Retiro', '500.00', '03-10-2024', NULL),
    (014, 123456791, 'Transferencia', '200.00', '03-10-2024', 123457790),
    (015, 123456792, 'Depósito', '1000.00', '03-10-2024', NULL),
    (016, 123456793, 'Retiro', '300.00', '03-10-2024', NULL),
    (017, 123456794, 'Transferencia', '400.00', '03-10-2024', 123457791),
    (018, 123456795, 'Depósito', '1500.00', '03-10-2024', NULL),
    (019, 123456796, 'Retiro', '700.00', '03-10-2024', NULL),
    (020, 123456797, 'Transferencia', '800.00', '03-10-2024', 123457792),
    (021, 123456798, 'Depósito', '2000.00', '03-10-2024', NULL),
    (022, 123456799, 'Retiro', '900.00', '03-10-2024', NULL),
    (012, 123456789, 'Depósito', '1000.00', '03-10-2024', 123457789);
--
SELECT * FROM Transacciones;
--


INSERT INTO Prestamos (ID_Préstamo, ID_Cliente, Tipo_Prestamo, Monto_Otorgado, Tasa_Interes, Fecha_Inicio, Fecha_Termino)
VALUES
    (02, '12345679', 'Hipotecario', 100000.00, 5.5, '03-11-2017', '08-02-2020'),
    (03, '12345680', 'Personal', 20000.00, 6.5, '04-11-2019', '08-03-2023'),
    (04, '12345681', 'Educacional', 15000.00, 4.0, '05-11-2020', '08-04-2022'),
    (05, '12345682', 'Hipoteca', 80000.00, 5.0, '06-11-2020', '08-05-2024'),
    (06, '12345683', 'Personal', 1000.00, 7.0, '07-11-2023', '08-06-2026'),
    (07, '12345684', 'Personal', 25000.00, 6.0, '08-11-2024', '08-07-2028'),
    (08, '12345685', 'Hipoteca', 120000.00, 4.5, '09-11-2015', '08-08-2018'),
    (09, '12345686', 'Personal', 3000.00, 6.5, '10-11-2016', '08-09-2018'),
    (10, '12345687', 'Educacional', 20000.00, 3.5, '11-11-2020', '08-10-2023'),
    (11, '12345678', 'Personal', 5000.00, 5.5, '02-11-2019', '08-01-2023');
--
SELECT * FROM Prestamos;
--


INSERT INTO Sucursales (ID_Sede, Direccion, Telefono, Correo, Gerente)
VALUES
    (1195, 'Av. Central 456', '987687421', 'sucursalcentral@gmail.com', 'María Lopez'),
    (1196, 'Av. Javier Prado Este 1234, San Isidro', '987687422', 'sucursalsanisidro@gmail.com', 'Juan Martinez'),
    (1197, 'Av. La Marina 789, Pueblo Libre', '987687423', 'sucursallamarin@gmail.com', 'Andrea Rodriguez'),
    (1198, 'Av. Angamos Oeste 456, Miraflores', '987687424', 'sucursalmiraflores@gmail.com', 'Luis Ramirez'),
    (1199, 'Av. Caminos del Inca 234, Surco', '987687425', 'sucursalsurco@gmail.com', 'Ana Sanchez'),
    (1200, 'Av. Benavides 789, Barranco', '987687426', 'sucursalbarranco@gmail.com', 'Diego Fernandez'),
    (1201, 'Av. Paseo de la República 567, Lima', '987687427', 'sucursallima@gmail.com', 'Laura Gomez'),
    (1202, 'Av. Tacna 345, Centro de Lima', '987687428', 'sucursalcentrolima@gmail.com', 'Carlos Gutierrez'),
    (1203, 'Av. Arequipa 678, Lince', '987687429', 'sucursallince@gmail.com', 'Marta Diaz'),
    (1204, 'Av. Alfonso Ugarte 789, Cercado de Lima', '987687430', 'sucursalce@gmail.com', 'Raul Castro'),
    (1205, 'Av. Javier Prado Oeste 234, San Borja', '987687431', 'sucursalsanborja@gmail.com', 'Elena Chavez');
--
SELECT * FROM Sucursales;


--
INSERT INTO Empleados (ID_Empleado, DNI, Nombre, Apellido, Teléfono, Correo, Área_trabaja, ID_Sucursal, Fecha_Contratacion)
VALUES
    (03491, '87654321', 'Pedro', 'García', '999888777', 'pedro@gmail.com', 'Caja', '1195', '2018-05-01'),
    (03492, '87654322', 'Luis', 'Martinez', '999888778', 'luis@gmail.com', 'Ventanilla', '1196', '2019-06-15'),
    (03493, '87654323', 'Ana', 'Rodriguez', '999888779', 'ana23@otl.com', 'Atención al Cliente', '1197', '2020-03-10'),
    (03494, '87654324', 'María', 'Fernández', '999888780', 'maria@gmail.com', 'Caja', '1198', '2017-11-20'),
    (03495, '87654325', 'Juan', 'Gutierrez', '999888781', 'juan@gmail.com', 'Ventanilla', '1199', '2019-08-30'),
    (03496, '87654326', 'Sofia', 'Lopez', '999888782', 'sofia@gmail.com', 'Atención al Cliente', '1200', '2020-01-05'),
    (03497, '87654327', 'Luisa', 'Diaz', '999888783', 'luisa@gmail.com', 'Caja', '1201', '2018-09-12'),
    (03498, '87654328', 'Pedro', 'Chavez', '999888784', 'pedroch@next.com', 'Ventanilla', '1202', '2021-02-28'),
    (03499, '87654329', 'Laura', 'Sanchez', '999888785', 'laura@net.com', 'Atención al Cliente', '1203', '2019-04-17'),
    (03500, '87654330', 'Diego', 'Vega', '999888786', 'diego@troe.com', 'Caja', '1204', '2022-07-07');

--
SELECT * FROM Empleados;
--


INSERT INTO Operaciones_Bancarias (ID_Operacion, Descripcion, Comisiones, Restricciones)
VALUES 
(8467310, 'Retiro de efectivo', '5.00', 'Máximo de retiro diario: 1000.00'),
(8467311, 'Retiro de efectivo', '5.00', 'Máximo de retiro diario: 1000.00'),
(8467312, 'Depósito en efectivo', '0.00', 'Sin restricciones'),
(8467313, 'Transferencia electrónica', '2.00', 'Máximo de transferencia diaria: 500.00'),
(8467314, 'Consulta de saldo', '0.50', 'Máximo de consultas diarias: 5'),
(8467315, 'Pago de servicios', '3.00', 'Comisiones variables según el servicio'),
(8467316, 'Cheques de viajero', '10.00', 'Compra mínima de 100.00'),
(8467317, 'Cambio de divisas', '1.50', 'Aplicación de tasas de cambio'),
(8467318, 'Pago de préstamo', '4.00', 'Comisión fija por pago anticipado'),
(8467319, 'Solicitud de préstamo', '1.00', 'Sujeto a aprobación de crédito'),
(8467320, 'Apertura de cuenta', '0.00', 'Sin comisiones de apertura');

-- 
SELECT * FROM Operaciones_Bancarias;
--

INSERT INTO Historial_Crediticio (ID_Cliente, Puntuacion_Credito, Reportes_Credito, Historial_Pagos)
VALUES 
(001234, 750, 'Sin reportes negativos', 'Al día'),
(001235, 800, 'Reporte de pago tardío hace 1 año', 'Deuda'),
(001236, 700, 'Reporte de préstamo incumplido hace 2 años', 'Al día'),
(001237, 720, 'Sin historial crediticio', 'Deuda'),
(001238, 780, 'Reporte de préstamo cancelado', 'Al día'),
(001239, 760, 'Reporte de crédito renovado', 'Deuda'),
(001240, 740, 'Reporte de préstamo vigente', 'Deuda'),
(001241, 790, 'Reporte de deuda refinanciada', 'Al día'),
(001242, 770, 'Reporte de crédito consolidado', 'Al día'),
(001243, 780, 'Reporte de crédito revocado', 'Deuda');

-- 
SELECT * FROM Historial_Crediticio;



