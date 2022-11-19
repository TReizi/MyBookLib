CREATE TABLE reader (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(15) NOT NULL
);

CREATE TABLE book (
    id     INT PRIMARY KEY AUTO_INCREMENT,
    name   varchar(15) NOT NULL,
    author varchar(25) NOT NULL
);

CREATE TABLE borrow (
    id        INT PRIMARY KEY AUTO_INCREMENT,
    reader_id INT(25) NOT NULL,
    book_id   INT(15) NOT NULL,
    FOREIGN KEY (reader_id) REFERENCES reader(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

-- add initial data

insert into book (id, name, author) values
(1, 'Abernathy Islan', 'Verda'),
(2, 'Adan Square', 'Gisselle'),
(3, 'Hershel Grove', 'Deja'),
(4, 'Rosalia Overpas', 'Monica'),
(5, 'Beier Trafficwa', 'Aileen');

insert into reader (id, name) values (1, 'Kreiger'),
(2, 'Reichel'),
(3, 'Bergstrom'),
(4, 'Feest'),
(5, 'Beer');

insert into borrow (reader_id, book_id)
values (1,3), (2,1), (3,4), (4,2);