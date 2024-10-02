CREATE TABLE coffee.Account
(
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NULL,
    idRole   VARCHAR(255) NULL,
    CONSTRAINT pk_account PRIMARY KEY (username)
);

CREATE TABLE coffee.`Role`
(
    idRole   VARCHAR(255) NOT NULL,
    nameRole VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (idRole)
);

ALTER TABLE coffee.Account
    ADD CONSTRAINT FK_ACCOUNT_ON_IDROLE FOREIGN KEY (idRole) REFERENCES coffee.`Role` (idRole);