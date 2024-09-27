CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(68) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com',
	 '{bcrypt}$2a$12$dOoq0naRAh5y8viFzzcb2e4Xj3irtPBZgSYd6J5ic1UyJ4TYAmS02'),
	(2,'Emma','Baumgarten','emma@luv2code.com',
        '{bcrypt}$2a$12$dOoq0naRAh5y8viFzzcb2e4Xj3irtPBZgSYd6J5ic1UyJ4TYAmS02'),
	(3,'Avani','Gupta','avani@luv2code.com',
     '{bcrypt}$2a$12$dOoq0naRAh5y8viFzzcb2e4Xj3irtPBZgSYd6J5ic1UyJ4TYAmS02'),
	(4,'Yuri','Petrov','yuri@luv2code.com',
     '{bcrypt}$2a$12$dOoq0naRAh5y8viFzzcb2e4Xj3irtPBZgSYd6J5ic1UyJ4TYAmS02'),
	(5,'Juan','Vega','juan@luv2code.com',
	 '{bcrypt}$2a$12$dOoq0naRAh5y8viFzzcb2e4Xj3irtPBZgSYd6J5ic1UyJ4TYAmS02');


DROP TABLE IF EXISTS `roles`;


--
-- Table structure for table `authorities`
--

CREATE TABLE `roles` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(50) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles` (name)
VALUES
    ('ROLE_EMPLOYEE'),
    ('ROLE_MANAGER'),
    ('ROLE_ADMIN');

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
                               `user_id` int NOT NULL,
                               `role_id` int NOT NULL,

                               PRIMARY KEY (`user_id`,`role_id`),

                               KEY `FK_ROLE_idx` (`role_id`),

                               CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`)
                                   REFERENCES `employee` (`id`)
                                   ON DELETE NO ACTION ON UPDATE NO ACTION,

                               CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`)
                                   REFERENCES `roles` (`id`)
                                   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (user_id,role_id)
VALUES
    (1, 1),
    (4, 1),
    (5, 1),
    (2, 1),
    (2, 2),
    (3, 1),
    (3, 2),
    (3, 3)