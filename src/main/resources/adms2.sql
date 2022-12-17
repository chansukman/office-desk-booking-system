USE `adms2`;

DROP TABLE IF EXISTS `Booking`;
CREATE TABLE `Booking` (`booking_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,`booking_date` date NOT NULL,`User_user_id` int NOT NULL,`Desk_desk_id` int NOT NULL,`User_UserName` varchar(25),`Location` varchar(25),`isAttended` TINYINT NULL DEFAULT 0);
  
DROP TABLE IF EXISTS `Desk`;
CREATE TABLE `Desk` (`desk_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,`desk_number` int NOT NULL,`has_monitors` boolean NOT NULL default true,`desk_type` varchar(50) NOT NULL default 'Standard',`desk_location` varchar(50) NOT NULL);

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (`user_id` int NOT NULL PRIMARY KEY,`first_name` varchar(50) NOT NULL,`last_name` varchar(50) DEFAULT NULL,`email` varchar(50) DEFAULT NULL,`department` varchar(50) DEFAULT NULL,`password` varchar(20) DEFAULT NULL,`default_location` varchar(50) default null);

DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin` (`admin_id` int NOT NULL PRIMARY KEY,`first_name` varchar(50) NOT NULL,`last_name` varchar(50) NOT NULL,`email` varchar(50) NOT NULL,`department` varchar(50) DEFAULT NULL,`password` varchar(20) NOT NULL);

DROP TABLE IF EXISTS `Maps`;
CREATE TABLE `Maps`(`map_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,`location` varchar(50) NOT NULL,`image` varchar(50) NOT NULL);

DROP TABLE IF EXISTS `Lottery`;
CREATE TABLE `Lottery`(`date` date NOT NULL,`user_id` int NOT NULL,`location` varchar(50) NOT NULL,`resolved` boolean default false);

DROP TABLE IF EXISTS `Cancel`;
CREATE TABLE IF NOT EXISTS `Cancel` (`transaction_id` INT NOT NULL AUTO_INCREMENT,`booking_id` INT NULL DEFAULT NULL,`booking_date` DATE NOT NULL,`User_user_id` INT NOT NULL,`Desk_desk_id` INT NOT NULL,`User_UserName` VARCHAR(25) NULL DEFAULT NULL,`Location` varchar(25),`isAttended` INT,PRIMARY KEY (`transaction_id`));



