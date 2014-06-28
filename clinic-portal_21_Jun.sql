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
	(1, 'Mr', 'Dhairya', 'Ashok', 'Bankar', NULL, '2014-06-20 18:29:10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(2, 'Mr', 'Dhairya', 'Ashok', 'Bankar', NULL, '2014-06-20 18:29:11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(3, 'Mr', 'Dhairya', 'Ashok', 'Bankar', NULL, '2014-06-20 18:29:12', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(8, 'Mrs', 'Pankja', 'Gopinath', 'Munde', NULL, '2014-06-20 18:29:05', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(10, 'Mr', 'Pankaj', 'Ashok', 'Muneshwar', NULL, '2014-06-20 18:29:07', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL),
	(11, 'fdsf', 'sfsdf', 'sdfsdf', 'fsdf', 'Male', '2014-06-20 18:29:08', 'fsfsdfdsf', 'fsdfsdf', 'sdf', 'fsdfsd', 'fsdfsdf', 'dfsdf', 'fsdfsd', 'fdsfsdf', 'sdfsdf', 'fsdfsdf', 'dsf', 'fdsfdsf', 'sdfsdf', 'fdsfds', 'dsfsd', 'fdsfsd', 'dsfdsf', 'fdsfsdf', 'fsdfsdf', 'fdsfds', 'Green', 'fsdfsdf', 'fdsfsdfdsf', 'URGENT_VISIT, FOLLOW_UP_VISIT, REFERRAL', 0, 0, NULL),
	(12, 'fdsf', 'sfsdf', 'sdfsdf', 'fsdf', 'Male', '2014-06-20 18:29:00', 'fsfsdfdsf', 'fsdfsdf', 'sdf', 'fsdfsd', 'fsdfsdf', 'dfsdf', 'fsdfsd', 'fdsfsdf', 'sdfsdf', 'fsdfsdf', 'dsf', 'fdsfdsf', 'sdfsdf', 'fdsfds', 'dsfsd', 'fdsfsd', 'dsfdsf', 'fdsfsdf', 'fsdfsdf', 'fdsfds', 'Green', 'fsdfsdf', 'fdsfsdfdsf', 'URGENT_VISIT, FOLLOW_UP_VISIT, REFERRAL', 0, 0, NULL),
	(13, 'dada', 'dadadada', 'dsfdsfc', 'xvxcvcxvcx', 'Male', '2014-06-20 18:29:01', 'vxcfsdzfvd', 'vcxvcx', 'safsaf', 'fsdfd', 'fdsafsa', 'fdsfsadfsf', 'safsafsafas', 'fxzvc', 'dsdffsadf', 'xzvx', 'fvxcvxc', 'xzcvxcv', 'vxcbvxc', 'vx', 'vcvxcv', 'dfsdsad', 'vxcvx', 'vxzvxfs', 'vxzcvxzvx', 'vxvxcz', 'Red', 'vxczvxzv', 'vxzvxzvz', 'URGENT_VISIT, FOLLOW_UP_VISIT, REFERRAL', 0, 0, NULL),
	(14, 'dadsasd', 'dasdasd', 'dada', 'dadad', 'Male', '2014-06-20 18:29:02', 'adsa', 'dsdsd', 'dasd', 'dada', 'dasd', 'dasdas', 'adadada', NULL, 'dadad', NULL, 'dadad', NULL, 'dad', NULL, 'dad', NULL, 'adad', NULL, 'ada', NULL, 'Orange', NULL, NULL, 'FOLLOW_UP_VISIT,DEXA,YEARLY_PHYSICAL', 0, 0, NULL),
	(15, 'Mr', 'Dhairya', 'A', 'Bankar', 'Male', '2014-06-20 18:29:03', 'adadad', 'adada', 'zcxzc', 'asdsadscf', 'czzczc', 'czxczc', 'zczczc', 'czczcz', 'zfcvxz', 'czczc', 'vxzvzxv', 'xczxzxc', 'bccvbc', 'czczc', 'czDCsdf', 'czc', 'cxzcz', 'werwesr', 'czxc', 'czxc', 'Green', 'cxzczx', 'czxcxzcxzc', 'DEXA,REFERRAL,FOLLOW_UP_VISIT', 0, 0, NULL),
	(16, 'Mr', 'Jagbir', 'Paul', 'Singh', 'Male', '2014-06-20 18:29:04', 'Cash', 'Pune', 'MH', 'IN', '411345', '997022331', 'sjksdkjszcd/@dmc.om', 'sdfsdf', 'fsdfsdf', 'fdsfsfsf', 'sdfsdfdsfsf', 'fsdfwsafae', 'asfasdfasf', 'fasfasdf', 'wrqwr', 'fasdfasf', 'rwqrwqer', 'fasdfasd', 'rwqerwqer', 'rqwrqwr', 'Orange', 'rwqerqwer', 'rqwrwrwqr', 'DEXA,REFERRAL,FOLLOW_UP_VISIT,WELLNESS_EXAM', 0, 0, NULL),
	(17, 'Mr', 'Pankaj', 'G', 'Munde', 'Male', '2014-06-18 05:30:00', 'Adhik', 'sdlkl', 'mxaslxk', NULL, 's;lkal', 'qklka', 'k;lask', 'dsadsada', 'dasdcxz', 'csacsa', 'cxzczx', 'csacdsa', 'csc', 'csacsa', 'czxc', 'cxzc', 'cxzcz', 'czxc', 'czxc', 'cxzc', 'Orange', 'czxczx', 'czxcxzcxz', 'URGENT_VISIT,DEXA,WELLNESS_EXAM', 0, 0, NULL),
	(18, 'as', 'aaaaa', 'aaaa', 'aaaaa', 'Male', '2014-06-26 05:30:00', 'dsddsdssdsd', 'dsddsdd', 'dsdsd', 'dsdsdsdd', 'ddd', 'dfsdfdsf', 'dddddd', 'ddddddd', 'sssss', 'sddss', 'dddd', 'ererer', 'vgcvcv', 'dfdfdf', 'vcvcv', 'vcvcvc', 'vcvcv', 'vcv', 'cvcvcvv', 'cvcvcv', 'Orange', 'cvcvcv', 'cvcvcv', 'REFERRAL,FOLLOW_UP_VISIT,WELLNESS_EXAM', 0, 0, NULL),
	(19, 'mr', 'sdsad', 'dsad', 'dasd', 'Male', '2014-06-26 05:30:00', 'dsasdasd', 'adasdsad', 'dasdsad', 'dasdasd', 'dasdas', 'sadsad', 'dsadasdsa', 'dasdsad', 'dsadasd', 'dsadasd', 'sadsa', 'sadsads', 'dasdsa', 'sadsad', 'dsad', 'dsad', 'asdsadsa', 'adsadsad', 'dsadsad', 'dsadsa', 'Orange', 'dsadsad', 'dasdsad', 'URGENT_VISIT,REFERRAL,WELLNESS_EXA', 0, 0, NULL),
	(20, 'adsad', 'dasdas', 'dada', 'dad', 'Male', '2014-06-25 05:30:00', 'dadada', 'dadad', 'adad', 'adada', 'adad', 'dadd', 'adad', 'dada', NULL, 'dadad', NULL, 'adad', NULL, 'adad', NULL, 'adad', NULL, 'dadad', NULL, 'dada', 'Green', 'dada', 'dadd', 'URGENT_VISIT,DEXA,REFERRA', 0, 0, NULL),
	(21, 'xcscf', 'cxcxz', 'czxczc', 'czxczxc', 'Male', '2014-06-26 05:30:00', 'czxczxc', 'cxzc', 'czxczc', 'xcxzc', 'czxc', 'cxzczc', 'zxcxzcz', 'cxzc', 'czxczxc', 'xcxzcz', 'cxzcx', 'cxzc', 'zcxzc', 'zxcxz', 'zxc', 'xzc', 'xzcxz', 'zxczxc', 'cc', NULL, 'Red', NULL, 'zzz', 'DEX', 0, 0, NULL),
	(22, 'dssd', 'cfxx', 'cxxc', '', 'Male', '2014-06-26 05:30:00', NULL, NULL, NULL, 'vbvb', NULL, 'bvb', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Red', NULL, NULL, 'URGENT_VISIT,DEX', 0, 0, NULL),
	(23, 'zx', 'xzxz', 'xzx', 'xzx', 'Male', '2014-06-05 05:30:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'xzxz', 'Green', 'xzx', 'xzxx', 'DEXA,FOLLOW_UP_VISI', 0, 0, NULL);
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
INSERT INTO `group_detail` (`id`, `doctor_id`, `group_name`, `clia_number`, `provider_number`, `effective_date`, `expiration_date`) VALUES
	(1, 19, 'Dhiraj', '2345', '1234', NULL, NULL),
	(2, 19, 'Pankaj', '455445', '2222', NULL, NULL),
	(3, 20, 'Dhiraj', 'P0012', 'Poi', '2014-06-25 05:30:00', NULL),
	(4, 20, 'Pankaj', '0009', 'aaa', '2014-06-12 05:30:00', NULL),
	(5, 21, 'xzx', NULL, 'xzxz', '2014-06-26 05:30:00', '2014-06-23 05:30:00'),
	(6, 22, 'bvbv', NULL, 'bvbv', '2014-06-19 05:30:00', '2014-06-10 05:30:00'),
	(7, 22, 'bvbv', NULL, 'vbbvb', '2014-06-20 05:30:00', '2014-06-27 05:30:00'),
	(8, 23, 'xzxzx', NULL, 'xzxz', '2014-06-05 05:30:00', '2014-06-12 05:30:00');
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
