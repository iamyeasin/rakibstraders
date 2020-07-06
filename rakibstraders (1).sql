-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 11, 2018 at 06:14 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rakibstraders`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill_list`
--

CREATE TABLE `bill_list` (
  `billing_ID` varchar(100) NOT NULL,
  `vendor_ID` varchar(60) NOT NULL,
  `time` varchar(60) NOT NULL,
  `date` date NOT NULL,
  `discount` double NOT NULL,
  `labour_cost` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bill_products`
--

CREATE TABLE `bill_products` (
  `billing_ID` varchar(200) NOT NULL,
  `products_ID` varchar(200) NOT NULL,
  `box` varchar(60) NOT NULL,
  `pcs` varchar(60) NOT NULL,
  `feet` varchar(60) NOT NULL,
  `price` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_ID` varchar(200) NOT NULL,
  `customer_name` varchar(60) NOT NULL,
  `phone_number1` varchar(15) NOT NULL,
  `phone_number2` varchar(15) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_ID` varchar(100) NOT NULL,
  `employee_name` varchar(50) NOT NULL,
  `phone1` varchar(50) NOT NULL,
  `phone2` varchar(50) NOT NULL,
  `StartingDate` varchar(50) NOT NULL,
  `Salary` double NOT NULL,
  `offdays_per_month` int(11) NOT NULL,
  `address` varchar(150) NOT NULL,
  `notes` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_salary`
--

CREATE TABLE `employee_salary` (
  `date` date NOT NULL,
  `time` varchar(30) NOT NULL,
  `exp_ID` varchar(50) NOT NULL,
  `emp_ID` varchar(50) NOT NULL,
  `reciept_ID` int(11) NOT NULL,
  `payment_method` varchar(50) NOT NULL,
  `payment_reason` varchar(50) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `emp_attendance`
--

CREATE TABLE `emp_attendance` (
  `Emp_ID` varchar(200) NOT NULL,
  `Date` date NOT NULL,
  `Start_Time` varchar(100) NOT NULL,
  `End_Time` varchar(100) NOT NULL,
  `Status` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `exp_ID` varchar(50) NOT NULL,
  `date` date DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `optional_category` varchar(200) NOT NULL,
  `amount` double DEFAULT NULL,
  `payment_type` varchar(30) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `notes` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `invoice_list`
--

CREATE TABLE `invoice_list` (
  `invoice_ID` varchar(200) NOT NULL,
  `customer_ID` varchar(200) NOT NULL,
  `time` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `discount` double NOT NULL,
  `labour_cost` double NOT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `invoice_products`
--

CREATE TABLE `invoice_products` (
  `invoice_ID` varchar(200) NOT NULL,
  `product_ID` varchar(200) NOT NULL,
  `Box` varchar(50) NOT NULL,
  `Pcs` varchar(50) NOT NULL,
  `feet` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `profit` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `ID` varchar(200) NOT NULL,
  `receipt_ID` int(100) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(30) NOT NULL,
  `payment_method` varchar(10) NOT NULL,
  `paid_amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `products_id` varchar(60) NOT NULL,
  `company_name` varchar(200) NOT NULL,
  `model` varchar(200) NOT NULL,
  `dimension` varchar(100) NOT NULL,
  `pcs_per_box` int(5) NOT NULL,
  `item_unit` varchar(60) NOT NULL,
  `purchase_price` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `notes` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `returned_list`
--

CREATE TABLE `returned_list` (
  `invoice_ID` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(30) NOT NULL,
  `total_cashBack` double NOT NULL,
  `Deduction` double NOT NULL,
  `original_total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `returned_products`
--

CREATE TABLE `returned_products` (
  `invoice_ID` varchar(50) NOT NULL,
  `product_ID` varchar(50) NOT NULL,
  `feet` double NOT NULL,
  `box` varchar(50) NOT NULL,
  `pcs` varchar(50) NOT NULL,
  `total_price` double NOT NULL,
  `ItemUnit` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `products_id` varchar(60) NOT NULL,
  `left` double NOT NULL,
  `alert_val` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_list`
--

CREATE TABLE `user_list` (
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(30) NOT NULL,
  `access_level` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_log`
--

CREATE TABLE `user_log` (
  `SL` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `log_in` datetime NOT NULL,
  `log_out` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vendors`
--

CREATE TABLE `vendors` (
  `vendor_id` varchar(100) NOT NULL,
  `vendor_name` varchar(200) NOT NULL,
  `shop_name` varchar(200) NOT NULL,
  `address` varchar(500) NOT NULL,
  `phone1` varchar(11) NOT NULL,
  `phone2` varchar(11) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `dealerships` varchar(500) DEFAULT NULL,
  `no_of_bus` int(6) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill_list`
--
ALTER TABLE `bill_list`
  ADD PRIMARY KEY (`billing_ID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_ID`);

--
-- Indexes for table `employee_salary`
--
ALTER TABLE `employee_salary`
  ADD PRIMARY KEY (`exp_ID`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`exp_ID`);

--
-- Indexes for table `invoice_list`
--
ALTER TABLE `invoice_list`
  ADD PRIMARY KEY (`invoice_ID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`products_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`products_id`);

--
-- Indexes for table `user_list`
--
ALTER TABLE `user_list`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `user_log`
--
ALTER TABLE `user_log`
  ADD PRIMARY KEY (`SL`);

--
-- Indexes for table `vendors`
--
ALTER TABLE `vendors`
  ADD PRIMARY KEY (`vendor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_log`
--
ALTER TABLE `user_log`
  MODIFY `SL` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
