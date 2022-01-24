 
DROP TABLE IF EXISTS BOOKING;  
DROP TABLE IF EXISTS Customer;  
CREATE TABLE Customer (  
Customer_Id INT  PRIMARY KEY auto_increment,  
Customer_Name VARCHAR(20),  
Age INT ,
Gender varchar(3),
Address VARCHAR(100),
Idproof VARCHAR(20),
Status Varchar(20),
Password Varchar(10000)
);

DROP TABLE IF EXISTS Room;  
CREATE TABLE Room (  
Room_Id INT  PRIMARY KEY auto_increment,  
Room_Type VARCHAR(20),  
Cost INT ,
Description VARCHAR(100),
Status VARCHAR(20)
);


CREATE TABLE BOOKING (  
Booking_Id INT  PRIMARY KEY auto_increment,  
Room_Id INT   ,  
Customer_Id INT  ,
Checkin_Date DATETIME DEFAULT CURRENT_TIMESTAMP,
Checkout_Date DATETIME DEFAULT CURRENT_TIMESTAMP,
Status VARCHAR(20),
Number_Of_People INT,
CONSTRAINT FK_Room  foreign key(Room_Id) REFERENCES Room (Room_Id),
CONSTRAINT FK_Cust  foreign key(Customer_Id) REFERENCES CUSTOMER (Customer_Id)
); 

--INSERT INTO ROOM VALUES ('AC',2000,'DUPLEX ROOM','F');
--INSERT INTO ROOM VALUES ('NON AC',1000,'ROOM','E');
--INSERT INTO ROOM VALUES  ('AC',2000,'DUPLEX ROOM','F');
--INSERT INTO ROOM VALUES	('NON AC',1000,'ROOM','E');
--INSERT INTO ROOM VALUES	('AC',2000,'DUPLEX ROOM','F');
--INSERT INTO ROOM (6,'NON AC',1000,'ROOM','E');