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
-- Table structure for table `plant_details_iluminacao`
--

DROP TABLE IF EXISTS `plant_details_iluminacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant_details_iluminacao` (
  `plant_details_id` int NOT NULL,
  `iluminacao_id` bigint NOT NULL,
  KEY `FKo9dm0fcl86g3h7jsnesnwl0ix` (`iluminacao_id`),
  KEY `FKfm258s37coipuwfasgv7ndwdo` (`plant_details_id`),
  CONSTRAINT `FKfm258s37coipuwfasgv7ndwdo` FOREIGN KEY (`plant_details_id`) REFERENCES `plant_details` (`id`),
  CONSTRAINT `FKo9dm0fcl86g3h7jsnesnwl0ix` FOREIGN KEY (`iluminacao_id`) REFERENCES `iluminacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant_details_iluminacao`
--

LOCK TABLES `plant_details_iluminacao` WRITE;
/*!40000 ALTER TABLE `plant_details_iluminacao` DISABLE KEYS */;
INSERT INTO `plant_details_iluminacao` VALUES (1,2),(1,3),(2,2),(2,1),(3,3),(4,3),(5,2),(5,1),(6,2),(7,2),(8,2),(8,1),(9,2),(9,3),(10,2),(10,3),(12,3),(13,2),(13,3),(14,2),(14,1),(15,3),(16,2),(17,2),(18,2),(18,1),(19,2),(20,3),(21,2),(21,1),(22,2),(22,1),(24,2),(24,1),(26,3),(27,3),(28,2),(28,3),(29,3),(30,3),(31,3),(32,3),(33,2),(33,1),(34,3),(35,2),(36,3),(37,3),(38,2),(38,3),(39,3),(40,3),(41,2),(41,3),(42,2),(42,3),(43,2),(43,3),(44,2),(45,2),(46,2),(46,3),(47,2),(48,3),(49,3),(50,2),(50,3),(51,3),(52,3),(53,2),(53,3),(54,2),(54,3),(56,3),(57,2),(58,3),(59,2),(59,3),(60,2),(60,3),(61,3),(62,2),(63,2),(63,3),(64,2),(65,3),(66,3),(67,2),(67,1),(68,3),(69,3),(70,3),(71,3),(72,2),(72,3),(73,3),(74,2),(74,1),(75,3),(76,3),(77,2),(77,3),(78,2),(78,3),(79,2),(79,3),(80,2),(80,3),(81,3),(82,3),(83,3),(84,2),(84,3),(85,2),(85,3),(86,2),(86,1),(88,2),(88,1),(89,2),(89,3),(90,3),(91,3),(92,2),(92,1),(93,2),(93,3),(94,3),(95,2),(96,2),(96,3),(97,2),(97,3),(98,3),(99,2),(99,3),(100,3),(101,2),(101,3),(102,2),(102,3),(103,2),(103,3),(104,2),(104,3),(105,2),(105,1),(106,3),(107,2),(108,2),(108,3),(109,2),(110,2),(111,2),(111,1),(112,3),(113,2),(113,3),(114,2);
/*!40000 ALTER TABLE `plant_details_iluminacao` ENABLE KEYS */;
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
