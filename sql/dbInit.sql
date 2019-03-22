CREATE DATABASE  IF NOT EXISTS `legostore`;

USE `legostore`;

SET FOREIGN_KEY_CHECKS=0; 
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `order`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `shipped` BOOLEAN,
  PRIMARY KEY (`orderid`),
    
    CONSTRAINT `user_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `user` VALUES 
(1,'jens@hansen.dk','1234','customer'),
(2,'ken@somewhere.com','1234','customer'),
(3,'hans@jensen.dk','1234','employee');

INSERT INTO `order` (`userid`, `length`, `width`, `height`, `shipped`) VALUES 
(1, 20, 11, 5, false),
(1, 25, 11, 5, false),
(2, 20, 18, 5, false),
(2, 40, 13, 5, false),
(3, 45, 14, 5, false),
(3, 50, 15, 5, false);

