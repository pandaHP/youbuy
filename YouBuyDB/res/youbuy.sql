-- MySQL dump 10.13  Distrib 5.5.22, for Win64 (x86)
--
-- Host: localhost    Database: youbuy
-- ------------------------------------------------------
-- Server version	5.5.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(50) DEFAULT NULL,
  `city_timezone` varchar(50) DEFAULT NULL,
  `city_long` varchar(50) DEFAULT NULL,
  `city_lat` varchar(50) DEFAULT NULL,
  `city_website` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deal`
--

DROP TABLE IF EXISTS `deal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deal` (
  `deal_id` int(11) NOT NULL AUTO_INCREMENT,
  `deal_origin` varchar(30) DEFAULT NULL,
  `deal_title` varchar(256) DEFAULT NULL,
  `deal_rank` int(11) DEFAULT NULL,
  `deal_url` varchar(256) DEFAULT NULL,
  `deal_img` varchar(300) DEFAULT NULL,
  `deal_cate` varchar(30) DEFAULT NULL,
  `deal_subcate` varchar(30) DEFAULT NULL,
  `deal_desc` varchar(1024) DEFAULT NULL,
  `deal_value` varchar(60) DEFAULT NULL,
  `deal_price` varchar(60) DEFAULT NULL,
  `deal_rebate` varchar(60) DEFAULT NULL,
  `deal_sales_min` int(11) DEFAULT NULL,
  `deal_sales_num` int(11) DEFAULT NULL,
  `deal_sold_out` tinyint(1) DEFAULT NULL,
  `deal_start_time` datetime DEFAULT NULL,
  `deal_end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`deal_id`),
  CONSTRAINT `merch_id` FOREIGN KEY (`deal_id`) REFERENCES `merchant` (`merch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `city_id` FOREIGN KEY (`deal_id`) REFERENCES `city` (`city_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deal`
--

LOCK TABLES `deal` WRITE;
/*!40000 ALTER TABLE `deal` DISABLE KEYS */;
/*!40000 ALTER TABLE `deal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `merchant` (
  `merch_id` int(11) NOT NULL AUTO_INCREMENT,
  `merch_name` varchar(50) DEFAULT NULL,
  `merch_address` varchar(50) DEFAULT NULL,
  `merch_area` varchar(50) DEFAULT NULL,
  `merch_long` varchar(50) DEFAULT NULL,
  `merch_lat` varchar(50) DEFAULT NULL,
  `merch_trafficinfo` varchar(1024) DEFAULT NULL,
  `merch_tel` varchar(15) DEFAULT NULL,
  `merch_email` varchar(100) DEFAULT NULL,
  `merch_url` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`merch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant`
--

LOCK TABLES `merchant` WRITE;
/*!40000 ALTER TABLE `merchant` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-31 21:39:09
