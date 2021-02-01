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
-- Table structure for table `outronome`
--

DROP TABLE IF EXISTS `outronome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `outronome` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=376 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outronome`
--

LOCK TABLES `outronome` WRITE;
/*!40000 ALTER TABLE `outronome` DISABLE KEYS */;
INSERT INTO `outronome` VALUES (1,'coração-magoado'),(2,'coração-de-maria'),(3,''),(4,'coroa-de-espinho'),(5,'colchão-de-noiva'),(6,'dois-irmãos'),(7,'bem-casado'),(8,'aguaxima-do-mangue'),(9,'algodoeiro-da-índia'),(10,'majagua'),(11,'baru'),(12,'embira'),(13,'embira-do-mangue'),(14,'guaxima-do-mangue'),(15,'ibaxama'),(16,'manhoco'),(17,'quiabo-do-mangue'),(18,'uacima-da-praia'),(19,''),(20,''),(21,''),(22,''),(23,''),(24,''),(25,'café-de-salão-imperial'),(26,'crossandra-laranja'),(27,'crossandra-salmão'),(28,'bunda-de-mulata'),(29,'olho-preto'),(30,'erva-de-cabrita'),(31,'amor-perfeito-de-verão'),(32,''),(33,''),(34,'erva-de-santa-luzia'),(35,''),(36,'planta-mosaico'),(37,''),(38,'calatéia-carlina'),(39,''),(40,'jiboia-prateada'),(41,'escorpião'),(42,'orelha-de-elefante'),(43,''),(44,'petúnia-comum'),(45,'cacto-pena'),(46,'abaneiro'),(47,'abano'),(48,'manga-da-praia'),(49,'mangue-bravo'),(50,'mangue-da-praia'),(51,'cana-do-brejo'),(52,'biri'),(53,'bananeirinha-da-índia'),(54,'bananeirinha-de-jardim'),(55,'ixora'),(56,'ixora-africana'),(57,'Coração-magoado'),(58,'lírio-d\'água'),(59,'loto-azul'),(60,'loto-egípcio'),(61,'lírio-sagrado-do-nilo'),(62,'banana-do-mato'),(63,'ceriman'),(64,'monstera'),(65,'abacaxi-do-reino'),(66,'pau-d\'arco'),(67,'ipê-do-cerrado'),(68,'capim-palmeira'),(69,'rosa'),(70,'roseira'),(71,'roseira-grandiflora'),(72,'rosa-arbustiva'),(73,'rosa-miniatura'),(74,'mini-rosa'),(75,'roseira-miniatura'),(76,'rosa-silvestre'),(77,'roseira-trepadeira'),(78,'roseira-rugosa'),(79,'sibipira'),(80,'sebipira'),(81,'coração-de-negro'),(82,'clerodendro'),(83,'clerodendro-trepador'),(84,'Cattleya'),(85,'Cattleya walkeriana'),(86,'rosmarino'),(87,'alecrim-comum'),(88,'alecrim-de-casa'),(89,'alecrim-de-cheiro'),(90,'alecrim-de-horta'),(91,'alecrim-de-jardim'),(92,'alecrim-rosmarinho'),(93,'erva-coroada'),(94,'erva-da-graça'),(95,'flor-de-olimpo'),(96,'rosa-marinha'),(97,'rosmarinho'),(98,'paineira-rosa'),(99,'árvore-de-lã'),(100,'barriguda'),(101,'árvore-de-paina'),(102,'paina-de-seda'),(103,'paineira-fêmea'),(104,'Chorisia speciosa'),(105,'planta-cabeça-de-flecha'),(106,'laranjeira'),(107,'laranja-lima'),(108,'laranja-pera'),(109,'laranja-bahia'),(110,'laranja-baiana'),(111,'maravilha'),(112,'madressilva-do-japão'),(113,'madressilva-da-china'),(114,'madressilva-dos-jardins'),(115,'rápis'),(116,'pameira-ráfis'),(117,'palmeira-rápis'),(118,'romanzeira'),(119,'violeta-africana'),(120,'cafeeiro'),(121,'café-arábica'),(122,'evólvulo'),(123,'ananá'),(124,'ananás'),(125,'abacaxizeiro'),(126,''),(127,'clerodendro'),(128,'beldroega'),(129,'time fool'),(130,'hera-do-diabo'),(131,'emerocale'),(132,'emerocalis'),(133,'hemerocalis'),(134,'lírio-de-são-josé'),(135,'lírio-de-dia'),(136,'lírio-de-um-dia'),(137,'daylily'),(138,'adênio'),(139,'adenium'),(140,'lírio-impala'),(141,'mini-baobá'),(142,'falso-baobá'),(143,'neofinétia'),(144,'corona-solar'),(145,'margarida-do-peru'),(146,'camarão-vermelho'),(147,'flor-camarão'),(148,'camarão-vegetal'),(149,'planta-camarão'),(150,'Beloperone guttata'),(151,'bauínia-de-hong-kong'),(152,'unha-de-vaca'),(153,'pata-de-vaca'),(154,'lírio-leopardo'),(155,'Coelogyne ovalis'),(156,'cuipeúna'),(157,'jacatirão'),(158,'jaguatirão'),(159,'flor-de-maio'),(160,'pau-de-flor'),(161,'flor-de-quaresma'),(162,'jacatirão-de-capote'),(163,'jacatirão-de-joinville'),(164,'mini-havaiana'),(165,'samambaia-crespa'),(166,'mini-samambaia-havaiana'),(167,'sakura'),(168,'cerejeira'),(169,'cerejeira-ornamental'),(170,'cerejeira-do-japão'),(171,'cerejeira-de-okinawa'),(172,'lavadeira'),(173,'boa-noite'),(174,'boa-tarde'),(175,'vinca-rósea'),(176,'vinca-de-gato'),(177,'vinca-de-madagascar'),(178,'flor-de-todo-o-ano'),(179,'filodendro'),(180,'camerunga'),(181,'carambola-doce'),(182,'limão-de-caiena'),(183,'petréia'),(184,'viuvinha'),(185,'flor-de-são-miguel'),(186,'capela-de-viúva'),(187,'touca-de-viúva'),(188,'mororó'),(189,'bauínia'),(190,'unha-de-vaca'),(191,'pé-de-boi'),(192,'pata-de-vaca-rosa'),(193,'pata-de-vaca-branca'),(194,'mentraço'),(195,'mentrasto'),(196,'celestina'),(197,'erva-de-santa-lúcia'),(198,'erva-de-são-joão'),(199,'marianinha'),(200,'dicorisandra'),(201,'gengibre-azul'),(202,'trapoeraba-azul'),(203,'figo-ornamental'),(204,'figueira-vermelha'),(205,'feto'),(206,'samambaiaçu'),(207,'samambaiaçu-imperial'),(208,'timo'),(209,'thyme'),(210,'acaju'),(211,'mepoto'),(212,'cajuzeiro'),(213,'caju-manso'),(214,''),(215,'quioiô'),(216,'alfavaca'),(217,'basilicão'),(218,'erva-real'),(219,'manjericão-verde'),(220,'manjericão-comum'),(221,'alfavaca-cheirosa'),(222,'basílicum-grande'),(223,'alfavaca-do-mato'),(224,'remédio-de-vaqueiro'),(225,'amendoinzinho'),(226,'amendoim-forrageiro'),(227,'amendoim-rasteiro'),(228,'forrageiro-amendoim'),(229,'lírio-africano'),(230,'flor-do-nilo'),(231,'lírio-do-nilo'),(232,'hera japonesa'),(233,'partenocisso'),(234,'vinha-virgem'),(235,'cássia-imperial'),(236,'canafístula'),(237,'chuva-de-ouro'),(238,'cássia-fístula'),(239,'frangipani'),(240,'árvore-pagode'),(241,'chagueira'),(242,'flamboianzinho'),(243,'flor-do-paraíso'),(244,'barba-de-barata'),(245,'poinciana-anã'),(246,'brio-de-estudante'),(247,'orgulho-de-barbados'),(248,'flamboyant-de-jardim'),(249,'beijo'),(250,'sultana'),(251,'beijo-turco'),(252,'beijo-de-frade'),(253,'cacau'),(254,'cacao'),(255,'chocolate'),(256,'massaroca'),(257,'cacao-forasteiro'),(258,'cacau-da-bahia'),(259,'cacau-do-brasil'),(260,'cacau-verdadeiro'),(261,'alfazema'),(262,'lavanda-francesa'),(263,'Maxillaria marginata'),(264,'orquídea-cheiro-de-uva'),(265,'gerânio-ferradura'),(266,''),(267,'açucena'),(268,'açucena-japonesa'),(269,'lírio-japonês'),(270,'lírio-chinês'),(271,'lírio-oriental'),(272,'lírio-trombeta'),(273,'lírio-leopardo'),(274,'lilies'),(275,'flor-verniz'),(276,'antúrio-de-flor'),(277,'flor-de-jorge-tadeu'),(278,'limão'),(279,'limão-siciliano'),(280,'limão-verdadeiro'),(281,'limão-eureka'),(282,'limão-gênova'),(283,'limão-faminello'),(284,'limão-monochelo'),(285,'limão-lisboa'),(286,'ginja'),(287,'jinja'),(288,'pitanga'),(289,'ibipitanga'),(290,'pitangatuba'),(291,'ubipitanga'),(292,'pitanga-branca'),(293,'cerise-de-Cayenne'),(294,'pitanga-rósea'),(295,'Florida-cherry'),(296,'pitanga-roxa'),(297,'pitanga-do-mato'),(298,'julieta'),(299,'escumilho'),(300,'escumilha'),(301,'extremosa'),(302,'árvore-de-júpiter'),(303,'flor-de-merenda'),(304,'flor-de-natal'),(305,'tomate'),(306,'tomato'),(307,'pomodoro'),(308,'salsa'),(309,'cheiro'),(310,'perrexil'),(311,'cheiro-verde'),(312,'salsa-cultivada'),(313,'salsa-das-hortas'),(314,'salsa-de-cheiro'),(315,'menta'),(316,'sândalo'),(317,'hortelã-pimenta'),(318,'menta-inglesa'),(319,'hortelã-apimentada'),(320,'hortelã-das-cozinhas'),(321,'Arundina bambusifolia'),(322,'Arundina speciosa'),(323,'Bletia graminifolia'),(324,'acalifa-rasteira'),(325,'rabo-de-rato'),(326,'estapélia'),(327,'flor-estrela'),(328,'nolina'),(329,'biucarnea'),(330,'palmeira-rabo-de-cavalo'),(331,'borboleta-azul'),(332,'clerodendro-africano'),(333,'clerodendro-azul'),(334,'Clerodendrum ugandense'),(335,'pimentão-comum'),(336,'pepper'),(337,'peperone'),(338,'buriti'),(339,'boriti'),(340,'miriti'),(341,'moriti'),(342,'muriti'),(343,'carandaí'),(344,'coqueiro-buriti'),(345,'caradá-guaçu'),(346,'carandaí-guaçu'),(347,'palmeira-buriti'),(348,'palmeira-dos-brejos'),(349,'caeté'),(350,'caetê'),(351,'bananeira-ornamental'),(352,'bananeira-do-brejo'),(353,'buganvília'),(354,'ceboleiro'),(355,'buganvile'),(356,'pataguinha'),(357,'três-marias'),(358,'flor-de-papel'),(359,'planta-zebra'),(360,'espiga-dourada'),(361,'fibasis'),(362,'Gibasis schiedeana'),(363,'cacto-macarrão'),(364,'rabo-de-rato'),(365,'suspiro'),(366,'crista-plumosa'),(367,'celósia-plumosa'),(368,'crista-de-galo-plumosa'),(369,'esperança'),(370,'amargosa'),(371,'taraxaco'),(372,'amor-de-homem'),(373,'alface-de-cão'),(374,'salada-de-toupeira'),(375,'angreco');
/*!40000 ALTER TABLE `outronome` ENABLE KEYS */;
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
