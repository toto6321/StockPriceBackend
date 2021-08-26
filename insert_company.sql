-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: stock_market
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

USE `stock_market`;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
INSERT INTO `company` (`id`, `isin`, `symbol`, `name`, `industry`, `series`)
VALUES (1, 'INE742F01042', 'ADANIPORTS', 'Adani Ports and Special Economic Zone Ltd.', 'SERVICES', 'EQ'),
       (2, 'INE021A01026', 'ASIANPAINT', 'Asian Paints Ltd.', 'CONSUMER GOODS', 'EQ'),
       (3, 'INE238A01034', 'AXISBANK', 'Axis Bank Ltd.', 'FINANCIAL SERVICES', 'EQ'),
       (4, 'INE917I01010', 'BAJAJ-AUTO', 'Bajaj Auto Ltd.', 'AUTOMOBILE', 'EQ'),
       (5, 'INE918I01018', 'BAJAJFINSV', 'Bajaj Finserv Ltd.', 'FINANCIAL SERVICES', 'EQ'),
       (6, 'INE296A01024', 'BAJFINANCE', 'Bajaj Finance Ltd.', 'FINANCIAL SERVICES', 'EQ'),
       (7, 'INE397D01024', 'BHARTIARTL', 'Bharti Airtel Ltd.', 'TELECOM', 'EQ'),
       (8, 'INE029A01011', 'BPCL', 'Bharat Petroleum Corporation Ltd.', 'ENERGY', 'EQ'),
       (9, 'INE216A01030', 'BRITANNIA', 'Britannia Industries Ltd.', 'CONSUMER GOODS', 'EQ'),
       (10, 'INE059A01026', 'CIPLA', 'Cipla Ltd.', 'PHARMA', 'EQ'),
       (11, 'INE522F01014', 'COALINDIA', 'Coal India Ltd.', 'METALS', 'EQ'),
       (12, 'INE089A01023', 'DRREDDY', 'Dr. Reddy\'s Laboratories Ltd.', 'PHARMA', 'EQ'),
       (13, 'INE066A01013', 'EICHERMOT', 'Eicher Motors Ltd.', 'AUTOMOBILE', 'EQ'),
       (14, 'INE129A01019', 'GAIL', 'GAIL (India) Ltd.', 'ENERGY', 'EQ'),
       (15, 'INE047A01021', 'GRASIM', 'Grasim Industries Ltd.', 'CEMENT & CEMENT PRODUCTS', 'EQ'),
       (16, 'INE860A01027', 'HCLTECH', 'HCL Technologies Ltd.', 'IT', 'EQ'),
       (17, 'INE001A01036', 'HDFC', 'Housing Development Finance Corporation Ltd.', 'FINANCIAL SERVICES', 'EQ'),
       (18, 'INE040A01034', 'HDFCBANK', 'HDFC Bank Ltd.', 'FINANCIAL SERVICES', 'EQ'),
       (19, 'INE158A01026', 'HEROMOTOCO', 'Hero MotoCorp Ltd.', 'AUTOMOBILE', 'EQ'),
       (20, 'INE038A01020', 'HINDALCO', 'Hindalco Industries Ltd.', 'METALS', 'EQ'),
       (21, 'INE030A01027', 'HINDUNILVR', 'Hindustan Unilever Ltd.', 'CONSUMER GOODS', 'EQ'),
       (22, 'INE090A01021', 'ICICIBANK', 'ICICI Bank Ltd.', 'FINANCIAL SERVICES', 'EQ'),
       (23, 'INE095A01012', 'INDUSINDBK', 'IndusInd Bank Ltd.', 'FINANCIAL SERVICES', 'EQ'),
       (24, 'INE121J01017', 'INFRATEL', 'Bharti Infratel Ltd.', 'TELECOM', 'EQ'),
       (25, 'INE009A01021', 'INFY', 'Infosys Ltd.', 'IT', 'EQ'),
       (26, 'INE242A01010', 'IOC', 'Indian Oil Corporation Ltd.', 'ENERGY', 'EQ'),
       (27, 'INE154A01025', 'ITC', 'ITC Ltd.', 'CONSUMER GOODS', 'EQ'),
       (28, 'INE019A01038', 'JSWSTEEL', 'JSW Steel Ltd.', 'METALS', 'EQ'),
       (29, 'INE237A01028', 'KOTAKBANK', 'Kotak Mahindra Bank Ltd.', 'FINANCIAL SERVICES', 'EQ'),
       (30, 'INE018A01030', 'LT', 'Larsen & Toubro Ltd.', 'CONSTRUCTION', 'EQ'),
       (31, 'INE101A01026', 'M&M', 'Mahindra & Mahindra Ltd.', 'AUTOMOBILE', 'EQ'),
       (32, 'INE585B01010', 'MARUTI', 'Maruti Suzuki India Ltd.', 'AUTOMOBILE', 'EQ'),
       (33, 'INE239A01016', 'NESTLEIND', 'Nestle India Ltd.', 'CONSUMER GOODS', 'EQ'),
       (34, 'INE733E01010', 'NTPC', 'NTPC Ltd.', 'ENERGY', 'EQ'),
       (35, 'INE213A01029', 'ONGC', 'Oil & Natural Gas Corporation Ltd.', 'ENERGY', 'EQ'),
       (36, 'INE752E01010', 'POWERGRID', 'Power Grid Corporation of India Ltd.', 'ENERGY', 'EQ'),
       (37, 'INE002A01018', 'RELIANCE', 'Reliance Industries Ltd.', 'ENERGY', 'EQ'),
       (38, 'INE062A01020', 'SBIN', 'State Bank of India', 'FINANCIAL SERVICES', 'EQ'),
       (39, 'INE070A01015', 'SHREECEM', 'Shree Cement Ltd.', 'CEMENT & CEMENT PRODUCTS', 'EQ'),
       (40, 'INE044A01036', 'SUNPHARMA', 'Sun Pharmaceutical Industries Ltd.', 'PHARMA', 'EQ'),
       (41, 'INE155A01022', 'TATAMOTORS', 'Tata Motors Ltd.', 'AUTOMOBILE', 'EQ'),
       (42, 'INE081A01012', 'TATASTEEL', 'Tata Steel Ltd.', 'METALS', 'EQ'),
       (43, 'INE467B01029', 'TCS', 'Tata Consultancy Services Ltd.', 'IT', 'EQ'),
       (44, 'INE669C01036', 'TECHM', 'Tech Mahindra Ltd.', 'IT', 'EQ'),
       (45, 'INE280A01028', 'TITAN', 'Titan Company Ltd.', 'CONSUMER GOODS', 'EQ'),
       (46, 'INE481G01011', 'ULTRACEMCO', 'UltraTech Cement Ltd.', 'CEMENT & CEMENT PRODUCTS', 'EQ'),
       (47, 'INE628A01036', 'UPL', 'UPL Ltd.', 'FERTILISERS & PESTICIDES', 'EQ'),
       (48, 'INE205A01025', 'VEDL', 'Vedanta Ltd.', 'METALS', 'EQ'),
       (49, 'INE075A01022', 'WIPRO', 'Wipro Ltd.', 'IT', 'EQ'),
       (50, 'INE256A01028', 'ZEEL', 'Zee Entertainment Enterprises Ltd.', 'MEDIA & ENTERTAINMENT', 'EQ');
UNLOCK TABLES;


-- Dump completed on 2021-08-26 18:45:52
