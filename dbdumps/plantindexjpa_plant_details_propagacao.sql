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
-- Table structure for table `plant_details_propagacao`
--

DROP TABLE IF EXISTS `plant_details_propagacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant_details_propagacao` (
  `plant_details_id` int NOT NULL,
  `propagacao_id` bigint NOT NULL,
  KEY `FKg9nceeyk147stw8v1nukk047l` (`propagacao_id`),
  KEY `FKo273mv9tmn7dlc6fr8ydi8kcl` (`plant_details_id`),
  CONSTRAINT `FKg9nceeyk147stw8v1nukk047l` FOREIGN KEY (`propagacao_id`) REFERENCES `propagacao` (`id`),
  CONSTRAINT `FKo273mv9tmn7dlc6fr8ydi8kcl` FOREIGN KEY (`plant_details_id`) REFERENCES `plant_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant_details_propagacao`
--

LOCK TABLES `plant_details_propagacao` WRITE;
/*!40000 ALTER TABLE `plant_details_propagacao` DISABLE KEYS */;
INSERT INTO `plant_details_propagacao` VALUES (1,1),(2,1),(2,2),(3,1),(4,3),(4,4),(5,3),(6,1),(6,4),(7,4),(7,2),(8,3),(9,3),(9,4),(10,5),(10,4),(10,2),(11,1),(11,4),(11,2),(12,1),(12,4),(13,3),(13,4),(14,4),(15,1),(15,4),(16,2),(17,5),(17,4),(17,2),(18,3),(18,2),(19,3),(20,2),(21,2),(22,3),(22,2),(23,3),(23,2),(24,5),(24,2),(25,3),(26,4),(27,3),(27,2),(28,1),(29,5),(29,2),(30,1),(31,3),(32,5),(32,4),(33,1),(33,2),(34,1),(34,3),(35,4),(35,2),(36,1),(36,3),(36,4),(37,1),(37,4),(38,1),(39,1),(39,4),(40,1),(40,4),(41,1),(42,4),(43,2),(44,2),(45,1),(45,2),(46,2),(47,2),(48,1),(48,3),(49,4),(50,1),(50,3),(51,1),(52,5),(52,4),(53,3),(54,2),(55,2),(56,4),(57,2),(58,4),(59,1),(59,3),(59,2),(60,3),(61,3),(61,4),(62,2),(63,3),(64,3),(64,4),(65,3),(66,3),(66,4),(67,1),(67,2),(68,3),(68,4),(69,1),(69,3),(69,4),(70,3),(70,4),(71,3),(71,4),(72,1),(72,3),(72,4),(73,1),(74,3),(75,3),(75,4),(76,3),(77,5),(77,4),(78,1),(78,3),(78,4),(79,3),(79,4),(80,5),(80,3),(81,1),(82,3),(82,4),(83,3),(84,3),(85,2),(86,1),(86,4),(87,2),(88,1),(88,4),(89,1),(89,2),(90,3),(90,4),(91,2),(92,2),(93,1),(93,4),(94,1),(94,4),(95,4),(96,3),(96,4),(97,3),(97,4),(98,1),(98,4),(99,1),(99,4),(100,2),(101,1),(101,3),(101,4),(102,3),(102,2),(103,1),(103,3),(104,4),(105,3),(106,3),(106,4),(107,1),(107,3),(108,4),(109,1),(110,2),(111,1),(112,4),(113,4),(114,2);
/*!40000 ALTER TABLE `plant_details_propagacao` ENABLE KEYS */;
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
