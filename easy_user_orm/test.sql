/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.27 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`gender`,`age`,`address`,`qq`,`email`,`username`,`password`) values (1,'admin','男',13,'陕西','12345','zhangsan@163.cn','root','root'),(2,'不知火舞','女',18,'广东','2316131','ls@i.cn','buzhihuowu','123'),(5,'猪八戒','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(6,'露娜','女',15,'北京','88888','ls@163.cn',NULL,NULL),(7,'孙悟空','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(8,'王昭君','女',15,'北京','88888','ls@163.cn',NULL,NULL),(9,'李元芳','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(10,'甄姬','女',15,'北京','88888','ls@163.cn',NULL,NULL),(11,'李信','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(12,'武则天','女',15,'北京','88888','ls@163.cn',NULL,NULL),(13,'关平','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(14,'孙尚香','女',15,'北京','88888','ls@163.cn',NULL,NULL),(15,'孙策','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(16,'荆轲','女',15,'北京','88888','ls@163.cn',NULL,NULL),(17,'夏侯惇','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(18,'西施','女',15,'北京','88888','ls@163.cn',NULL,NULL),(19,'刘禅','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(20,'钟无艳','女',15,'北京','88888','ls@163.cn',NULL,NULL),(21,'孙权','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(22,'大乔','女',15,'北京','88888','ls@163.cn',NULL,NULL),(23,'孟获','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(24,'小乔','女',15,'北京','88888','ls@163.cn',NULL,NULL),(25,'曹操','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(26,'貂蝉','女',15,'北京','88888','ls@163.cn',NULL,NULL),(27,'赵云','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(28,'黄月英','女',15,'北京','88888','ls@163.cn',NULL,NULL),(29,'诸葛亮','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(30,'刘备','男',15,'北京','88888','ls@163.cn',NULL,NULL),(31,'关羽','男',13,'陕西','12345','zhangsan@163.cn',NULL,NULL),(32,'张飞','男',15,'北京','88888','ls@163.cn',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
