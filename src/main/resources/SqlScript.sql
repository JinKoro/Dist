CREATE SCHEMA `dits` ;

CREATE TABLE `dits`.`topic` (
  `topicId` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NULL,
  `name` VARCHAR(20) NULL,
  PRIMARY KEY (`topicId`));

CREATE TABLE `dits`.`test`(
`testId` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(20),
`description` VARCHAR(100),
`topicId` INT NOT NULL,
FOREIGN KEY (`topicId`) REFERENCES `topic`(`topicId`) ON DELETE CASCADE
);

CREATE TABLE `dits`.`question`(
`questionId` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`description` VARCHAR(100),
`testId` INT NOT NULL,
FOREIGN KEY (`testId`) REFERENCES `test`(`testId`) ON DELETE CASCADE
);

CREATE TABLE `dits`.`literature`(
`literatureId` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`description` VARCHAR(100),
`questionId` INT NOT NULL,
FOREIGN KEY (`questionId`) REFERENCES `question`(`questionId`) ON DELETE CASCADE
);

CREATE TABLE `dits`.`answer`(
`answerId` INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
`description` VARCHAR(100),
`correct` BOOLEAN,
`questionId` INT NOT NULL,
FOREIGN KEY (`questionId`) REFERENCES `question`(`questionId`) ON DELETE CASCADE
);

CREATE TABLE `dits`.`role`(
`roleId` INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
`user` BINARY,
`tutor` BINARY,
`admin` BINARY
);

CREATE TABLE `dits`.`user`(
`userId` INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
`firstName` VARCHAR(45),
`lastName` VARCHAR(45),
`login` VARCHAR(45),
`password` INT,
`roleId` INT,
FOREIGN KEY (`roleId`) REFERENCES `role`(`roleId`) ON DELETE CASCADE
);

CREATE TABLE `dits`.`statistic`(
`statisticId` INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
`date` DATE,
`correct` BOOLEAN,
`questionId` INT,
`userId` INT,
FOREIGN KEY (`userId`) REFERENCES `user`(`userId`) ON DELETE CASCADE
);

CREATE TABLE `dits`.`link` (
  `linkId` INT NOT NULL,
  `link` VARCHAR(45) NULL,
  `literatureId` INT NULL,
  PRIMARY KEY (`linkId`),
  CONSTRAINT `literatureId`
    FOREIGN KEY (`literatureId`)
    REFERENCES `dits`.`literature` (`literatureId`)
    ON DELETE CASCADE
);

ALTER TABLE `dits`.`user`
ADD COLUMN `roleName` VARCHAR(45) NULL AFTER `password`,
CHANGE COLUMN `login` `login` VARCHAR(255) NULL DEFAULT NULL ,
CHANGE COLUMN `password` `password` VARCHAR(255) NULL DEFAULT NULL ;

=======================================================================
ВВОД ДАННЫХ
=======================================================================

LOCK TABLES `dits`.`topic` WRITE;
INSERT INTO `dits`.`topic` VALUES
(1,'First Topic','First Topic'),
(2,'Second Topic','Second Topic'),
(3,'Third Topic','Third Topic');
UNLOCK TABLES;

LOCK TABLES `dits`.`test` WRITE;
INSERT INTO `dits`.`test` VALUES
(1,'First Test','First Topic',1),
(2,'Second Test','Second Test',2),
(3,'Third Test','Third Test',3),
(4,'Fourth Test','Fourth Test',2);
UNLOCK TABLES;

LOCK TABLES `dits`.`question` WRITE;
INSERT INTO `dits`.`question` VALUES
(1,'First Question',1),
(2,'Second Question',2),
(3,'First Question',2),
(4,'First Question',4),
(5,'Second Question',4),
(6,'Second Question',1),
(7,'First Question',3),
(8,'Second Question',3);
UNLOCK TABLES;

LOCK TABLES `dits`.`answer` WRITE;
INSERT INTO `dits`.`answer` VALUES
(1,'а',true,1),
(2,'b',true,2),
(3,'c',false,3),
(4,'d',true,4),
(5,'e',false,5),
(6,'f',true,6),
(7,'g',false,7),
(8,'h',true,8);
UNLOCK TABLES;

LOCK TABLES `dits`.`role` WRITE;
INSERT INTO `dits`.`role` VALUES
(1,1,0,0),
(2,0,1,0),
(3,0,0,1);
UNLOCK TABLES;

LOCK TABLES `dits`.`user` WRITE;
INSERT INTO `dits`.`user` VALUES
(1,'Petya','Pupkin','petya.pupkin@gmail.com','Petya2000','Admin',1),
(2,'Vasya','Dudkin','vasya.dudkin@gmail.com','Vasya1999','Tutor',2),
(3,'Vitya','Sumkin','vitya.sumkin@gmail.com','Vitya2000','User',3);
UNLOCK TABLES;

LOCK TABLES `dits`.`statistic` WRITE;
INSERT INTO `dits`.`statistic` VALUES
(1,'2020-06-23',true,1,1),
(2,'2020-06-23',true,3,1),
(3,'2020-06-23',true,4,1),
(4,'2020-06-23',false,7,1),
(5,'2020-06-23',true,2,1),
(6,'2020-06-24',true,4,2),
(7,'2020-06-24',false,8,2),
(8,'2020-06-24',true,5,2),
(9,'2020-06-24',false,3,2),
(10,'2020-06-24',true,1,2),
(11,'2020-06-25',true,7,3),
(12,'2020-06-25',false,6,3),
(13,'2020-06-25',true,3,3),
(14,'2020-06-25',true,4,3),
(15,'2020-06-25',false,2,3);
UNLOCK TABLES;

LOCK TABLES `dits`.`literature` WRITE;
INSERT INTO `dits`.`literature` VALUES
(1,'Literature 1',1),
(2,'Literature 2',2),
(3,'Literature 3',3),
(4,'Literature 4',4),
(5,'Literature 5',5),
(6,'Literature 6',6),
(7,'Literature 7',7),
(8,'Literature 8',8);
UNLOCK TABLES;

LOCK TABLES `dits`.`link` WRITE;
INSERT INTO `dits`.`link` VALUES
(1,'Link 1',1),
(2,'Link 2',2),
(3,'Link 3',3),
(4,'Link 4',4),
(5,'Link 5',5),
(6,'Link 6',6),
(7,'Link 7',7),
(8,'Link 8',8);
UNLOCK TABLES;

===============================================================
PROCEDURE
===============================================================
USE `dits`;
DROP procedure IF EXISTS `get_result`;

DELIMITER $$
USE `dits`$$
CREATE PROCEDURE `get_result` (out_userId int)
BEGIN
	SELECT sum(correct)/count(correct) from dits.statistic where userId=out_userId;
END$$

DELIMITER ;

===============================================================
ИЗМЕНИЯ
===============================================================


ALTER TABLE `dits`.`statistic`
ADD INDEX `statistic_ibfk_2_idx` (`questionId` ASC) VISIBLE;
;
ALTER TABLE `dits`.`statistic`
ADD CONSTRAINT `statistic_ibfk_2`
  FOREIGN KEY (`questionId`)
  REFERENCES `dits`.`question` (`questionId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

UPDATE `dits`.`user` SET `login` = '1234', `password` = '1234', `roleName` = 'ROLE_ADMIN' WHERE (`userId` = '1');
UPDATE `dits`.`user` SET `login` = '5678', `password` = '5678', `roleName` = 'ROLE_TUTOR' WHERE (`userId` = '2');
UPDATE `dits`.`user` SET `login` = '0987', `password` = '0987', `roleName` = 'ROLE_USER' WHERE (`userId` = '3');

ALTER TABLE `dits`.`role`
DROP COLUMN `admin`,
DROP COLUMN `tutor`,
CHANGE COLUMN `user` `RoleName` VARCHAR(45) NULL DEFAULT NULL ;

UPDATE `dits`.`role` SET `RoleName` = 'ROLE_ADMIN' WHERE (`roleId` = '1');
UPDATE `dits`.`role` SET `RoleName` = 'ROLE_TUTOR' WHERE (`roleId` = '2');
UPDATE `dits`.`role` SET `RoleName` = 'ROLE_USER' WHERE (`roleId` = '3');

ALTER TABLE `dits`.`user`
CHANGE COLUMN `roleName` `nameRole` VARCHAR(45) NULL DEFAULT NULL ;
ALTER TABLE `dits`.`role`
CHANGE COLUMN `RoleName` `nameRole` VARCHAR(45) NULL DEFAULT NULL ;

{1234,5678,0987}
UPDATE `dits`.`user` SET `password` = '$2y$12$Cr/KZQyMw3SN1XNpbISxyuxLIdKxpoQUOsNYT39w25mk5Gf3.K196' WHERE (`userId` = '2');
UPDATE `dits`.`user` SET `password` = '$2y$12$JkSc08PwdcTZMbKc7sCr4ezhIYoTMaDftoKJAN1a4iV7yN54D3bLe' WHERE (`userId` = '3');



