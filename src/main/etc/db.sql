-- -----------------------------------------------------
-- Create new SCHEMA named evozon
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `evozon` DEFAULT CHARACTER SET utf8 ;
USE `evozon` ;

-- -----------------------------------------------------
-- Table `evozon`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `evozon`.`product` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(8) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NOT NULL,
  `stockLevel` INT(11) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC))
DEFAULT CHARACTER SET = utf8;

