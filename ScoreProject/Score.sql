DROP TABLE student;
CREATE TABLE student(
    stdid    NUMBER(20)   PRIMARY KEY,
    stdname  VARCHAR2(20) NOT NULL,
    it       NUMBER(6,2)  default 0 NOT NULL,
    language NUMBER(6,2)  default 0 NOT NULL,
    basic    NUMBER(6,2)  default 0 NOT NULL
);