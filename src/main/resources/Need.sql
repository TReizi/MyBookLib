CREATE USER 'bestuser'@'localhost' IDENTIFIED BY 'bestuser';

GRANT ALL PRIVILEGES ON *.* TO 'bestuser'@'localhost';


CREATE DATABASE my_db;
USE my_db;



CREATE TABLE books
(
    id     int NOT NULL AUTO_INCREMENT,
    name   varchar(15),
    author varchar(25),
    status varchar(25),
    PRIMARY KEY (id)
);

CREATE TABLE readers
(
    id   int NOT NULL AUTO_INCREMENT,
    name varchar(15),
    PRIMARY KEY (id)
);

CREATE TABLE addiction
(
    id     int NOT NULL AUTO_INCREMENT,
    idBook   varchar(15),
    idReader varchar(25),
    PRIMARY KEY (id)
);
#
# TABLE STRUCTURE FOR: addiction
#

DROP TABLE IF EXISTS `addiction`;

CREATE TABLE `addiction` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `idBook` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `idReader` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# TABLE STRUCTURE FOR: books
#

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `author` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `status` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (1, 'Abernathy Islan', 'Verda', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (2, 'Adan Square', 'Gisselle', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (3, 'Hershel Grove', 'Deja', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (4, 'Rosalia Overpas', 'Monica', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (5, 'Beier Trafficwa', 'Aileen', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (6, 'McGlynn Port', 'Era', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (7, 'Roob Brook', 'Edyth', 'Можно взять ');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (8, 'Nienow Crossroa', 'Susanna', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (9, 'Abernathy Mews', 'Estella', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (10, 'Eleanora Mill', 'Adelle', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (11, 'Reyna Ramp', 'Eleanore', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (12, 'Haleigh Fork', 'Natalia', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (13, 'Eliseo Crescent', 'Gudrun', 'Можно взять ');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (14, 'Madaline Corner', 'Georgette', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (15, 'Liza Knolls', 'Susanna', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (16, 'Crona Crossing', 'Adelle', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (17, 'DuBuque Burg', 'Libby', 'Можно взять ');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (18, 'Wendell Pike', 'Reta', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (19, 'Kozey Terrace', 'Aletha', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (20, 'Shields Plain', 'Rosina', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (21, 'Carolanne Lakes', 'Jodie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (22, 'Lesch Street', 'Thora', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (23, 'Angela Crossing', 'Karolann', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (24, 'Mavis River', 'Stefanie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (25, 'Gibson Canyon', 'Abbie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (26, 'Hiram Roads', 'Annetta', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (27, 'Jeremy Locks', 'Lenna', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (28, 'Lonnie Corners', 'Amelie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (29, 'King Ports', 'Zelda', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (30, 'Dan Mill', 'Allene', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (31, 'Kiarra Summit', 'Penelope', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (32, 'Miracle Light', 'Rosanna', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (33, 'Ernser Drive', 'Karolann', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (34, 'Weissnat River', 'Alice', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (35, 'Zula Port', 'Eloisa', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (36, 'Viva Hollow', 'Michele', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (37, 'Wisozk Forge', 'Aryanna', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (38, 'Nedra Mills', 'Ova', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (39, 'Farrell Road', 'Aletha', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (40, 'Hackett Corner', 'Aida', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (41, 'Fadel Cliff', 'Carlotta', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (42, 'Gutkowski Avenu', 'Billie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (43, 'Lauretta Villag', 'Alysha', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (44, 'Raynor Cliffs', 'Zora', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (45, 'Quitzon Union', 'Kaia', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (46, 'Omari Ports', 'Effie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (47, 'Perry Street', 'Kailyn', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (48, 'Hermiston Islan', 'Margret', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (49, 'Koss Mission', 'Shanna', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (50, 'Martine Curve', 'Emelia', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (51, 'Daugherty Fores', 'Ena', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (52, 'Stroman Straven', 'Ethyl', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (53, 'Kathryne Mounta', 'Shaniya', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (54, 'Ziemann Course', 'Bella', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (55, 'Borer Mills', 'Lizeth', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (56, 'Will Key', 'Fay', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (57, 'Annamarie Gatew', 'Casandra', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (58, 'Mosciski Viaduc', 'Caroline', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (59, 'Janice Garden', 'Meggie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (60, 'Wolf Road', 'Glenda', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (61, 'Brown Ways', 'Ona', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (62, 'Jefferey Isle', 'Nina', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (63, 'Keeling Pike', 'Odie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (64, 'Thompson Mount', 'Marjorie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (65, 'Wilhelm Island', 'Madge', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (66, 'Roberta Burg', 'Rhianna', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (67, 'Harber Causeway', 'Heidi', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (68, 'Danial Trafficw', 'Malika', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (69, 'Blick Court', 'Olga', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (70, 'Satterfield Mis', 'Emily', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (71, 'Sadie Plain', 'Cara', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (72, 'Emie Springs', 'Corene', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (73, 'Korbin Dam', 'Kaylin', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (74, 'Kenya Knolls', 'Zella', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (75, 'Ondricka Plaza', 'Winifred', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (76, 'Herman Cliffs', 'Tracy', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (77, 'Boyd Pines', 'Breanna', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (78, 'McGlynn Island', 'Greta', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (79, 'Mills Island', 'Erica', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (80, 'Bauch Track', 'Tressa', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (81, 'Maggio Gardens', 'Rosalia', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (82, 'Vergie Loaf', 'Simone', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (83, 'Larkin Park', 'Greta', 'Можно взять ');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (84, 'Wellington Isla', 'Kathryne', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (85, 'Deckow Motorway', 'Danika', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (86, 'Lindgren Trail', 'Phyllis', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (87, 'Leannon Rapid', 'Lucy', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (88, 'Gorczany Hollow', 'Ellie', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (89, 'Hailie Villages', 'Beverly', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (90, 'Donnelly Shores', 'Lacy', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (91, 'Gerhold Forks', 'Marlene', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (92, 'Gertrude Forges', 'Creola', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (93, 'Muller Shores', 'Leta', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (94, 'Lolita Tunnel', 'Lesly', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (95, 'Athena Cliffs', 'Minerva', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (96, 'Armstrong Corne', 'Libbie', 'Можно взять ');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (97, 'Nikolas Prairie', 'Jermaine', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (98, 'Schuppe Parkway', 'Irma', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (99, 'Friesen Roads', 'Betty', 'Можно взять');
INSERT INTO `books` (`id`, `name`, `author`, `status`) VALUES (100, 'Jillian Center', 'Eliane', 'Можно взять);

#
# TABLE STRUCTURE FOR: readers
#

DROP TABLE IF EXISTS `readers`;

CREATE TABLE `readers` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `readers` (`id`, `name`) VALUES (1, 'Kreiger');
INSERT INTO `readers` (`id`, `name`) VALUES (2, 'Reichel');
INSERT INTO `readers` (`id`, `name`) VALUES (3, 'Bergstrom');
INSERT INTO `readers` (`id`, `name`) VALUES (4, 'Feest');
INSERT INTO `readers` (`id`, `name`) VALUES (5, 'Beer');
INSERT INTO `readers` (`id`, `name`) VALUES (6, 'Breitenberg');
INSERT INTO `readers` (`id`, `name`) VALUES (7, 'Wisozk');
INSERT INTO `readers` (`id`, `name`) VALUES (8, 'Thompson');
INSERT INTO `readers` (`id`, `name`) VALUES (9, 'Boyer');
INSERT INTO `readers` (`id`, `name`) VALUES (10, 'Hyatt');
INSERT INTO `readers` (`id`, `name`) VALUES (11, 'Johnson');
INSERT INTO `readers` (`id`, `name`) VALUES (12, 'Gusikowski');
INSERT INTO `readers` (`id`, `name`) VALUES (13, 'Schultz');
INSERT INTO `readers` (`id`, `name`) VALUES (14, 'Graham');
INSERT INTO `readers` (`id`, `name`) VALUES (15, 'Windler');
INSERT INTO `readers` (`id`, `name`) VALUES (16, 'Mraz');
INSERT INTO `readers` (`id`, `name`) VALUES (17, 'Gusikowski');
INSERT INTO `readers` (`id`, `name`) VALUES (18, 'Keebler');
INSERT INTO `readers` (`id`, `name`) VALUES (19, 'Casper');
INSERT INTO `readers` (`id`, `name`) VALUES (20, 'Schultz');
INSERT INTO `readers` (`id`, `name`) VALUES (21, 'Braun');
INSERT INTO `readers` (`id`, `name`) VALUES (22, 'Metz');
INSERT INTO `readers` (`id`, `name`) VALUES (23, 'Blanda');
INSERT INTO `readers` (`id`, `name`) VALUES (24, 'Jerde');
INSERT INTO `readers` (`id`, `name`) VALUES (25, 'Runolfsson');
INSERT INTO `readers` (`id`, `name`) VALUES (26, 'Terry');
INSERT INTO `readers` (`id`, `name`) VALUES (27, 'Dibbert');
INSERT INTO `readers` (`id`, `name`) VALUES (28, 'Kutch');
INSERT INTO `readers` (`id`, `name`) VALUES (29, 'Torp');
INSERT INTO `readers` (`id`, `name`) VALUES (30, 'Deckow');
INSERT INTO `readers` (`id`, `name`) VALUES (31, 'Zemlak');
INSERT INTO `readers` (`id`, `name`) VALUES (32, 'Trantow');
INSERT INTO `readers` (`id`, `name`) VALUES (33, 'Robel');
INSERT INTO `readers` (`id`, `name`) VALUES (34, 'O\'Keefe');
INSERT INTO `readers` (`id`, `name`) VALUES (35, 'Erdman');
INSERT INTO `readers` (`id`, `name`) VALUES (36, 'Schaefer');
INSERT INTO `readers` (`id`, `name`) VALUES (37, 'Cassin');
INSERT INTO `readers` (`id`, `name`) VALUES (38, 'Simonis');
INSERT INTO `readers` (`id`, `name`) VALUES (39, 'White');
INSERT INTO `readers` (`id`, `name`) VALUES (40, 'Becker');
INSERT INTO `readers` (`id`, `name`) VALUES (41, 'Schaefer');
INSERT INTO `readers` (`id`, `name`) VALUES (42, 'Murphy');
INSERT INTO `readers` (`id`, `name`) VALUES (43, 'Kuhic');
INSERT INTO `readers` (`id`, `name`) VALUES (44, 'Larkin');
INSERT INTO `readers` (`id`, `name`) VALUES (45, 'Wehner');
INSERT INTO `readers` (`id`, `name`) VALUES (46, 'Howe');
INSERT INTO `readers` (`id`, `name`) VALUES (47, 'Hermann');
INSERT INTO `readers` (`id`, `name`) VALUES (48, 'Schiller');
INSERT INTO `readers` (`id`, `name`) VALUES (49, 'Turner');
INSERT INTO `readers` (`id`, `name`) VALUES (50, 'Gutmann');
INSERT INTO `readers` (`id`, `name`) VALUES (51, 'Graham');
INSERT INTO `readers` (`id`, `name`) VALUES (52, 'Yundt');
INSERT INTO `readers` (`id`, `name`) VALUES (53, 'Pouros');
INSERT INTO `readers` (`id`, `name`) VALUES (54, 'Collins');
INSERT INTO `readers` (`id`, `name`) VALUES (55, 'Schimmel');
INSERT INTO `readers` (`id`, `name`) VALUES (56, 'Lehner');
INSERT INTO `readers` (`id`, `name`) VALUES (57, 'Powlowski');
INSERT INTO `readers` (`id`, `name`) VALUES (58, 'Rath');
INSERT INTO `readers` (`id`, `name`) VALUES (59, 'Windler');
INSERT INTO `readers` (`id`, `name`) VALUES (60, 'Beer');
INSERT INTO `readers` (`id`, `name`) VALUES (61, 'Murphy');
INSERT INTO `readers` (`id`, `name`) VALUES (62, 'Waelchi');
INSERT INTO `readers` (`id`, `name`) VALUES (63, 'Balistreri');
INSERT INTO `readers` (`id`, `name`) VALUES (64, 'Goyette');
INSERT INTO `readers` (`id`, `name`) VALUES (65, 'Torp');
INSERT INTO `readers` (`id`, `name`) VALUES (66, 'Bergnaum');
INSERT INTO `readers` (`id`, `name`) VALUES (67, 'Predovic');
INSERT INTO `readers` (`id`, `name`) VALUES (68, 'Turner');
INSERT INTO `readers` (`id`, `name`) VALUES (69, 'Schmitt');
INSERT INTO `readers` (`id`, `name`) VALUES (70, 'Waters');
INSERT INTO `readers` (`id`, `name`) VALUES (71, 'McGlynn');
INSERT INTO `readers` (`id`, `name`) VALUES (72, 'Hessel');
INSERT INTO `readers` (`id`, `name`) VALUES (73, 'Gutmann');
INSERT INTO `readers` (`id`, `name`) VALUES (74, 'Abernathy');
INSERT INTO `readers` (`id`, `name`) VALUES (75, 'Harris');
INSERT INTO `readers` (`id`, `name`) VALUES (76, 'Fahey');
INSERT INTO `readers` (`id`, `name`) VALUES (77, 'Leffler');
INSERT INTO `readers` (`id`, `name`) VALUES (78, 'Stroman');
INSERT INTO `readers` (`id`, `name`) VALUES (79, 'Gleichner');
INSERT INTO `readers` (`id`, `name`) VALUES (80, 'Barrows');
INSERT INTO `readers` (`id`, `name`) VALUES (81, 'Lehner');
INSERT INTO `readers` (`id`, `name`) VALUES (82, 'West');
INSERT INTO `readers` (`id`, `name`) VALUES (83, 'Williamson');
INSERT INTO `readers` (`id`, `name`) VALUES (84, 'Schuppe');
INSERT INTO `readers` (`id`, `name`) VALUES (85, 'DuBuque');
INSERT INTO `readers` (`id`, `name`) VALUES (86, 'Stark');
INSERT INTO `readers` (`id`, `name`) VALUES (87, 'Barrows');
INSERT INTO `readers` (`id`, `name`) VALUES (88, 'Turcotte');
INSERT INTO `readers` (`id`, `name`) VALUES (89, 'Fay');
INSERT INTO `readers` (`id`, `name`) VALUES (90, 'Tillman');
INSERT INTO `readers` (`id`, `name`) VALUES (91, 'Hamill');
INSERT INTO `readers` (`id`, `name`) VALUES (92, 'Baumbach');
INSERT INTO `readers` (`id`, `name`) VALUES (93, 'Botsford');
INSERT INTO `readers` (`id`, `name`) VALUES (94, 'Cremin');
INSERT INTO `readers` (`id`, `name`) VALUES (95, 'Fahey');
INSERT INTO `readers` (`id`, `name`) VALUES (96, 'Kiehn');
INSERT INTO `readers` (`id`, `name`) VALUES (97, 'Friesen');
INSERT INTO `readers` (`id`, `name`) VALUES (98, 'Wiegand');
INSERT INTO `readers` (`id`, `name`) VALUES (99, 'Zemlak');
INSERT INTO `readers` (`id`, `name`) VALUES (100, 'Bergstrom');




