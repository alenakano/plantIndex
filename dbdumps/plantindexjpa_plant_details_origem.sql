-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: plantindexjpa
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `plant_details_origem`
--

DROP TABLE IF EXISTS `plant_details_origem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant_details_origem` (
  `plant_details_id` int NOT NULL,
  `origem_id` bigint NOT NULL,
  KEY `FKjnk6w7ralv5c6ls90jf9ynieb` (`origem_id`),
  KEY `FKeo7jiy48a96n6jsljnpyprnxr` (`plant_details_id`),
  CONSTRAINT `FKeo7jiy48a96n6jsljnpyprnxr` FOREIGN KEY (`plant_details_id`) REFERENCES `plant_details` (`id`),
  CONSTRAINT `FKjnk6w7ralv5c6ls90jf9ynieb` FOREIGN KEY (`origem_id`) REFERENCES `origem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant_details_origem`
--

LOCK TABLES `plant_details_origem` WRITE;
/*!40000 ALTER TABLE `plant_details_origem` DISABLE KEYS */;
INSERT INTO `plant_details_origem` VALUES (1,1),(2,2),(3,3),(4,4),(4,5),(4,6),(5,7),(6,8),(7,9),(8,10),(9,11),(9,12),(10,13),(11,14),(11,15),(12,16),(12,17),(13,18),(14,19),(15,20),(16,21),(17,22),(18,23),(19,24),(19,25),(19,26),(20,27),(21,28),(22,29),(22,30),(22,31),(22,32),(23,33),(24,34),(25,35),(25,36),(26,37),(27,38),(28,39),(29,40),(30,41),(31,42),(32,43),(32,44),(33,45),(34,46),(35,47),(36,48),(37,49),(38,50),(39,51),(40,52),(41,53),(41,54),(42,55),(42,56),(43,57),(43,58),(44,59),(44,60),(45,61),(45,62),(45,63),(46,64),(46,65),(47,66),(48,67),(49,68),(50,69),(50,70),(51,71),(52,72),(53,73),(54,74),(55,75),(55,76),(55,77),(56,78),(56,79),(57,80),(57,81),(57,82),(58,83),(59,84),(60,85),(61,86),(61,87),(62,88),(62,89),(63,90),(64,91),(65,92),(66,93),(67,94),(68,95),(68,96),(69,97),(70,98),(71,99),(72,100),(73,101),(73,102),(73,103),(74,104),(75,105),(76,106),(77,107),(77,108),(78,109),(79,110),(80,111),(81,112),(81,113),(82,114),(82,115),(83,116),(83,117),(83,118),(83,119),(84,120),(84,121),(84,122),(84,123),(85,124),(86,125),(86,126),(86,127),(87,128),(88,129),(89,130),(89,131),(89,132),(89,133),(90,134),(91,135),(92,136),(92,137),(93,138),(94,139),(95,140),(96,141),(97,142),(98,143),(99,144),(100,145),(100,146),(100,147),(100,148),(100,149),(101,150),(102,151),(103,152),(104,153),(104,154),(105,155),(106,156),(107,157),(107,158),(108,159),(109,160),(109,161),(110,162),(111,163),(111,164),(112,165),(112,166),(113,167),(113,168),(113,169),(114,170);
/*!40000 ALTER TABLE `plant_details_origem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-01  8:52:20
