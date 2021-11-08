CREATE DATABASE  IF NOT EXISTS `mini-project-db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mini-project-db`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mini-project-db
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(100) NOT NULL,
  `item_price` varchar(100) NOT NULL,
  `item_url` varchar(200) NOT NULL,
  `item_description` varchar(100) NOT NULL,
  `wishlist_number` int NOT NULL,
  `user_email` varchar(100) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'xzxzx','sdsdsd','sdsd','sdsd',12,'cacxcxc'),(2,'xcxc','swewe','wewe','wewe',12,'2323'),(3,'2323','2323','323','2323',11,'222'),(4,'l,m.','4545','mm,','mlml',12,'jjkjll'),(5,'cxc','xcxc','xcx','xcxc',55,'dfxcxc'),(6,'cxc','xcxc','xcx','xcxc',554,'dfxcxc'),(7,'xzxz','zxz','zxzx','zxzx',333,'ccxcx'),(8,'sdsd','sdsdsd','sds','sdsd',444,'scsdd'),(9,'xzxz','zxx','zx','zxzx',12,'vs@hotmail.com'),(10,'sdsd','sdd','sds','sds',11,'vs@hotmail.com'),(11,'sdsd','sdd','sds','sds',11,'vs@hotmail.com'),(12,'sdsd','sdd','sds','sds',11,'vs@hotmail.com'),(13,'sad','sdd','dsdsdsds','sdsd',2,'vs@hotmail.com'),(14,'we','sdd','sd','sds',10000,'vs@hotmail.com'),(15,'sds','sdsdsds','sds','sds',2323,'sdsd'),(16,'cxcx','xcxc','xcx','xc',0,'vs@hotmail.com'),(17,'sds','sdsd','sds','sds',343434,'vs@hotmail.com'),(18,'asa','asas','asa','asas',232323,'vs@hotmail.com'),(19,'sds','sdd','sd','sd',12,'vs@hotmail.com'),(20,'sd','sd','sd','sd',23,'vs@hotmail.com'),(21,'xc','xc','xc','xc',1212,'vs@hotmail.com'),(22,'we','we','we','we',223232323,'vs@hotmail.com'),(23,'23','23','23','23',0,'232'),(24,'sd','sd','gf','fg',33,'sfd'),(25,'sd','sd','ds','sds',0,'test1'),(26,'sd','sd','sd','sd',111,'vs@hotmail.com'),(27,'sd','ds','d','d',12,'we'),(28,'33','33','33','33',33,'test3'),(29,'sd','ds','d','d',0,'test3'),(30,'sdsd','sds','sds','sds',23,'test3'),(31,'sdsd','sd','sd','ssd',23,'vs@hotmail.com'),(32,'cxc','xcx','xcxc','xcx',0,'cxcx');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-08 10:48:24
