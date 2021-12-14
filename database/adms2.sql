CREATE DATABASE  IF NOT EXISTS `adms2`;
USE `adms2`;

DROP TABLE IF EXISTS `Booking`;

CREATE TABLE `Booking` (
  `booking_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `booking_date` date NOT NULL,
  `User_user_id` int NOT NULL,
  `Desk_desk_id` int NOT NULL,
  `User_UserName` varchar(25),
  `Location` varchar(25),
  `isattended` TINYINT NULL DEFAULT 0
  );


INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-11-20',24,14);
INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-12-09',24,14);
INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-12-10',24,14);
INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-12-11',24,14);
INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-12-11',23,15);
INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-12-12',24,14);
INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-12-13',24,14);
INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-12-14',24,14);
INSERT INTO `Booking`(booking_date, User_user_id, Desk_desk_id) VALUES ('2021-12-08',24,14);


DROP TABLE IF EXISTS `Desk`;

CREATE TABLE `Desk` (
  `desk_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `desk_number` int NOT NULL,
  `has_monitors` boolean NOT NULL default true,
  `desk_type` varchar(50) NOT NULL default 'Standard',
  `desk_location` varchar(50) NOT NULL
);


INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (1,true,'Standing', 'Bristol'),(2,true,'Standing', 'Bristol'),(3,true,'Standing', 'Bristol'),(4,true,'Standing', 'Bristol'),(5,false,'Standard', 'Bristol'),(6,false,'Standard', 'Bristol'),(7,false,'Standard', 'Bristol');
INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (8,true,'Standard', 'Bristol'),(9,true,'Standard', 'Bristol'),(10,true,'Standard', 'Bristol'),(11,true,'Standard', 'Bristol'),(12,false,'Standard', 'Bristol'),(13,false,'Standard', 'Bristol'),(14,false,'Standard', 'Bristol');
INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (15,true,'Standard', 'Bristol'),(16,true,'Standard', 'Bristol'),(17,true,'Standard', 'Bristol'),(18,true,'Standard', 'Bristol'),(19,false,'Standard', 'Bristol'),(20,false,'Standard', 'Bristol'),(21,false,'Standard', 'Bristol');
INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (22,true,'Standard', 'Bristol'),(23,true,'Standard', 'Bristol'),(24,true,'Standard', 'Bristol'),(25,true,'Standard', 'Bristol');

INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (1,true,'Standard', 'Cardiff'),(2,true,'Standard', 'Cardiff'),(3,true,'Standard', 'Cardiff'),(4,true,'Standard', 'Cardiff'),(5,false,'Standard', 'Cardiff'),(6,false,'Standard', 'Cardiff'),(7,false,'Standard', 'Cardiff');
INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (8,true,'Standard', 'Cardiff'),(9,true,'Standard', 'Cardiff'),(10,true,'Standard', 'Cardiff');


DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `user_id` int NOT NULL PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `default_location` varchar(50) default null
);

INSERT INTO `User`(user_id, first_name, last_name, email, department, password) VALUES (21,'Abdullah','Alotaibi','alotaibia5@cardiff.ac.uk','HR','123456'),(22,'Daniel','Harling','harlingd@cardiff.ac.uk','IT','123456'),(23,'Mahad','Khurshid','khurshidm1@cardiff.ac.uk','Sales','123456'),(24,'Shuwen','Chen','chens100@cardiff.ac.uk','IT','123456');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (31,'James','Jackson');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (32,'Kenneth','Platt');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (33,'Shane','Martinson');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (34,'Alma','Duke');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (35,'Kylie','Woodham');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (36,'Daniela','Westcott');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (37,'Evan','Goddard');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (38,'Haze','Steffen');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (39,'Juliana','Midgely');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (40,'Cecil','Hubert');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (41,'Kolton','Irwin');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (42,'James','Philips');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (43,'Philipa','Jackson');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (44,'Anthony','Joshua');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (45,'John','Smith');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (46,'Alan','Watts');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (47,'Jane','Goodman');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (48,'Theresa','Hedgerly');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (49,'Anthony','Smith');
INSERT INTO `User`(user_id, first_name, last_name) VALUES (50,'Jason','Allen');


DROP TABLE IF EXISTS `Admin`;

CREATE TABLE `Admin` (
  `admin_id` int NOT NULL PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `password` varchar(20) NOT NULL
);


INSERT INTO `Admin` VALUES(1,'admin','admin','admin@cardiff.ac.uk','management','admin');

DROP TABLE IF EXISTS `Maps`;
CREATE TABLE `Maps`(
   `map_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
   `location` varchar(50) NOT NULL,
   `image` varchar(50) NOT NULL
);

INSERT INTO `maps`(location, image) VALUES ('Bristol', '/Images/bristol_numbered.PNG'), ('Cardiff', '/Images/Cardiff_numbered.jpg');

DROP TABLE IF EXISTS `Lottery`;
CREATE TABLE `Lottery`(
    `date` date NOT NULL,
    `user_id` int NOT NULL,
    `location` varchar(50) NOT NULL,
    `resolved` boolean default false
);

DROP TABLE IF EXISTS `Cancel`;
CREATE TABLE IF NOT EXISTS `Cancel` (
    `transaction_id` INT NOT NULL AUTO_INCREMENT,
    `booking_id` INT NULL DEFAULT NULL,
    `booking_date` DATE NOT NULL,
    `User_user_id` INT NOT NULL,
    `Desk_desk_id` INT NOT NULL,
    `User_UserName` VARCHAR(25) NULL DEFAULT NULL,
    `Location` varchar(25),
    `time_stamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`transaction_id`));

    


