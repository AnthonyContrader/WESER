CREATE DATABASE  IF NOT EXISTS `weser` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `weser`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
<<<<<<< HEAD
-- Host: localhost    Database: weserusers
=======
-- Host: localhost    Database: weser
>>>>>>> b6691aa9e4bad79f3b5f0dd68495122793ad5b56
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
<<<<<<< HEAD
-- Table structure for table `devices`
--

DROP TABLE IF EXISTS `devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `devices` (
  `dev_id` int(11) NOT NULL AUTO_INCREMENT,
  `reg_number` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dev_type` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `min_press` int(4) NULL,
  `max_press` int(4) NULL,
  `min_cir` int(4) NULL,
  `max_cir` int(4) NULL,
  `min_breath` int(4) NULL,
  `max_breath` int(4) NULL,
  `min_temp` float(2,1) NULL,
  `max_temp` float(2,1) NULL,

 PRIMARY KEY (`dev_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all devices';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `users`
--


DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
=======
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
>>>>>>> b6691aa9e4bad79f3b5f0dd68495122793ad5b56
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cf` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all users';
/*!40101 SET character_set_client = @saved_cs_client */;

<<<<<<< HEAD


--
-- Table structure for table `cares`
--


DROP TABLE IF EXISTS `cares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cares` (
  `care_id` int(11) NOT NULL AUTO_INCREMENT,
  `pat_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
=======
LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','weser','user','user','abcdefg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


--
-- Table structure for table `devices`
--

DROP TABLE IF EXISTS `devices`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `devices` (
  `dev_id` int(11) NOT NULL AUTO_INCREMENT,
  `reg_number` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dev_type` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `min_press` int(4) NULL,
  `max_press` int(4) NULL,
  `min_cir` int(4) NULL,
  `max_cir` int(4) NULL,
  `min_breath` int(4) NULL,
  `max_breath` int(4) NULL,
  `min_temp` float(2,1) NULL,
  `max_temp` float(2,1) NULL,
  
  PRIMARY KEY (`dev_id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all devices';
  
--
-- Table structure for table `cares`
--

DROP TABLE IF EXISTS `cares`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cares` (
  `care_id` int(11) NOT NULL AUTO_INCREMENT,
   `pat_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
>>>>>>> b6691aa9e4bad79f3b5f0dd68495122793ad5b56
  `pat_cf` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `pat_age` int(3) COLLATE utf8_unicode_ci NOT NULL,
  `patology` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `care_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
<<<<<<< HEAD
  `quantity` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `notes` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`care_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all cares';
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `payments`
--


DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
=======
  `quantity` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `notes` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`care_id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all cares';
  
   --
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
>>>>>>> b6691aa9e4bad79f3b5f0dd68495122793ad5b56
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payments` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_type` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `card_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `card_owner` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `card_expire` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
<<<<<<< HEAD
  `cvv` int(4) COLLATE utf8_unicode_ci NOT NULL, 
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert payments credential';
/*!40101 SET character_set_client = @saved_cs_client */;




--
-- Dumping data for table `users`
--


LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','weser','user','user','abcdfg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;





-- Dump completed on 2019-03-19 11:25:37
=======
  `cvv` int(4) COLLATE utf8_unicode_ci NOT NULL,
 
  PRIMARY KEY (`pay_id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert payment credentials';
  
>>>>>>> b6691aa9e4bad79f3b5f0dd68495122793ad5b56
