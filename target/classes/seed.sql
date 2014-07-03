
-- Dumping structure for table emr-portal.auth_user
CREATE TABLE IF NOT EXISTS `auth_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.auth_user: ~1 rows (approximately)
/*!40000 ALTER TABLE `auth_user` DISABLE KEYS */;
INSERT INTO `auth_user` (`id`, `password`, `username`) VALUES
	(1, 'sa', 'sa');
/*!40000 ALTER TABLE `auth_user` ENABLE KEYS */;


-- Dumping structure for table emr-portal.auth_user_role
CREATE TABLE IF NOT EXISTS `auth_user_role` (
  `auth_user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`auth_user_id`,`role_id`),
  KEY `fk_auth_user_role_role_02` (`role_id`),
  CONSTRAINT `fk_auth_user_role_role_02` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_auth_user_role_auth_user_01` FOREIGN KEY (`auth_user_id`) REFERENCES `auth_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.auth_user_role: ~1 rows (approximately)
/*!40000 ALTER TABLE `auth_user_role` DISABLE KEYS */;
INSERT INTO `auth_user_role` (`auth_user_id`, `role_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `auth_user_role` ENABLE KEYS */;


-- Dumping structure for table emr-portal.facility
CREATE TABLE IF NOT EXISTS `facility` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.facility: ~1 rows (approximately)
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` (`id`) VALUES
	(-1);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;


-- Dumping structure for table emr-portal.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_menu_permission_1` (`permission_id`),
  CONSTRAINT `fk_menu_permission_1` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.menu: ~6 rows (approximately)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `pid`, `permission_id`) VALUES
	(2, NULL, 1),
	(3, NULL, 3),
	(4, NULL, 2),
	(5, NULL, 4),
	(6, NULL, 5),
	(7, 6, 6);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


-- Dumping structure for table emr-portal.permission
CREATE TABLE IF NOT EXISTS `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.permission: ~6 rows (approximately)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`id`, `name`, `display_name`, `url`) VALUES
	(1, 'doctorLayout', 'Manage Doctor', '/doctorLayout'),
	(2, 'userLayout', 'Manage User', '/userLayout'),
	(3, 'facilityLayout', 'Manage Facility', '/facilityLayout'),
	(4, 'homeLayout', 'Home', '/homeLayout'),
	(5, 'manage', 'Manage', NULL),
	(6, 'clinicLayout', 'Manage Clinic', '/clinicLayout');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;


-- Dumping structure for table emr-portal.privileges
CREATE TABLE IF NOT EXISTS `privileges` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `is_read` tinyint(1) DEFAULT '0',
  `is_write` tinyint(1) DEFAULT '0',
  `is_denied` tinyint(1) DEFAULT '0',
  `permision_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_privileges_permision_3` (`permision_id`),
  CONSTRAINT `fk_privileges_permision_3` FOREIGN KEY (`permision_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.privileges: ~3 rows (approximately)
/*!40000 ALTER TABLE `privileges` DISABLE KEYS */;
INSERT INTO `privileges` (`id`, `name`, `is_read`, `is_write`, `is_denied`, `permision_id`) VALUES
	(1, NULL, 1, 1, 0, 1),
	(2, NULL, 1, 1, 0, 3),
	(3, NULL, 1, 1, 0, 2);
/*!40000 ALTER TABLE `privileges` ENABLE KEYS */;


-- Dumping structure for table emr-portal.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `facility_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_role_facility_4` (`facility_id`),
  CONSTRAINT `fk_role_facility_4` FOREIGN KEY (`facility_id`) REFERENCES `facility` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.role: ~1 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `facility_id`) VALUES
	(1, 'ROLE_ADMIN', -1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Dumping structure for table emr-portal.role_privileges
CREATE TABLE IF NOT EXISTS `role_privileges` (
  `role_id` bigint(20) NOT NULL,
  `privileges_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`privileges_id`),
  KEY `fk_role_privileges_privileges_02` (`privileges_id`),
  CONSTRAINT `fk_role_privileges_privileges_02` FOREIGN KEY (`privileges_id`) REFERENCES `privileges` (`id`),
  CONSTRAINT `fk_role_privileges_role_01` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emr-portal.role_privileges: ~3 rows (approximately)
/*!40000 ALTER TABLE `role_privileges` DISABLE KEYS */;
INSERT INTO `role_privileges` (`role_id`, `privileges_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3);
/*!40000 ALTER TABLE `role_privileges` ENABLE KEYS */;



