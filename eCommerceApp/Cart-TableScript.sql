create table orderTBL(
	OrderID iNt primary key,
	OrderDate varchar(50) NOT NULL,
	PaymentMethod varchar(50) NOT NULL,
	CustomerID varchar(50) NOT NULL
);

create table CustomerTBL(
	CustomerID varchar(10) NOT NULL,
	Customername varchar(50) NOT NULL
    );
    
    create table OrderLienTBL(
	OrderID iNt ,
	ProductID varchar(50) NOT NULL,
	Quantity iNt NOT NULL,
	Price iNt );
    
    
    
    CREATE TABLE ProductTBL(
	ProductID varchar(10) NOT NULL,
	Productname varchar(50) nOT NULL,
	ProductPrice iNt NOT NULL);
    
       
INSERT CustomerTBL (CustomerID, Customername) VALUES (1, "Customer1");
INSERT CustomerTBL (CustomerID, Customername) VALUES (2, "Customer2");
INSERT CustomerTBL (CustomerID, Customername) VALUES (3, "Customer3");
INSERT OrderLienTBL (OrderID, ProductID, Quantity, Price) VALUES (1, 1, 1, 100);
INSERT OrderLienTBL (OrderID, ProductID, Quantity, Price) VALUES (1, 2, 1, 200);
INSERT OrderLienTBL (OrderID, ProductID, Quantity, Price) VALUES (1, 3, 1, 250);


INSERT OrderTBL (OrderID, OrderDate, PaymentMethod, CustomerID) VALUES (1, "02/10/2017", "Cash", 3);

INSERT ProductTBL (ProductID, Productname, ProductPrice) VALUES (1, "P1", 100);
INSERT ProductTBL (ProductID, Productname, ProductPrice) VALUES (2, "P2", 200);
INSERT ProductTBL (ProductID, Productname, ProductPrice) VALUES (3, "P3", 250);
INSERT ProductTBL (ProductID, Productname, ProductPrice) VALUES (4, "P4", 50);
INSERT ProductTBL (ProductID, Productname, ProductPrice) VALUES (5, "P5", 15);
INSERT ProductTBL (ProductID, Productname, ProductPrice) VALUES (6, "P6", 25);
INSERT ProductTBL (ProductID, Productname, ProductPrice) VALUES (7, "P7", 30);