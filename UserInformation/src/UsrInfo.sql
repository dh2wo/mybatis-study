DROP TABLE UsrInfo;
CREATE TABLE UsrInfo(
    id VARCHAR2(10) PRIMARY KEY,
    name VARCHAR2(30) NOT NULL,
    age NUMBER DEFAULT 1 NOT NULL 
);

INSERT INTO UsrInfo VALUES ('aaa','피츄',10);
INSERT INTO UsrInfo VALUES ('bbb','피카츄',20);
INSERT INTO UsrInfo VALUES ('ccc','라이츄',30);
INSERT INTO UsrInfo VALUES ('ddd','홍길동',40);
INSERT INTO UsrInfo VALUES ('eee','임꺽정',50);

commit;
