CREATE TABLE client (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(100),
    LAST_NAME VARCHAR(100),
    DOCUMENT VARCHAR(100),
    EMAIL VARCHAR(100) UNIQUE,
    PASSWORD VARCHAR(100),

    PRIMARY KEY(ID)
);

INSERT INTO client(NAME, LAST_NAME, DOCUMENT, EMAIL, PASSWORD)
VAlUES ('CLIENT', 'TEST', '11111111111', 'test@example.com', 'password123');