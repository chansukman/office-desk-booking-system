CREATE DATABASE  IF NOT EXISTS `adms2`;
USE `adms2`;

DROP TABLE IF EXISTS `Booking`;

CREATE TABLE `Booking` (
                           `booking_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           `booking_date` date NOT NULL,
                           `booking_time` time NOT NULL,
                           `User_user_id` int NOT NULL,
                           `Desk_desk_id` int NOT NULL,
                           `transaction_timestamp` timestamp NULL DEFAULT NULL
);


INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-11-20','13:00:00',21,1);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-11-20','13:00:00',22,2);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-11-20','13:00:00',23,3);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-11-20','13:00:00',24,4);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-11-21','13:00:00',21,1);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-11-21','13:00:00',22,4);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-11-21','13:00:00',23,6);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-1','13:00:00',21,1);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-2','13:00:00',22,2);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-3','13:00:00',23,3);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-4','13:00:00',24,4);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-5','13:00:00',21,1);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-7','13:00:00',22,4);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-8','13:00:00',23,6);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-10','13:00:00',22,2);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-11','13:00:00',22,2);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-12','13:00:00',22,2);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-13','13:00:00',22,2);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id) VALUES ('2021-12-14','13:00:00',22,2);



DROP TABLE IF EXISTS `Desk`;

CREATE TABLE `Desk` (
  `desk_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `desk_number` int NOT NULL,
  `has_monitors` boolean NOT NULL,
  `desk_type` varchar(50) NOT NULL,
  `desk_location` varchar(50) NOT NULL
);


INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (1,true,'Standing', 'Bristol'),(2,true,'Standing', 'Bristol'),(3,true,'Standing', 'Bristol'),(4,true,'Standing', 'Bristol'),(5,false,'Standard', 'Bristol'),(6,false,'Standard', 'Bristol'),(7,false,'Standard', 'Bristol');
INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (8,true,'Standard', 'Bristol'),(9,true,'Standard', 'Bristol'),(10,true,'Standard', 'Bristol'),(11,true,'Standard', 'Bristol'),(12,false,'Standard', 'Bristol'),(13,false,'Standard', 'Bristol'),(14,false,'Standard', 'Bristol');
INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (15,true,'Standard', 'Bristol'),(16,true,'Standard', 'Bristol'),(17,true,'Standard', 'Bristol'),(18,true,'Standard', 'Bristol'),(19,false,'Standard', 'Bristol'),(20,false,'Standard', 'Bristol'),(21,false,'Standard', 'Bristol');
INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (22,true,'Standard', 'Bristol'),(23,true,'Standard', 'Bristol'),(24,true,'Standard', 'Bristol'),(25,true,'Standard', 'Bristol');

INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (1,true,'Standard', 'cardiff'),(2,true,'Standard', 'cardiff'),(3,true,'Standard', 'cardiff'),(4,true,'Standard', 'cardiff'),(5,false,'Standard', 'cardiff'),(6,false,'Standard', 'cardiff'),(7,false,'Standard', 'cardiff');
INSERT INTO `Desk`(desk_number, has_monitors, desk_type, desk_location) VALUES (8,true,'Standard', 'cardiff'),(9,true,'Standard', 'cardiff'),(10,true,'Standard', 'cardiff');


DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `user_id` int NOT NULL PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `password` varchar(20) NOT NULL
);

CREATE TABLE `Admin` (
  `admin_id` int NOT NULL PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `password` varchar(20) NOT NULL
);



INSERT INTO `User` VALUES (21,'Abdullah','Alotaibi','abdullah.alotaibi@me.com','HR','123456'),(22,'Daniel','Harling','daniel@harling.com','IT','123456'),(23,'Mahad','Khurshid','MahadKhurshid@Khurshid.com','Sales','123456'),(24,'Shuwen','Chen','Chen@Shuwen.com','IT','123456');
INSERT INTO `Admin` VALUES(1,'admin','admin','admin@cardiff.ac.uk','management','admin');

DROP TABLE IF EXISTS `Maps`;
CREATE TABLE `Maps`(
                       `map_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       `location` varchar(50) NOT NULL,
                       `image` varchar(50) NOT NULL
);

INSERT INTO `maps`(location, image) VALUES ('Bristol', '/Images/bristol_numbered.PNG'), ('Cardiff', '/Images/Cardiff_numbered.jpg');

