-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: library database
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `bookid` int(10) NOT NULL,
  `bookname` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publishing date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (5353,'True Love','Komos De Kamo','1/08/2015'),(53534,'Nolonger at Ease','Chinua Achebe','9/11/2001'),(54632,'Tomorrow','Trust Rickens','3/01/2005'),(54635,'True Love','Komos De Kamo','1/08/2015'),(64647,'Revenge','Timothy Hills','8/04/2012'),(64738,'Oliver Twist','Charlse Dickens','4/10/2004');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_borrowed`
--

DROP TABLE IF EXISTS `books_borrowed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books_borrowed` (
  `booksid` int(10) NOT NULL,
  `bookname` varchar(100) DEFAULT NULL,
  `userid` int(10) NOT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`booksid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_borrowed`
--

LOCK TABLES `books_borrowed` WRITE;
/*!40000 ALTER TABLE `books_borrowed` DISABLE KEYS */;
INSERT INTO `books_borrowed` VALUES (6367,'True Love',4263,'Good Condition'),(6464,'True Love',3231,'Bad Condition'),(6473,'True Love',1323,'Bad Condition'),(6622,'True Love',9842,'Good Condition');
/*!40000 ALTER TABLE `books_borrowed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_reserved`
--

DROP TABLE IF EXISTS `books_reserved`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books_reserved` (
  `reserveid` int(10) NOT NULL,
  `userid` int(100) NOT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`reserveid`),
  KEY `userid` (`userid`),
  CONSTRAINT `books_reserved_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_reserved`
--

LOCK TABLES `books_reserved` WRITE;
/*!40000 ALTER TABLE `books_reserved` DISABLE KEYS */;
INSERT INTO `books_reserved` VALUES (4357,3231,'2001-12-12','Good Condition'),(6322,9842,'2008-04-18','Bad Condition'),(6352,1323,'2007-02-19','Good Condition'),(6353,4263,'2013-07-30','Good Condition');
/*!40000 ALTER TABLE `books_reserved` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(10) NOT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `occupation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1323,'Joel','malaya','Accountant'),(3231,'Joseph','Mawuli','teacher'),(4263,'Josh','Uwezeye','Nurse'),(6574,'Patrick','Tuku','Driver'),(9473,'Brian','Angullo','Lecturer'),(9842,'Kirk','Mwesigwa','Banker');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'library database'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-18 22:17:23
