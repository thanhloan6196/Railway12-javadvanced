DROP DATABASE IF EXISTS student_management ;
CREATE DATABASE student_management ;
USE student_management ;

DROP TABLE IF EXISTS Clazz;
CREATE TABLE Clazz (
ID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Class_name	CHAR(5) NOT NULL,
Create_at	DATETIME DEFAULT NOW(),
Update_at	DATETIME
);

DROP TABLE IF EXISTS Student;
CREATE TABLE Student (
ID 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
First_Name 	NVARCHAR(30) NOT NULL ,
Last_Name	NVARCHAR(30) NOT NULL,
Email		VARCHAR(50) NOT NULL UNIQUE KEY,
Gender		ENUM('MALE', 'FEMALE'),
Address		NVARCHAR(50),
Clazz_ID	INT UNSIGNED NOT NULL,
Create_at	DATETIME DEFAULT NOW(),
Update_at	DATETIME,
FOREIGN KEY(Clazz_ID) REFERENCES Clazz(ID) ON DELETE CASCADE
);

-- **********************************
INSERT INTO clazz( Class_name) VALUES
('10A'),
('10B'),
('10C'),
('11A'),
('11B'),
('11C'),
('12A'),
('12B'),
('12C');

-- ********************************




insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (1, 'Tamqrah', 'Veivers', 'tveivers0@bandcamp.com', 'MALE', '710 Garrison Circle', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (2, 'Enrichetta', 'Brickham', 'ebrickham1@noaa.gov', 'MALE', '231 Sherman Street', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (3, 'Stevena', 'Stoaks', 'sstoaks2@163.com', 'FEMALE', '7272 Nancy Junction', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (4, 'Ellsworth', 'Nerval', 'enerval3@vinaora.com', 'MALE', '7 Talmadge Street', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (5, 'Cole', 'Rasor', 'crasor4@plala.or.jp', 'MALE', '33 Bartillon Point', 8);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (6, 'Heindrick', 'Mussalli', 'hmussalli5@unicef.org', 'FEMALE', '48284 Park Meadow Court', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (7, 'Borg', 'Daniau', 'bdaniau6@desdev.cn', 'MALE', '81 Melvin Alley', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (8, 'Dredi', 'Coad', 'dcoad7@ft.com', 'FEMALE', '8 Drewry Court', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (9, 'Louise', 'Loosley', 'lloosley8@ycombinator.com', 'FEMALE', '194 Crescent Oaks Road', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (10, 'Corby', 'Allsupp', 'callsupp9@geocities.com', 'FEMALE', '7817 Bobwhite Terrace', 5);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (11, 'Oliy', 'Clausner', 'oclausnera@examiner.com', 'MALE', '7024 Cherokee Hill', 5);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (12, 'Kailey', 'Hearnden', 'khearndenb@domainmarket.com', 'MALE', '24 Sachs Hill', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (13, 'Rancell', 'Bartolomeo', 'rbartolomeoc@rambler.ru', 'MALE', '41 Butterfield Terrace', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (14, 'Gilda', 'Alderwick', 'galderwickd@jimdo.com', 'MALE', '94 Maple Center', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (15, 'Gill', 'Howcroft', 'ghowcrofte@live.com', 'MALE', '50454 Helena Way', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (16, 'Dodie', 'Sambles', 'dsamblesf@google.co.uk', 'FEMALE', '02441 Paget Trail', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (17, 'Miguela', 'Jermy', 'mjermyg@harvard.edu', 'MALE', '219 Farwell Drive', 5);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (18, 'Valerye', 'Jope', 'vjopeh@discuz.net', 'FEMALE', '3685 Pleasure Place', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (19, 'Effie', 'Gavan', 'egavani@delicious.com', 'FEMALE', '17 Manufacturers Point', 5);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (20, 'Isa', 'Granville', 'igranvillej@dion.ne.jp', 'MALE', '71168 Ryan Road', 6);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (21, 'Emlyn', 'Baudacci', 'ebaudaccik@webeden.co.uk', 'FEMALE', '9679 Forest Park', 8);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (22, 'Johannah', 'Moralas', 'jmoralasl@skyrock.com', 'FEMALE', '42 Vahlen Place', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (23, 'Marabel', 'Prestage', 'mprestagem@cdc.gov', 'MALE', '4860 Veith Place', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (24, 'Normy', 'Tabourel', 'ntaboureln@dell.com', 'FEMALE', '35900 Maryland Alley', 8);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (25, 'Humfried', 'Stanley', 'hstanleyo@independent.co.uk', 'FEMALE', '14 Stuart Drive', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (26, 'Dominic', 'Bielfeld', 'dbielfeldp@moonfruit.com', 'MALE', '55247 Maple Wood Hill', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (27, 'Mallory', 'Coventon', 'mcoventonq@cam.ac.uk', 'FEMALE', '38 Hayes Trail', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (28, 'Violante', 'MacLese', 'vmacleser@t.co', 'FEMALE', '256 Sutherland Park', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (29, 'Gwenora', 'Langton', 'glangtons@ucsd.edu', 'FEMALE', '9634 Golf View Center', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (30, 'Erhart', 'Winstanley', 'ewinstanleyt@ebay.co.uk', 'MALE', '091 Warner Court', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (31, 'Ron', 'Weldon', 'rweldonu@t-online.de', 'MALE', '4 Rockefeller Junction', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (32, 'Hayes', 'Klaas', 'hklaasv@dailymail.co.uk', 'FEMALE', '867 4th Plaza', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (33, 'Washington', 'Klebes', 'wklebesw@friendfeed.com', 'MALE', '77124 Sundown Circle', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (34, 'Cirstoforo', 'Weller', 'cwellerx@unc.edu', 'MALE', '6 Walton Way', 8);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (35, 'Lenna', 'Garrow', 'lgarrowy@google.com.hk', 'MALE', '403 Roth Park', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (36, 'Cristi', 'Szimoni', 'cszimoniz@dropbox.com', 'FEMALE', '6 Redwing Avenue', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (37, 'Lennard', 'Streader', 'lstreader10@sciencedaily.com', 'MALE', '85393 Holmberg Road', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (38, 'Betty', 'Morgen', 'bmorgen11@cornell.edu', 'FEMALE', '4849 Crest Line Point', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (39, 'Elyse', 'Pitbladdo', 'epitbladdo12@globo.com', 'MALE', '0824 Judy Court', 6);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (40, 'Dale', 'Surmeir', 'dsurmeir13@cisco.com', 'MALE', '1 Sundown Street', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (41, 'Andonis', 'Glasspoole', 'aglasspoole14@arizona.edu', 'FEMALE', '23026 Steensland Terrace', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (42, 'Madella', 'Heater', 'mheater15@amazon.com', 'FEMALE', '2 Morningstar Way', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (43, 'Hunt', 'Jirsa', 'hjirsa16@ask.com', 'FEMALE', '52406 Sheridan Street', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (44, 'Camellia', 'De Mitri', 'cdemitri17@altervista.org', 'MALE', '542 Longview Circle', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (45, 'Nefen', 'Chmiel', 'nchmiel18@shutterfly.com', 'FEMALE', '850 Thackeray Way', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (46, 'Joy', 'Rubke', 'jrubke19@alexa.com', 'MALE', '82981 Iowa Pass', 6);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (47, 'Patten', 'Pree', 'ppree1a@dot.gov', 'MALE', '970 Hauk Street', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (48, 'Nathanil', 'MacGiolla Pheadair', 'nmacgiollapheadair1b@google.fr', 'MALE', '97777 Orin Trail', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (49, 'Ivory', 'Karlsson', 'ikarlsson1c@yandex.ru', 'MALE', '9760 Novick Park', 6);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (50, 'Megen', 'Rignold', 'mrignold1d@diigo.com', 'FEMALE', '51344 Valley Edge Way', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (51, 'Min', 'Aneley', 'maneley1e@cnet.com', 'FEMALE', '9 Bay Lane', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (52, 'Stillman', 'Phear', 'sphear1f@geocities.com', 'MALE', '1 Division Terrace', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (53, 'Orren', 'Allward', 'oallward1g@theatlantic.com', 'MALE', '08852 Arizona Parkway', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (54, 'Nadia', 'Machent', 'nmachent1h@tiny.cc', 'FEMALE', '9720 Judy Crossing', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (55, 'Scarlett', 'Milsap', 'smilsap1i@house.gov', 'MALE', '45044 Superior Pass', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (56, 'Betsey', 'Oherlihy', 'boherlihy1j@mozilla.org', 'FEMALE', '0099 Monica Center', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (57, 'Carmencita', 'Marciek', 'cmarciek1k@businesswire.com', 'MALE', '8898 Elmside Road', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (58, 'Manda', 'Kenen', 'mkenen1l@printfriendly.com', 'MALE', '86 Ilene Way', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (59, 'Courtney', 'Roset', 'croset1m@github.io', 'MALE', '88282 Saint Paul Terrace', 5);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (60, 'Ibby', 'Jerwood', 'ijerwood1n@pen.io', 'MALE', '4 Merrick Avenue', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (61, 'Harman', 'Hardison', 'hhardison1o@webeden.co.uk', 'FEMALE', '7820 Gateway Way', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (62, 'Shirlene', 'Poplee', 'spoplee1p@dmoz.org', 'MALE', '225 Buell Hill', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (63, 'Rochette', 'Helm', 'rhelm1q@bandcamp.com', 'MALE', '2 Blackbird Trail', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (64, 'Adam', 'Gligoraci', 'agligoraci1r@springer.com', 'MALE', '133 Nevada Circle', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (65, 'Jemimah', 'Stealy', 'jstealy1s@epa.gov', 'FEMALE', '48162 Becker Street', 8);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (66, 'Clarine', 'Marshland', 'cmarshland1t@cam.ac.uk', 'FEMALE', '085 Roxbury Junction', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (67, 'Reece', 'Orsman', 'rorsman1u@va.gov', 'FEMALE', '223 Northport Terrace', 5);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (68, 'Abramo', 'Dowtry', 'adowtry1v@devhub.com', 'MALE', '4120 Mallory Avenue', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (69, 'Rocky', 'Wurz', 'rwurz1w@un.org', 'MALE', '1 David Circle', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (70, 'Eric', 'Chisman', 'echisman1x@stumbleupon.com', 'MALE', '496 Buena Vista Drive', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (71, 'Milli', 'Troucher', 'mtroucher1y@vistaprint.com', 'FEMALE', '97 Graceland Lane', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (72, 'Sophia', 'Sineath', 'ssineath1z@shop-pro.jp', 'FEMALE', '976 Kings Point', 1);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (73, 'Tildie', 'McClinton', 'tmcclinton20@printfriendly.com', 'FEMALE', '00 Sutherland Parkway', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (74, 'Addy', 'McConway', 'amcconway21@wufoo.com', 'FEMALE', '8 Mayfield Drive', 8);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (75, 'Jarib', 'Mushett', 'jmushett22@walmart.com', 'MALE', '639 Cody Court', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (76, 'Gypsy', 'Rainy', 'grainy23@taobao.com', 'MALE', '0 Kinsman Circle', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (77, 'Merrili', 'Edscer', 'medscer24@nyu.edu', 'MALE', '6 Sutteridge Way', 8);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (78, 'Gawen', 'Castelli', 'gcastelli25@tripadvisor.com', 'FEMALE', '6475 Twin Pines Point', 7);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (79, 'Ulysses', 'Rowan', 'urowan26@microsoft.com', 'FEMALE', '1 Northport Terrace', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (80, 'Benton', 'Polglase', 'bpolglase27@google.com.br', 'FEMALE', '740 Beilfuss Pass', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (81, 'Modesta', 'Bowery', 'mbowery28@blogspot.com', 'MALE', '84609 Cascade Parkway', 5);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (82, 'Justinn', 'Boost', 'jboost29@mayoclinic.com', 'MALE', '2 Rockefeller Circle', 8);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (83, 'Carlynne', 'Tschierse', 'ctschierse2a@omniture.com', 'FEMALE', '91 Dorton Junction', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (84, 'Nadiya', 'Speechly', 'nspeechly2b@aol.com', 'FEMALE', '48857 Cordelia Pass', 3);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (85, 'Myrvyn', 'Skryne', 'mskryne2c@trellian.com', 'MALE', '4558 Kedzie Junction', 9);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (86, 'Cori', 'Craney', 'ccraney2d@skyrock.com', 'FEMALE', '03 Talisman Point', 2);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (87, 'Radcliffe', 'Willman', 'rwillman2e@reference.com', 'FEMALE', '670 Bay Court', 5);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (88, 'Damaris', 'Crauford', 'dcrauford2f@chronoengine.com', 'FEMALE', '4287 Farwell Park', 4);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (89, 'Risa', 'Mathewes', 'rmathewes2g@abc.net.au', 'MALE', '764 Village Drive', 6);
insert into Student (ID, First_Name , Last_Name, Email, Gender, Address	, Clazz_ID) values (90, 'Viki', 'Arminger', 'varminger2h@eepurl.com', 'FEMALE', '257 Surrey Hill', 1);

