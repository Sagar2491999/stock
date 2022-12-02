-- MySQL dump 10.13  Distrib 5.5.8, for Win32 (x86)
--
-- Host: localhost    Database: bca
-- ------------------------------------------------------
-- Server version	5.5.8-log

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
-- Table structure for table `attendence`
--

DROP TABLE IF EXISTS `attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendence` (
  `s_no` int(11) DEFAULT NULL,
  `empid` varchar(15) DEFAULT NULL,
  `empname` varchar(20) DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendence`
--

LOCK TABLES `attendence` WRITE;
/*!40000 ALTER TABLE `attendence` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendencedata`
--

DROP TABLE IF EXISTS `attendencedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendencedata` (
  `date` varchar(20) DEFAULT NULL,
  `empid` varchar(15) DEFAULT NULL,
  `empname` varchar(15) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendencedata`
--

LOCK TABLES `attendencedata` WRITE;
/*!40000 ALTER TABLE `attendencedata` DISABLE KEYS */;
INSERT INTO `attendencedata` VALUES ('02/Aug/2021','12345','Sagar','P'),('02/Aug/2021','54321','Tarang','P'),('02/Aug/2021','56789','Aayush','P'),('02/Aug/2021','12345','Sagar','P'),('02/Aug/2021','54321','Tarang','P'),('02/Aug/2021','56789','Aayush','P'),('02/Aug/2021','12345','Sagar','A'),('02/Aug/2021','54321','Tarang','A'),('02/Aug/2021','56789','Aayush','A'),('02/Aug/2021','12345','Sagar','P'),('02/Aug/2021','54321','Tarang','A'),('02/Aug/2021','56789','Aayush','P'),('02/Aug/2021','12345','Sagar','A'),('02/Aug/2021','54321','Tarang','A'),('02/Aug/2021','56789','Aayush','A'),('02/Aug/2021','12345','Sagar','A'),('02/Aug/2021','54321','Tarang','A'),('02/Aug/2021','56789','Aayush','A'),('02/Aug/2021','12345','Sagar','A'),('02/Aug/2021','54321','Tarang','A'),('02/Aug/2021','56789','Aayush','A');
/*!40000 ALTER TABLE `attendencedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `billno` varchar(20) DEFAULT NULL,
  `CustomerName` varchar(20) DEFAULT NULL,
  `mobile` int(15) DEFAULT NULL,
  `itemcode` varchar(20) DEFAULT NULL,
  `itemname` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `salingprice` float DEFAULT NULL,
  `quantity` int(15) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billdetail`
--

DROP TABLE IF EXISTS `billdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billdetail` (
  `billnumber` int(10) DEFAULT NULL,
  `customername` varchar(15) DEFAULT NULL,
  `mobilenumber` varchar(15) DEFAULT NULL,
  `date` varchar(15) DEFAULT NULL,
  `totalammount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billdetail`
--

LOCK TABLES `billdetail` WRITE;
/*!40000 ALTER TABLE `billdetail` DISABLE KEYS */;
INSERT INTO `billdetail` VALUES (1,'Sagar','7535124578','1/Aug/2021',138725),(2,'Aayush','9985456525','1/Aug/2021',224690),(3,'Sagar','7599854152','1/Aug/2021',26299),(4,'Tarang','99587454','1/Aug/2021',111875),(5,'Mainsh','9988554444','1/Aug/2021',22375),(6,'Sagar','9988774455','1/Aug/2021',22375),(7,'','','',85246),(8,'vishu','9988556622','1/Aug/2021',21216),(9,'Tarang','9999999999','1/Aug/2021',78175),(10,'Aayush','5544112233','1/Aug/2021',80550),(11,'manish','1111111111','1/Aug/2021',17900),(12,'Sagar','2222222222','1/Aug/2021',21216),(13,'aadi','3333333333','1/aAug/2021',76075),(14,'Sagar','7535010796','1/Aug/2021',76075),(15,'Tarang','7535010797','1/Aug/2021',19448),(16,'Sagar','9927384396','1/Aug/2021',1105),(17,'Vishu','7511111111','1/Aug/2021',1105),(18,'xcvrfgbjh','75265245','1/Aug/2021',1105),(19,'Tarang','111111111','1/Aug/2021',1105),(20,'Sagar','1234567891','1/Aug/2021',1105),(21,'SagarKumar','5555555555','02/Aug/2021',1326),(22,'Manish','6666666666','02/Aug/2021',884);
/*!40000 ALTER TABLE `billdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custinfo`
--

DROP TABLE IF EXISTS `custinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custinfo` (
  `customerid` int(11) DEFAULT NULL,
  `customername` varchar(15) DEFAULT NULL,
  `shopname` varchar(15) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `phoneno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custinfo`
--

LOCK TABLES `custinfo` WRITE;
/*!40000 ALTER TABLE `custinfo` DISABLE KEYS */;
INSERT INTO `custinfo` VALUES (123456,'AAyush','asfg','Meerut',1234567892);
/*!40000 ALTER TABLE `custinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `s_no` int(11) DEFAULT NULL,
  `Empid` varchar(12) DEFAULT NULL,
  `Empname` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'12345','Sagar'),(2,'54321','Tarang'),(3,'56789','Aayush'),(4,'98765','Manish');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empinfo`
--

DROP TABLE IF EXISTS `empinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empinfo` (
  `EmpId` varchar(15) DEFAULT NULL,
  `EmpName` varchar(15) DEFAULT NULL,
  `Designation` varchar(25) DEFAULT NULL,
  `salary` int(20) DEFAULT NULL,
  `PhoneNo` varchar(20) DEFAULT NULL,
  `Address` varchar(20) DEFAULT NULL,
  `EMail` varchar(30) DEFAULT NULL,
  `DateOfJoning` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empinfo`
--

LOCK TABLES `empinfo` WRITE;
/*!40000 ALTER TABLE `empinfo` DISABLE KEYS */;
INSERT INTO `empinfo` VALUES ('12345','Sagar','Software Devloper',50000,'9978456321','Meerut','Ssagarkumar3@gmail.com','01/Jun/2021'),('54321','Tarang','Testing',60000,'9987456321','Meerut','tarang5@gmail.com','02/Jun/2021'),('56789','Aayush','DataBase Admi',70000,'9987415263','Meerut','aayush7@gmail.com','03/Jun/2021'),('98765','Manish','Data Analyst',40000,'9785456321','Meerut','manish8@gmail.com','04/Jun/2021');
/*!40000 ALTER TABLE `empinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iteminfo`
--

DROP TABLE IF EXISTS `iteminfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iteminfo` (
  `itemcode` varchar(15) DEFAULT NULL,
  `itemname` varchar(15) DEFAULT NULL,
  `itemdescription` varchar(50) DEFAULT NULL,
  `quantity` int(20) DEFAULT NULL,
  `reorderlevel` int(20) DEFAULT NULL,
  `costprice` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `saleprice` float DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iteminfo`
--

LOCK TABLES `iteminfo` WRITE;
/*!40000 ALTER TABLE `iteminfo` DISABLE KEYS */;
INSERT INTO `iteminfo` VALUES ('789pqr','Notebook','Handwriting',12,4,200,10,180,'18/Jun/2021'),('123abc','Book','Reading',100,15,200.5,10.5,221.553,'22/Jun/2021'),('159abc','laptop','coading',25,2,5000.5,10.5,4475.45,'22/Jun/2021');
/*!40000 ALTER TABLE `iteminfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `usename` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('sagar','sagar123',NULL),(NULL,NULL,'dev');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logon`
--

DROP TABLE IF EXISTS `logon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logon` (
  `uname` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `cpassword` varchar(30) DEFAULT NULL,
  `sques` varchar(50) DEFAULT NULL,
  `ans` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logon`
--

LOCK TABLES `logon` WRITE;
/*!40000 ALTER TABLE `logon` DISABLE KEYS */;
INSERT INTO `logon` VALUES ('sagarKuamr','kumar123','kumar123','What is your nationality','Indian'),('TarangSharma','tarang@123','tarang@123','What is your nationality','Indian');
/*!40000 ALTER TABLE `logon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `itemcode` varchar(20) DEFAULT NULL,
  `quantity` int(20) DEFAULT NULL,
  `costprice` float DEFAULT NULL,
  `profit` float DEFAULT NULL,
  `saleprice` float DEFAULT NULL,
  `dateofpurchase` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES ('159abc',80,5000,10,4475,'23/Jun/2021'),('123abc',50,200,10,221,'23/Jun/2021'),('159abc',5,5000,10,4475,'23/Jun/2021');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reg`
--

DROP TABLE IF EXISTS `reg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reg` (
  `Customer_id` int(15) DEFAULT NULL,
  `Customer_name` varchar(20) DEFAULT NULL,
  `Shop_name` varchar(20) DEFAULT NULL,
  `Address` varchar(20) DEFAULT NULL,
  `Phone_no` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reg`
--

LOCK TABLES `reg` WRITE;
/*!40000 ALTER TABLE `reg` DISABLE KEYS */;
INSERT INTO `reg` VALUES (12345,'aadi kumar','aadimanufacture','muzzfrnagar','9927384999'),(56789,'sagar','sagarmanufactures','Muzzfarnagar','7535010795');
/*!40000 ALTER TABLE `reg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salaryslip`
--

DROP TABLE IF EXISTS `salaryslip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salaryslip` (
  `empid` varchar(15) DEFAULT NULL,
  `EmpName` varchar(20) DEFAULT NULL,
  `Month` varchar(10) DEFAULT NULL,
  `year` varchar(20) DEFAULT NULL,
  `NetSalary` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salaryslip`
--

LOCK TABLES `salaryslip` WRITE;
/*!40000 ALTER TABLE `salaryslip` DISABLE KEYS */;
INSERT INTO `salaryslip` VALUES ('Sagar','Software Devloper','Jun','2021',2083),('Tarang','Testing','Jun','2021',2500),('Manish','Data Analyst','Jun','2021',1667),('Sagar','Software Devloper','Aug','2021',7500),('Tarang','Testing','Aug','2021',6000),('Aayush','DataBase Admi','Aug','2021',10500),('Sagar','Software Devloper','Aug','2021',10000),('Tarang','Testing','Aug','2021',8000),('Aayush','DataBase Admi','Aug','2021',14000);
/*!40000 ALTER TABLE `salaryslip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale` (
  `date` varchar(20) DEFAULT NULL,
  `customername` varchar(20) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `itemcode` varchar(20) DEFAULT NULL,
  `itemname` varchar(20) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `quantity` int(20) DEFAULT NULL,
  `saleprice` float DEFAULT NULL,
  `sellingno` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES ('01/Aug/2021','Sagar','9925486585','123abc','Book','Reading',50,221,1),('01/Aug/2021','Sagar','7595486525','123abc','Book','Reading',69,221,2),('01/Aug/2021','Aayush','6545857496','159abc','laptop','coading',19,4475,3),('01/Aug/2021','Aayush','65857496','159abc','laptop','coading',6,4475,4),('01/Aug/2021','Tarang','75854512','159abc','laptop','coading',1,4475,5),('01/Aug/2021','Tarang','7574844541','123abc','Book','Reading',62,221,6),('01/Aug/2021','Manish','9988774444','159abc','laptop','coading',5,4475,7),('01/Aug/2021','Sagar','998856622','123abc','Book','Reading',1,221,8),('01/Aug/2021','aadi','2255441166','159abc','laptop','coading',5,4475,9),('01/Aug/2021','garvit','9988552211','159abc','laptop','coading',9,4475,10),('01/Aug/2021','vishu','9988552233','123abc','Book','Reading',96,221,11),('01/Aug/2021','Tarang','9999999999','123abc','Book','Reading',50,221,12),('01/Aug/2021','Tarang','99999999','159abc','laptop','coading',15,4475,13),('01/Aug/2021','Aayush','9955112233','159abc','laptop','coading',18,4475,14),('01/Aug/2021','manish','1111111111','159abc','laptop','coading',4,4475,15),('01/Aug/2021','sagar','2222222222','123abc','Book','Reading',96,221,16),('01/Aug/2021','Aadi','3333333333','159abc','laptop','coading',17,4475,17),('01/Aug/2021','Sagar','7535010796','159abc','laptop','coading',17,4475,18),('01/Aug/2021','Tarang','7535010797','123abc','Book','Reading',88,221,19),('01/Aug/2021','Sagar','9927384396','123abc','Book','Reading',5,221,20),('01/Aug/2021','Vishu','7511111111','123abc','Book','Reading',5,221,21),('01/Aug/2021','szdxc','752957465','123abc','Book','Reading',5,221,22),('01/Aug/2021','Tarang','111111111','123abc','Book','Reading',5,221,23),('01/Aug/2021','Sagar','1234567891','123abc','Book','Reading',5,221,24),('02/Aug/2021','SagarKumar','5555555555','123abc','Book','Reading',6,221,26),('02/Aug/2021','manish','6666666666','123abc','Book','Reading',4,221,27);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sellcart`
--

DROP TABLE IF EXISTS `sellcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sellcart` (
  `s_no` int(5) DEFAULT NULL,
  `itemname` varchar(15) DEFAULT NULL,
  `description` varchar(15) DEFAULT NULL,
  `saleprice` float DEFAULT NULL,
  `quantity` int(15) DEFAULT NULL,
  `amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellcart`
--

LOCK TABLES `sellcart` WRITE;
/*!40000 ALTER TABLE `sellcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `sellcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `roll_no` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `course` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1111,'Sagar Kumar','Khatauli','Male','BCA'),(1111,'Sagar Kumar',' Khatauli (M.Nagar)','Male','BCA'),(1112,'Shivam','Galibpur,Khatauli(M.Nagar)','Male','BCA');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-02 23:05:23
