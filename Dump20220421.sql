-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: signal_suggester
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `dow_jones`
--

DROP TABLE IF EXISTS `dow_jones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dow_jones` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dow_jones`
--

LOCK TABLES `dow_jones` WRITE;
/*!40000 ALTER TABLE `dow_jones` DISABLE KEYS */;
INSERT INTO `dow_jones` VALUES ('AAPL'),('AMGN'),('AXP'),('BA'),('CAT'),('CRM'),('CSCO'),('CVX'),('DIS'),('DOW'),('GS'),('HD'),('HON'),('IBM'),('INTC'),('JNJ'),('JPM'),('KO'),('MCD'),('MMM'),('MRK'),('MSFT'),('NKE'),('PG'),('TRV'),('UNH'),('V'),('VZ'),('WBA'),('WMT');
/*!40000 ALTER TABLE `dow_jones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nasdaq_100`
--

DROP TABLE IF EXISTS `nasdaq_100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nasdaq_100` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nasdaq_100`
--

LOCK TABLES `nasdaq_100` WRITE;
/*!40000 ALTER TABLE `nasdaq_100` DISABLE KEYS */;
INSERT INTO `nasdaq_100` VALUES ('AAPL'),('ABNB'),('ADBE'),('ADI'),('ADP'),('ADSK'),('AEP'),('ALGN'),('AMAT'),('AMD'),('AMGN'),('AMZN'),('ANSS'),('ASML'),('ATVI'),('AVGO'),('AZN'),('BIDU'),('BIIB'),('BKNG'),('CDNS'),('CEG'),('CHTR'),('CMCSA'),('COST'),('CPRT'),('CRWD'),('CSCO'),('CSX'),('CTAS'),('CTSH'),('DDOG'),('DLTR'),('DOCU'),('DXCM'),('EA'),('EBAY'),('EXC'),('FAST'),('FB'),('FISV'),('FTNT'),('GILD'),('GOOG'),('GOOGL'),('HON'),('IDXX'),('ILMN'),('INTC'),('INTU'),('ISRG'),('JD'),('KDP'),('KHC'),('KLAC'),('LCID'),('LRCX'),('LULU'),('MAR'),('MCHP'),('MDLZ'),('MELI'),('MNST'),('MRNA'),('MRVL'),('MSFT'),('MTCH'),('MU'),('NFLX'),('NTES'),('NVDA'),('NXPI'),('ODFL'),('OKTA'),('ORLY'),('PANW'),('PAYX'),('PCAR'),('PDD'),('PEP'),('PYPL'),('QCOM'),('REGN'),('ROST'),('SBUX'),('SGEN'),('SIRI'),('SNPS'),('SPLK'),('SWKS'),('TEAM'),('TMUS'),('TSLA'),('TXN'),('VRSK'),('VRSN'),('VRTX'),('WBA'),('WDAY'),('XEL'),('ZM'),('ZS');
/*!40000 ALTER TABLE `nasdaq_100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_100`
--

DROP TABLE IF EXISTS `nifty_100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_100` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_100`
--

LOCK TABLES `nifty_100` WRITE;
/*!40000 ALTER TABLE `nifty_100` DISABLE KEYS */;
INSERT INTO `nifty_100` VALUES ('ACC'),('ADANIENT'),('ADANIGREEN'),('ADANIPORTS'),('ADANITRANS'),('AMBUJACEM'),('APOLLOHOSP'),('ASIANPAINT'),('AXISBANK'),('BAJAJ-AUTO'),('BAJAJFINSV'),('BAJAJHLDNG'),('BAJFINANCE'),('BANDHANBNK'),('BANKBARODA'),('BERGEPAINT'),('BHARTIARTL'),('BIOCON'),('BOSCHLTD'),('BPCL'),('BRITANNIA'),('CHOLAFIN'),('CIPLA'),('COALINDIA'),('COLPAL'),('DABUR'),('DIVISLAB'),('DLF'),('DMART'),('DRREDDY'),('EICHERMOT'),('GAIL'),('GLAND'),('GODREJCP'),('GRASIM'),('HAVELLS'),('HCLTECH'),('HDFC'),('HDFCAMC'),('HDFCBANK'),('HDFCLIFE'),('HEROMOTOCO'),('HINDALCO'),('HINDUNILVR'),('ICICIBANK'),('ICICIGI'),('ICICIPRULI'),('INDIGO'),('INDUSINDBK'),('INDUSTOWER'),('INFY'),('IOC'),('ITC'),('JSWSTEEL'),('JUBLFOOD'),('KOTAKBANK'),('LT'),('LTI'),('LUPIN'),('M&M'),('MARICO'),('MARUTI'),('MCDOWELL-N'),('MINDTREE'),('MUTHOOTFIN'),('NAUKRI'),('NESTLEIND'),('NMDC'),('NTPC'),('NYKAA'),('ONGC'),('PAYTM'),('PEL'),('PGHH'),('PIDILITIND'),('PIIND'),('PNB'),('POWERGRID'),('RELIANCE'),('SAIL'),('SBICARD'),('SBILIFE'),('SBIN'),('SHREECEM'),('SIEMENS'),('SRF'),('SUNPHARMA'),('TATACONSUM'),('TATAMOTORS'),('TATASTEEL'),('TCS'),('TECHM'),('TITAN'),('TORNTPHARM'),('ULTRACEMCO'),('UPL'),('VEDL'),('WIPRO'),('ZOMATO'),('ZYDUSLIFE');
/*!40000 ALTER TABLE `nifty_100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_50`
--

DROP TABLE IF EXISTS `nifty_50`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_50` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_50`
--

LOCK TABLES `nifty_50` WRITE;
/*!40000 ALTER TABLE `nifty_50` DISABLE KEYS */;
INSERT INTO `nifty_50` VALUES ('ADANIPORTS'),('APOLLOHOSP'),('ASIANPAINT'),('AXISBANK'),('BAJAJ-AUTO'),('BAJAJFINSV'),('BAJFINANCE'),('BHARTIARTL'),('BPCL'),('BRITANNIA'),('CIPLA'),('COALINDIA'),('DIVISLAB'),('DRREDDY'),('EICHERMOT'),('GRASIM'),('HCLTECH'),('HDFC'),('HDFCBANK'),('HDFCLIFE'),('HEROMOTOCO'),('HINDALCO'),('HINDUNILVR'),('ICICIBANK'),('INDUSINDBK'),('INFY'),('ITC'),('JSWSTEEL'),('KOTAKBANK'),('LT'),('M&M'),('MARUTI'),('NESTLEIND'),('NTPC'),('ONGC'),('POWERGRID'),('RELIANCE'),('SBILIFE'),('SBIN'),('SHREECEM'),('SUNPHARMA'),('TATACONSUM'),('TATAMOTORS'),('TATASTEEL'),('TCS'),('TECHM'),('TITAN'),('ULTRACEMCO'),('UPL'),('WIPRO');
/*!40000 ALTER TABLE `nifty_50` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_auto`
--

DROP TABLE IF EXISTS `nifty_auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_auto` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_auto`
--

LOCK TABLES `nifty_auto` WRITE;
/*!40000 ALTER TABLE `nifty_auto` DISABLE KEYS */;
INSERT INTO `nifty_auto` VALUES ('ASHOKLEY'),('BAJAJ-AUTO'),('BALKRISIND'),('BHARATFORG'),('BOSCHLTD'),('EICHERMOT'),('ESCORTS'),('HEROMOTOCO'),('M&M'),('MARUTI'),('MRF'),('SONACOMS'),('TATAMOTORS'),('TIINDIA'),('TVSMOTOR');
/*!40000 ALTER TABLE `nifty_auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_bank`
--

DROP TABLE IF EXISTS `nifty_bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_bank` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_bank`
--

LOCK TABLES `nifty_bank` WRITE;
/*!40000 ALTER TABLE `nifty_bank` DISABLE KEYS */;
INSERT INTO `nifty_bank` VALUES ('AUBANK'),('AXISBANK'),('BANDHANBNK'),('BANKBARODA'),('FEDERALBNK'),('HDFCBANK'),('ICICIBANK'),('IDFCFIRSTB'),('INDUSINDBK'),('KOTAKBANK'),('PNB'),('SBIN');
/*!40000 ALTER TABLE `nifty_bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_commodities`
--

DROP TABLE IF EXISTS `nifty_commodities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_commodities` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_commodities`
--

LOCK TABLES `nifty_commodities` WRITE;
/*!40000 ALTER TABLE `nifty_commodities` DISABLE KEYS */;
INSERT INTO `nifty_commodities` VALUES ('AARTIIND'),('ACC'),('ADANIGREEN'),('AMBUJACEM'),('ATUL'),('BPCL'),('COALINDIA'),('DALBHARAT'),('DEEPAKNTR'),('GRASIM'),('HINDALCO'),('HINDPETRO'),('IOC'),('JINDALSTEL'),('JSWSTEEL'),('NMDC'),('NTPC'),('ONGC'),('PIDILITIND'),('PIIND'),('RAMCOCEM'),('RELIANCE'),('SAIL'),('SHREECEM'),('SRF'),('TATAPOWER'),('TATASTEEL'),('ULTRACEMCO'),('UPL'),('VEDL');
/*!40000 ALTER TABLE `nifty_commodities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_consumer_durables`
--

DROP TABLE IF EXISTS `nifty_consumer_durables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_consumer_durables` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_consumer_durables`
--

LOCK TABLES `nifty_consumer_durables` WRITE;
/*!40000 ALTER TABLE `nifty_consumer_durables` DISABLE KEYS */;
INSERT INTO `nifty_consumer_durables` VALUES ('AMBER'),('BATAINDIA'),('BLUESTARCO'),('CROMPTON'),('DIXON'),('HAVELLS'),('KAJARIACER'),('ORIENTELEC'),('RAJESHEXPO'),('RELAXO'),('TITAN'),('TTKPRESTIG'),('VGUARD'),('VOLTAS'),('WHIRLPOOL');
/*!40000 ALTER TABLE `nifty_consumer_durables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_energy`
--

DROP TABLE IF EXISTS `nifty_energy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_energy` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_energy`
--

LOCK TABLES `nifty_energy` WRITE;
/*!40000 ALTER TABLE `nifty_energy` DISABLE KEYS */;
INSERT INTO `nifty_energy` VALUES ('ADANIGREEN'),('ADANITRANS'),('BPCL'),('GAIL'),('IOC'),('NTPC'),('ONGC'),('POWERGRID'),('RELIANCE'),('TATAPOWER');
/*!40000 ALTER TABLE `nifty_energy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_financial_services`
--

DROP TABLE IF EXISTS `nifty_financial_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_financial_services` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_financial_services`
--

LOCK TABLES `nifty_financial_services` WRITE;
/*!40000 ALTER TABLE `nifty_financial_services` DISABLE KEYS */;
INSERT INTO `nifty_financial_services` VALUES ('AXISBANK'),('BAJAJFINSV'),('BAJFINANCE'),('CHOLAFIN'),('HDFC'),('HDFCAMC'),('HDFCBANK'),('HDFCLIFE'),('ICICIBANK'),('ICICIGI'),('ICICIPRULI'),('KOTAKBANK'),('MUTHOOTFIN'),('PEL'),('PFC'),('RECLTD'),('SBICARD'),('SBILIFE'),('SBIN'),('SRTRANSFIN');
/*!40000 ALTER TABLE `nifty_financial_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_fmcg`
--

DROP TABLE IF EXISTS `nifty_fmcg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_fmcg` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_fmcg`
--

LOCK TABLES `nifty_fmcg` WRITE;
/*!40000 ALTER TABLE `nifty_fmcg` DISABLE KEYS */;
INSERT INTO `nifty_fmcg` VALUES ('BRITANNIA'),('COLPAL'),('DABUR'),('EMAMILTD'),('GODREJCP'),('HINDUNILVR'),('ITC'),('MARICO'),('MCDOWELL-N'),('NESTLEIND'),('PGHH'),('RADICO'),('TATACONSUM'),('UBL'),('VBL');
/*!40000 ALTER TABLE `nifty_fmcg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_infrastructure`
--

DROP TABLE IF EXISTS `nifty_infrastructure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_infrastructure` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_infrastructure`
--

LOCK TABLES `nifty_infrastructure` WRITE;
/*!40000 ALTER TABLE `nifty_infrastructure` DISABLE KEYS */;
INSERT INTO `nifty_infrastructure` VALUES ('ACC'),('ADANIPORTS'),('AMBUJACEM'),('APOLLOHOSP'),('ASHOKLEY'),('BALKRISIND'),('BHARTIARTL'),('BPCL'),('CONCOR'),('DLF'),('GAIL'),('GODREJPROP'),('GRASIM'),('HINDPETRO'),('IGL'),('INDIGO'),('INDUSTOWER'),('IOC'),('IRCTC'),('LT'),('MRF'),('NTPC'),('ONGC'),('PETRONET'),('POWERGRID'),('RELIANCE'),('SHREECEM'),('SIEMENS'),('TATAPOWER'),('ULTRACEMCO');
/*!40000 ALTER TABLE `nifty_infrastructure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_it`
--

DROP TABLE IF EXISTS `nifty_it`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_it` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_it`
--

LOCK TABLES `nifty_it` WRITE;
/*!40000 ALTER TABLE `nifty_it` DISABLE KEYS */;
INSERT INTO `nifty_it` VALUES ('COFORGE'),('HCLTECH'),('INFY'),('LTI'),('LTTS'),('MINDTREE'),('MPHASIS'),('TCS'),('TECHM'),('WIPRO');
/*!40000 ALTER TABLE `nifty_it` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_media`
--

DROP TABLE IF EXISTS `nifty_media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_media` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_media`
--

LOCK TABLES `nifty_media` WRITE;
/*!40000 ALTER TABLE `nifty_media` DISABLE KEYS */;
INSERT INTO `nifty_media` VALUES ('DISHTV'),('HATHWAY'),('INOXLEISUR'),('NAZARA'),('NETWORK18'),('PVR'),('SAREGAMA'),('SUNTV'),('TV18BRDCST'),('ZEEL');
/*!40000 ALTER TABLE `nifty_media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_metal`
--

DROP TABLE IF EXISTS `nifty_metal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_metal` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_metal`
--

LOCK TABLES `nifty_metal` WRITE;
/*!40000 ALTER TABLE `nifty_metal` DISABLE KEYS */;
INSERT INTO `nifty_metal` VALUES ('ADANIENT'),('APLAPOLLO'),('HINDALCO'),('HINDCOPPER'),('HINDZINC'),('JINDALSTEL'),('JSLHISAR'),('JSWSTEEL'),('NATIONALUM'),('NMDC'),('RATNAMANI'),('SAIL'),('TATASTEEL'),('VEDL'),('WELCORP');
/*!40000 ALTER TABLE `nifty_metal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_midcap_100`
--

DROP TABLE IF EXISTS `nifty_midcap_100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_midcap_100` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_midcap_100`
--

LOCK TABLES `nifty_midcap_100` WRITE;
/*!40000 ALTER TABLE `nifty_midcap_100` DISABLE KEYS */;
INSERT INTO `nifty_midcap_100` VALUES ('AARTIIND'),('ABB'),('ABBOTINDIA'),('ABCAPITAL'),('ABFRL'),('ALKEM'),('APLLTD'),('APOLLOTYRE'),('ASHOKLEY'),('ASTRAL'),('ATGL'),('AUBANK'),('AUROPHARMA'),('BALKRISIND'),('BANKINDIA'),('BATAINDIA'),('BEL'),('BHARATFORG'),('BHEL'),('CANBK'),('CLEAN'),('COFORGE'),('CONCOR'),('COROMANDEL'),('CROMPTON'),('CUMMINSIND'),('DALBHARAT'),('DEEPAKNTR'),('DIXON'),('EMAMILTD'),('ESCORTS'),('EXIDEIND'),('FEDERALBNK'),('FORTIS'),('GLENMARK'),('GODREJPROP'),('GSPL'),('GUJGASLTD'),('HAL'),('HINDPETRO'),('HINDZINC'),('IDBI'),('IDEA'),('IDFCFIRSTB'),('IEX'),('IGL'),('INDHOTEL'),('INDIAMART'),('INDIANB'),('IPCALAB'),('IRCTC'),('ISEC'),('JINDALSTEL'),('JSWENERGY'),('L&TFH'),('LALPATHLAB'),('LAURUSLABS'),('LICHSGFIN'),('LTTS'),('M&MFIN'),('MANAPPURAM'),('MAXHEALTH'),('METROPOLIS'),('MFSL'),('MPHASIS'),('MRF'),('NAM-INDIA'),('NATIONALUM'),('NAVINFLUOR'),('OBEROIRLTY'),('OFSS'),('OIL'),('PAGEIND'),('PERSISTENT'),('PETRONET'),('PFC'),('POLICYBZR'),('POLYCAB'),('PRESTIGE'),('RAMCOCEM'),('RECLTD'),('SONACOMS'),('SRTRANSFIN'),('SUNTV'),('SYNGENE'),('TATACHEM'),('TATACOMM'),('TATAELXSI'),('TATAPOWER'),('TORNTPOWER'),('TRENT'),('TRIDENT'),('TVSMOTOR'),('UBL'),('UNIONBANK'),('VBL'),('VOLTAS'),('WHIRLPOOL'),('YESBANK'),('ZEEL');
/*!40000 ALTER TABLE `nifty_midcap_100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_midcap_50`
--

DROP TABLE IF EXISTS `nifty_midcap_50`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_midcap_50` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_midcap_50`
--

LOCK TABLES `nifty_midcap_50` WRITE;
/*!40000 ALTER TABLE `nifty_midcap_50` DISABLE KEYS */;
INSERT INTO `nifty_midcap_50` VALUES ('AARTIIND'),('ABB'),('ABBOTINDIA'),('ALKEM'),('ASHOKLEY'),('ASTRAL'),('AUBANK'),('AUROPHARMA'),('BALKRISIND'),('BATAINDIA'),('BEL'),('BHARATFORG'),('BHEL'),('CANBK'),('COFORGE'),('CONCOR'),('CUMMINSIND'),('ESCORTS'),('FEDERALBNK'),('GODREJPROP'),('GUJGASLTD'),('HAL'),('HINDPETRO'),('IDEA'),('IDFCFIRSTB'),('IRCTC'),('JINDALSTEL'),('L&TFH'),('LICHSGFIN'),('LTTS'),('M&MFIN'),('MFSL'),('MPHASIS'),('MRF'),('OFSS'),('PAGEIND'),('PETRONET'),('PFC'),('RAMCOCEM'),('RECLTD'),('SRTRANSFIN'),('SUNTV'),('TATACOMM'),('TATAPOWER'),('TORNTPOWER'),('TRENT'),('TVSMOTOR'),('UBL'),('VOLTAS'),('ZEEL');
/*!40000 ALTER TABLE `nifty_midcap_50` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_mnc`
--

DROP TABLE IF EXISTS `nifty_mnc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_mnc` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_mnc`
--

LOCK TABLES `nifty_mnc` WRITE;
/*!40000 ALTER TABLE `nifty_mnc` DISABLE KEYS */;
INSERT INTO `nifty_mnc` VALUES ('3MINDIA'),('ABB'),('ABBOTINDIA'),('AMBUJACEM'),('ASHOKLEY'),('BATAINDIA'),('BOSCHLTD'),('BRITANNIA'),('CASTROLIND'),('COLPAL'),('CUMMINSIND'),('GLAND'),('GLAXO'),('HINDUNILVR'),('HONAUT'),('IDEA'),('KANSAINER'),('MARUTI'),('MCDOWELL-N'),('MPHASIS'),('NESTLEIND'),('OFSS'),('PFIZER'),('PGHH'),('SANOFI'),('SIEMENS'),('SKFINDIA'),('UBL'),('VEDL'),('WHIRLPOOL');
/*!40000 ALTER TABLE `nifty_mnc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_next_50`
--

DROP TABLE IF EXISTS `nifty_next_50`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_next_50` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_next_50`
--

LOCK TABLES `nifty_next_50` WRITE;
/*!40000 ALTER TABLE `nifty_next_50` DISABLE KEYS */;
INSERT INTO `nifty_next_50` VALUES ('ACC'),('ADANIENT'),('ADANIGREEN'),('ADANITRANS'),('AMBUJACEM'),('BAJAJHLDNG'),('BANDHANBNK'),('BANKBARODA'),('BERGEPAINT'),('BIOCON'),('BOSCHLTD'),('CHOLAFIN'),('COLPAL'),('DABUR'),('DLF'),('DMART'),('GAIL'),('GLAND'),('GODREJCP'),('HAVELLS'),('HDFCAMC'),('ICICIGI'),('ICICIPRULI'),('INDIGO'),('INDUSTOWER'),('IOC'),('JUBLFOOD'),('LTI'),('LUPIN'),('MARICO'),('MCDOWELL-N'),('MINDTREE'),('MUTHOOTFIN'),('NAUKRI'),('NMDC'),('NYKAA'),('PAYTM'),('PEL'),('PGHH'),('PIDILITIND'),('PIIND'),('PNB'),('SAIL'),('SBICARD'),('SIEMENS'),('SRF'),('TORNTPHARM'),('VEDL'),('ZOMATO'),('ZYDUSLIFE');
/*!40000 ALTER TABLE `nifty_next_50` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_oil_and_gas`
--

DROP TABLE IF EXISTS `nifty_oil_and_gas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_oil_and_gas` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_oil_and_gas`
--

LOCK TABLES `nifty_oil_and_gas` WRITE;
/*!40000 ALTER TABLE `nifty_oil_and_gas` DISABLE KEYS */;
INSERT INTO `nifty_oil_and_gas` VALUES ('AEGISCHEM'),('ATGL'),('BPCL'),('CASTROLIND'),('GAIL'),('GSPL'),('GUJGASLTD'),('HINDPETRO'),('IGL'),('IOC'),('MGL'),('OIL'),('ONGC'),('PETRONET'),('RELIANCE');
/*!40000 ALTER TABLE `nifty_oil_and_gas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_pharma`
--

DROP TABLE IF EXISTS `nifty_pharma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_pharma` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_pharma`
--

LOCK TABLES `nifty_pharma` WRITE;
/*!40000 ALTER TABLE `nifty_pharma` DISABLE KEYS */;
INSERT INTO `nifty_pharma` VALUES ('ABBOTINDIA'),('ALKEM'),('APLLTD'),('AUROPHARMA'),('BIOCON'),('CIPLA'),('DIVISLAB'),('DRREDDY'),('GLAND'),('GLENMARK'),('GRANULES'),('IPCALAB'),('LAURUSLABS'),('LUPIN'),('NATCOPHARM'),('PFIZER'),('STAR'),('SUNPHARMA'),('TORNTPHARM'),('ZYDUSLIFE');
/*!40000 ALTER TABLE `nifty_pharma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_private_bank`
--

DROP TABLE IF EXISTS `nifty_private_bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_private_bank` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_private_bank`
--

LOCK TABLES `nifty_private_bank` WRITE;
/*!40000 ALTER TABLE `nifty_private_bank` DISABLE KEYS */;
INSERT INTO `nifty_private_bank` VALUES ('AXISBANK'),('BANDHANBNK'),('CUB'),('FEDERALBNK'),('HDFCBANK'),('ICICIBANK'),('IDFCFIRSTB'),('INDUSINDBK'),('KOTAKBANK'),('RBLBANK');
/*!40000 ALTER TABLE `nifty_private_bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_psu_bank`
--

DROP TABLE IF EXISTS `nifty_psu_bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_psu_bank` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_psu_bank`
--

LOCK TABLES `nifty_psu_bank` WRITE;
/*!40000 ALTER TABLE `nifty_psu_bank` DISABLE KEYS */;
INSERT INTO `nifty_psu_bank` VALUES ('BANKBARODA'),('BANKINDIA'),('CANBK'),('CENTRALBK'),('INDIANB'),('IOB'),('MAHABANK'),('PNB'),('PSB'),('SBIN'),('UCOBANK'),('UNIONBANK');
/*!40000 ALTER TABLE `nifty_psu_bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_realty`
--

DROP TABLE IF EXISTS `nifty_realty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_realty` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_realty`
--

LOCK TABLES `nifty_realty` WRITE;
/*!40000 ALTER TABLE `nifty_realty` DISABLE KEYS */;
INSERT INTO `nifty_realty` VALUES ('BRIGADE'),('DLF'),('GODREJPROP'),('IBREALEST'),('LODHA'),('OBEROIRLTY'),('PHOENIXLTD'),('PRESTIGE'),('SOBHA'),('SUNTECK');
/*!40000 ALTER TABLE `nifty_realty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_smallcap_100`
--

DROP TABLE IF EXISTS `nifty_smallcap_100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_smallcap_100` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_smallcap_100`
--

LOCK TABLES `nifty_smallcap_100` WRITE;
/*!40000 ALTER TABLE `nifty_smallcap_100` DISABLE KEYS */;
INSERT INTO `nifty_smallcap_100` VALUES ('AEGISCHEM'),('ALLCARGO'),('ALOKINDS'),('AMARAJABAT'),('AMBER'),('ANGELONE'),('ANURAS'),('APTUS'),('AVANTIFEED'),('BAJAJELEC'),('BALAMINES'),('BALRAMCHIN'),('BASF'),('BCG'),('BDL'),('BIRLACORPN'),('BRIGADE'),('BSE'),('BSOFT'),('CAMS'),('CANFINHOME'),('CARBORUNIV'),('CDSL'),('CENTRALBK'),('CENTURYTEX'),('CESC'),('CHAMBLFERT'),('CHEMPLASTS'),('CUB'),('CYIENT'),('DBL'),('DCMSHRIRAM'),('DELTACORP'),('DEVYANI'),('EDELWEISS'),('EIDPARRY'),('FINEORG'),('FSL'),('GMMPFAUDLR'),('GNFC'),('GRANULES'),('GRAPHITE'),('HEG'),('HFCL'),('HINDCOPPER'),('IBULHSGFIN'),('IDFC'),('INDIGOPNTS'),('INTELLECT'),('IOB'),('IRB'),('JBCHEPHARM'),('JKLAKSHMI'),('JMFINANCIL'),('JSL'),('JUBLINGREA'),('JUSTDIAL'),('KALYANKJIL'),('KEC'),('KEI'),('KPITTECH'),('LATENTVIEW'),('LUXIND'),('LXCHEM'),('MAHABANK'),('MAPMYINDIA'),('MASTEK'),('MCX'),('MEDPLUS'),('METROBRAND'),('MGL'),('MMTC'),('MOTILALOFS'),('NBCC'),('PNBHOUSING'),('POONAWALLA'),('PRINCEPIPE'),('PVR'),('QUESS'),('RADICO'),('RAIN'),('RBLBANK'),('REDINGTON'),('ROSSARI'),('ROUTE'),('RVNL'),('SAPPHIRE'),('SOBHA'),('SONATSOFTW'),('SPARC'),('STLTECH'),('SUNTECK'),('SUZLON'),('TANLA'),('TV18BRDCST'),('UTIAMC'),('VIPIND'),('VTL'),('WELSPUNIND'),('ZENSARTECH');
/*!40000 ALTER TABLE `nifty_smallcap_100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_smallcap_250`
--

DROP TABLE IF EXISTS `nifty_smallcap_250`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_smallcap_250` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_smallcap_250`
--

LOCK TABLES `nifty_smallcap_250` WRITE;
/*!40000 ALTER TABLE `nifty_smallcap_250` DISABLE KEYS */;
INSERT INTO `nifty_smallcap_250` VALUES ('AARTIDRUGS'),('ABSLAMC'),('ADVENZYMES'),('AEGISCHEM'),('ALLCARGO'),('ALOKINDS'),('AMARAJABAT'),('AMBER'),('ANGELONE'),('ANURAS'),('APTUS'),('ASAHIINDIA'),('ASTERDM'),('ASTRAZEN'),('AVANTIFEED'),('BAJAJELEC'),('BALAMINES'),('BALRAMCHIN'),('BASF'),('BBTC'),('BCG'),('BDL'),('BIRLACORPN'),('BLUESTARCO'),('BORORENEW'),('BRIGADE'),('BSE'),('BSOFT'),('CAMS'),('CANFINHOME'),('CAPLIPOINT'),('CARBORUNIV'),('CASTROLIND'),('CCL'),('CDSL'),('CEATLTD'),('CENTRALBK'),('CENTURYPLY'),('CENTURYTEX'),('CERA'),('CESC'),('CGCL'),('CHALET'),('CHAMBLFERT'),('CHEMPLASTS'),('CHOLAHLDNG'),('COCHINSHIP'),('CREDITACC'),('CSBBANK'),('CUB'),('CYIENT'),('DBL'),('DCMSHRIRAM'),('DELTACORP'),('DEVYANI'),('DHANI'),('EASEMYTRIP'),('ECLERX'),('EDELWEISS'),('EIDPARRY'),('EIHOTEL'),('ELGIEQUIP'),('ENGINERSIN'),('EPL'),('EQUITAS'),('EQUITASBNK'),('ERIS'),('FACT'),('FDC'),('FINCABLES'),('FINEORG'),('FINPIPE'),('FSL'),('GAEL'),('GALAXYSURF'),('GARFIBRES'),('GESHIP'),('GLS'),('GMMPFAUDLR'),('GNFC'),('GOCOLORS'),('GODFRYPHLP'),('GODREJAGRO'),('GPPL'),('GRANULES'),('GRAPHITE'),('GRINFRA'),('GSFC'),('GUJALKALI'),('HATHWAY'),('HEG'),('HEMIPROP'),('HFCL'),('HGS'),('HIKAL'),('HINDCOPPER'),('HLEGLAS'),('HOMEFIRST'),('HUDCO'),('IBREALEST'),('IBULHSGFIN'),('ICIL'),('IDFC'),('IFBIND'),('IIFL'),('IIFLWAM'),('INDIACEM'),('INDIGOPNTS'),('INDOCO'),('INFIBEAM'),('INOXLEISUR'),('INTELLECT'),('IOB'),('IRB'),('IRCON'),('ITI'),('JAMNAAUTO'),('JBCHEPHARM'),('JKLAKSHMI'),('JKPAPER'),('JMFINANCIL'),('JSL'),('JSLHISAR'),('JUBLINGREA'),('JUBLPHARMA'),('JUSTDIAL'),('JYOTHYLAB'),('KALPATPOWR'),('KALYANKJIL'),('KARURVYSYA'),('KEC'),('KEI'),('KIMS'),('KNRCON'),('KPITTECH'),('KPRMILL'),('KRBL'),('LATENTVIEW'),('LAXMIMACH'),('LUXIND'),('LXCHEM'),('MAHABANK'),('MAHINDCIE'),('MAHLOG'),('MAPMYINDIA'),('MASTEK'),('MAZDOCK'),('MCX'),('MEDPLUS'),('METROBRAND'),('MGL'),('MHRIL'),('MMTC'),('MOIL'),('MOTILALOFS'),('MRPL'),('MTARTECH'),('NAZARA'),('NBCC'),('NCC'),('NESCO'),('NETWORK18'),('NH'),('NLCINDIA'),('NOCIL'),('ORIENTELEC'),('PCBL'),('PGHL'),('PNBHOUSING'),('PNCINFRA'),('POLYMED'),('POLYPLEX'),('POONAWALLA'),('POWERINDIA'),('PRAJIND'),('PRINCEPIPE'),('PRIVISCL'),('PRSMJOHNSN'),('PVR'),('QUESS'),('RADICO'),('RAILTEL'),('RAIN'),('RALLIS'),('RATNAMANI'),('RBA'),('RBLBANK'),('RCF'),('REDINGTON'),('RENUKA'),('RHIM'),('RITES'),('ROSSARI'),('ROUTE'),('RTNINDIA'),('RVNL'),('SAPPHIRE'),('SAREGAMA'),('SCI'),('SEQUENT'),('SFL'),('SHILPAMED'),('SHRIRAMCIT'),('SHYAMMETL'),('SIS'),('SJVN'),('SOBHA'),('SOLARA'),('SONATSOFTW'),('SPARC'),('SPICEJET'),('STAR'),('STLTECH'),('SUDARSCHEM'),('SUNTECK'),('SUPRAJIT'),('SUVENPHAR'),('SUZLON'),('SWSOLAR'),('SYMPHONY'),('TANLA'),('TATACOFFEE'),('TATAINVEST'),('TATASTLLP'),('TCIEXP'),('TCNSBRANDS'),('TEAMLEASE'),('THYROCARE'),('TIMKEN'),('TRITURBINE'),('TTKPRESTIG'),('TV18BRDCST'),('UCOBANK'),('UFLEX'),('UTIAMC'),('VAIBHAVGBL'),('VAKRANGEE'),('VARROC'),('VENKEYS'),('VGUARD'),('VIJAYA'),('VIPIND'),('VMART'),('VTL'),('WELCORP'),('WELSPUNIND'),('WESTLIFE'),('WOCKPHARMA'),('ZENSARTECH'),('ZYDUSWELL');
/*!40000 ALTER TABLE `nifty_smallcap_250` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nifty_smallcap_50`
--

DROP TABLE IF EXISTS `nifty_smallcap_50`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nifty_smallcap_50` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nifty_smallcap_50`
--

LOCK TABLES `nifty_smallcap_50` WRITE;
/*!40000 ALTER TABLE `nifty_smallcap_50` DISABLE KEYS */;
INSERT INTO `nifty_smallcap_50` VALUES ('ALOKINDS'),('AMARAJABAT'),('AMBER'),('ANGELONE'),('ANURAS'),('BAJAJELEC'),('BALAMINES'),('BIRLACORPN'),('BSOFT'),('CAMS'),('CANFINHOME'),('CDSL'),('CENTRALBK'),('CESC'),('CHAMBLFERT'),('CHEMPLASTS'),('CYIENT'),('DBL'),('DEVYANI'),('FSL'),('GRANULES'),('GRAPHITE'),('HEG'),('HFCL'),('HINDCOPPER'),('IBULHSGFIN'),('IDFC'),('INDIGOPNTS'),('INTELLECT'),('IOB'),('JBCHEPHARM'),('JUBLINGREA'),('KPITTECH'),('LATENTVIEW'),('LXCHEM'),('MAHABANK'),('MCX'),('MEDPLUS'),('METROBRAND'),('NBCC'),('PNBHOUSING'),('POONAWALLA'),('PVR'),('RADICO'),('RBLBANK'),('ROUTE'),('STLTECH'),('UTIAMC'),('WELSPUNIND'),('ZENSARTECH');
/*!40000 ALTER TABLE `nifty_smallcap_50` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_and_p_100`
--

DROP TABLE IF EXISTS `s_and_p_100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_and_p_100` (
  `Name` varchar(150) DEFAULT NULL,
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_and_p_100`
--

LOCK TABLES `s_and_p_100` WRITE;
/*!40000 ALTER TABLE `s_and_p_100` DISABLE KEYS */;
INSERT INTO `s_and_p_100` VALUES ('AAPL'),('ABBV'),('ABT'),('ACN'),('AEP'),('AIG'),('AMGN'),('AMZN'),('AVGO'),('AXP'),('BA'),('BAC'),('BAX'),('BIIB'),('BK'),('BMY'),('BRKB'),('C'),('CAT'),('CL'),('CMCSA'),('COF'),('COP'),('COST'),('CSCO'),('CVS'),('CVX'),('DIS'),('DOW'),('DVN'),('EBAY'),('EMR'),('EXC'),('F'),('FB'),('FCX'),('FDX'),('GD'),('GILD'),('GM'),('GOOG'),('GS'),('HAL'),('HD'),('HON'),('HPQ'),('IBM'),('INTC'),('JNJ'),('JPM'),('KO'),('LIN'),('LLY'),('LMT'),('LOW'),('MA'),('MCD'),('MDLZ'),('MDT'),('MET'),('MO'),('MRK'),('MS'),('MSFT'),('NFLX'),('NKE'),('NSC'),('ORCL'),('PEP'),('PFE'),('PG'),('PM'),('QCOM'),('RTX'),('SBUX'),('SO'),('SPG'),('T'),('TGT'),('TMO'),('TMUS'),('TSLA'),('TXN'),('UNH'),('UNP'),('UPS'),('USB'),('V'),('VZ'),('WBA'),('WFC'),('WMB'),('WMT'),('XOM');
/*!40000 ALTER TABLE `s_and_p_100` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-21 19:50:58
