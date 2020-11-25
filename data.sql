drop database JDBC;
create database JDBC;
use booking;
create table accommodation
(
    id          serial not null,
    type        varchar(32),
    bed_type    varchar(32),
    max_guests  int,
    description varchar(512),
    primary key (id)
);
create table room_fair
(
    id     serial not null,
    value  double precision,
    season varchar(32),
    primary key (id)
);
create table accommodation_fair_relation
(
    id               serial not null,
    id_accommodation serial,
    id_room_fair     int,
    primary key (id),
    foreign key (id_accommodation) references accommodation (id),
    foreign key (id_room_fair) references room_fair (id)
);

Select * from accommodation
Select * from accommodation_fair_relation
Select * from room_fair
DELETE FROM accommodation_fair_relation;
DELETE FROM accommodation;
DELETE FROM room_fair;
 select *
from accommodation a,
     room_fair rf,
     accommodation_fair_relation afr
where a.id = afr.id_accommodation
  AND rf.id = afr.id_room_fair;
 Drop table accommodation_fair_relation;
 Drop table accommodation;
 Drop table room_fair