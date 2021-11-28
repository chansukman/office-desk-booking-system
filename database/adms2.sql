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
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id)  VALUES ('2021-11-20','13:00:00',22,2);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id)  VALUES ('2021-11-20','13:00:00',23,3);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id)  VALUES ('2021-11-20','13:00:00',24,4);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id)  VALUES ('2021-11-21','13:00:00',21,1);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id)  VALUES ('2021-11-21','13:00:00',22,4);
INSERT INTO `Booking`(booking_date, booking_time, User_user_id, Desk_desk_id)  VALUES ('2021-11-21','13:00:00',23,6);



DROP TABLE IF EXISTS `Desk`;

CREATE TABLE `Desk` (
  `desk_id` int NOT NULL PRIMARY KEY,
  `has_window` boolean NOT NULL,
  `desk_type` varchar(50) NOT NULL
);


INSERT INTO `Desk` VALUES (1,true,'Standing'),(2,true,'Standing'),(3,true,'Standing'),(4,true,'Standing'),(5,false,'Standard'),(6,false,'Standard'),(7,false,'Standard');
INSERT INTO `Desk` VALUES (8,true,'Standard'),(9,true,'Standard'),(10,true,'Standard'),(11,true,'Standard'),(12,false,'Standard'),(13,false,'Standard'),(14,false,'Standard');
INSERT INTO `Desk` VALUES (15,true,'Standard'),(16,true,'Standard'),(17,true,'Standard'),(18,true,'Standard'),(19,false,'Standard'),(20,false,'Standard'),(21,false,'Standard');
INSERT INTO `Desk` VALUES (22,true,'Standard'),(23,true,'Standard'),(24,true,'Standard'),(25,true,'Standard');




DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `user_id` int NOT NULL PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `department` varchar(50) DEFAULT NULL
);



INSERT INTO `User` VALUES (21,'Abdullah','Alotaibi','abdullah.alotaibi@me.com','HR'),(22,'Daniel','Harling','daniel@harling.com','IT'),(23,'Mahad','Khurshid','MahadKhurshid@Khurshid.com','Sales'),(24,'Shuwen','Chen','Chen@Shuwen.com','IT'),(25,'Mohd',' ',' ','Sales');

