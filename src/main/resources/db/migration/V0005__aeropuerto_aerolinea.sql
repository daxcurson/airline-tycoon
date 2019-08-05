CREATE TABLE `aerolinea`.`aeropuerto_aerolinea` (
`id` INT NOT NULL AUTO_INCREMENT , 
`aeropuerto_id` INT NOT NULL , 
`aerolinea_id` INT NOT NULL , 
PRIMARY KEY (`id`)
) ENGINE = InnoDB;