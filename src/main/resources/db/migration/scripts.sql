-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: ediaristas
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comissao` decimal(19,2) NOT NULL,
  `horas_banheiro` int NOT NULL,
  `horas_cozinha` int NOT NULL,
  `horas_outros` int NOT NULL,
  `horas_quarto` int NOT NULL,
  `horas_quintal` int NOT NULL,
  `horas_salar` int NOT NULL,
  `icone` varchar(14) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `posicao` int NOT NULL,
  `qtde_horas` int NOT NULL,
  `valor_banheiro` decimal(19,2) NOT NULL,
  `valor_cozinha` decimal(19,2) NOT NULL,
  `valor_minimo` decimal(19,2) NOT NULL,
  `valor_outros` decimal(19,2) NOT NULL,
  `valor_quarto` decimal(19,2) NOT NULL,
  `valor_quintal` decimal(19,2) NOT NULL,
  `valor_sala` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (2,3.00,3,3,3,3,3,3,'TWF_CLEANING_2','Outro Teste Serviço',2,3,3.00,3.00,10.00,3.00,3.00,3.00,3.00),(3,5.00,5,5,5,5,5,5,'TWF_CLEANING_2','Teste serviço',2,5,5.00,5.00,2.00,5.00,5.00,5.00,5.00),(21,78.00,87,87,78,78,877,87,'TWF_CLEANING_2','Testando servico mascara alterado',7,12,87.00,7.87,16.87,7.87,87.87,87.00,78.78);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nome_completo` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `tipo_usuario` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (7,'fernando@email.teste','Fernanda Souza','$2a$10$/rV3VR4sfAIX0DePlvtI3uRmLlKBYnNR/KFXL5BUnfUtFjageonUC','ADMIN'),(8,'antonia@email.teste','Antônia Bárbara Ribeiro','$2a$10$DwD6ik..bRwPeTy17kWHo.ONOLh/AEE0/6u7wVCnm3HUKKaf.dVPq','ADMIN'),(9,'carlos@teste.email','Carlos Teste','$2a$10$DuRQtF3C4crMpxd/2AFWfeiiIoRgfgi1C/vXzIotbC4xS8nmVNKjO','ADMIN'),(10,'pacheco@email.com','José Pacheco','$2a$10$4.n.p7FlHLT/rl.7gMAS9ezFS9bH8VfEbSj6KLE6jilra7jK2XN42','ADMIN');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-26 20:15:52
