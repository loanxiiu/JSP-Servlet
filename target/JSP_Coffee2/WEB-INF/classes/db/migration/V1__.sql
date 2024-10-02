CREATE TABLE coffee.CoffeeType
(
    idCoffee   VARCHAR(255) NOT NULL,
    nameCoffee VARCHAR(255) NOT NULL,
    price      DOUBLE       NOT NULL,
    quantity   INT          NULL,
    detail     VARCHAR(255) NULL,
    CONSTRAINT pk_coffeetype PRIMARY KEY (idCoffee)
);