CREATE TABLE word (
id SERIAL unique,
mother_meaning varchar(150) unique,
foreign_meaning varchar(150),
synonymous varchar (300)
);