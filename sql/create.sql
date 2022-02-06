CREATE TABLE `spring`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `url` VARCHAR(45) NULL,
  `top_id` VARCHAR(45) NULL,
  `reg_dt` DATETIME NULL,
  `mod_dt` DATETIME NULL,
  `use_yn` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `spring`.`menu_auth` (
  `menu_id` INT NOT NULL,
  `user_id` VARCHAR(100) NOT NULL,
  `select_yn` CHAR(1) NULL,
  `modify_yn` CHAR(1) NULL,
  `reg_dt` DATETIME NULL,
  `reg_id` VARCHAR(100) NULL,
  PRIMARY KEY (`menu_id`, `user_id`));

CREATE TABLE `spring`.`user` (
  `id` VARCHAR(100) NOT NULL,
  `password` VARCHAR(200) NULL,
  `name` VARCHAR(45) NULL,
  `reg_dt` DATETIME NULL,
  `mod_dt` DATETIME NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `spring`.`menu`
CHANGE COLUMN `id` `id` INT NOT NULL ;

ALTER TABLE `spring`.`menu`
ADD COLUMN `order` INT NULL DEFAULT 0 AFTER `use_yn`,
CHANGE COLUMN `use_yn` `use_yn` VARCHAR(45) NULL DEFAULT 'N' ;

ALTER TABLE `spring`.`menu`
CHANGE COLUMN `id` `id` VARCHAR(10) NOT NULL ,
CHANGE COLUMN `top_id` `top_id` VARCHAR(10) NULL DEFAULT NULL ,
CHANGE COLUMN `use_yn` `use_yn` VARCHAR(1) NULL DEFAULT 'N' ;
