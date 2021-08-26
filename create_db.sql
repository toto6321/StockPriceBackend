CREATE DATABASE IF NOT EXISTS `stock_market`; 

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
    `date`   date         NOT NULL,
    `symbol` varchar(255) NOT NULL,
    `open`   double       NOT NULL,
    `high`   double       NOT NULL,
    `low`    double       NOT NULL,
    `close`  double       NOT NULL,
    `volume` bigint          NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


--
-- Table structure for table `company`
--

-- DROP TABLE IF EXISTS `company`;

CREATE TABLE IF NOT EXISTS `company`
(
    `id`       bigint       NOT NULL AUTO_INCREMENT,
    `isin`     varchar(255) NOT NULL,
    `symbol`   varchar(255) NOT NULL,
    `name`     varchar(255) NOT NULL,
    `industry` varchar(255) NOT NULL,
    `series`   varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


--
-- Table structure for table `stock_price`
--

-- DROP TABLE IF EXISTS `stock_index`;

CREATE TABLE IF NOT EXISTS `stock_index`
(
    `id`     bigint       NOT NULL AUTO_INCREMENT,
    `date`   date         NOT NULL,
    `symbol` varchar(255) NOT NULL,
    `open`   double       NOT NULL,
    `high`   double       NOT NULL,
    `low`    double       NOT NULL,
    `close`  double       NOT NULL,
    `volume` bigint          NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;