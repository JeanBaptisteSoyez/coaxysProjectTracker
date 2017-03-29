-- MySQL Script generated by MySQL Workbench
-- mer. 29 mars 2017 12:25:24 CEST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Project` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Project` (
  `idProject` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProject`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`User` ;

CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Epic`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Epic` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Epic` (
  `idEpic` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `idProject` INT NOT NULL,
  PRIMARY KEY (`idEpic`),
  INDEX `fk_Epic_1_idx` (`idProject` ASC),
  CONSTRAINT `fk_Epic_1`
    FOREIGN KEY (`idProject`)
    REFERENCES `mydb`.`Project` (`idProject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Story`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Story` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Story` (
  `idStory` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `idEpic` INT NOT NULL,
  PRIMARY KEY (`idStory`),
  INDEX `fk_Story_1_idx` (`idEpic` ASC),
  CONSTRAINT `fk_Story_1`
    FOREIGN KEY (`idEpic`)
    REFERENCES `mydb`.`Epic` (`idEpic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Task`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Task` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Task` (
  `idTask` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `process` VARCHAR(45) NULL,
  `results` VARCHAR(45) NULL,
  `parameters` VARCHAR(45) NULL,
  `idStory` INT NOT NULL,
  PRIMARY KEY (`idTask`),
  INDEX `fk_Task_1_idx` (`idStory` ASC),
  CONSTRAINT `fk_Task_1`
    FOREIGN KEY (`idStory`)
    REFERENCES `mydb`.`Story` (`idStory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Status` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Status` (
  `idStatus` INT NOT NULL,
  `label` VARCHAR(45) NOT NULL,
  `remarks` VARCHAR(45) NULL,
  `date` DATETIME NOT NULL,
  `idTask` INT NOT NULL,
  PRIMARY KEY (`idStatus`),
  INDEX `fk_Status_1_idx` (`idTask` ASC),
  CONSTRAINT `fk_Status_1`
    FOREIGN KEY (`idTask`)
    REFERENCES `mydb`.`Task` (`idTask`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Project_has_User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Project_has_User` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Project_has_User` (
  `Project_idProject` INT NOT NULL,
  `User_idUser` INT NOT NULL,
  PRIMARY KEY (`Project_idProject`, `User_idUser`),
  INDEX `fk_Project_has_User_User1_idx` (`User_idUser` ASC),
  INDEX `fk_Project_has_User_Project1_idx` (`Project_idProject` ASC),
  CONSTRAINT `fk_Project_has_User_Project1`
    FOREIGN KEY (`Project_idProject`)
    REFERENCES `mydb`.`Project` (`idProject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Project_has_User_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `mydb`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;