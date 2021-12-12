SELECT * FROM adms2.booking;
INSERT into Lottery(date, user_id, location) value ('2022-01-06', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-02-03', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-03-03', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-04-07', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-05-05', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-06-02', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-07-07', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-08-04', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-09-01', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-10-06', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-11-03', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2022-11-01', 1, 'Bristol') ;


INSERT into Lottery(date, user_id, location) value ('2021-12-13', 1, 'Bristol') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-13', 1, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-13', 31, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-13', 50, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-13', 32, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-13', 33, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 34, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 35, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 36, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 37, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 38, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 39, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 40, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 41, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 42, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 43, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 44, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 45, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 46, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 47, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 48, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 49, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 21, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 22, 'Cardiff') ;
INSERT into Lottery(date, user_id, location) value ('2021-12-14', 23, 'Cardiff') ;

SELECT * FROM adms2.lottery;

-- select * from desk where desk_location='Bristol' and desk_id not in (select Desk_desk_id from booking where booking_date='2021-12-11') and '2021-12-12' not in (select date from lottery);