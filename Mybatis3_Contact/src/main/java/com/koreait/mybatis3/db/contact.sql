DROP TABLE CONTACT;
CREATE TABLE CONTACT(
	CNO NUMBER PRIMARY KEY, 
	CNAME VARCHAR2(50),
	CPHONE VARCHAR2(50),
	CADDRESS VARCHAR2(100),
	CEMAIL VARCHAR2(100),
	CNOTE VARCHAR2(1000)
);
DROP SEQUENCE CONTACT_SEQ;
CREATE SEQUENCE CONTACT_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
NOCYCLE
NOCACHE;

INSERT INTO CONTACT (CNO, CNAME, CPHONE, CADDRESS, CEMAIL, CNOTE)
VALUES (CONTACT_SEQ.NEXTVAL,'Tom','010-111-1111','Seoul','t@e.com','co-worker')
INSERT INTO CONTACT (CNO, CNAME, CPHONE, CADDRESS, CEMAIL, CNOTE)
VALUES (CONTACT_SEQ.NEXTVAL,'Kim','010-211-1111','Busan','b@s.com','co-worker')
commit