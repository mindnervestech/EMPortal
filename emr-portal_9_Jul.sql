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

-- Dumping structure for table emr-portal.address_detail
CREATE TABLE IF NOT EXISTS `address_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patient_id` bigint(20) NOT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_default_contact` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `ix_address_detail_patient_1` (`patient_id`),
  CONSTRAINT `fk_address_detail_patient_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.address_detail: ~1 rows (approximately)
/*!40000 ALTER TABLE `address_detail` DISABLE KEYS */;
INSERT INTO `address_detail` (`id`, `patient_id`, `address`, `city`, `state`, `country`, `postal_code`, `is_default_contact`) VALUES
	(4, 4, 'Pune', 'Pune', 'MH', 'IN', '23456677', 0);
/*!40000 ALTER TABLE `address_detail` ENABLE KEYS */;


-- Dumping structure for table emr-portal.appointment
CREATE TABLE IF NOT EXISTS `appointment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appointment_date` int(11) DEFAULT NULL,
  `appointment_month` int(11) DEFAULT NULL,
  `appointment_year` int(11) DEFAULT NULL,
  `appointment_dmy` datetime DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `notes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `visit_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `start_min` int(11) DEFAULT NULL,
  `end_min` int(11) DEFAULT NULL,
  `appointment_of_id` bigint(20) DEFAULT NULL,
  `appointment_of_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `appointment_with_id` bigint(20) DEFAULT NULL,
  `appointment_with_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.appointment: ~10 rows (approximately)
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` (`id`, `appointment_date`, `appointment_month`, `appointment_year`, `appointment_dmy`, `status`, `notes`, `visit_type`, `start_min`, `end_min`, `appointment_of_id`, `appointment_of_type`, `appointment_with_id`, `appointment_with_type`) VALUES
	(1, 8, 6, 2014, '2014-07-08 09:00:00', 'BOOKED', NULL, '4', 540, 645, 4, 'USER', 1, 'DOCTOR'),
	(2, 8, 6, 2014, '2014-07-08 09:00:00', 'PARTIAL', NULL, '4', 540, 600, 4, 'USER', 2, 'DOCTOR'),
	(4, 8, 6, 2014, '2014-07-08 09:00:00', 'BOOKED', NULL, '5', 540, 645, 4, 'USER', 2, 'DOCTOR'),
	(5, 8, 6, 2014, '2014-07-08 11:15:00', 'BOOKED', NULL, '5', 675, 750, 4, 'USER', 1, 'DOCTOR'),
	(6, 8, 6, 2014, '2014-07-08 11:15:00', 'BOOKED', NULL, '4', 675, 750, 4, 'USER', 2, 'DOCTOR'),
	(8, 9, 6, 2014, '2014-07-09 10:30:00', 'BOOKED', NULL, '2', 630, 690, 4, 'USER', 1, 'DOCTOR'),
	(9, 11, 6, 2014, '2014-07-11 05:30:00', 'PARTIAL', NULL, '3', 1035, 1095, 4, 'USER', 2, 'DOCTOR'),
	(10, 9, 6, 2014, '2014-07-09 10:30:00', 'BOOKED', NULL, '3', 630, 690, 4, 'USER', 2, 'DOCTOR'),
	(11, 9, 6, 2014, '2014-07-09 17:00:00', 'PARTIAL', NULL, '2', 1020, 1080, 4, 'USER', 1, 'DOCTOR'),
	(12, 10, 6, 2014, '2014-07-10 08:45:00', 'PARTIAL', NULL, '6', 525, 585, 4, 'USER', 1, 'DOCTOR');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;


-- Dumping structure for table emr-portal.auth_user
CREATE TABLE IF NOT EXISTS `auth_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `facility_id` bigint(20) DEFAULT NULL,
  `user_profile_id` bigint(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `ix_auth_user_facility_2` (`facility_id`),
  KEY `ix_auth_user_userProfile_3` (`user_profile_id`),
  CONSTRAINT `fk_auth_user_facility_2` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`),
  CONSTRAINT `fk_auth_user_userProfile_3` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.auth_user: ~8 rows (approximately)
/*!40000 ALTER TABLE `auth_user` DISABLE KEYS */;
INSERT INTO `auth_user` (`id`, `password`, `username`, `facility_id`, `user_profile_id`, `enabled`) VALUES
	(1, 'sa', 'dhairyashil.bankar@gmail.com', -1, NULL, 1),
	(2, 'PZ7KvT', 'pankajashokmuneshwar@gmail.com', NULL, NULL, 1),
	(3, 'Ba9l9T', 'sanghapal.ahankare@gmail.com', -1, NULL, 1),
	(5, '123', 'harshad.r.gojare@gmail.com', 2, NULL, 0),
	(6, 'FT9vaJ', 'shwashank12@gmail.com', 2, NULL, 1),
	(8, 'alG1NX', 'dhiraj10.1988@gmail.com', 2, NULL, 1),
	(9, 'yIUC1z', 'dhiraj101.9888@gmail.com', 2, NULL, 1),
	(10, 'bAsfwD', 'jagbir.paul@gmail.com', 2, NULL, 1);
/*!40000 ALTER TABLE `auth_user` ENABLE KEYS */;


-- Dumping structure for table emr-portal.auth_user_role
CREATE TABLE IF NOT EXISTS `auth_user_role` (
  `auth_user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`auth_user_id`,`role_id`),
  KEY `fk_auth_user_role_role_02` (`role_id`),
  CONSTRAINT `fk_auth_user_role_auth_user_01` FOREIGN KEY (`auth_user_id`) REFERENCES `auth_user` (`id`),
  CONSTRAINT `fk_auth_user_role_role_02` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.auth_user_role: ~6 rows (approximately)
/*!40000 ALTER TABLE `auth_user_role` DISABLE KEYS */;
INSERT INTO `auth_user_role` (`auth_user_id`, `role_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(5, 5),
	(6, 6),
	(10, 7);
/*!40000 ALTER TABLE `auth_user_role` ENABLE KEYS */;


-- Dumping structure for table emr-portal.clinic
CREATE TABLE IF NOT EXISTS `clinic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ext` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contact_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `internal_location` tinyint(1) DEFAULT '0',
  `dial_area_code` tinyint(1) DEFAULT '0',
  `display_in_scheduling` tinyint(1) DEFAULT '0',
  `optical_location` tinyint(1) DEFAULT '0',
  `facility_location` tinyint(1) DEFAULT '0',
  `place_of_service` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `facility_npi` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `facility_entity_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `note` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `directions` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.clinic: ~1 rows (approximately)
/*!40000 ALTER TABLE `clinic` DISABLE KEYS */;
INSERT INTO `clinic` (`id`, `name`, `address1`, `address2`, `city`, `state`, `postal_code`, `country`, `phone`, `ext`, `contact_name`, `internal_location`, `dial_area_code`, `display_in_scheduling`, `optical_location`, `facility_location`, `place_of_service`, `facility_npi`, `facility_entity_id`, `note`, `directions`) VALUES
	(1, 'Dhiraj', 'Pune', 'Pintur', 'Pune', 'MH', '999999', 'India', '9999999', '20', 'Fred', 1, 1, 0, 1, 1, 'Out_Patient_Hospital', 'fsdfsdfsdf', '67', 'dgdfgfdgfdsg', 'gdsagdsfgdfsg');
/*!40000 ALTER TABLE `clinic` ENABLE KEYS */;


-- Dumping structure for table emr-portal.doctor
CREATE TABLE IF NOT EXISTS `doctor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `salutation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `address` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contact_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `primary_speciality` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `secondary_speciality` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `professional_qualification` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `employment_status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `professional_reg_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `federal_ein` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ssn` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `npi` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dea` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state_license` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `upin` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `taxanomy` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `rendering_provider` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `doctor_color` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `signature` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `signature_text` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `allowed_scheduled_event` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_external_refer` tinyint(1) DEFAULT '0',
  `is_admin` tinyint(1) DEFAULT '0',
  `bio` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.doctor: ~2 rows (approximately)
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`id`, `salutation`, `first_name`, `middle_name`, `last_name`, `gender`, `date_of_birth`, `address`, `city`, `state`, `country`, `postal_code`, `contact_number`, `email`, `primary_speciality`, `secondary_speciality`, `professional_qualification`, `employment_status`, `professional_reg_no`, `federal_ein`, `ssn`, `npi`, `dea`, `state_license`, `upin`, `taxanomy`, `rendering_provider`, `doctor_color`, `signature`, `signature_text`, `allowed_scheduled_event`, `is_external_refer`, `is_admin`, `bio`) VALUES
	(1, 'Mr', 'Amit', NULL, 'Goyal', 'MALE', '2014-07-30 05:30:00', 'P-1', 'Pune', 'MH', 'IN', '987456', '9988877', 'mindnervestech@gmail.com', 'Primary-1', 'Secondary-2', 'BE', 'START', 'P-123456', 'E-2345', '9999999', 'NPI-123', 'DEA', 'MH-123', 'pppp', 'oooo', 'RP-123', 'Green', 'Dhiraj', 'Dhiraj', 'YEARLY_PHYSICAL,URGENT_VISIT,DEXA,WELLNESS_EXA', 0, 0, NULL),
	(2, 'Mr', 'Jagbir', NULL, 'Singh', 'MALE', '2014-07-24 05:30:00', 'Pune', 'Pune', 'MH', 'IN', '99999999', '9898989898', 'dhairya@gmail.com', 'P-1', 'S-2', 'BE', 'Pending', 'P-1111', 'EIN-2222', 'SSN-123', 'NPI-232', 'sdas', 'sdasd', 'sdas', 'sdasd', 'Pickock', 'Red', 'PSA', 'PSA', 'URGENT_VISIT,DEXA,REFERRA', 0, 0, NULL);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;


-- Dumping structure for table emr-portal.facility
CREATE TABLE IF NOT EXISTS `facility` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `facility_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `salutation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contact_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `relative_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `website` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.facility: ~2 rows (approximately)
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` (`id`, `facility_name`, `salutation`, `contact_name`, `address1`, `address2`, `city`, `state`, `country`, `zip_code`, `relative_url`, `website`, `email`, `status`) VALUES
	(-1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, 'DiyaBati', 'MISS', 'Pankaj', 'Delhi', 'Pune', 'Pune', 'MH', 'India', '4323423', '/dhairya', 'www.gmail.com', 'harshad.r.gojare@gmail.com', 'APPROVED');
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;


-- Dumping structure for table emr-portal.group_detail
CREATE TABLE IF NOT EXISTS `group_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `clia_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `provider_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `effective_date` datetime DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_group_detail_doctor_4` (`doctor_id`),
  CONSTRAINT `fk_group_detail_doctor_4` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.group_detail: ~2 rows (approximately)
/*!40000 ALTER TABLE `group_detail` DISABLE KEYS */;
INSERT INTO `group_detail` (`id`, `group_name`, `clia_number`, `provider_number`, `effective_date`, `expiration_date`, `doctor_id`) VALUES
	(1, 'Dhiraj', NULL, 'P-1212', '2014-07-31 05:30:00', '2014-08-04 05:30:00', 1),
	(2, 'Doctor', '08', '09', '2014-07-31 05:30:00', '2014-08-05 05:30:00', 2);
/*!40000 ALTER TABLE `group_detail` ENABLE KEYS */;


-- Dumping structure for table emr-portal.insurance_company
CREATE TABLE IF NOT EXISTS `insurance_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `attn` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cms_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `payer_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.insurance_company: ~0 rows (approximately)
/*!40000 ALTER TABLE `insurance_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `insurance_company` ENABLE KEYS */;


-- Dumping structure for table emr-portal.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_id` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_menu_permission_5` (`permission_id`),
  CONSTRAINT `fk_menu_permission_5` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.menu: ~10 rows (approximately)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `permission_id`, `pid`) VALUES
	(2, 1, NULL),
	(3, 3, NULL),
	(4, 2, NULL),
	(5, 4, NULL),
	(6, 5, NULL),
	(7, 6, NULL),
	(8, 7, NULL),
	(9, 8, NULL),
	(10, 9, NULL),
	(11, 10, NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


-- Dumping structure for table emr-portal.patient
CREATE TABLE IF NOT EXISTS `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `salutation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `guardian_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `ssn` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobile_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `preferred_communication` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `emergency_contact_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `emergency_contact_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `insurance_carrier_1_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `insurance_carrier_2_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `insurance_carrier_1_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `insurance_carrier_2_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ethnicity` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.patient: ~1 rows (approximately)
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`id`, `salutation`, `first_name`, `middle_name`, `last_name`, `parent`, `guardian_name`, `nick_name`, `gender`, `date_of_birth`, `ssn`, `phone_number`, `mobile_number`, `email`, `preferred_communication`, `emergency_contact_name`, `emergency_contact_number`, `insurance_carrier_1_no`, `insurance_carrier_2_no`, `insurance_carrier_1_name`, `insurance_carrier_2_name`, `ethnicity`) VALUES
	(4, 'Mr', 'Dhiraj', 'Ashok', 'Bankar', 'Ashok', 'Ashok', 'Dheeraj', 'MALE', '2014-07-30 05:30:00', '121232323', '999999999', '32323232', 'dhiraj10.1988@gmail.com', 'Mail', 'dhairya', '31231231', '12121212', '3232323', NULL, NULL, 'ASIAN');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;


-- Dumping structure for table emr-portal.permission
CREATE TABLE IF NOT EXISTS `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `display_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.permission: ~10 rows (approximately)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`id`, `name`, `display_name`, `url`) VALUES
	(1, 'doctorLayout', 'Manage Doctor', '/doctorLayout'),
	(2, 'userLayout', 'Manage User', '/userLayout'),
	(3, 'facilityLayout', 'Manage Facility', '/facilityLayout'),
	(4, 'homeLayout', 'Home', '/homeLayout'),
	(5, 'manage', 'Manage', NULL),
	(6, 'clinicLayout', 'Manage Clinic', '/clinicLayout'),
	(7, 'permissionLayout', 'Manage Permission', '/permissionLayout'),
	(8, 'patientLayout', 'Manage Patient', '/patientLayout'),
	(9, 'roleLayout', 'Manage Roles', '/roleLayout'),
	(10, 'schedularLayout', 'Schedular', '/schedularLayout');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;


-- Dumping structure for table emr-portal.pharmacy
CREATE TABLE IF NOT EXISTS `pharmacy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fax` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `method` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.pharmacy: ~0 rows (approximately)
/*!40000 ALTER TABLE `pharmacy` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacy` ENABLE KEYS */;


-- Dumping structure for table emr-portal.privileges
CREATE TABLE IF NOT EXISTS `privileges` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_read` tinyint(1) DEFAULT '0',
  `is_write` tinyint(1) DEFAULT '0',
  `is_denied` tinyint(1) DEFAULT '0',
  `permision_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_privileges_permision_6` (`permision_id`),
  CONSTRAINT `fk_privileges_permision_6` FOREIGN KEY (`permision_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.privileges: ~28 rows (approximately)
/*!40000 ALTER TABLE `privileges` DISABLE KEYS */;
INSERT INTO `privileges` (`id`, `name`, `is_read`, `is_write`, `is_denied`, `permision_id`) VALUES
	(4, NULL, 1, 1, 0, 4),
	(5, NULL, 1, 1, 0, 6),
	(41, NULL, 0, 0, 1, 1),
	(42, NULL, 0, 0, 0, 2),
	(43, NULL, 0, 0, 0, 3),
	(44, NULL, 0, 0, 0, 4),
	(45, NULL, 0, 0, 0, 6),
	(46, NULL, 0, 0, 0, 1),
	(47, NULL, 0, 0, 0, 2),
	(48, NULL, 0, 0, 1, 3),
	(49, NULL, 0, 0, 1, 4),
	(50, NULL, 0, 0, 0, 6),
	(63, NULL, 0, 0, 0, 1),
	(64, NULL, 0, 0, 0, 2),
	(65, NULL, 0, 0, 1, 3),
	(66, NULL, 0, 0, 0, 4),
	(67, NULL, 0, 0, 1, 6),
	(68, NULL, 0, 0, 1, 7),
	(76, NULL, 0, 0, 0, 7),
	(110, NULL, 0, 0, 0, 1),
	(111, NULL, 0, 0, 0, 2),
	(112, NULL, 0, 0, 1, 3),
	(113, NULL, 0, 0, 1, 4),
	(114, NULL, 0, 0, 1, 6),
	(115, NULL, 0, 0, 0, 7),
	(116, NULL, 0, 0, 0, 8),
	(117, NULL, 0, 0, 1, 9),
	(118, NULL, 0, 0, 0, 10);
/*!40000 ALTER TABLE `privileges` ENABLE KEYS */;


-- Dumping structure for table emr-portal.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `facility_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_role_facility_7` (`facility_id`),
  CONSTRAINT `fk_role_facility_7` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.role: ~8 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `facility_id`) VALUES
	(1, 'SADMIN', -1),
	(2, 'NURSE', -1),
	(3, 'FRONT_DESK', -1),
	(5, 'FADMIN', 2),
	(6, 'RN', 2),
	(7, 'Doctor', 2),
	(10, 'Ward-Boy', 2),
	(11, 'Warden', 2);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Dumping structure for table emr-portal.role_privileges
CREATE TABLE IF NOT EXISTS `role_privileges` (
  `role_id` bigint(20) NOT NULL,
  `privileges_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`privileges_id`),
  KEY `fk_role_privileges_privileges_02` (`privileges_id`),
  CONSTRAINT `fk_role_privileges_privileges_02` FOREIGN KEY (`privileges_id`) REFERENCES `privileges` (`id`),
  CONSTRAINT `fk_role_privileges_role_01` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.role_privileges: ~26 rows (approximately)
/*!40000 ALTER TABLE `role_privileges` DISABLE KEYS */;
INSERT INTO `role_privileges` (`role_id`, `privileges_id`) VALUES
	(2, 41),
	(2, 42),
	(2, 43),
	(2, 44),
	(2, 45),
	(1, 46),
	(1, 47),
	(1, 48),
	(1, 49),
	(1, 50),
	(6, 63),
	(6, 64),
	(6, 65),
	(6, 66),
	(6, 67),
	(6, 68),
	(1, 76),
	(5, 110),
	(5, 111),
	(5, 112),
	(5, 113),
	(5, 114),
	(5, 115),
	(5, 116),
	(5, 117),
	(5, 118);
/*!40000 ALTER TABLE `role_privileges` ENABLE KEYS */;


-- Dumping structure for table emr-portal.task
CREATE TABLE IF NOT EXISTS `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `priority` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stat_task` tinyint(1) DEFAULT '0',
  `dept` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `to_task` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cc_task` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `task_list` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `task_subject` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `fu_date` datetime DEFAULT NULL,
  `exp_date` datetime DEFAULT NULL,
  `completion_date` datetime DEFAULT NULL,
  `by_task` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comments_task` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.task: ~0 rows (approximately)
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;


-- Dumping structure for table emr-portal.user_profile
CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contact_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `profession_qualification` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_admin_allowed` tinyint(1) DEFAULT '0',
  `facility_id` bigint(20) DEFAULT NULL,
  `auth_user_id` bigint(20) DEFAULT NULL,
  `user_type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_user_profile_facility_8` (`facility_id`),
  KEY `ix_user_profile_authUser_9` (`auth_user_id`),
  CONSTRAINT `fk_user_profile_authUser_9` FOREIGN KEY (`auth_user_id`) REFERENCES `auth_user` (`id`),
  CONSTRAINT `fk_user_profile_facility_8` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Dumping data for table emr-portal.user_profile: ~9 rows (approximately)
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`, `first_name`, `middle_name`, `last_name`, `gender`, `date_of_birth`, `email`, `contact_number`, `address`, `city`, `state`, `postal_code`, `country`, `profession_qualification`, `is_admin_allowed`, `facility_id`, `auth_user_id`, `user_type`) VALUES
	(3, 'Pankaj', 'A', 'Muneshwar', 'MALE', '2014-07-29 05:30:00', 'pankajashokmuneshwar@gmail.com', '23423421', 'dsdad', 'dasdasd', 'sdsad', 'd4', 'United Kingdom', 'DE', 0, -1, 2, 6),
	(4, 'Nagesh', 'S', 'Dalave', 'MALE', '2014-07-14 05:30:00', 'nageshdalave@gmail.com', '42234234', 'grease', 'safsadf', 'saf', '34242442', 'United Kingdom', 'fdf', 0, -1, NULL, 7),
	(5, 'Ahmed', NULL, 'Tutake', 'MALE', '2014-08-07 05:30:00', 'ahemad.tutake@gmail.com', '4545454', 'Pune', 'Pune', 'MH', '565656', 'India', 'BR', 0, -1, NULL, 6),
	(6, 'Shashank', NULL, 'Pohare', 'MALE', '2014-07-28 05:30:00', 'shwashank112@gmail.com', '43545435', 'dfds', 'dfsdfd', 'mhm', '4643664343', 'United Kingdom', 'DE', 0, -1, NULL, 7),
	(7, 'Sanghpal', NULL, 'Ahankare', 'MALE', '2014-07-29 05:30:00', 'sanghapal.ahankare@gmail.com', '323232', 'sda', 'desr', 'MH', '676575', 'United States', 'BF', 0, -1, 3, 6),
	(8, 'Shshank', NULL, 'Pohare', 'MALE', '2014-07-23 05:30:00', 'shwashank12@gmail.com', '232323', 'Pindda', 'Pune', 'MH', '123123', 'India', 'BE', 0, 2, 6, 7),
	(10, 'Pankaj', 'A', 'Muneshwar', 'MALE', '2014-07-29 05:30:00', 'dhiraj10.1988@gmail.com', '3423434', 'Delhi', 'Pune', 'MH', '3532523542', 'India', 'BE', 0, 2, 8, 7),
	(11, 'Dhiraj', 'A', 'Bankar', 'MALE', '2014-07-29 05:30:00', 'dhiraj101.9888@gmail.com', '2421412', 'dfsadf', 'pune', 'mh', '42342', 'United States', 'de', 0, 2, 9, 6),
	(12, 'Jagbir', 'Paul', 'Singh', 'MALE', '2014-06-30 05:30:00', 'jagbir.paul@gmail.com', '1232435435', 'Pune', 'Pune', 'MH', '121121', 'United Kingdom', 'BE', 0, 2, 10, 7);
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
