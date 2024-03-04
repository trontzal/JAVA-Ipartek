-- MySQL Workbench Synchronization
-- Generated: 2024-02-29 08:58
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Java

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `mf0966_3`.`puntuacion` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `puntos` INT(11) NOT NULL,
  `alumno_codigo` INT(11) NOT NULL,
  `curso_codigo` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_puntuacion_alumno1_idx` (`alumno_codigo` ASC) VISIBLE,
  INDEX `fk_puntuacion_curso1_idx` (`curso_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_puntuacion_alumno1`
    FOREIGN KEY (`alumno_codigo`)
    REFERENCES `mf0966_3`.`alumno` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_puntuacion_curso1`
    FOREIGN KEY (`curso_codigo`)
    REFERENCES `mf0966_3`.`curso` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
