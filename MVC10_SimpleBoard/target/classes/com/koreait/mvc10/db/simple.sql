DROP TABLE SIMPLE;
CREATE TABLE SIMPLE(
	BNO NUMBER PRIMARY KEY, 
	BWRITER VARCHAR2(50),
	BTITLE VARCHAR2(100),
	BCONTENT VARCHAR2(100),
	BDATE DATE
);

DROP SEQUENCE SIMPLE_SEQ;
CREATE SEQUENCE SIMPLE_SEQ
START WITH 1 
INCREMENT BY 1 
MAXVALUE 999999
NOCYCLE
NOCACHE;