CREATE SCHEMA `class_scheduler`;

CREATE TABLE USER

( ID INT NOT NULL AUTO_INCREMENT,

 NAME VARCHAR(50) NOT NULL,

 EMAIL VARCHAR(50) NOT NULL UNIQUE,

 PASSWORD VARCHAR(100) NOT NULL,
 
 USERNAME VARCHAR(25) NOT NULL UNIQUE,

 TRACK VARCHAR(50) NOT NULL,

 SCHOOL VARCHAR(50) NOT NULL,

 PRIMARY KEY(ID)

);

CREATE TABLE PREFERENCE

(

 ID INT NOT NULL AUTO_INCREMENT,

 TYPE VARCHAR(50) NOT NULL,

 VALUE VARCHAR(50) NOT NULL,

 PRIMARY KEY(ID)

 );

CREATE TABLE USER_PREFERENCE

(

 ID INT NOT NULL AUTO_INCREMENT,

 USER_ID INT NOT NULL,

 PREFERENCE_ID INT NOT NULL,

 PRIMARY KEY(ID),

 FOREIGN KEY(USER_ID) REFERENCES USER(ID),

 FOREIGN KEY(PREFERENCE_ID) REFERENCES PREFERENCE(ID)

);

CREATE TABLE COURSE

(

 ID INT NOT NULL AUTO_INCREMENT,

 COURSECODE VARCHAR(20) NOT NULL,

 COURSENAME VARCHAR(50) NOT NULL,

 PROFESSOR VARCHAR(50) NOT NULL,

 STARTTIME DATE NOT NULL,

 ENDTIME DATE NOT NULL,

 DAYS VARCHAR(10) NOT NULL,

 INTAKE_COUNT INT NOT NULL,

 AVAILABILITY INT NOT NULL,

 CLASS_LEVEL VARCHAR(50) NOT NULL,

 CLASS_CREDITS INT NOT NULL,

 PRIMARY KEY(ID)

);

CREATE TABLE USER_COURSE

(

 ID INT NOT NULL AUTO_INCREMENT,

 USER_ID INT NOT NULL,

 COURSE_ID INT NOT NULL,

 SEMESTER INT NOT NULL,

 PRIMARY KEY(ID),

 FOREIGN KEY(USER_ID) REFERENCES USER(ID),

 FOREIGN KEY(COURSE_ID) REFERENCES COURSE(ID)

);