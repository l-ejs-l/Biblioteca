DROP DATABASE biblioteca;
CREATE DATABASE biblioteca;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET latin1 ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`Autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Autor` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Autor` (
  `id_autor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_autor` VARCHAR(30) NOT NULL,
  `apaterno_autor` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Region` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Region` (
  `id_region` INT(11) NOT NULL AUTO_INCREMENT,
  `region` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_region`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Comuna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Comuna` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Comuna` (
  `id_comuna` INT(11) NOT NULL AUTO_INCREMENT,
  `comuna` VARCHAR(50) NOT NULL,
  `id_region` INT(11) NOT NULL,
  PRIMARY KEY (`id_comuna`),
  INDEX `region_comuna` (`id_region` ASC),
  CONSTRAINT `region_comuna`
    FOREIGN KEY (`id_region`)
    REFERENCES `biblioteca`.`Region` (`id_region`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Editorial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Editorial` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Editorial` (
  `id_editorial` INT(11) NOT NULL AUTO_INCREMENT,
  `editorial` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_editorial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Recurso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Recurso` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Recurso` (
  `id_recurso` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(50) NOT NULL,
  `tipo_recurso` INT(11) NOT NULL,
  `tipo_texto` INT(11) NOT NULL,
  `id_editorial` INT(11) NOT NULL,
  `total_paginas` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  INDEX `recurso_editorial` (`id_editorial` ASC),
  CONSTRAINT `recurso_editorial`
    FOREIGN KEY (`id_editorial`)
    REFERENCES `biblioteca`.`Editorial` (`id_editorial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `usuario` VARCHAR(30) NOT NULL,
  `clave` VARCHAR(30) NOT NULL,
  `es_miembro`   TINYINT(1)            DEFAULT '0',
  `apellido` VARCHAR(30) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `activo` TINYINT(1) NOT NULL,
	`cod_sucursal` INTEGER      NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Sucursal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Sucursal` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Sucursal` (
  `cod_sucursal` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `es_central` TINYINT(1) NULL DEFAULT '0',
  `dir_calle` VARCHAR(40) NOT NULL,
  `dir_numero` INT(11) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  `id_comuna` INT(11) NOT NULL,
  PRIMARY KEY (`cod_sucursal`),
  UNIQUE INDEX `sucursal__idx` (`id_usuario` ASC),
  INDEX `sucursal_comuna` (`id_comuna` ASC),
  CONSTRAINT `sucursal_comuna`
    FOREIGN KEY (`id_comuna`)
    REFERENCES `biblioteca`.`Comuna` (`id_comuna`),
  CONSTRAINT `sucursal_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `biblioteca`.`Usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Copia_Recurso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Copia_Recurso` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Copia_Recurso` (
  `id_copia` INT(11) NOT NULL AUTO_INCREMENT,
  `estado_copia` INT(11) NOT NULL,
  `id_recurso` INT(11) NOT NULL,
  `cod_sucursal` INT(11) NOT NULL,
  PRIMARY KEY (`id_copia`),
  INDEX `recurso_copia` (`id_recurso` ASC),
  INDEX `sucursal_copia_recurso` (`cod_sucursal` ASC),
  CONSTRAINT `recurso_copia`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `biblioteca`.`Recurso` (`id_recurso`),
  CONSTRAINT `sucursal_copia_recurso`
    FOREIGN KEY (`cod_sucursal`)
    REFERENCES `biblioteca`.`Sucursal` (`cod_sucursal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Cuenta` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Cuenta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(30) NOT NULL,
  `clave` VARCHAR(30) NOT NULL,
  `es_miembro` TINYINT(1) NULL DEFAULT '0',
  `nombre` VARCHAR(30) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `correo` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Proveedor` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Proveedor` (
  `id_proveedor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` VARCHAR(30) NOT NULL,
  `dir_calle` VARCHAR(40) NOT NULL,
  `dir_numero` INT(11) NOT NULL,
  `id_comuna` INT(11) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  INDEX `comuna_proveedor` (`id_comuna` ASC),
  CONSTRAINT `comuna_proveedor`
    FOREIGN KEY (`id_comuna`)
    REFERENCES `biblioteca`.`Comuna` (`id_comuna`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Factura` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Factura` (
  `id_factura` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_factura` INT(11) NOT NULL,
  `cod_sucursal` INT(11) NOT NULL,
  `sucursal_destino` INT(11) NOT NULL,
  `sucursal_origen` INT(11) NOT NULL,
  `id_proveedor` INT(11) NOT NULL,
  `total` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  INDEX `actura_proveedor` (`id_proveedor` ASC),
  INDEX `sucursal_compra` (`cod_sucursal` ASC),
  INDEX `factura_destino` (`sucursal_destino` ASC),
  INDEX `factura_origen` (`sucursal_origen` ASC),
  CONSTRAINT `actura_proveedor`
    FOREIGN KEY (`id_proveedor`)
    REFERENCES `biblioteca`.`Proveedor` (`id_proveedor`),
  CONSTRAINT `factura_destino`
    FOREIGN KEY (`sucursal_destino`)
    REFERENCES `biblioteca`.`Sucursal` (`cod_sucursal`),
  CONSTRAINT `factura_origen`
    FOREIGN KEY (`sucursal_origen`)
    REFERENCES `biblioteca`.`Sucursal` (`cod_sucursal`),
  CONSTRAINT `sucursal_compra`
    FOREIGN KEY (`cod_sucursal`)
    REFERENCES `biblioteca`.`Sucursal` (`cod_sucursal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Pedido` (
  `id_pedido` INT(11) NOT NULL AUTO_INCREMENT,
  `total` INT(11) NOT NULL,
  `id_recurso` INT(11) NOT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `recurso_pedido` (`id_recurso` ASC),
  CONSTRAINT `recurso_pedido`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `biblioteca`.`Recurso` (`id_recurso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Detalle_Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Detalle_Factura` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Detalle_Factura` (
  `id_detalle_factura` INT(11) NOT NULL AUTO_INCREMENT,
  `id_factura` INT(11) NOT NULL,
  `id_pedido` INT(11) NOT NULL,
  PRIMARY KEY (`id_detalle_factura`),
  INDEX `compra_detalle` (`id_factura` ASC),
  INDEX `pedido_factura` (`id_pedido` ASC),
  CONSTRAINT `compra_detalle`
    FOREIGN KEY (`id_factura`)
    REFERENCES `biblioteca`.`Factura` (`id_factura`),
  CONSTRAINT `pedido_factura`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `biblioteca`.`Pedido` (`id_pedido`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Prestamo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Prestamo` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Prestamo` (
  `cod_prestamo` INT(11) NOT NULL AUTO_INCREMENT,
  `uso_total` DATE NOT NULL,
  `cod_sucursal` INT(11) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  `fecha_prestamo` DATE NOT NULL,
  `fecha_devolución` DATE NOT NULL,
  PRIMARY KEY (`cod_prestamo`),
  INDEX `prestamo_sucursal` (`cod_sucursal` ASC),
  INDEX `usuario_prestamo` (`id_usuario` ASC),
  CONSTRAINT `prestamo_sucursal`
    FOREIGN KEY (`cod_sucursal`)
    REFERENCES `biblioteca`.`Sucursal` (`cod_sucursal`),
  CONSTRAINT `usuario_prestamo`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `biblioteca`.`Usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Detalle_Prestamo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Detalle_Prestamo` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Detalle_Prestamo` (
  `id_detalle_prestamo` INT(11) NOT NULL AUTO_INCREMENT,
  `estado_prestamo` INT(11) NOT NULL,
  `cod_prestamo` INT(11) NOT NULL,
  `id_copia` INT(11) NOT NULL,
  `cod_sucursal` INT(11) NOT NULL,
  PRIMARY KEY (`id_detalle_prestamo`),
  INDEX `biblioteca_devolucion` (`cod_sucursal` ASC),
  INDEX `copia_prestamo` (`id_copia` ASC),
  INDEX `libro_prestamo` (`cod_prestamo` ASC),
  CONSTRAINT `biblioteca_devolucion`
    FOREIGN KEY (`cod_sucursal`)
    REFERENCES `biblioteca`.`Sucursal` (`cod_sucursal`),
  CONSTRAINT `copia_prestamo`
    FOREIGN KEY (`id_copia`)
    REFERENCES `biblioteca`.`Copia_Recurso` (`id_copia`),
  CONSTRAINT `libro_prestamo`
    FOREIGN KEY (`cod_prestamo`)
    REFERENCES `biblioteca`.`Prestamo` (`cod_prestamo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Libro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Libro` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Libro` (
  `id_recurso` INT(11) NOT NULL,
  `isbn` VARCHAR(30) NOT NULL,
  `lomo` VARCHAR(30) NULL DEFAULT NULL,
  `contraportada` VARCHAR(30) NULL DEFAULT NULL,
  `portada` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id_recurso`),
  CONSTRAINT `libro_recurso_fk`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `biblioteca`.`Recurso` (`id_recurso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Multa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Multa` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Multa` (
  `id_multa` INT(11) NOT NULL AUTO_INCREMENT,
  `valor_multa` INT(11) NOT NULL,
  PRIMARY KEY (`id_multa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Periodico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Periodico` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Periodico` (
  `id_recurso` INT(11) NOT NULL,
  `lema` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_publicacion` DATE NOT NULL,
  PRIMARY KEY (`id_recurso`),
  CONSTRAINT `periodico_recurso_fk`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `biblioteca`.`Recurso` (`id_recurso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Recurso_Autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Recurso_Autor` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Recurso_Autor` (
  `id_autor` INT(11) NOT NULL,
  `id_recurso` INT(11) NOT NULL,
  INDEX `autor_libro_autor` (`id_autor` ASC),
  INDEX `recurso_autor` (`id_recurso` ASC),
  CONSTRAINT `autor_libro_autor`
    FOREIGN KEY (`id_autor`)
    REFERENCES `biblioteca`.`Autor` (`id_autor`)
    ON DELETE NO ACTION,
  CONSTRAINT `recurso_autor`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `biblioteca`.`Recurso` (`id_recurso`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Revista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Revista` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Revista` (
  `id_recurso` INT(11) NOT NULL,
  PRIMARY KEY (`id_recurso`),
  CONSTRAINT `revista_recurso_fk`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `biblioteca`.`Recurso` (`id_recurso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Topico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Topico` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Topico` (
  `id_topico` INT(11) NOT NULL AUTO_INCREMENT,
  `topico` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_topico`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Topico_Recurso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Topico_Recurso` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Topico_Recurso` (
  `id_topico` INT(11) NOT NULL,
  `id_recurso` INT(11) NOT NULL,
  INDEX `recurso_topico_idx` (`id_recurso` ASC),
  INDEX `topico_libro` (`id_topico` ASC),
  CONSTRAINT `recurso_topico`
    FOREIGN KEY (`id_recurso`)
    REFERENCES `biblioteca`.`Recurso` (`id_recurso`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `topico_libro`
    FOREIGN KEY (`id_topico`)
    REFERENCES `biblioteca`.`Topico` (`id_topico`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Usuario_Multa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Usuario_Multa` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Usuario_Multa` (
  `id_usuario_multa` INT(11) NOT NULL AUTO_INCREMENT,
  `activo` TINYINT(1) NOT NULL,
  `id_multa` INT(11) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario_multa`),
  INDEX `multa_usuario` (`id_multa` ASC),
  INDEX `usuario_multa` (`id_usuario` ASC),
  CONSTRAINT `multa_usuario`
    FOREIGN KEY (`id_multa`)
    REFERENCES `biblioteca`.`Multa` (`id_multa`),
  CONSTRAINT `usuario_multa`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `biblioteca`.`Usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `biblioteca`.`Usuario_Rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Usuario_Rol` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`Usuario_Rol` (
  `rol` INT(11) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  INDEX `usuario_rol` (`id_usuario` ASC),
  CONSTRAINT `usuario_rol`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `biblioteca`.`Usuario` (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
