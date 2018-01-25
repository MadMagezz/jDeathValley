CREATE SCHEMA `UserBankList` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `UserBankList`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `sureName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC));

CREATE TABLE `UserBankList`.`account` (
  `accountId` INT NOT NULL,
  `account` INT NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`accountId`),
  UNIQUE INDEX `accountId_UNIQUE` (`accountId` ASC));

INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('1', 'Stephan', 'Karsakov');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('2', 'Bruce', 'Eckelevich');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('3', 'Javascript', 'Bootstrapovich');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('4', 'Python', 'Webovich');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('5', 'Java', 'Enterprisovna');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('6', 'Bjaurne', 'Stroustrupovich');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('7', 'Esquel', 'Musculovich');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('8', 'Framework', 'Springovna');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('9', 'Richi', 'Kernigonovich');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('10', 'Vasil', 'Petrovich');
INSERT INTO `UserBankList`.`user` (`userId`, `name`, `sureName`) VALUES ('11', 'Petr', 'Vasilich');

INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('9085644', '234', '1');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('45631111', '4573', '2');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('77212322', '4634', '3');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('662346234', '2362', '4');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('5523522', '112513', '5');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('44324522', '6796734', '6');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('2228763', '267967', '7');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('22224545', '6784', '8');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('11116575', '243634', '9');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('1112352', '23523', '10');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('1123523', '235232', '11');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('45745321', '22332', '10');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('23454432', '45645', '9');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('67845623', '6587564', '8');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('3346457', '424646', '7');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('2254365', '45734573', '6');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('7894534', '78978', '5');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('4634563', '949378', '4');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('265344', '3535', '3');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('56856332', '2226', '2');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('2235325', '4356345', '1');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('2464357', '666667', '1');
INSERT INTO `UserBankList`.`account` (`accountId`, `account`, `userId`) VALUES ('6346341', '26246', '1');







