-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 03, 2021 at 05:30 PM
-- Server version: 5.7.33-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.7

-- 03022021.2 : API stable with authentication

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_notepadinhand`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_notes`
--

CREATE TABLE `tbl_notes` (
  `id_notes` int(11) NOT NULL,
  `titleof_notes` text,
  `contentof_notes` text,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_user` int(11) DEFAULT NULL,
  `categoryof_notes` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_notes`
--

INSERT INTO `tbl_notes` (`id_notes`, `titleof_notes`, `contentof_notes`, `date_created`, `id_user`, `categoryof_notes`) VALUES
(21, 'Task lagi 3', 'test', '2021-02-02 07:48:08', 3, 'Task'),
(22, 'Task lagi 3', 'test', '2021-02-02 07:00:27', 55, 'To do');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `hash_useraccess` text,
  `level` varchar(40) DEFAULT NULL,
  `dateuser_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id_user`, `username`, `password`, `hash_useraccess`, `level`, `dateuser_created`) VALUES
(3, 'septiadi', '631ec9f3d25318425609112350772635', '104da6ff6c25dfb1fce322b9e18e4140ff5fe99c', 'Administrator', '2021-01-07 15:32:57'),
(8, 'lula', 'd88a4d2b4799bcd2ccdb2d2e2929f09d', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-01-18 07:08:19'),
(55, 'riona', '49f3cc3c97f36a843d65b3194d3aceea', '104da6ff6c25dfb1fce322b9e18e4140ff5fe99c', 'Administrator', '2021-02-02 06:15:55'),
(56, 'wayan', '6f3792a964f0e3a5f06a35dfe609716c', '104da6ff6c25dfb1fce322b9e18e4140ff5fe99c', 'Administrator', '2021-02-02 06:50:44'),
(57, 'aji', '8d045450ae16dc81213a75b725ee2760', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-02-02 07:10:27'),
(58, 'aryolo', 'd9c9e55612c5dce2fbdeae9adb67afee', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-02-02 07:10:50'),
(59, 'tegar', '1d31802d64bae29d88923d795fc73734', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-02-02 07:50:05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_notes`
--
ALTER TABLE `tbl_notes`
  ADD PRIMARY KEY (`id_notes`),
  ADD KEY `fknotes2user` (`id_user`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_notes`
--
ALTER TABLE `tbl_notes`
  MODIFY `id_notes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_notes`
--
ALTER TABLE `tbl_notes`
  ADD CONSTRAINT `fknotes2user` FOREIGN KEY (`id_user`) REFERENCES `tbl_user` (`id_user`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
