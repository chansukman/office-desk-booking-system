CREATE DATABASE  IF NOT EXISTS `adms2`;
USE `adms2`;

DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `booking_date` date NOT NULL,
  `User_user_id` int NOT NULL,
  `desk_desk_id` int NOT NULL,
  `User_UserName` varchar(25),
  `Location` varchar(25),
  `isAttended` TINYINT NULL DEFAULT 0
  );
  
DROP TABLE IF EXISTS `desk`;
CREATE TABLE `desk` (
  `desk_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `desk_number` int NOT NULL,
  `has_monitors` boolean NOT NULL default true,
  `desk_type` varchar(50) NOT NULL default 'Standard',
  `desk_location` varchar(50) NOT NULL
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `default_location` varchar(50) default null
);

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_id` int NOT NULL PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `password` varchar(20) NOT NULL
);
DROP TABLE IF EXISTS `maps`;
CREATE TABLE `maps`(
   `map_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
   `location` varchar(50) NOT NULL,
   `image` varchar(50) NOT NULL
);

DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery`(
    `date` date NOT NULL,
    `user_id` int NOT NULL,
    `location` varchar(50) NOT NULL,
    `resolved` boolean default false
);

DROP TABLE IF EXISTS `cancel`;
CREATE TABLE IF NOT EXISTS `cancel` (
    `transaction_id` INT NOT NULL AUTO_INCREMENT,
    `booking_id` INT NULL DEFAULT NULL,
    `booking_date` DATE NOT NULL,
    `User_user_id` INT NOT NULL,
    `desk_desk_id` INT NOT NULL,
    `User_UserName` VARCHAR(25) NULL DEFAULT NULL,
    `Location` varchar(25),
    `isAttended` INT,
PRIMARY KEY (`transaction_id`));



-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-11-20',24,14);
-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-12-09',24,14);
-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-12-10',24,14);
-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-12-11',24,14);
-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-12-11',23,15);
-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-12-12',24,14);
-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-12-13',24,14);
-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-12-14',24,14);
-- INSERT INTO `Booking`(booking_date, User_user_id, desk_desk_id) VALUES ('2021-12-08',24,14);





INSERT INTO `desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (1,true,'Standing', 'Bristol'),(2,true,'Standing', 'Bristol'),(3,true,'Standing', 'Bristol'),(4,true,'Standing', 'Bristol'),(5,false,'Standard', 'Bristol'),(6,false,'Standard', 'Bristol'),(7,false,'Standard', 'Bristol');
INSERT INTO `desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (8,true,'Standard', 'Bristol'),(9,true,'Standard', 'Bristol'),(10,true,'Standard', 'Bristol'),(11,true,'Standard', 'Bristol'),(12,false,'Standard', 'Bristol'),(13,false,'Standard', 'Bristol'),(14,false,'Standard', 'Bristol');
INSERT INTO `desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (15,true,'Standard', 'Bristol'),(16,true,'Standard', 'Bristol'),(17,true,'Standard', 'Bristol'),(18,true,'Standard', 'Bristol'),(19,false,'Standard', 'Bristol'),(20,false,'Standard', 'Bristol'),(21,false,'Standard', 'Bristol');
INSERT INTO `desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (22,true,'Standard', 'Bristol'),(23,true,'Standard', 'Bristol'),(24,true,'Standard', 'Bristol'),(25,true,'Standard', 'Bristol');

INSERT INTO `desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (1,true,'Standard', 'Cardiff'),(2,true,'Standard', 'Cardiff'),(3,true,'Standard', 'Cardiff'),(4,true,'Standard', 'Cardiff'),(5,false,'Standard', 'Cardiff'),(6,false,'Standard', 'Cardiff'),(7,false,'Standard', 'Cardiff');
INSERT INTO `desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (8,true,'Standard', 'Cardiff'),(9,true,'Standard', 'Cardiff'),(10,true,'Standard', 'Cardiff');



INSERT INTO `user`(user_id, first_name, last_name, email, department, password) VALUES (21,'Abdullah','Alotaibi','alotaibia5@cardiff.ac.uk','HR','123456'),(22,'Daniel','Harling','harlingd@cardiff.ac.uk','IT','123456'),(23,'Mahad','Khurshid','khurshidm1@cardiff.ac.uk','Sales','123456'),(24,'Shuwen','Chen','chens100@cardiff.ac.uk','IT','123456');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (31,'James','Jackson');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (32,'Kenneth','Platt');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (33,'Shane','Martinson');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (34,'Alma','Duke');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (35,'Kylie','Woodham');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (36,'Daniela','Westcott');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (37,'Evan','Goddard');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (38,'Haze','Steffen');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (39,'Juliana','Midgely');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (40,'Cecil','Hubert');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (41,'Kolton','Irwin');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (42,'James','Philips');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (43,'Philipa','Jackson');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (44,'Anthony','Joshua');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (45,'John','Smith');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (46,'Alan','Watts');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (47,'Jane','Goodman');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (48,'Theresa','Hedgerly');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (49,'Anthony','Smith');
INSERT INTO `user`(user_id, first_name, last_name) VALUES (50,'Jason','Allen');




INSERT INTO `admin` VALUES(1,'admin','admin','admin@cardiff.ac.uk','management','admin');



INSERT INTO `maps`(location, image) VALUES ('Bristol', '/Images/bristol_numbered.PNG'), ('Cardiff', '/Images/Cardiff_numbered.jpg');

INSERT into lottery(date, user_id, location) value ('2022-01-06', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-02-03', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-03-03', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-04-07', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-05-05', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-06-02', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-07-07', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-08-04', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-09-01', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-10-06', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-11-03', 1, 'Bristol') ;
INSERT into lottery(date, user_id, location) value ('2022-12-01', 1, 'Bristol') ;


INSERT into lottery(date, user_id, location) value ('2021-12-14', 1, 'Cardiff') ;

INSERT into lottery(date, user_id, location) value ('2021-12-14', 34, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 35, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 36, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 37, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 38, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 39, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 40, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 41, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 42, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 43, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 44, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 45, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 46, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 47, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 48, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 49, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 21, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 22, 'Cardiff') ;
INSERT into lottery(date, user_id, location) value ('2021-12-14', 23, 'Cardiff') ;


