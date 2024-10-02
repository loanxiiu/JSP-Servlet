CREATE TABLE coffee.Customer
(
    idCustomer   VARCHAR(255) NOT NULL,
    nameCustomer VARCHAR(255) NULL,
    dateOfBirth  date         NULL,
    gender       BIT(1)       NULL,
    idCity       VARCHAR(255) NULL,
    phoneNumber  VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    CONSTRAINT pk_customer PRIMARY KEY (idCustomer)
);

CREATE TABLE coffee.`Order`
(
    idOrder      VARCHAR(255) NOT NULL,
    idCustomer   VARCHAR(255) NOT NULL,
    dateOrder    date         NULL,
    dateDelivery date         NULL,
    status       VARCHAR(255) NULL,
    payment      VARCHAR(255) NULL,
    totalPrice   DOUBLE       NULL,
    CONSTRAINT pk_order PRIMARY KEY (idOrder)
);

CREATE TABLE coffee.OrderDetail
(
    idOrderDetail VARCHAR(255) NOT NULL,
    idOrder       VARCHAR(255) NOT NULL,
    idCoffee      VARCHAR(255) NOT NULL,
    quantity      INT          NULL,
    vat           DOUBLE       NULL,
    CONSTRAINT pk_orderdetail PRIMARY KEY (idOrderDetail)
);

ALTER TABLE coffee.`Order`
    ADD CONSTRAINT uc_order_idcustomer UNIQUE (idCustomer);

ALTER TABLE coffee.Customer
    ADD CONSTRAINT FK_CUSTOMER_ON_IDCITY FOREIGN KEY (idCity) REFERENCES coffee.City (idCity);

ALTER TABLE coffee.OrderDetail
    ADD CONSTRAINT FK_ORDERDETAIL_ON_IDCOFFEE FOREIGN KEY (idCoffee) REFERENCES coffee.CoffeeType (idCoffee);

ALTER TABLE coffee.OrderDetail
    ADD CONSTRAINT FK_ORDERDETAIL_ON_IDORDER FOREIGN KEY (idOrder) REFERENCES coffee.`Order` (idOrder);

ALTER TABLE coffee.`Order`
    ADD CONSTRAINT FK_ORDER_ON_IDCUSTOMER FOREIGN KEY (idCustomer) REFERENCES coffee.Customer (idCustomer);