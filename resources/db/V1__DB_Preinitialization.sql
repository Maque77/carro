-- Body Types
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('Sedan');
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('Hatchback');
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('Wagon');
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('Coupe');
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('MUV/SUV');
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('Convertible');
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('Van');
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('Jeep');
INSERT INTO `ilcarro_business_common`.`body_types` (`body_type`) VALUES ('Pickup');


-- Transmission Types
INSERT INTO `ilcarro_business_common`.`transmissions` (`transmission_type`) VALUES ('Automatic');
INSERT INTO `ilcarro_business_common`.`transmissions` (`transmission_type`) VALUES ('Manual');

-- Fuel Types
INSERT INTO `ilcarro_business_common`.`fuel_types` (`fuel_type`) VALUES ('Gasoline');
INSERT INTO `ilcarro_business_common`.`fuel_types` (`fuel_type`) VALUES ('Diesel');
INSERT INTO `ilcarro_business_common`.`fuel_types` (`fuel_type`) VALUES ('Bio-Diesel');
INSERT INTO `ilcarro_business_common`.`fuel_types` (`fuel_type`) VALUES ('Hybrid');
INSERT INTO `ilcarro_business_common`.`fuel_types` (`fuel_type`) VALUES ('Electric vehicle');
INSERT INTO `ilcarro_business_common`.`fuel_types` (`fuel_type`) VALUES ('Compressed Natural Gas');

-- Wheel Drive Types
INSERT INTO `ilcarro_business_common`.`wheel_drive_types` (`wheel_drive_type`) VALUES ('All-wheel drive');
INSERT INTO `ilcarro_business_common`.`wheel_drive_types` (`wheel_drive_type`) VALUES ('Front-wheel drive');
INSERT INTO `ilcarro_business_common`.`wheel_drive_types` (`wheel_drive_type`) VALUES ('Rear-wheel drive');

-- User
INSERT INTO `ilcarro_business_common`.`users` (`email`, `birthDate`, `firstNameUser`, `lastNameUser`, `phoneNumber`) VALUES ('john@mail.com', '2000-01-01', 'John', 'Doe', '050055005');
