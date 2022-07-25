DROP TABLE IF EXISTS `state`;
create table `state` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `posX` int(10) unsigned,
  `posY` int(10) unsigned,
  `posZ` int(10) unsigned,
  `serverTimestamp` datetime    DEFAULT NULL,
  `session` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `player`;
create table `player` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `playerFrags` varchar(50) DEFAULT NULL,
  `isAdmin` int ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `session`;
create table `session` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `timeStart` datetime    DEFAULT NULL,
  `timeEnded` datetime    DEFAULT NULL,
  `player` int(10) unsigned NOT NULL,
  `server` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `server`;
create table `server` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;