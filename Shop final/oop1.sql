-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2019 at 11:23 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop1`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerId` varchar(13) NOT NULL,
  `customerName` varchar(15) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `address` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerId`, `customerName`, `phoneNumber`, `address`) VALUES
('c0001', 'mahmudhassan', '01752612062', 'kuril'),
('c0002', 'bakul', '01752619273', 'gazipur'),
('c0003', 'manik', '0197483745', 'bushundhora'),
('c0004', 'arnob', '018374933948', 'rajshahi'),
('', '', '', ''),
('2222', 'mahmuhassan', '01739485416', 'bogra'),
('2222', 'mahmuhassan', '01739485416', 'bogra'),
('2222', 'mahmuhassan', '01739485416', 'bogra'),
('2222', 'mahmuhassan', '01739485416', 'bogra'),
('2222', 'mahmuhassan', '01739485416', 'bogra'),
('2222', 'mahmuhassan', '01739485416', 'bogra'),
('2222', 'mahmuhassan', '01739485416', 'bogra'),
('c0005', 'mahmodul', '01752612062', 'bogra'),
('c0005', 'mahmodul', '01752612062', 'bogra'),
('c0005', 'mahmodul', '01752612062', 'bogra'),
('c0005', 'mahmodul', '01752612062', 'bogra'),
('c0005', 'mahmodul', '01752612062', 'bogra'),
('c0005', 'mahmodul', '01752612062', 'bogra'),
('c0005', 'mahmodul', '01752612062', 'bogra'),
('c0005', 'mahmodul', '0175261206', 'bogra'),
('c000oo', 'mahmodulll', 'gyg', 'bograoo'),
('c000oo', 'mahmodulll', 'gyg', 'bograoo'),
('c000oo', 'mahmodulll', 'gyg', 'bograoo'),
('c000oooo', 'mahmodulllo', 'igyg', 'bograooo'),
('', '', '', ''),
('', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(6) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`, `salary`) VALUES
('e00001', 'emp1', 'manager', 300000.00),
('e00002', 'Employee2', 'salesman', 220000.00),
('e00003', 'emp3', 'salesman', 10000.00),
('e00006', 'e6', 'cashier', 10000.00),
('e013', 'Employee13', 'manager', 5345.00),
('e08', 'Emp08', 'cashier', 12000.00),
('e11', 'mp11', 'cashier', 10000.00),
('e12', 'E12', 'assdd', 1234.00),
('e15', 'Emp015', 'manager', 1234.00),
('e16', 'asdgg', 'cashier', 10000.00),
('e3713', 'mahmud', 'manager', 3000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('', '', 0),
('17340591', '16160491', 1),
('2222', '4444', 0),
('c0001', '1234', 2),
('c00011', '1111', 2),
('c0002', '1234', 2),
('c0004', '1234', 2),
('c0005', '1234', 0),
('c0007', '1234', 2),
('c0008', '1234', 2),
('c0009', '1234', 2),
('c000oo', '1234o', 0),
('c000oooo', '1234oi', 0),
('e00001', '1234', 0),
('e00002', '17404044', 1),
('e00003', '13695425', 1),
('e00006', '10415479', 1),
('e013', '14487762', 0),
('e08', '12121238', 1),
('e11', '10956941', 1),
('e12', '17588323', 1),
('e15', '15501192', 0),
('e16', '18587052', 1),
('e3713', '15419779', 1),
('mahmud3', '11648175', 1),
('p0003', '13652425', 1),
('p0004', '10305369', 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `proId` varchar(14) NOT NULL,
  `proName` varchar(13) NOT NULL,
  `price` int(14) NOT NULL,
  `quantity` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`proId`, `proName`, `price`, `quantity`) VALUES
('p00001', 'juice', 2, 15),
('p0001', 'chips', 0, 20),
('p0003', 'coffee', 500, 5),
('p0004', 'phone', 1500, 2),
('p0006', 'mi brand', 6000, 1),
('p0007', 'Frutika', 16, 2),
('p0008', '7UP', 15, 6),
('p0009', 'book', 200, 2),
('p0011', 'fan', 1200, 2);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `proId` varchar(13) NOT NULL,
  `proName` varchar(13) NOT NULL,
  `price` int(12) DEFAULT NULL,
  `quantity` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`proId`, `proName`, `price`, `quantity`) VALUES
('p0001', 'food', 200, 45),
('p0002', 'cold', 50, 10),
('p0003', 'mi', NULL, 0),
('p0004', 'pc', 1200, 22),
('p0005', 'mouse', 450, 5),
('p00001', 'juice', 2, 1),
('p0011', 'fan', 1200, 1),
('p0009', 'book', 200, 1),
('p0008', '7UP', 15, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`empId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`proId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
