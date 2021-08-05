DROP DATABASE IF EXISTS TestingSystem3;
CREATE DATABASE TestingSystem3;
USE TestingSystem3;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
ID MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Department_Name NVARCHAR(30) NOT NULL UNIQUE KEY
);
-- create table 2: Posittion
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position` (
ID MEDIUMINT UNSIGNED AUTO_INCREMENT
PRIMARY KEY,
Position_Name ENUM('DEV','TEST','SCRUM_MASTER','PM') NOT NULL UNIQUE
KEY
);
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
ID MEDIUMINT UNSIGNED AUTO_INCREMENT
PRIMARY KEY,
Email VARCHAR(50) NOT NULL UNIQUE KEY,
User_name VARCHAR(50) NOT NULL UNIQUE KEY,
Full_Name NVARCHAR(50) NOT NULL,
Department_ID MEDIUMINT UNSIGNED NOT NULL,
Position_ID MEDIUMINT UNSIGNED NOT NULL,
Update_At DATETIME,
Create_Date DATETIME,
FOREIGN KEY(Department_ID) REFERENCES Department(ID),
FOREIGN KEY(Position_ID) REFERENCES `Position`(ID)
);
INSERT INTO Position (Position_Name )
VALUES ('DEV' ),
('TEST' ),
('SCRUM_MASTER'),
('PM' );
insert into department (Department_Name) values ('Engineering');
insert into department (Department_Name) values ('Product Management');
insert into department (Department_Name) values ('Business Development');
insert into department (Department_Name) values ('Legal');
insert into department (Department_Name) values ('Support');
insert into department (Department_Name) values ('Accounting');
insert into department (Department_Name) values ('Services');
insert into department (Department_Name) values ('Sale');
insert into department (Department_Name) values ('Training');
insert into department (Department_Name) values ('Human Resources');
insert into department (Department_Name) values ('Research and Development');
insert into department (Department_Name) values ('Marketing');insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('lgoodge0@msn.com', 'lgoodge0', 'Lyman Goodge', 11, 3, '2017-04-09');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('dgeertz1@bluehost.com', 'dgeertz1', 'Dal Geertz', 3, 2, '2020-09-13');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('qharwick2@kickstarter.com', 'qharwick2', 'Quentin Harwick', 9, 2, '2018-01-23');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('noriordan3@jugem.jp', 'noriordan3', 'Nomi O''Riordan', 7, 2, '2018-11-30');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('ledmondson4@jalbum.net', 'ledmondson4', 'Livia Edmondson', 3, 4, '2019-06-16');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('cgerauld5@lycos.com', 'cgerauld5', 'Cordell Gerauld', 6, 2, '2019-12-26');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('thowgego6@sourceforge.net', 'thowgego6', 'Taffy Howgego', 5, 2, '2017-08-27');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('vkiernan7@uol.com.br', 'vkiernan7', 'Verna Kiernan', 9, 3, '2017-08-08');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('tgegg8@cyberchimps.com', 'tgegg8', 'Tiffanie Gegg', 9, 4, '2017-09-23');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('tplace9@cbc.ca', 'tplace9', 'Tiffani Place', 10, 4, '2018-10-08');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('iadamidesa@blogs.com', 'iadamidesa', 'Isac Adamides', 7, 3, '2021-01-02');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('lghirardib@imgur.com', 'lghirardib', 'Lanie Ghirardi', 3, 4, '2018-08-13');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('eallwoodc@example.com', 'eallwoodc', 'Erena Allwood', 11, 4, '2017-09-21');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('mrizzid@vimeo.com', 'mrizzid', 'Monte Rizzi', 3, 3, '2017-08-12');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('mlynese@photobucket.com', 'mlynese', 'Mayne Lynes', 8, 3, '2020-03-15');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('achanningf@apache.org', 'achanningf', 'Ansley Channing', 1, 3, '2020-11-08');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('hgoscombg@umn.edu', 'hgoscombg', 'Horacio Goscomb', 10, 3, '2018-09-10');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('jwarykh@cam.ac.uk', 'jwarykh', 'Jorge Waryk', 1, 1, '2020-04-30');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('nmariansi@studiopress.com', 'nmariansi', 'Northrup Marians', 3, 3, '2019-08-28');insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('aapedailej@printfriendly.com', 'aapedailej', 'Alwyn Apedaile', 2, 4, '2017-10-25');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('bmastersk@census.gov', 'bmastersk', 'Bridie Masters', 5, 2, '2020-02-11');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('cboulgerl@theguardian.com', 'cboulgerl', 'Cristen Boulger', 3, 4, '2020-03-19');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('reamm@state.gov', 'reamm', 'Ripley Eam', 6, 1, '2020-10-17');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('epietranekn@nps.gov', 'epietranekn', 'Elinore Pietranek', 8, 1, '2018-03-21');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('skrammero@abc.net.au', 'skrammero', 'Stanfield Krammer', 1, 2, '2017-12-22');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('jboswoodp@auda.org.au', 'jboswoodp', 'Jillie Boswood', 10, 4, '2018-01-18');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('cheadleyq@usnews.com', 'cheadleyq', 'Cynthea Headley', 5, 1, '2020-09-23');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('erozecr@plala.or.jp', 'erozecr', 'Eden Rozec', 6, 3, '2017-05-04');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('bguilloneaus@tmall.com', 'bguilloneaus', 'Bennie Guilloneau', 1, 4, '2017-07-25');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('ktommist@loc.gov', 'ktommist', 'Katherina Tommis', 10, 4, '2019-04-29');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('fdallau@smh.com.au', 'fdallau', 'Ferdie Dalla', 1, 2, '2020-09-17');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('adockreev@cdc.gov', 'adockreev', 'Adolf Dockree', 2, 2, '2021-01-22');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('thumbatchw@cargocollective.com', 'thumbatchw', 'Tomasine Humbatch', 10, 3, '2019-06-24');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('edomeganx@weebly.com', 'edomeganx', 'Eddi Domegan', 3, 4, '2019-01-15');
insert into account (Email, User_name, Full_Name, Department_ID, Position_ID, Create_Date) values
('jwaighty@discuz.net', 'jwaighty', 'Jeanna Waight', 4, 2, '2018-10-22');