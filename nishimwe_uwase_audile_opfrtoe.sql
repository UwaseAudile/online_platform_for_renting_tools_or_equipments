-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 12:01 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nishimwe_uwase_audile_opfrtoe`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `idNumber` int(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `martialStatus` varchar(100) NOT NULL,
  `Dob` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `delivary_man`
--

CREATE TABLE `delivary_man` (
  `id` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `delivary_man`
--

INSERT INTO `delivary_man` (`id`, `name`, `telephone`, `email`) VALUES
(1, 'John', '078989', 'john@gmail.com'),
(2, 'Mami', '087777', 'mami@gmail.com'),
(3, 'kamali', '078888', 'kama@gmail.com'),
(4, 'Doe', '07800', 'doe@gmail.com'),
(5, 'Diane', '078666', 'dia@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `use_id` int(100) NOT NULL,
  `tool_id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `name`, `use_id`, `tool_id`) VALUES
(1, 'kamonyi', 1, 1),
(3, 'kamonyi', 1, 1),
(4, 'kigali', 3, 2),
(5, 'karongi', 2, 3),
(6, 'kabuga', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `idNumber` int(100) NOT NULL,
  `Phone` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `dob` varchar(100) NOT NULL,
  `martialStatus` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`fname`, `lname`, `idNumber`, `Phone`, `gender`, `dob`, `martialStatus`, `email`, `password`) VALUES
('nishimwe', '', 0, '0789', 'Female', '', 'single', 'nish@gmail.com', '1111'),
('', '', 0, '', 'Male', '', '', '', ''),
('NISHIMWE', '', 0, '88888', 'Male', '', 'SINGLE', 'uwa@gmail.com', '66666'),
('', '', 0, '', 'Male', '', '', '', ''),
('Kalisa', '', 0, '0789', 'Male', '', 'single', 'kali@gmail.com', '2222'),
('Kalisa', '', 0, '0789', 'Male', '', 'single', 'kali@gmail.com', '2222'),
('', '', 0, '', 'Male', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `rentals`
--

CREATE TABLE `rentals` (
  `id` int(50) NOT NULL,
  `start_date` varchar(20) NOT NULL,
  `end_date` varchar(20) NOT NULL,
  `total_cost` int(100) NOT NULL,
  `user_id` int(100) NOT NULL,
  `tool_id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rentals`
--

INSERT INTO `rentals` (`id`, `start_date`, `end_date`, `total_cost`, `user_id`, `tool_id`) VALUES
(0, '0', '0', 0, 0, 0),
(1, '11', '12', 100, 1, 1),
(2, '11', '12', 100, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tool_equipments`
--

CREATE TABLE `tool_equipments` (
  `id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tool_equipments`
--

INSERT INTO `tool_equipments` (`id`, `name`, `description`, `price`) VALUES
(1, 'Screwdriver', 'used to turn drives', 220),
(2, 'hammer', 'used to pound nails', 200),
(3, 'Saw', 'used to cut wood', 230),
(4, 'plates', 'used in eating', 400),
(5, 'car', 'used in transport', 40000);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `transaction_date` int(100) DEFAULT NULL,
  `amount` int(100) DEFAULT NULL,
  `use_id` int(100) NOT NULL,
  `tool_id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `name`, `transaction_date`, `amount`, `use_id`, `tool_id`) VALUES
(1, 'renting screwdrive', 11, 100, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `PHONE_NUMBER` int(10) DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `address` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `PHONE_NUMBER`, `EMAIL`, `address`) VALUES
(1, 'dudu', 78989, 'dudu@gmail.com', 'kacyiru'),
(2, 'Nana', 78888, 'nana@gmail.com', 'kamonyi'),
(3, 'yvan', 6789, 'yvan@gmail.com', 'kabeza'),
(4, 'yvan', 6789, 'yvan@gmail.com', 'kabeza'),
(5, 'Rugema', 6789, 'yvan@gmail.com', 'kabeza'),
(6, 'aud', 6789, 'aud@gmail.com', 'kabeza'),
(7, 'munana', 5678, 'muna@gmail.com', 'karongi'),
(8, 'munana', 5678, 'muna@gmail.com', 'karongi'),
(9, 'kaka', 8797, 'ka@gmail.com', 'rubavu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `delivary_man`
--
ALTER TABLE `delivary_man`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rentals`
--
ALTER TABLE `rentals`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
