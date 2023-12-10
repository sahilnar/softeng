CREATE TABLE items
(
    Catcode varchar(25) not null,
    lcode   varchar(25) not null,
    ldesc   varchar(25) not null,
    Price   float       not null
);

CREATE TABLE category
(
    Catcode varchar(25) not null,
    Catdesc varchar(25) not null
);

CREATE TABLE sales
(
    id bigint(20) primary key auto_increment,
    recno int(11),
    lcode varchar(255) not null,
    qty double not null,
    dot date
);

INSERT INTO category(Catcode, Catdesc)
VALUES
(101, 'School Supplies'),
(102, 'Drinks'),
(103, 'Dog items');

INSERT INTO items(Catcode, lcode, ldesc, Price)
VALUES
(102, 'J102A', 'Coke', 5),
(101, 'J102B', 'Vines Paper pad', 4),
(102, 'J102B', 'Pepsi', 4),
(103, 'J102C', 'Purina Dog Food', 22.5),
(101, 'J101C', 'Xyz Eraser', 1.5),
(103, 'J103D', 'Dog Chew Toy', 13.5);