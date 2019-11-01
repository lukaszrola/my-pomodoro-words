CREATE TABLE word (
id SERIAL unique,
mother_meaning varchar(50) unique,
foreign_meaning varchar(50),
synonymous varchar (200)
);