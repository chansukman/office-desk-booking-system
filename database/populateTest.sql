USE `adms2`;

select * from booking;
select * from desk;

select * from desk where desk_id in (select Desk_desk_id from booking where booking_date='2021-11-20');


