-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 05, 2021 at 01:28 PM
-- Server version: 5.7.33-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_notepad`
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
(22, 'Task lagi 3', 'test', '2021-02-02 07:00:27', 55, 'To do'),
(23, 'Ini dibuat Arif', 'Ini adalah catatan arif', '2021-03-04 02:24:14', 87, 'Task'),
(24, 'Ini dibuat oleh randi', 'Ini dibuat oleh randi', '2021-03-05 00:28:22', 89, 'Notes'),
(25, 'Ini dibuat oleh randi', 'Ini dibuat oleh randi', '2021-03-05 00:28:45', 89, 'Task'),
(26, 'Ini dibuat Arif', 'Ini adalah catatan arif', '2021-03-08 05:43:14', 87, 'Task'),
(27, 'Ini dibuat Arif', 'Ini adalah catatan arif', '2021-03-08 05:43:35', 87, 'To do'),
(28, 'Ini dibuat Arif', 'Ini adalah catatan arif', '2021-03-08 05:44:50', 87, 'To do'),
(29, 'Tambah baru lah 1', 'Ini adalah catatan arif', '2021-03-08 05:49:11', 87, 'To do'),
(30, 'Tambah baru lah 1asd', 'Ini adalah catatan arif', '2021-03-08 05:51:00', 87, 'To do'),
(31, 'Tambah dei lah', 'Ini adalah catatan arif', '2021-03-08 05:51:31', 87, 'To do'),
(32, 'Tambah dei lah di task', 'Ini adalah catatan arif', '2021-03-08 05:53:55', 87, 'Task'),
(33, 'Tambah dei lah di notes', 'Ini adalah catatan arif', '2021-03-08 05:56:42', 87, 'Notes'),
(34, 'Tambah dengan password encyprt', 'Ini adalah catatan arif', '2021-03-08 05:57:59', 87, 'Notes'),
(35, 'Tambah data oleh user arif', 'Catatan baru', '2021-03-08 06:34:57', 87, 'Task'),
(38, 'Ditambahkan dari Aplikasi Notes', 'cek tambah 1', '2021-03-08 07:40:27', 87, 'Notes'),
(39, 'Sampel input', 'asdfasdfasdfajsdlfjkasldfjasljkdfalskjdflaskjdflasjkdflajksdlfjkasldfjkasldfjkasldfjasldjfaslkjdfalsjkdflasjkdflasjkdflakjsdflasjkdflakjsdflajsdlfjkasldkfjasldkfjaslkdfjalskdjfalsjdflasjkdflasjkfalskjdfalsjkdfalskjdfalskjdfalskjdfaslkjdfaskljdflasjkdfajsdflkasjdflasjdflajsdflajksdfljkasldfjkasldfjkalsdfjalskdfjaslkdfjalskdjfalskjdfalsjfalskjdfalsdfjaskljdfaskljdfasldfjalskjfaskljdfalsjkdflaksjdfalksdjfaskjdfaklsjdfalskjdfasjfaskfklasjfaslkjdfaklsdfjaslkdfjaskljfaklsfka', '2021-03-08 07:49:22', 87, 'Notes'),
(40, 'Sample', 'aoweirj', '2021-03-15 03:45:10', 87, 'Task'),
(41, 'Saya Menambahkan Tugas Baru', 'Saya mengerjakan tugas dari Ust. Asep', '2021-03-30 06:24:51', 64, 'Task'),
(43, 'Ini adalah catatan dari tugas Matematika', 'Pembahasan Rumus Kuadrat', '2021-03-30 06:53:42', 64, 'Notes'),
(44, 'skldjfa', 'kajsdlfj', '2021-03-30 06:55:32', 64, 'To do'),
(45, 'fjasdlkfj', 'alskdfjalskj', '2021-03-30 06:55:44', 64, 'Notes'),
(46, 'Sampe Aja', 'Catatan', '2021-04-01 02:39:20', 3, 'Notes'),
(47, 'Coba Task', 'Task', '2021-04-01 02:49:25', 64, 'Task'),
(48, 'Its fun', 'Task', '2021-04-01 03:01:18', 64, 'Task'),
(49, 'Ini catatan hilda pertama', 'Catatan', '2021-04-05 00:34:15', 65, 'Notes'),
(50, 'Ini todo list tugas', 'Mengerjakan tugas RPL', '2021-04-05 01:04:00', 3, 'To do');

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
(3, 'septiadi', '631ec9f3d25318425609112350772635', '104da6ff6c25dfb1fce322b9e18e4140ff5fe99c', 'Administrator', '2021-02-26 01:50:38'),
(8, 'lula', 'd88a4d2b4799bcd2ccdb2d2e2929f09d', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-01-18 07:08:19'),
(55, 'riona', '49f3cc3c97f36a843d65b3194d3aceea', '104da6ff6c25dfb1fce322b9e18e4140ff5fe99c', 'Administrator', '2021-02-02 06:15:55'),
(56, 'wayan', '6f3792a964f0e3a5f06a35dfe609716c', '104da6ff6c25dfb1fce322b9e18e4140ff5fe99c', 'Administrator', '2021-02-02 06:50:44'),
(57, 'aji', '8d045450ae16dc81213a75b725ee2760', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-02-02 07:10:27'),
(58, 'aryolo', 'd9c9e55612c5dce2fbdeae9adb67afee', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-02-02 07:10:50'),
(59, 'tegar', '1d31802d64bae29d88923d795fc73734', '1e0e4e24cd186e001e9f702316158729652fa72a', 'User Biasa', '2021-02-02 07:50:05'),
(60, 'rudi', '1755e8df56655122206c7c1d16b1c7e3', '104da6ff6c25dfb1fce322b9e18e4140ff5fe99c', 'Administrator', '2021-02-24 06:47:43'),
(61, 'sample', '5e8ff9bf55ba3508199d22e984129be6', '104da6ff6c25dfb1fce322b9e18e4140ff5fe99c', 'Administrator', '2021-03-01 06:34:35'),
(64, 'handi', 'd06aab75b19db81f44975b164a5fe86f', 'f3f9b7d32ebdd16560bba29cf151ba23427e96c7', 'Administrator', '2021-03-01 07:21:31'),
(65, 'hilda', 'ad31b478525413f0b1b1d8bf0aebeb7c', 'b4a76018b58008c6f2f9e5d7d38379682903a9c2', 'General', '2021-03-01 07:30:23'),
(66, 'aa', '4124bc0a9335c27f086f24ba207a4912', '20226b6aaf0df4fc525481e97685ba99ba6b8679', 'General', '2021-03-03 07:57:10'),
(67, 'Rahmet', '7650b528dd425791ef555d7bccb48cce', 'fbbdad5661eb7265265964573da557979a597a1a', 'Administrator', '2021-03-03 08:02:19'),
(68, 'a', '0cc175b9c0f1b6a831c399e269772661', 'e99a953fb08caa1d08e583814972357c3c05c730', 'General', '2021-03-03 08:05:13'),
(69, 'gina', '7df27de84ed79a46d75c7c57ad00f76f', '5f59b537e78a21a0de74548ba979078520b52ccb', 'General', '2021-03-04 01:04:44'),
(76, 'ai', '4921c0e2d1f6005abe1f9ec2e2041909', '1a1191839adde10597b77d5d31551f11e7c2fecd', 'Administrator', '2021-03-04 01:55:46'),
(77, 'rara', 'd8830ed2c45610e528dff4cb229524e9', '7b321a5176e9cedc6d9251118a1c1e1c696b7083', 'General', '2021-03-04 01:57:35'),
(78, 'Ira', '93de2c7fd5e9b0b4cd338dc2c577bf84', 'e48c66e5f592937bf879a7bafc48314e986c4dd4', 'General', '2021-03-04 01:59:10'),
(79, 'r', '4b43b0aee35624cd95b910189b3dc231', 'eaeb4fc8a3f57230d8e11dbb1f31ccdec1ae7e20', 'r', '2021-03-04 01:59:43'),
(80, 'y', '415290769594460e2e485922904f345d', '33ec99acbb0bb2fe8ad57fc767c2dcc1cd74d8e9', 'y', '2021-03-04 02:00:41'),
(81, 'Nina', 'f2ceea1536ac1b8fed1a167a9c8bf04d', '2cc8f4b2afd990e700c3cdf7e80bb01d5929660f', 'General', '2021-03-04 02:01:35'),
(82, 'Feri', '4c850dbd4128e75d16f407a9188e2aab', 'fef77ae9cf662bf0be31ec0227eca62f3faaf8a0', 'Administrator', '2021-03-04 02:03:19'),
(83, 'Kila', '80570bebec5742bf89b3fbf9642cec02', '2731f7be3bc2433d1fc72465625ef609ce14aff5', 'Administrator', '2021-03-04 02:04:02'),
(84, 'Bima', '7fcba392d4dcca33791a44cd892b2112', 'e46380a72b95a4ae44c6e4d85269adfc6d9ec97e', 'Administrator', '2021-03-04 02:05:03'),
(85, 'Fitri', '534a0b7aa872ad1340d0071cbfa38697', 'ea61c7c0d709c8e266a3b31932e76125684dbd75', 'General', '2021-03-04 02:06:05'),
(86, 'Riri', 'c740d6848b6a342dcc26c177ea2c49fe', '42c93ca69e6163c4964e94abbc89458dad1d7ba3', 'Administrator', '2021-03-04 02:09:44'),
(87, 'arif', '0ff6c3ace16359e41e37d40b8301d67f', '92b6099770d8bd96bbed3c6ecdcbf8b8fef78b5e', 'Staff Kantor', '2021-03-04 02:21:56'),
(88, 'Renata', '1b67d3053dc8facc72e0238bc8640c7a', '5e269db58eb835d94e9ed260148aee9b3c3a70da', 'General', '2021-03-04 02:26:02'),
(89, 'randi', 'ec1a08ca25857e260784856b3556804d', '3be699eb22cbc2d8b4c8adf5951bdb0d13049838', 'Administrator', '2021-03-05 00:27:14'),
(90, 'ferdi', '8bf4bb0e2efad01abe522bf314504a49', '7af3c132282506a391c1d3b0f12bd474da9b2021', 'Administrator', '2021-03-08 05:24:36');

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
  MODIFY `id_notes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;
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
