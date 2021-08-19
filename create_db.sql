CREATE DATABASE IF NOT EXISTS `stock_market` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `stock_market`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: stock_market
-- ------------------------------------------------------
-- Server version	8.0.26


--
-- Table structure for table `stock_price`
--

-- DROP TABLE IF EXISTS `stock_price`;

CREATE TABLE IF NOT EXISTS `stock_price`
(
    `id`     bigint       NOT NULL AUTO_INCREMENT,
    `close`  double       NOT NULL,
    `date`   date         NOT NULL,
    `high`   double       NOT NULL,
    `low`    double       NOT NULL,
    `open`   double       NOT NULL,
    `symbol` varchar(255) NOT NULL,
    `volume` int          NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    AUTO_INCREMENT = 32768
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `company`
--

-- DROP TABLE IF EXISTS `company`;

CREATE TABLE IF NOT EXISTS `company`
(
    `id`       bigint       NOT NULL AUTO_INCREMENT,
    `industry` varchar(255) NOT NULL,
    `isin`     varchar(255) NOT NULL,
    `name`     varchar(255) NOT NULL,
    `series`   varchar(255) NOT NULL,
    `symbol`   varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    AUTO_INCREMENT = 64
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

