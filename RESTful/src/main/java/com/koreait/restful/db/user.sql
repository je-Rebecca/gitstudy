DROP TABLE USERS;
CREATE TABLE USERS(
	USERID VARCHAR2(20) PRIMARY KEY, 
	USERNAME VARCHAR2(20),
	GENDER VARCHAR2(10),
	ADDRESS VARCHAR2(20)
);

INSERT INTO USERS VALUES ('user1', 'Dann', 'm','Seoul');
INSERT INTO USERS VALUES ('user2', 'Jenn', 'f','Incheon');
INSERT INTO USERS VALUES ('user3', 'Tom', 'm','Busan');
INSERT INTO USERS VALUES ('user4', 'William', 'm','Gimpo');
INSERT INTO USERS VALUES ('user5', 'Gerry', 'm','Jeju');