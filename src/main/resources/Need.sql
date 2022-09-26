--CREATE USER 'bestuser'@'localhost' IDENTIFIED BY 'bestuser';

--GRANT ALL PRIVILEGES ON *.* TO 'bestuser'@'localhost';

USE my_db;


CREATE TABLE addiction(
                             id int(11) NOT NULL AUTO_INCREMENT,
                             idBook varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             idReader varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             PRIMARY KEY (`id`)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE books(
                         id int(11) NOT NULL AUTO_INCREMENT,
                         name varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         author varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         status varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         PRIMARY KEY (`id`)
 )ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


insert into books (id, name, author, status) values (1, 'Abernathy Islan', 'Verda', 'Можно взять');
insert into books (id, name, author, status) values (2, 'Adan Square', 'Gisselle', 'Можно взять');
insert into books (id, name, author, status) values (3, 'Hershel Grove', 'Deja', 'Можно взять');
insert into books (id, name, author, status)values (4, 'Rosalia Overpas', 'Monica', 'Можно взять');
insert into books (id, name, author, status) values (5, 'Beier Trafficwa', 'Aileen', 'Можно взять');
insert into books (id, name, author, status) values (6, 'McGlynn Port', 'Era', 'Можно взять');
insert into books (id, name, author, status) values (7, 'Roob Brook', 'Edyth', 'Можно взять ');
insert into books (id, name, author, status)values (8, 'Nienow Crossroa', 'Susanna', 'Можно взять');
insert into books (id, name, author, status) values (9, 'Abernathy Mews', 'Estella', 'Можно взять');
insert into books (id, name, author, status) values (10, 'Eleanora Mill', 'Adelle', 'Можно взять');
insert into books (id, name, author, status) values (11, 'Reyna Ramp', 'Eleanore', 'Можно взять');
insert into books (id, name, author, status) values (12, 'Haleigh Fork', 'Natalia', 'Можно взять');
insert into books (id, name, author, status) values (13, 'Eliseo Crescent', 'Gudrun', 'Можно взять ');
insert into books (id, name, author, status) values (14, 'Madaline Corner', 'Georgette', 'Можно взять');
insert into books (id, name, author, status) values (15, 'Liza Knolls', 'Susanna', 'Можно взять');
insert into books (id, name, author, status) values (16, 'Crona Crossing', 'Adelle', 'Можно взять');
insert into books (id, name, author, status)values (17, 'DuBuque Burg', 'Libby', 'Можно взять ');
insert into books (id, name, author, status) values (18, 'Wendell Pike', 'Reta', 'Можно взять');
insert into books (id, name, author, status) values (19, 'Kozey Terrace', 'Aletha', 'Можно взять');
insert into books (id, name, author, status) values (20, 'Shields Plain', 'Rosina', 'Можно взять');
insert into books (id, name, author, status)values (21, 'Carolanne Lakes', 'Jodie', 'Можно взять');
insert into books (id, name, author, status) values (22, 'Lesch Street', 'Thora', 'Можно взять');
insert into books (id, name, author, status) values (23, 'Angela Crossing', 'Karolann', 'Можно взять');
insert into books (id, name, author, status) values (24, 'Mavis River', 'Stefanie', 'Можно взять');
insert into books (id, name, author, status) values (25, 'Gibson Canyon', 'Abbie', 'Можно взять');
insert into books (id, name, author, status) values (26, 'Hiram Roads', 'Annetta', 'Можно взять');
insert into books (id, name, author, status) values (27, 'Jeremy Locks', 'Lenna', 'Можно взять');
insert into books (id, name, author, status) values (28, 'Lonnie Corners', 'Amelie', 'Можно взять');
insert into books (id, name, author, status)values (29, 'King Ports', 'Zelda', 'Можно взять');
insert into books (id, name, author, status) values (30, 'Dan Mill', 'Allene', 'Можно взять');
insert into books (id, name, author, status) values (31, 'Kiarra Summit', 'Penelope', 'Можно взять');
insert into books (id, name, author, status) values (32, 'Miracle Light', 'Rosanna', 'Можно взять');
insert into books (id, name, author, status) values (33, 'Ernser Drive', 'Karolann', 'Можно взять');
insert into books (id, name, author, status) values (34, 'Weissnat River', 'Alice', 'Можно взять');
insert into books (id, name, author, status) values (35, 'Zula Port', 'Eloisa', 'Можно взять');
insert into books (id, name, author, status) values (36, 'Viva Hollow', 'Michele', 'Можно взять');
insert into books (id, name, author, status) values (37, 'Wisozk Forge', 'Aryanna', 'Можно взять');
insert into books (id, name, author, status) values (38, 'Nedra Mills', 'Ova', 'Можно взять');
insert into books (id, name, author, status) values (39, 'Farrell Road', 'Aletha', 'Можно взять');
insert into books (id, name, author, status) values (40, 'Hackett Corner', 'Aida', 'Можно взять');
insert into books (id, name, author, status) values (41, 'Fadel Cliff', 'Carlotta', 'Можно взять');
insert into books (id, name, author, status) values (42, 'Gutkowski Avenu', 'Billie', 'Можно взять');
insert into books (id, name, author, status) values (43, 'Lauretta Villag', 'Alysha', 'Можно взять');
insert into books (id, name, author, status) values (44, 'Raynor Cliffs', 'Zora', 'Можно взять');
insert into books (id, name, author, status) values (45, 'Quitzon Union', 'Kaia', 'Можно взять');
insert into books (id, name, author, status) values (46, 'Omari Ports', 'Effie', 'Можно взять');
insert into books (id, name, author, status) values (47, 'Perry Street', 'Kailyn', 'Можно взять');
insert into books (id, name, author, status) values (48, 'Hermiston Islan', 'Margret', 'Можно взять');
insert into books (id, name, author, status)values (49, 'Koss Mission', 'Shanna', 'Можно взять');
insert into books (id, name, author, status) values (50, 'Martine Curve', 'Emelia', 'Можно взять');
insert into books (id, name, author, status)values (51, 'Daugherty Fores', 'Ena', 'Можно взять');
insert into books (id, name, author, status) values (52, 'Stroman Straven', 'Ethyl', 'Можно взять');
insert into books (id, name, author, status) values (53, 'Kathryne Mounta', 'Shaniya', 'Можно взять');
insert into books (id, name, author, status) values (54, 'Ziemann Course', 'Bella', 'Можно взять');
insert into books (id, name, author, status) values (55, 'Borer Mills', 'Lizeth', 'Можно взять');
insert into books (id, name, author, status)values (56, 'Will Key', 'Fay', 'Можно взять');
insert into books (id, name, author, status) values (57, 'Annamarie Gatew', 'Casandra', 'Можно взять');
insert into books (id, name, author, status) values (58, 'Mosciski Viaduc', 'Caroline', 'Можно взять');
insert into books (id, name, author, status) values (59, 'Janice Garden', 'Meggie', 'Можно взять');
insert into books (id, name, author, status)values (60, 'Wolf Road', 'Glenda', 'Можно взять');
insert into books (id, name, author, status) values (61, 'Brown Ways', 'Ona', 'Можно взять');
insert into books (id, name, author, status) values (62, 'Jefferey Isle', 'Nina', 'Можно взять');
insert into books (id, name, author, status) values (63, 'Keeling Pike', 'Odie', 'Можно взять');
insert into books (id, name, author, status) values (64, 'Thompson Mount', 'Marjorie', 'Можно взять');
insert into books (id, name, author, status) values (65, 'Wilhelm Island', 'Madge', 'Можно взять');
insert into books (id, name, author, status) values (66, 'Roberta Burg', 'Rhianna', 'Можно взять');
insert into books (id, name, author, status) values (67, 'Harber Causeway', 'Heidi', 'Можно взять');
insert into books (id, name, author, status) values (68, 'Danial Trafficw', 'Malika', 'Можно взять');
insert into books (id, name, author, status) values (69, 'Blick Court', 'Olga', 'Можно взять');
insert into books (id, name, author, status) values (70, 'Satterfield Mis', 'Emily', 'Можно взять');
insert into books (id, name, author, status) values (71, 'Sadie Plain', 'Cara', 'Можно взять');
insert into books (id, name, author, status) values (72, 'Emie Springs', 'Corene', 'Можно взять');
insert into books (id, name, author, status)values (73, 'Korbin Dam', 'Kaylin', 'Можно взять');
insert into books (id, name, author, status) values (74, 'Kenya Knolls', 'Zella', 'Можно взять');
insert into books (id, name, author, status) values (75, 'Ondricka Plaza', 'Winifred', 'Можно взять');
insert into books (id, name, author, status) values (76, 'Herman Cliffs', 'Tracy', 'Можно взять');
insert into books (id, name, author, status) values (77, 'Boyd Pines', 'Breanna', 'Можно взять');
insert into books (id, name, author, status) values (78, 'McGlynn Island', 'Greta', 'Можно взять');
insert into books (id, name, author, status) values (79, 'Mills Island', 'Erica', 'Можно взять');
insert into books (id, name, author, status) values (80, 'Bauch Track', 'Tressa', 'Можно взять');
insert into books (id, name, author, status) values (81, 'Maggio Gardens', 'Rosalia', 'Можно взять');
insert into books (id, name, author, status) values (82, 'Vergie Loaf', 'Simone', 'Можно взять');
insert into books (id, name, author, status) values (83, 'Larkin Park', 'Greta', 'Можно взять ');
insert into books (id, name, author, status)values (84, 'Wellington Isla', 'Kathryne', 'Можно взять');
insert into books (id, name, author, status) values (85, 'Deckow Motorway', 'Danika', 'Можно взять');
insert into books (id, name, author, status) values (86, 'Lindgren Trail', 'Phyllis', 'Можно взять');
insert into books (id, name, author, status) values (87, 'Leannon Rapid', 'Lucy', 'Можно взять');
insert into books (id, name, author, status) values (88, 'Gorczany Hollow', 'Ellie', 'Можно взять');
insert into books (id, name, author, status) values (89, 'Hailie Villages', 'Beverly', 'Можно взять');
insert into books (id, name, author, status) values (90, 'Donnelly Shores', 'Lacy', 'Можно взять');
insert into books (id, name, author, status) values (91, 'Gerhold Forks', 'Marlene', 'Можно взять');
insert into books (id, name, author, status) values (92, 'Gertrude Forges', 'Creola', 'Можно взять');
insert into books (id, name, author, status) values (93, 'Muller Shores', 'Leta', 'Можно взять');
insert into books (id, name, author, status) values (94, 'Lolita Tunnel', 'Lesly', 'Можно взять');
insert into books (id, name, author, status)values (95, 'Athena Cliffs', 'Minerva', 'Можно взять');
insert into books (id, name, author, status) values (96, 'Armstrong Corne', 'Libbie', 'Можно взять ');
insert into books (id, name, author, status) values (97, 'Nikolas Prairie', 'Jermaine', 'Можно взять');
insert into books (id, name, author, status) values (98, 'Schuppe Parkway', 'Irma', 'Можно взять');
insert into books (id, name, author, status) values  (99, 'Friesen Roads', 'Betty', 'Можно взять');
insert into books (id, name, author, status) values (100, 'Jillian Center', 'Eliane', 'Можно взять');


CREATE TABLE readers(
                           id int(11) NOT NULL AUTO_INCREMENT,
                           name varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                           PRIMARY KEY (id)
 )ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert into readers (id, name) values (1, 'Kreiger');
insert into readers (id, name) values (2, 'Reichel');
insert into readers (id, name) values (3, 'Bergstrom');
insert into readers (id, name) values (4, 'Feest');
insert into readers (id, name) values (5, 'Beer');
insert into readers (id, name) values (6, 'Breitenberg');
insert into readers (id, name) values (7, 'Wisozk');
insert into readers (id, name) values (8, 'Thompson');
insert into readers (id, name) values (9, 'Boyer');
insert into readers (id, name) values (10, 'Hyatt');
insert into readers (id, name) values (11, 'Johnson');
insert into readers (id, name) values (12, 'Gusikowski');
insert into readers (id, name) values (13, 'Schultz');
insert into readers (id, name) values (14, 'Graham');
insert into readers (id, name) values (15, 'Windler');
insert into readers (id, name) values (16, 'Mraz');
insert into readers (id, name) values (17, 'Gusikowski');
insert into readers (id, name) values (18, 'Keebler');
insert into readers (id, name) values (19, 'Casper');
insert into readers (id, name) values (20, 'Schultz');
insert into readers (id, name) values (21, 'Braun');
insert into readers (id, name) values (22, 'Metz');
insert into readers (id, name) values (23, 'Blanda');
insert into readers (id, name) values (24, 'Jerde');
insert into readers (id, name) values (25, 'Runolfsson');
insert into readers (id, name) values (26, 'Terry');
insert into readers (id, name) values (27, 'Dibbert');
insert into readers (id, name) values (28, 'Kutch');
insert into readers (id, name) values (29, 'Torp');
insert into readers (id,name) values (30, 'Deckow');
insert into readers (id, name) values (31, 'Zemlak');
insert into readers (id, name) values (32, 'Trantow');
insert into readers (id, name) values (33, 'Robel');
insert into readers (id, name) values (34, 'Keefe');
insert into readers (id, name) values (35, 'Erdman');
insert into readers (id, name) values (36, 'Schaefer');
insert into readers (id, name) values (37, 'Cassin');
insert into readers (id, name) values (38, 'Simonis');
insert into readers (id, name) values (39, 'White');
insert into readers (id, name) values (40, 'Becker');
insert into readers (id, name) values (41, 'Schaefer');
insert into readers (id, name) values (42, 'Murphy');
insert into readers (id, name) values (43, 'Kuhic');
insert into readers (id, name) values (44, 'Larkin');
insert into readers (id, name) values (45, 'Wehner');
insert into readers (id, name) values (46, 'Howe');
insert into readers (id, name) values (47, 'Hermann');
insert into readers (id, name) values (48, 'Schiller');
insert into readers (id, name) values (49, 'Turner');
insert into readers (id, name) values (50, 'Gutmann');
insert into readers (id, name) values (51, 'Graham');
insert into readers (id, name) values (52, 'Yundt');
insert into readers (id, name) values (53, 'Pouros');
insert into readers (id, name) values (54, 'Collins');
insert into readers (id, name) values (55, 'Schimmel');
insert into readers (id, name) values (56, 'Lehner');
insert into readers (id, name) values (57, 'Powlowski');
insert into readers (id, name) values (58, 'Rath');
insert into readers (id, name) values (59, 'Windler');
insert into readers (id, name) values (60, 'Beer');
insert into readers (id, name) values (61, 'Murphy');
insert into readers (id, name) values (62, 'Waelchi');
insert into readers (id, name) values (63, 'Balistreri');
insert into readers (id, name) values (64, 'Goyette');
insert into readers (id, name) values (65, 'Torp');
insert into readers (id,name) values (66, 'Bergnaum');
insert into readers (id, name) values (67, 'Predovic');
insert into readers (id, name) values (68, 'Turner');
insert into readers(id,name) values (69, 'Schmitt');
insert into readers (id, name) values (70, 'Waters');
insert into readers (id, name) values (71, 'McGlynn');
insert into readers (id, name) values (72, 'Hessel');
insert into readers (id,name) values (73, 'Gutmann');
insert into readers (id, name) values (74, 'Abernathy');
insert into readers (id,name) values (75, 'Harris');
insert into readers (id, name) values (76, 'Fahey');
insert into readers (id, name) values (77, 'Leffler');
insert into readers (id, name) values (78, 'Stroman');
insert into readers (id, name) values (79, 'Gleichner');
insert into readers (id, name) values (80, 'Barrows');
insert into readers (id, name) values (81, 'Lehner');
insert into readers (id, name) values (82, 'West');
insert into readers (id, name) values (83, 'Williamson');
insert into readers (id, name) values (84, 'Schuppe');
insert into readers (id, name) values (85, 'DuBuque');
insert into readers (id, name) values (86, 'Stark');
insert into readers (id, name) values (87, 'Barrows');
insert into readers (id, name) values (88, 'Turcotte');
insert into readers (id, name) values (89, 'Fay');
insert into readers (id, name) values (90, 'Tillman');
insert into readers (id, name) values (91, 'Hamill');
insert into readers (id, name) values (92, 'Baumbach');
insert into readers (id, name) values (93, 'Botsford');
insert into readers (id, name) values (94, 'Cremin');
insert into readers (id, name) values (95, 'Fahey');
insert into readers (id, name) values (96, 'Kiehn');
insert into readers (id, name) values (97, 'Friesen');
insert into readers (id, name) values (98, 'Wiegand');
insert into readers (id, name) values (99, 'Zemlak');
insert into readers(id, name) values (100, 'Bergstrom');



