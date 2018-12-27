/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 10.1.28-MariaDB : Database - tiket
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tiket` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `tiket`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `billing_address` varchar(255) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL,
  `company_website` varchar(200) DEFAULT NULL,
  `email` varchar(75) DEFAULT NULL,
  `fax_number` varchar(30) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `ship_address` varchar(255) DEFAULT NULL,
  `ship_city` varchar(50) DEFAULT NULL,
  `ship_phone_number` varchar(30) DEFAULT NULL,
  `ship_state_or_province` varchar(50) DEFAULT NULL,
  `ship_zip_code` varchar(20) DEFAULT NULL,
  `state_or_province` varchar(20) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`billing_address`,`city`,`company_name`,`company_website`,`email`,`fax_number`,`first_name`,`last_name`,`phone_number`,`ship_address`,`ship_city`,`ship_phone_number`,`ship_state_or_province`,`ship_zip_code`,`state_or_province`,`zip_code`) values 
(1,'1234 Brown Street','Furntree','A. Datum Corporation','http://www.adatum.com/','','4255550144','Terry','Adams','6065550134','1234 Brown Street','Furntree Gulley','4255550134','WA','680526789','WA','680526789'),
(2,'4567 Green Road','Clovelly','Contoso, Ltd','http://www.contoso.com/','','4255550145','Jo','Berry','4255550135','4567 Green Road','Clovelly','4255550135','CA','863924444','CA','863924444'),
(3,'5678 Yellow Place','Beecroft','Trey Research','http://www.treyresearch.net/','','4255550146','Kim','Akers','4255550136','5678 Yellow Place','Beecroft','4255550136','MO','564781234','MO','564781234'),
(4,'2345 Brick Road','Irvine','Litware, Inc','http://www.litwareinc.com','','8065550147','Robin','Counts','8065550137','2345 Brick Road','Irvine','8065550137','AZ','234893456','AZ','234893456');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `work_phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`first_name`,`last_name`,`title`,`work_phone`) values 
(1,'Adam','Barr','Sales Representative','2065550123'),
(2,'Oliver','Cox','Sales Manager','2065550126'),
(3,'Chris','Cannon','Sales Representative','2065550125'),
(4,'Eva','Corets','Product Manager','2065550127'),
(5,'Doris','Hartwig','Sales Representative','2065550128');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL DEFAULT '13',
  `comment` varchar(150) DEFAULT NULL,
  `freight_charge` int(11) DEFAULT NULL,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `paryment_received` int(11) DEFAULT NULL,
  `purchase_order_number` varchar(30) DEFAULT NULL,
  `ship_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `taxes` int(11) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `shipping_method_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK1oduxyuuo3n2g98l3j7754vym` (`customer_id`),
  KEY `FKdjonorx78bdje2vp5oyrt0qrq` (`employee_id`),
  KEY `FK2pqrxd858x8362v6ositor5pp` (`shipping_method_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `order` */

insert  into `order`(`order_id`,`comment`,`freight_charge`,`order_date`,`paryment_received`,`purchase_order_number`,`ship_date`,`taxes`,`customer_id`,`employee_id`,`shipping_method_id`) values 
(1,'',64,'2005-04-23 00:00:00',0,'10','2005-04-29 00:00:00',5,2,1,1),
(2,'',NULL,'2005-03-23 00:00:00',0,'11','2005-03-29 00:00:00',5,1,1,1),
(3,'',NULL,'2005-01-21 00:00:00',0,'30','2005-06-28 00:00:00',5,3,3,5),
(4,'',NULL,'2005-05-05 00:00:00',0,'26','2005-09-19 00:00:00',5,2,2,2),
(5,'',NULL,'2005-05-02 00:00:00',0,'32','2005-09-27 00:00:00',5,4,5,2),
(13,'',50,'2008-02-29 00:00:00',0,'1','2018-12-27 11:25:16',5,1,1,2);

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `order_detail_id` int(11) NOT NULL,
  `discount` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `order_id` int(11) NOT NULL DEFAULT '13',
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `FKlb8mofup9mi791hraxt9wlj5u` (`order_id`),
  KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `order_detail` */

insert  into `order_detail`(`order_detail_id`,`discount`,`quantity`,`unit_price`,`order_id`,`product_id`) values 
(1,0,15,5,1,4),
(2,0,10,7.5,2,7),
(3,0,5,4,3,8),
(5,5,100,5,4,9),
(6,0,5,7,5,6),
(7,5,30,5,5,9),
(9,0,9,6,1,1),
(11,0,1,5,13,4),
(12,0,2,2.5,13,1),
(13,0,1,7.5,13,7);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `in_stock` char(1) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`product_id`,`in_stock`,`product_name`,`unit_price`) values 
(1,'1','Blue Mug',2.5),
(2,'1','Red Mug',4),
(3,'1','Green Mug',2.5),
(4,'1','Black Mug',5),
(5,'1','Yellow Mug',2.5),
(6,'1','Silver Mug',7),
(7,'1','Gold Mug',7.5),
(8,'1','White Mug',4),
(9,'1','US Flag Mug',5);

/*Table structure for table `shipping_method` */

DROP TABLE IF EXISTS `shipping_method`;

CREATE TABLE `shipping_method` (
  `shipping_method_id` int(11) NOT NULL,
  `shipping_method` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`shipping_method_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `shipping_method` */

insert  into `shipping_method`(`shipping_method_id`,`shipping_method`) values 
(1,'Federal Express'),
(2,'UPS Ground'),
(3,'UPS Second Day'),
(4,'US Mail Overnight'),
(5,'US Certified Mail');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
