CREATE TABLE `hangar` 
( 
`id` INT NOT NULL AUTO_INCREMENT , 
`nombre` VARCHAR(200) NOT NULL , 
`aeropuerto_id` INT NOT NULL , 
PRIMARY KEY (`id`)
) ENGINE = InnoDB;
CREATE TABLE `puerta` 
( 
`id` INT NOT NULL AUTO_INCREMENT , 
`nombre` VARCHAR(50) NOT NULL , 
`aeropuerto_id` INT NOT NULL , 
PRIMARY KEY (`id`)
) ENGINE = InnoDB;
CREATE TABLE `pista` 
(
`id` INT NOT NULL AUTO_INCREMENT , 
`nombre` VARCHAR(50) NOT NULL , 
`aeropuerto_id` INT NOT NULL , 
PRIMARY KEY (`id`)
) ENGINE = InnoDB;
