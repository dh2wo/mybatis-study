DROP TABLE bmimember;

CREATE TABLE bmimember(
	id         VARCHAR2(10) PRIMARY KEY,
	name       VARCHAR2(30) NOT NULL,
	height     NUMBER(5,2)  NOT NULL,
	weight     NUMBER(5,2)  NOT NULL,
	bmi        NUMBER(5,2)  NOT NULL,
	bmiresult  VARCHAR2(9)  CHECK(bmireault IN('비만','과체중','정상','저체중')) NOT NULL,
	deleteflag NUMBER(1)    DEFAULT 0 CHECK(deleteflag IN (0,1)),
    regdate                 DEFAULT sysdate,
    upddate                 DEFAULT sysdate
);