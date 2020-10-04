-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema code_hero
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema code_hero
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `code_hero` DEFAULT CHARACTER SET utf8 ;
USE `code_hero` ;

-- -----------------------------------------------------
-- Table `code_hero`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`paciente` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `dpi` VARCHAR(16) NOT NULL,
  `telefono` VARCHAR(12) NOT NULL,
  `peso` INT NOT NULL,
  `sangre` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `contraseña` BLOB NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`medico` (
  `codigo` VARCHAR(60) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `colegiado` VARCHAR(45) NOT NULL,
  `dpi` VARCHAR(16) NOT NULL,
  `telefono` VARCHAR(12) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `horario_inicio` TIME NOT NULL,
  `horario_final` TIME NOT NULL,
  `fecha_empezo` DATE NOT NULL,
  `contraseña` BLOB NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`cita` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `paciente_codigo` INT NOT NULL,
  `medico_codigo` VARCHAR(60) NOT NULL,
  INDEX `fk_paciente_has_medico_medico1_idx` (`medico_codigo` ASC) VISIBLE,
  INDEX `fk_paciente_has_medico_paciente_idx` (`paciente_codigo` ASC) VISIBLE,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_paciente_has_medico_paciente`
    FOREIGN KEY (`paciente_codigo`)
    REFERENCES `code_hero`.`paciente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_has_medico_medico1`
    FOREIGN KEY (`medico_codigo`)
    REFERENCES `code_hero`.`medico` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`informe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`informe` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(900) NOT NULL,
  `hora` TIME NOT NULL,
  `fecha` DATE NOT NULL,
  `costo` DOUBLE NOT NULL,
  `paciente_codigo` INT NOT NULL,
  `medico_codigo` VARCHAR(60) NOT NULL,
  INDEX `fk_paciente_has_medico_medico2_idx` (`medico_codigo` ASC) VISIBLE,
  INDEX `fk_paciente_has_medico_paciente1_idx` (`paciente_codigo` ASC) VISIBLE,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_paciente_has_medico_paciente1`
    FOREIGN KEY (`paciente_codigo`)
    REFERENCES `code_hero`.`paciente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_has_medico_medico2`
    FOREIGN KEY (`medico_codigo`)
    REFERENCES `code_hero`.`medico` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`especialidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`examen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`examen` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `tipo` VARCHAR(10) NOT NULL,
  `orden` TINYINT NOT NULL,
  `costo` DOUBLE NOT NULL,
  `descripcion` VARCHAR(900) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`laboratorista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`laboratorista` (
  `codigo` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `num_ministerio` VARCHAR(45) NOT NULL,
  `dpi` VARCHAR(16) NOT NULL,
  `telefono` VARCHAR(12) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `fecha_empezo` DATE NOT NULL,
  `contraseña` BLOB NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`resultado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`resultado` (
  `codigo` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `verificado` TINYINT NULL,
  `documento` MEDIUMBLOB NULL,
  `orden_hecha` MEDIUMBLOB NULL,
  `paciente_codigo` INT NOT NULL,
  `medico_codigo` VARCHAR(60) NULL,
  `examen_codigo` INT NOT NULL,
  `laboratorista_codigo` VARCHAR(100) NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_resultado_paciente1_idx` (`paciente_codigo` ASC) VISIBLE,
  INDEX `fk_resultado_medico1_idx` (`medico_codigo` ASC) VISIBLE,
  INDEX `fk_resultado_examen1_idx` (`examen_codigo` ASC) VISIBLE,
  INDEX `fk_resultado_laboratorista1_idx` (`laboratorista_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_resultado_paciente1`
    FOREIGN KEY (`paciente_codigo`)
    REFERENCES `code_hero`.`paciente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resultado_medico1`
    FOREIGN KEY (`medico_codigo`)
    REFERENCES `code_hero`.`medico` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resultado_examen1`
    FOREIGN KEY (`examen_codigo`)
    REFERENCES `code_hero`.`examen` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resultado_laboratorista1`
    FOREIGN KEY (`laboratorista_codigo`)
    REFERENCES `code_hero`.`laboratorista` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`medico_especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`medico_especialidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `medico_codigo` VARCHAR(60) NOT NULL,
  `especialidad_id` INT NOT NULL,
  INDEX `fk_medico_has_especialidad_especialidad1_idx` (`especialidad_id` ASC) VISIBLE,
  INDEX `fk_medico_has_especialidad_medico1_idx` (`medico_codigo` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_medico_has_especialidad_medico1`
    FOREIGN KEY (`medico_codigo`)
    REFERENCES `code_hero`.`medico` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medico_has_especialidad_especialidad1`
    FOREIGN KEY (`especialidad_id`)
    REFERENCES `code_hero`.`especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`dia_lab`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`dia_lab` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dia_semana` VARCHAR(20) NOT NULL,
  `laboratorista_codigo` VARCHAR(100) NOT NULL,
  INDEX `fk_dia_semana_has_laboratorista_laboratorista1_idx` (`laboratorista_codigo` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_dia_semana_has_laboratorista_laboratorista1`
    FOREIGN KEY (`laboratorista_codigo`)
    REFERENCES `code_hero`.`laboratorista` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`cita_especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`cita_especialidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cita_codigo` INT NOT NULL,
  `especialidad_id` INT NOT NULL,
  INDEX `fk_cita_has_especialidad_especialidad1_idx` (`especialidad_id` ASC) VISIBLE,
  INDEX `fk_cita_has_especialidad_cita1_idx` (`cita_codigo` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cita_has_especialidad_cita1`
    FOREIGN KEY (`cita_codigo`)
    REFERENCES `code_hero`.`cita` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_has_especialidad_especialidad1`
    FOREIGN KEY (`especialidad_id`)
    REFERENCES `code_hero`.`especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_hero`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `code_hero`.`admin` (
  `codigo` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dpi` VARCHAR(16) NOT NULL,
  `contraseña` BLOB NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
