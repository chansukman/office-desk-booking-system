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



INSERT INTO `Booking` VALUES (1,'2021-11-20','13:00:00',24,14,NULL);


DROP TABLE IF EXISTS `Desk`;

CREATE TABLE `Desk` (
  `desk_id` int NOT NULL PRIMARY KEY,
  `has_window` tinyint NOT NULL,
  `desk_location` int DEFAULT NULL
);


INSERT INTO `Desk` VALUES (10,1,1),(11,0,1),(12,0,1),(13,0,2),(14,1,1),(15,0,2),(16,0,1),(17,1,2);




DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `user_id` int NOT NULL PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department` varchar(50) DEFAULT NULL
);



INSERT INTO `User` VALUES (21,'Abdullah','Alotaibi','abdullah.alotaibi@me.com','HR'),(22,'Daniel','Harling','daniel@harling.com','IT'),(23,'Mahad','Khurshid','MahadKhurshid@Khurshid.com','Sales'),(24,'Shuwen','Chen','Chen@Shuwen.com','IT'),(25,'Mohd',' ',' ','Sales');

