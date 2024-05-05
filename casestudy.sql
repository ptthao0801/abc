create database casestudy;

use casestudy;

create table Class (
    id int auto_increment primary key,
    nameClass varchar(255)
);

create table Student (
    id int auto_increment primary key,
    nameStudent varchar(255),
    dob date,
    id_class int, foreign key (id_class) references Class (id)
);

create table Subject (
    id int auto_increment primary key,
    nameSubject varchar(255)
);

create table Grade (
    id_student int, foreign key (id_student) references Student (id),
    id_subject int, foreign key (id_subject) references Subject (id),
    primary key (id_student, id_subject),
    grade double
);

insert into Class (nameClass) values ('CGHN'), ('CGSG'), ('CGH'), ('CGDN');

insert into Student (nameStudent, id_class, dob) values ('Duong Minh Hieu', 1, '2000-12-17'),
                                                 ('Nguyen Tat Quan', 1, '2004-01-27'),
                                                 ('Phan Thanh Thao', 1, '1999-01-23'),
                                                 ('Trinh Luu Khoa', 1, '1996-7-05'),
                                                 ('Nguyen Nhat Huy', 2, '2004-05-15'),
                                                 ('Nguyen Nhat Minh', 2, '1994-08-21'),
                                                 ('Pham Hoang An', 2, '2000-02-14'),
                                                 ('Dang Phuoc Quy', 3, '2004-09-30'),
                                                 ('Le Hoang Duc', 3, '2005-06-09'),
                                                 ('Le Thanh Nhon', 4, '1997-03-25'),
                                                 ('Phan Dinh Truong', 4, '1994-02-28');

insert into Subject (nameSubject) values ('Toan'), ('Van'), ('Anh');

insert into Grade values (1, 1, 10), (2, 1, 5), (3, 1, 10), (4, 1, 10), (5, 1, 5.7), (6, 1, 3),
                         (7, 1, 9), (8, 1, 9), (9, 1, 8.6), (10, 1, 7), (11, 1, 5),
                         (1, 2, 7.7), (2, 2, 3.3), (3, 2, 7.8), (4, 2, 10), (5, 2, 9.9), (6, 2, 8.9),
                         (7, 2, 7.9), (8, 2, 10), (9, 2, 9.8), (10, 2, 6.9), (11, 2, 7.7),
                         (1, 3, 8), (2, 3, 9), (3, 3, 10), (4, 3, 10), (5, 3, 3), (6, 3, 9),
                         (7, 3, 8.9), (8, 3, 9), (9, 3, 9), (10, 3, 10), (11, 3, 5.6);

select * from Class;

select * from Student;

select * from Subject;

select * from Grade;




