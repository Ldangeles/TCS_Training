-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Coffee_Network
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Coffee_Network` ;

-- -----------------------------------------------------
-- Schema Coffee_Network
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Coffee_Network` DEFAULT CHARACTER SET utf8 ;
USE `Coffee_Network` ;

-- -----------------------------------------------------
-- Table `Coffee_Network`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Coffee_Network`.`users` ;

CREATE TABLE IF NOT EXISTS `Coffee_Network`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(25) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Coffee_Network`.`posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Coffee_Network`.`posts` ;

CREATE TABLE IF NOT EXISTS `Coffee_Network`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_posts_users_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_posts_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `Coffee_Network`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
