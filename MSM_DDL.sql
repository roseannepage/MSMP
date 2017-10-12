/*	Author: Jiebin Gao, Jianing Zhang, Justin So, Vinh Le
	Date: 2017-09-30 */

DROP DATABASE IF EXISTS MSM;
CREATE DATABASE MSM;
USE MSM;

DROP TABLE IF EXISTS ActiveLocation;#
DROP TABLE IF EXISTS HistoryLocation;#
DROP TABLE IF EXISTS MdLocation;#
DROP TABLE IF EXISTS LocTraining;#
DROP TABLE IF EXISTS MdSpecializaiton;#
DROP TABLE IF EXISTS ScribeSpecializaiton;
DROP TABLE IF EXISTS Preference;
DROP TABLE IF EXISTS ShiftSchedule;
DROP TABLE IF EXISTS Availability;
DROP TABLE IF EXISTS MentorMentee; #
DROP TABLE IF EXISTS Scribe; 
DROP TABLE IF EXISTS Location;
DROP TABLE IF EXISTS Physician;
DROP TABLE IF EXISTS Specialization;
DROP TABLE IF EXISTS Shift;


CREATE TABLE Scribe
( scribe_id int NOT NULL AUTO_INCREMENT,
 scribe_fname VARCHAR(20) NOT NULL,
 scribe_lname VARCHAR(20) NOT NULL,
 scribe_phone VARCHAR(20) NULL,
 scribe_address VARCHAR(60) NULL,
 scribe_email VARCHAR(40) NULL,
 scribe_photo BLOB NULL,
 contract_type ENUM('Hiatu','Full-time', 'Part-time') NOT NULL,
 hiring_date Date NULL, 
 expected_end_date Date NULL, 
 end_date Date NULL,
 hours_worked SMALLINT NULL,
 camelot_progress TINYINT NULL CHECK (camelot_progress <= 100), 
 camelot_score  INT NULL, 
 textbook_readings BIT(1) NULL, 
 online_resources BIT(1) NULL, 
 in_class_training BIT(1) NULL, 
 msc_paperwork BIT(1) NULL,	 
 general_qualified BIT(1) NOT NULL,	
CONSTRAINT pk_scribe PRIMARY KEY (scribe_id));

CREATE TABLE Location
( location_id int NOT NULL AUTO_INCREMENT,
 country	VARCHAR(20) NOT NULL, 
 province 	VARCHAR(30) NOT NULL,
 city  		VARCHAR(20) NOT NULL,
 site  		VARCHAR(60) NOT NULL,
 department	VARCHAR(40) NULL,
 area		VARCHAR(40) NULL,
CONSTRAINT pk_location PRIMARY KEY (location_id));

CREATE TABLE ActiveLocation
(#active_location_id int NOT NULL AUTO_INCREMENT,
location_id int NOT NULL,
 scribe_id int NOT NULL,
  #PRIMARY KEY (active_location_id),
 PRIMARY KEY (location_id, scribe_id),
 FOREIGN KEY (scribe_id) REFERENCES Scribe(scribe_id),
 FOREIGN KEY (location_id) REFERENCES Location(location_id)
 );


CREATE TABLE HistoryLocation
(location_id int NOT NULL,
 scribe_id int NOT NULL,
 PRIMARY KEY (location_id, scribe_id),
 FOREIGN KEY (scribe_id) REFERENCES Scribe(scribe_id),
 FOREIGN KEY (location_id) REFERENCES Location(location_id)
 );
 
 CREATE TABLE Physician
(physician_id int NOT NULL AUTO_INCREMENT,
 physician_fname VARCHAR(20) NOT NULL,
 physician_lname VARCHAR(20) NOT NULL,
 physician_phone VARCHAR(20) NULL,
 physician_address VARCHAR(60) NULL,
 physician_email VARCHAR(40) NULL,
 physician_photo BLOB NULL,
 client_date DATE NULL,
 contract_start_date DATE NULL,
 contract_end_date DATE NULL,
CONSTRAINT pk_scribe PRIMARY KEY (physician_id));

CREATE TABLE MdLocation
(location_id int NOT NULL,
 physician_id int NOT NULL,
 PRIMARY KEY (location_id, physician_id),
 FOREIGN KEY (physician_id) REFERENCES Physician(physician_id),
 FOREIGN KEY (location_id) REFERENCES Location(location_id)
 );

CREATE TABLE LocTraining # site specific training
(location_id int NOT NULL,
 scribe_id int NOT NULL,
 PRIMARY KEY (location_id, scribe_id),
 FOREIGN KEY (scribe_id) REFERENCES Scribe(scribe_id),
 FOREIGN KEY (location_id) REFERENCES Location(location_id)
 );

CREATE TABLE Specialization
(specialization_id INT NOT NULL AUTO_INCREMENT,
 specialization_name VARCHAR(40) NOT NULL,
 PRIMARY KEY(specialization_id)
);

CREATE TABLE MdSpecializaiton
(specialization_id INT NOT NULL AUTO_INCREMENT,
 physician_id int NOT NULL,
 PRIMARY KEY(specialization_id, physician_id),
 FOREIGN KEY (physician_id) REFERENCES Physician(physician_id),
 FOREIGN KEY (specialization_id) REFERENCES Specialization(specialization_id)
);

CREATE TABLE ScribeSpecializaiton # specialization specific clinical training
(specialization_id INT NOT NULL AUTO_INCREMENT,
 scribe_id int NOT NULL,
 location_id int NOT NULL,	
 PRIMARY KEY(specialization_id, scribe_id, location_id),
 FOREIGN KEY (scribe_id) REFERENCES Scribe(scribe_id),
 FOREIGN KEY (specialization_id) REFERENCES Specialization(specialization_id),
 FOREIGN KEY (location_id) REFERENCES Location(location_id)
);

CREATE TABLE Preference
(physician_id int NOT NULL,
 scribe_id int NOT NULL,
 preference Bit(1) NOT NULL, # 0 for avoidance, 1 for perference
 PRIMARY KEY (physician_id, scribe_id),
 FOREIGN KEY (scribe_id) REFERENCES Scribe(scribe_id),
 FOREIGN KEY (physician_id) REFERENCES Physician(physician_id)
 );
  
CREATE TABLE Shift
(shift_id INT NOT NULL AUTO_INCREMENT,
shift_name VARCHAR(20) NOT NULL,
start_hour INT NOT NULL,
finish_hour INT NOT NULL,
overnight BIT(1) NULL,
PRIMARY KEY(shift_id));

CREATE TABLE ShiftSchedule
(shift_schedule_id int NOT NULL AUTO_INCREMENT,
 physician_id INT NOT NULL,
 specialization_id INT NOT NULL,
 date_to_fill DATE NOT NULL,
 location_id INT NOT NULL,
 shift_id INT NOT NULL,
 scribe_id INT NULL,
 time_in DATETIME NULL,
 time_out DATETIME NULL,
 patients_seen INT NULL,
 high_volumn BIT(1) NULL,
 note BLOB NULL,
 PRIMARY KEY(shift_schedule_id),
 FOREIGN KEY (physician_id) REFERENCES Physician(physician_id),
 FOREIGN KEY (scribe_id) REFERENCES Scribe(scribe_id),
 FOREIGN KEY (location_id) REFERENCES Location(location_id),
 FOREIGN KEY (specialization_id) REFERENCES Specialization(specialization_id),
 FOREIGN KEY (shift_id) REFERENCES Shift(shift_id)
 );

CREATE TABLE Availability
(availability_id INT NOT NULL AUTO_INCREMENT,
scribe_id INT NOT NULL,
available_date DATE NOT NULL,
start_hour INT NOT NULL,
finish_hour INT NOT NULL,
overnight BIT(1) NOT NULL,
PRIMARY KEY(availability_id),
FOREIGN KEY (scribe_id) REFERENCES Scribe(scribe_id)
);

CREATE TABLE MentorMentee
(
mentor_id INT NOT NULL, 
mentee_id INT NOT NULL,
PRIMARY KEY (mentor_id, mentee_id),
FOREIGN KEY (mentor_id) REFERENCES Scribe(scribe_id),
FOREIGN KEY (mentee_id) REFERENCES Scribe(scribe_id)
);
 
