-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: stock_market
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

use `stock_market`;

--
-- Dumping data for table `exchange`
--

LOCK TABLES `exchange` WRITE;
INSERT INTO `exchange` (`id`, `symbol`, `name`, `region`, `currency`)
VALUES (1, 'NYA', 'New York Stock Exchange', 'United States', 'USD'),
       (2, 'IXIC', 'NASDAQ', 'United States', 'USD'),
       (3, 'HSI', 'Hong Kong Stock Exchange', 'Hong Kong', 'HKD'),
       (4, '000001.SS', 'Shanghai Stock Exchange', 'China', 'CNY'),
       (5, 'N225', 'Tokyo Stock Exchange', 'Japan', 'JPY'),
       (6, 'N100', 'Euronext', 'Europe', 'EUR'),
       (7, '399001.SZ', 'Shenzhen Stock Exchange', 'China', 'CNY'),
       (8, 'GSPTSE', 'Toronto Stock Exchange', 'Canada', 'CAD'),
       (9, 'NSEI', 'National Stock Exchange of India', 'India', 'INR'),
       (10, 'GDAXI', 'Frankfurt Stock Exchange', 'Germany', 'EUR'),
       (11, 'KS11', 'Korea Exchange', 'Korea', 'KRW'),
       (12, 'SSMI', 'SIX Swiss Exchange', 'Switzerland', 'CHF'),
       (13, 'TWII', 'Taiwan Stock Exchange', 'Taiwan', 'TWD'),
       (14, 'J203.JO', 'Johannesburg Stock Exchange', 'South Africa', 'ZAR');
UNLOCK TABLES;


-- Dump completed on 2021-08-27  1:34:18
