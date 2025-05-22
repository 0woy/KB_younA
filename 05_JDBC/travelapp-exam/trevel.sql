drop table if exists tbl_travel_image;
drop table if exists travel_tbl;

CREATE TABLE tbl_travel(
    no INT auto_increment not NULL PRIMARY KEY ,
    district VARCHAR(30) NOT NULL ,
    title VARCHAR(100) NOT NULL ,
    description TEXT,
    address VARCHAR(256),
    phone VARCHAR(256)
);

create table tbl_travel_img(
    no int not null auto_increment primary key ,
    filename varchar(256) not null ,
    travel_no int ,
    constraint foreign key (travel_no) references tbl_travel(no)
                           on delete cascade
);

SELECT * FROM tbl_travel;
SELECT * FROM tbl_travel_img;

select distinct (district) from tbl_travel;


select * from tbl_travel t
left outer join tbl_travel_img ti  on t.no = ti.travel_no;