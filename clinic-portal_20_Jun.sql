-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.44-community - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table emr-portal.doctor
CREATE TABLE IF NOT EXISTS `doctor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `salutation` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `address` varchar(400) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `primary_speciality` varchar(255) DEFAULT NULL,
  `secondary_speciality` varchar(255) DEFAULT NULL,
  `professional_qualification` varchar(255) DEFAULT NULL,
  `employment_status` varchar(255) DEFAULT NULL,
  `professional_reg_no` varchar(255) DEFAULT NULL,
  `federal_ein` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `npi` varchar(255) DEFAULT NULL,
  `dea` varchar(255) DEFAULT NULL,
  `state_license` varchar(255) DEFAULT NULL,
  `upin` varchar(255) DEFAULT NULL,
  `taxanomy` varchar(255) DEFAULT NULL,
  `rendering_provider` varchar(255) DEFAULT NULL,
  `doctor_color` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `signature_text` varchar(255) DEFAULT NULL,
  `allowed_scheduled_event` varchar(255) DEFAULT NULL,
  `is_external_refer` tinyint(1) DEFAULT '0',
  `is_admin` tinyint(1) DEFAULT '0',
  `bio` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.doctor: ~9 rows (approximately)
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`id`, `salutation`, `first_name`, `middle_name`, `last_name`, `gender`, `date_of_birth`, `address`, `city`, `state`, `country`, `postal_code`, `contact_number`, `email`, `primary_speciality`, `secondary_speciality`, `professional_qualification`, `employment_status`, `professional_reg_no`, `federal_ein`, `ssn`, `npi`, `dea`, `state_license`, `upin`, `taxanomy`, `rendering_provider`, `doctor_color`, `signature`, `signature_text`, `allowed_scheduled_event`, `is_external_refer`, `is_admin`, `bio`) VALUES
	(1, 'Mr', 'Dhairya', 'Ashok', 'Bankar', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(2, 'Mr', 'Dhairya', 'Ashok', 'Bankar', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(3, 'Mr', 'Dhairya', 'Ashok', 'Bankar', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(8, 'Mrs', 'Pankja', 'Gopinath', 'Munde', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(10, 'Mr', 'Pankaj', 'Ashok', 'Muneshwar', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(11, 'fdsf', 'sfsdf', 'sdfsdf', 'fsdf', 'Male', NULL, 'fsfsdfdsf', 'fsdfsdf', 'sdf', 'fsdfsd', 'fsdfsdf', 'dfsdf', 'fsdfsd', 'fdsfsdf', 'sdfsdf', 'fsdfsdf', 'dsf', 'fdsfdsf', 'sdfsdf', 'fdsfds', 'dsfsd', 'fdsfsd', 'dsfdsf', 'fdsfsdf', 'fsdfsdf', 'fdsfds', 'Green', 'fsdfsdf', 'fdsfsdfdsf', 'DEXA, WellnessExam, YearlyPhysical', 0, 0, NULL),
	(12, 'fdsf', 'sfsdf', 'sdfsdf', 'fsdf', 'Male', NULL, 'fsfsdfdsf', 'fsdfsdf', 'sdf', 'fsdfsd', 'fsdfsdf', 'dfsdf', 'fsdfsd', 'fdsfsdf', 'sdfsdf', 'fsdfsdf', 'dsf', 'fdsfdsf', 'sdfsdf', 'fdsfds', 'dsfsd', 'fdsfsd', 'dsfdsf', 'fdsfsdf', 'fsdfsdf', 'fdsfds', 'Green', 'fsdfsdf', 'fdsfsdfdsf', 'DEXA, WellnessExam, YearlyPhysical', 0, 0, NULL),
	(13, 'dada', 'dadadada', 'dsfdsfc', 'xvxcvcxvcx', 'Male', NULL, 'vxcfsdzfvd', 'vcxvcx', 'safsaf', 'fsdfd', 'fdsafsa', 'fdsfsadfsf', 'safsafsafas', 'fxzvc', 'dsdffsadf', 'xzvx', 'fvxcvxc', 'xzcvxcv', 'vxcbvxc', 'vx', 'vcvxcv', 'dfsdsad', 'vxcvx', 'vxzvxfs', 'vxzcvxzvx', 'vxvxcz', 'Red', 'vxczvxzv', 'vxzvxzvz', 'UrgentVisit, FollowupVisit, Refferal', 0, 0, NULL),
	(14, 'dadsasd', 'dasdasd', 'dada', 'dadad', 'Male', NULL, 'adsa', 'dsdsd', 'dasd', 'dada', 'dasd', 'dasdas', 'adadada', NULL, 'dadad', NULL, 'dadad', NULL, 'dad', NULL, 'dad', NULL, 'adad', NULL, 'ada', NULL, 'Orange', NULL, NULL, 'FollowupVisit,DEXA,YearlyPhysical', 0, 0, NULL);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;


-- Dumping structure for table emr-portal.group_detail
CREATE TABLE IF NOT EXISTS `group_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `doctor_id` bigint(20) NOT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  `clia_number` varchar(255) DEFAULT NULL,
  `provider_number` varchar(255) DEFAULT NULL,
  `effective_date` datetime DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_group_detail_doctor_1` (`doctor_id`),
  CONSTRAINT `fk_group_detail_doctor_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.group_detail: ~0 rows (approximately)
/*!40000 ALTER TABLE `group_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_detail` ENABLE KEYS */;


-- Dumping structure for table emr-portal.user_model
CREATE TABLE IF NOT EXISTS `user_model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `profession_qualification` varchar(255) DEFAULT NULL,
  `is_admin_allowed` tinyint(1) DEFAULT '0',
  `user_type` varchar(17) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.user_model: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_model` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
