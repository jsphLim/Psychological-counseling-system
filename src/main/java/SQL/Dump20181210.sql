-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: homework
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `appointment` (
  `appointdate` char(50) NOT NULL,
  `detail` char(250) NOT NULL,
  `status` int(11) NOT NULL,
  `sno` char(20) NOT NULL,
  `tno` char(20) NOT NULL,
  `serialnumber` int(11) NOT NULL AUTO_INCREMENT,
  `sname` char(20) DEFAULT NULL,
  `tname` char(20) NOT NULL,
  `location` char(45) NOT NULL,
  PRIMARY KEY (`serialnumber`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (' Webnesday 09:00-16:00','心理疾病问题',0,'2016051537','20020515',27,'','钟文辉\n','珠海T110'),('Monday  09:00-16:00','心理疾病问题',0,'2016051537','20170526',28,'','刘东明\n','本部112');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultant`
--

DROP TABLE IF EXISTS `consultant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consultant` (
  `tno` char(20) NOT NULL,
  `name` char(20) NOT NULL,
  `email` char(30) NOT NULL,
  `information` char(250) DEFAULT NULL,
  `location` varchar(45) NOT NULL,
  `currentnumber` int(11) NOT NULL,
  `totalnumber` int(11) NOT NULL,
  `dutytime` varchar(45) NOT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultant`
--

LOCK TABLES `consultant` WRITE;
/*!40000 ALTER TABLE `consultant` DISABLE KEYS */;
INSERT INTO `consultant` VALUES ('19980762','刘向农\n','liuxiangnong@gmail.com','国家一级注册心理咨询师\n','N319',0,2,' Webnesday 09:00-16:00'),('20010987','李少辉','125434546@gmail.com','国家注册二级心理咨询师','本部601',0,10,'Sunday  09:00-16:00'),('20020515','钟文辉\n','huali@fox.com','国家二级注册心理咨询师\n','珠海T110',1,3,' Webnesday 09:00-16:00'),('20020879','张将星','13456@gmail.com','暨南大学教授','N118',0,5,'Monday 08:00-16:00'),('20030765','刘汉城\n','xiangcheg@163.com','国家二级注册心理咨询师\n','珠海T110',0,4,' Monday 09:00-16:00'),('20090934','王震','293048902@gmail.com','暨南大学教授','本部311',0,10,'Sunday 09:00-17:00'),('20100929','叶秉光\n','yebg@gmail.com','暨南大学副教授','N465',0,8,'Thuesday  09:00-16:00'),('20109879','孙巧芬\n','sunqiaofen@gmail.com','精神分析师','N108',0,4,'Tuesday  09:00-16:00'),('20140498','曹文研','caowenyan@163.com','国家二级心理师','N515',1,4,'Thursday 08:00-12:00'),('20150524','李华\n','huali@fox.com','精神分析师','珠海T110',0,4,' Sunday 09:00-16:00'),('20160983','王雪薇\n','xuehui@163.com','暨南大学副教授\n','珠海T110',0,4,' Friday 09:00-16:00'),('20170526','刘东明\n','liudongming@gmail.com','暨南大学教授','本部112',1,4,'Monday  09:00-16:00'),('20180293','李文灏','liwenhao@gmail.com','暨南大学教授','D101',0,3,'Saturday 09:00-15:00');
/*!40000 ALTER TABLE `consultant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `sno` char(20) NOT NULL,
  `name` char(10) NOT NULL,
  `password` char(40) NOT NULL,
  `email` char(100) NOT NULL,
  `deptno` char(10) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('','','D41D8CD98F00B204E9800998ECF8427E','',''),('122','hg','D41D8CD98F00B204E9800998ECF8427E','',''),('2016051537','林越','E10ADC3949BA59ABBE56E057F20F883E','1050450245@qq.com','计算机科学系');
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

-- Dump completed on 2018-12-10 22:20:41
