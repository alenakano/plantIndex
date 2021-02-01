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
-- Table structure for table `origem`
--

DROP TABLE IF EXISTS `origem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `origem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `origem`
--

LOCK TABLES `origem` WRITE;
/*!40000 ALTER TABLE `origem` DISABLE KEYS */;
INSERT INTO `origem` VALUES (1,'América do Sul'),(2,'Algum laboratório'),(3,'Madagascar'),(4,'Ásia'),(5,'Austrália'),(6,'Oceania'),(7,'Brasil'),(8,'América Central'),(9,'Américas'),(10,'África do Sul'),(11,'Europa'),(12,'Ásia'),(13,'América do Sul'),(14,'Ásia'),(15,'Oceania'),(16,'Índia'),(17,'Sri Lanka'),(18,'África'),(19,'Ásia'),(20,'Bolívia'),(21,'Brasil'),(22,'Américas'),(23,'Brasil'),(24,'Peru'),(25,'Brasil'),(26,'Colômbia'),(27,'África do Sul'),(28,'Brasil'),(29,'Brasil'),(30,'Equador'),(31,'Bolívia'),(32,'Venezuela'),(33,'Sul da Ásia'),(34,'Indonésia'),(35,'China'),(36,'Camboja'),(37,'Argentina'),(38,'México'),(39,'Brasil'),(40,'América do Sul'),(41,'Sumatra'),(42,'Java'),(43,'África'),(44,'África do Sul'),(45,'Américas Central'),(46,'Brasil'),(47,'Ilha de Java'),(48,'Ásia'),(49,'Brasil'),(50,'África do Sul'),(51,'Brasil'),(52,'Mediterrâneo'),(53,'Brasil'),(54,'Argentina'),(55,'México'),(56,'Costa Rica'),(57,'China'),(58,'Índia'),(59,'China'),(60,'Japão'),(61,'China'),(62,'Coreia'),(63,'Japão'),(64,'Grécia'),(65,'Balcãs'),(66,'África'),(67,'Etiópia'),(68,'Brasil'),(69,'Américas Central'),(70,'do Sul'),(71,'África do Sul'),(72,'África do Sul'),(73,'Brasil'),(74,'Ilhas Salomão'),(75,'China'),(76,'Coreia'),(77,'Japão'),(78,'África'),(79,'Península Arábica'),(80,'Japão'),(81,'China'),(82,'Coreia'),(83,'Estados Unidos'),(84,'México'),(85,'Hong Kong'),(86,'China'),(87,'Japão'),(88,'Nepal'),(89,'China'),(90,'Brasil'),(91,'híbrido'),(92,'Japão'),(93,'Madagascar'),(94,'América Central'),(95,'Índia'),(96,'Malásia'),(97,'Brasil'),(98,'Índia'),(99,'México'),(100,'Brasil'),(101,'Índia'),(102,'Vietnã'),(103,'Tailândia'),(104,'Brasil'),(105,'Europa'),(106,'Brasil'),(107,'Ásia'),(108,'África'),(109,'Ásia'),(110,'Brasil'),(111,'África do Sul'),(112,'China'),(113,'Japão'),(114,'Índia'),(115,'Sri Lanka'),(116,'Antilhas'),(117,'Equador'),(118,'Guianas'),(119,'México'),(120,'Antilhas'),(121,'Equador'),(122,'Guianas'),(123,'México'),(124,'África'),(125,'México'),(126,'Onduras'),(127,'Venezuela'),(128,'Mediterrâneo'),(129,'Brasil'),(130,'Malásia'),(131,'Nova Guiné'),(132,'Filipinas'),(133,'Indonésia'),(134,'África do Sul'),(135,'Brasil'),(136,'Europa'),(137,'Ásia'),(138,'Colômbia'),(139,'Ásia'),(140,'Brasil'),(141,'Índia'),(142,'Américas'),(143,'Europa'),(144,'Europa'),(145,'China'),(146,'Malásia'),(147,'Indonésia'),(148,'Himalaia'),(149,'Sri Lanka'),(150,'Índia'),(151,'África do Sul'),(152,'México'),(153,'Uganda'),(154,'Quênia'),(155,'Américas'),(156,'Brasil'),(157,'Brasil'),(158,'Peru'),(159,'Brasil'),(160,'Peru'),(161,'Equador'),(162,'América Central'),(163,'África'),(164,'Sri Lanka'),(165,'Índia'),(166,'Malásia'),(167,'Ásia'),(168,'Europa'),(169,'América'),(170,'Madagascar');
/*!40000 ALTER TABLE `origem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-01  8:52:21
