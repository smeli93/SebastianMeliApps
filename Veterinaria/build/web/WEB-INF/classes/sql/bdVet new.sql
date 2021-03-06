-- MySQL Script generated by MySQL Workbench
-- Tue Nov  6 11:52:38 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema veterinaria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema veterinaria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `veterinaria` ;
USE `veterinaria` ;

-- -----------------------------------------------------
-- Table `veterinaria`.`Perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Perfil` (
  `idPerfil` INT NOT NULL AUTO_INCREMENT,
  `descripcionPerfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPerfil`),
  UNIQUE INDEX `idPerfil_UNIQUE` (`idPerfil` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Usuario` (
  `rut_usuario` VARCHAR(45) NOT NULL,
  `password_usuario` VARCHAR(45) NOT NULL,
  `nombre_usuario` VARCHAR(50) NOT NULL,
  `apellido_usuario` VARCHAR(50) NOT NULL,
  `email_usuario` VARCHAR(255) NOT NULL,
  `telefono_usuario` INT NOT NULL,
  `Perfil_idPerfil` INT NOT NULL,
  UNIQUE INDEX `rut_usuario_UNIQUE` (`rut_usuario`),
  PRIMARY KEY (`rut_usuario`),
  INDEX `fk_Usuario_Perfil1_idx` (`Perfil_idPerfil` ASC),
  CONSTRAINT `fk_Usuario_Perfil1`
    FOREIGN KEY (`Perfil_idPerfil`)
    REFERENCES `veterinaria`.`Perfil` (`idPerfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Raza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Raza` (
  `idRaza` INT NOT NULL AUTO_INCREMENT,
  `descripcionRaza` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRaza`),
  UNIQUE INDEX `idRaza_UNIQUE` (`idRaza` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Tipo_Mascota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Tipo_Mascota` (
  `idTipoMascota` INT NOT NULL AUTO_INCREMENT,
  `descripcionTipoMascota` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoMascota`),
  UNIQUE INDEX `idTipoMascota_UNIQUE` (`idTipoMascota` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Mascota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Mascota` (
  `idMascota` INT NOT NULL AUTO_INCREMENT,
  `nombre_mascota` VARCHAR(50) NOT NULL,
  `fecha_Nacimiento` DATETIME NOT NULL,
  `Usuario_rut_usuario` VARCHAR(45) NOT NULL,
  `Tipo_Mascota_idTipoMascota` INT NOT NULL,
  `Raza_idRaza` INT NOT NULL,
  PRIMARY KEY (`idMascota`),
  UNIQUE INDEX `id_mascota_UNIQUE` (`idMascota` ASC),
  INDEX `fk_Mascota_Usuario1_idx` (`Usuario_rut_usuario` ASC),
  INDEX `fk_Mascota_TipoMascota1_idx` (`Tipo_Mascota_idTipoMascota` ASC),
  INDEX `fk_Mascota_Raza1_idx` (`Raza_idRaza` ASC),
  CONSTRAINT `fk_Mascota_Usuario1`
    FOREIGN KEY (`Usuario_rut_usuario`)
    REFERENCES `veterinaria`.`Usuario` (`rut_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mascota_Tipo_Mascota1`
    FOREIGN KEY (`Tipo_Mascota_idTipoMascota`)
    REFERENCES `veterinaria`.`Tipo_Mascota` (`idTipoMascota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mascota_Raza1`
    FOREIGN KEY (`Raza_idRaza`)
    REFERENCES `veterinaria`.`Raza` (`idRaza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Especialidad` (
  `idEspecialidad` INT NOT NULL AUTO_INCREMENT,
  `descripcionEspecialidad` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idEspecialidad`),
  UNIQUE INDEX `idEspecialidad_UNIQUE` (`idEspecialidad` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Veterinario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Veterinario` (
  `idVeterinario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NOT NULL,
  `telefono` VARCHAR(255) NOT NULL,
  `fecha_de_ingreso` DATE NOT NULL,
  `Especialidad_idEspecialidad` INT NOT NULL,
  PRIMARY KEY (`idVeterinario`),
  UNIQUE INDEX `id_veterinario_UNIQUE` (`idVeterinario` ASC),
  INDEX `fk_Veterinario_Especialidad1_idx` (`Especialidad_idEspecialidad` ASC),
  CONSTRAINT `fk_Veterinario_Especialidad1`
    FOREIGN KEY (`Especialidad_idEspecialidad`)
    REFERENCES `veterinaria`.`Especialidad` (`idEspecialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Estado` (
  `idEstado` INT NOT NULL AUTO_INCREMENT,
  `descripcionEstado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstado`),
  UNIQUE INDEX `idEstado_UNIQUE` (`idEstado` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Reserva` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `motivo_reserva` VARCHAR(100) NOT NULL,
  `fecha_reserva` DATE NOT NULL,
  `hora_reserva` INT NOT NULL,
  `Estado_idEstado` INT NOT NULL,
  `Veterinario_idVeterinario` INT NOT NULL,
  `Usuario_rut_usuario` VARCHAR(45) NOT NULL,
  `Mascota_idMascota` INT NOT NULL,
  PRIMARY KEY (`idReserva`),
  UNIQUE INDEX `id_UNIQUE` (`idReserva` ASC),
  INDEX `fk_Reserva_Estado1_idx` (`Estado_idEstado` ASC),
  INDEX `fk_Reserva_Veterinario1_idx` (`Veterinario_idVeterinario` ASC),
  INDEX `fk_Reserva_Usuario1_idx` (`Usuario_rut_usuario` ASC),
  INDEX `fk_Reserva_Mascota1_idx` (`Mascota_idMascota` ASC),
  CONSTRAINT `fk_Reserva_Estado1`
    FOREIGN KEY (`Estado_idEstado`)
    REFERENCES `veterinaria`.`Estado` (`idEstado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Veterinario1`
    FOREIGN KEY (`Veterinario_idVeterinario`)
    REFERENCES `veterinaria`.`Veterinario` (`idVeterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Usuario1`
    FOREIGN KEY (`Usuario_rut_usuario`)
    REFERENCES `veterinaria`.`Usuario` (`rut_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Mascota1`
    FOREIGN KEY (`Mascota_idMascota`)
    REFERENCES `veterinaria`.`Mascota` (`idMascota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Historial_Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Historial_Medico` (
  `idHistorial_Medico` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `fecha_Ingreso` DATE NOT NULL,
  `vacunaAlDia` TINYINT(1) NOT NULL,
  `fecha_Vacuna` DATE NOT NULL,
  `Mascota_idMascota` INT NOT NULL,
  PRIMARY KEY (`idHistorial_Medico`),
  UNIQUE INDEX `idHistorial_Medico_UNIQUE` (`idHistorial_Medico` ASC),
  INDEX `fk_Historial_Medico_Mascota1_idx` (`Mascota_idMascota` ASC),
  CONSTRAINT `fk_Historial_Medico_Mascota1`
    FOREIGN KEY (`Mascota_idMascota`)
    REFERENCES `veterinaria`.`Mascota` (`idMascota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`Procedimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinaria`.`Procedimiento` (
  `idProcedimiento` INT NOT NULL,
  `nombre_prodecimiento` VARCHAR(45) NOT NULL,
  `fecha_Procedimiento` DATE NOT NULL,
  `descripcion_Procedimiento` VARCHAR(100) NOT NULL,
  `Reserva_idReserva` INT NOT NULL,
  `Historial_Medico_idHistorial_Medico` INT NOT NULL,
  PRIMARY KEY (`idProcedimiento`),
  UNIQUE INDEX `idProcedimiento_UNIQUE` (`idProcedimiento` ASC),
  INDEX `fk_Procedimiento_Reserva1_idx` (`Reserva_idReserva` ASC),
  INDEX `fk_Procedimiento_Historial_Medico1_idx` (`Historial_Medico_idHistorial_Medico` ASC),
  CONSTRAINT `fk_Procedimiento_Reserva1`
    FOREIGN KEY (`Reserva_idReserva`)
    REFERENCES `veterinaria`.`Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Procedimiento_Historial_Medico1`
    FOREIGN KEY (`Historial_Medico_idHistorial_Medico`)
    REFERENCES `veterinaria`.`Historial_Medico` (`idHistorial_Medico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `veterinaria`.`especialidad` (`idEspecialidad`, `descripcionEspecialidad`) VALUES
(1, 'cirugia');



INSERT INTO `veterinaria`.`estado` (`idEstado`, `descripcionEstado`) VALUES
(1, 'Pendiente'),
(2, 'Realizada'),
(3, 'Cancelada'),
(4, 'Perdida');


INSERT INTO `veterinaria`.`perfil` (`idPerfil`, `descripcionPerfil`) VALUES
(1, 'Administrador'),
(2, 'Veterinario'),
(3, 'Cliente');


INSERT INTO `veterinaria`.`raza` (`idRaza`, `descripcionRaza`) VALUES
(1, 'chiguagua');

INSERT INTO `veterinaria`.`tipo_mascota` (`idTipoMascota`, `descripcionTipoMascota`) VALUES
(1, 'Conejo'),
(2, 'Gato'),
(3, 'Perro'),
(4, 'Hamster'),
(5, 'Otros');


INSERT INTO `veterinaria`.`usuario` (`rut_usuario`, `password_usuario`, `nombre_usuario`, `apellido_usuario`, `email_usuario`, `telefono_usuario`, `Perfil_idPerfil`) VALUES
('18529570-2', 'admin', 'sebastian', 'meli', 'sebameli@gmail.com', 23838278, 1);








