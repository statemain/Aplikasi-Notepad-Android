-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 18, 2021 at 02:51 PM
-- Server version: 5.7.32-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_notes`
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
(28, 'Konten', 'Konten', '2021-01-12 06:56:08', 3, 'Notes'),
(29, 'sdfa', 'sdf', '2021-01-12 06:56:18', 5, 'Task'),
(30, 'skjdfaslkdj', 'lakjsdf;lkaj', '2021-01-14 02:33:11', 5, 'Task'),
(31, 'Contoh Notes baru', 'konten notesnya', '2021-01-18 06:27:33', 5, 'To do'),
(32, 'Ini dari postman', 'Ini proses input dari postman', '2021-01-18 06:41:44', 3, 'Notes'),
(33, 'Ditambakan oleh si ardi', 'Ini konten si ardi', '2021-01-18 06:50:19', 5, 'Notes'),
(34, 'Ditambakan oleh si ardi', 'Ini konten si ardi', '2021-01-18 07:01:56', 5, 'Notes'),
(35, 'Konten baru', 'Konten baru', '2021-01-18 07:03:07', 5, 'Notes'),
(36, 'Konten baru lagi', 'Konten baru lagi', '2021-01-18 07:03:56', 5, 'Notes'),
(37, 'Title Pemberitahuan', 'Konten baru lagi', '2021-01-18 07:04:46', 5, 'Task'),
(38, 'Sample data baru', 'Konten baru lagi', '2021-01-18 07:08:32', 8, 'To do'),
(39, 'Test tambah notes lagi', 'Test tambah notes lagi', '2021-01-18 07:11:49', 8, 'Notes');

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
(5, 'ardi', '0264391c340e4d3cbba430cee7836eaf', '0bd9da89839528b632e08f7a833c30a77f1480f4', 'Staff', '2021-01-12 06:49:29'),
(8, 'lula', 'd88a4d2b4799bcd2ccdb2d2e2929f09d', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-01-18 07:08:19');

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
  MODIFY `id_notes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
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
