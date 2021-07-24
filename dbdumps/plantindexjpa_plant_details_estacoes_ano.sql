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
-- Table structure for table `plant_details_estacoes_ano`
--

DROP TABLE IF EXISTS `plant_details_estacoes_ano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plant_details_estacoes_ano` (
  `plant_details_id` int NOT NULL,
  `estacoes_ano_id` bigint NOT NULL,
  KEY `FKigg46vli074bsdqrn31fp78eh` (`estacoes_ano_id`),
  KEY `FK7n9lxbk8107uhen468qktw6aj` (`plant_details_id`),
  CONSTRAINT `FK7n9lxbk8107uhen468qktw6aj` FOREIGN KEY (`plant_details_id`) REFERENCES `plant_details` (`id`),
  CONSTRAINT `FKigg46vli074bsdqrn31fp78eh` FOREIGN KEY (`estacoes_ano_id`) REFERENCES `estacoes_ano` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plant_details_estacoes_ano`
--

LOCK TABLES `plant_details_estacoes_ano` WRITE;
/*!40000 ALTER TABLE `plant_details_estacoes_ano` DISABLE KEYS */;
INSERT INTO `plant_details_estacoes_ano` VALUES (1,2),(1,5),(2,1),(2,2),(2,1),(2,2),(3,1),(3,2),(3,1),(3,2),(4,1),(4,1),(4,2),(5,1),(5,2),(5,5),(6,1),(6,2),(6,2),(6,3),(7,5),(7,5),(8,3),(8,5),(9,1),(9,2),(9,3),(10,1),(10,5),(11,5),(11,5),(12,5),(12,5),(13,5),(13,5),(14,1),(14,2),(14,3),(15,1),(15,2),(15,5),(16,6),(16,5),(17,5),(17,5),(18,5),(18,5),(19,6),(19,3),(20,1),(20,5),(21,1),(21,2),(21,5),(22,1),(22,2),(22,5),(23,2),(23,1),(24,6),(24,1),(25,6),(25,5),(26,6),(26,6),(27,2),(27,5),(28,3),(28,5),(29,5),(29,5),(30,1),(30,2),(30,1),(31,5),(31,5),(32,1),(32,5),(33,1),(33,5),(34,5),(34,5),(35,1),(35,2),(35,1),(35,4),(36,5),(36,5),(37,5),(37,5),(38,3),(38,4),(38,1),(38,2),(39,1),(39,2),(39,1),(40,1),(40,5),(41,1),(41,2),(41,5),(42,1),(42,2),(42,5),(43,6),(43,5),(44,3),(44,4),(44,5),(45,5),(45,5),(46,2),(46,1),(47,2),(47,3),(48,1),(48,2),(48,1),(49,2),(49,2),(50,5),(50,3),(50,4),(51,1),(51,2),(51,5),(52,1),(52,2),(52,5),(53,2),(53,1),(54,6),(54,5),(55,2),(55,3),(55,5),(56,1),(56,2),(56,5),(57,2),(57,3),(57,5),(58,2),(58,5),(59,5),(59,1),(59,4),(60,3),(60,5),(61,5),(61,5),(62,2),(62,3),(62,5),(63,1),(63,2),(63,5),(64,6),(64,5),(65,4),(65,5),(66,5),(66,5),(67,6),(67,5),(68,5),(68,5),(69,2),(69,5),(70,1),(70,4),(70,5),(71,1),(71,4),(71,3),(72,5),(72,5),(73,2),(73,1),(74,6),(74,5),(75,2),(75,1),(76,1),(76,4),(76,5),(77,1),(77,2),(77,3),(78,2),(78,5),(79,1),(79,2),(79,5),(80,3),(80,5),(81,2),(81,4),(82,1),(82,2),(82,5),(83,1),(83,4),(83,5),(84,1),(84,2),(84,5),(85,5),(85,3),(86,5),(86,5),(87,1),(87,3),(87,4),(87,5),(88,2),(88,3),(89,5),(89,5),(90,5),(90,5),(91,5),(91,5),(92,5),(92,5),(93,5),(93,5),(94,1),(94,2),(94,5),(95,1),(95,2),(95,5),(96,3),(96,5),(97,5),(97,5),(98,5),(98,1),(98,2),(99,1),(99,4),(100,5),(100,5),(101,1),(101,1),(101,3),(102,2),(102,3),(102,5),(103,5),(103,5),(104,5),(104,5),(105,5),(105,5),(106,2),(106,5),(107,1),(107,4),(108,1),(108,2),(108,3),(109,3),(109,4),(109,5),(110,5),(110,5),(111,1),(111,2),(111,1),(111,4),(112,2),(112,3),(112,5),(113,5),(113,5),(114,1),(114,4),(114,5);
/*!40000 ALTER TABLE `plant_details_estacoes_ano` ENABLE KEYS */;
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
