SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `Models`;
CREATE TABLE `Models` (
                          `id` int(9) NOT NULL AUTO_INCREMENT,
                          `model` varchar(50) NOT NULL,
                          `brand` varchar(50) NOT NULL,
                          `color` varchar(50) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;