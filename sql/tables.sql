
CREATE TABLE `contacts` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `surname` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `numeroTel` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `emails` (
  `email` varchar(25) DEFAULT NULL,
  `id` bigint unsigned NOT NULL,
  PRIMARY KEY (`email`)
  CONSTRAINT perEmail_contatto_esistente FOREIGN KEY (id) REFERENCES contacts(id) ON UPDRATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `phones` (
  `Phonumber` varchar(25) DEFAULT NULL,
  `id` bigint unsigned NOT NULL,
  PRIMARY KEY (`Phonumber`)
  CONSTRAINT perNumero_contatto_esistente FOREIGN KEY (id) REFERENCES contacts(id) ON UPDATE CASCADE ON DELETE CASCADE
);