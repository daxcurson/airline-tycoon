CREATE TABLE `aeropuerto` 
(
`id` INT NOT NULL AUTO_INCREMENT , 
`ciudad_id` INT NOT NULL , 
`codigo` VARCHAR(20) NOT NULL , 
`nombre` VARCHAR(200) NOT NULL , 
PRIMARY KEY (`id`)
) ENGINE = InnoDB;