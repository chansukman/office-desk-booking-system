SELECT * FROM adms2.booking;
INSERT into Lottery value ('2021-12-13', 1, 'Bristol') ;
INSERT into Lottery value ('2021-12-13', 12, 'Cardiff') ;
INSERT into Lottery value ('2021-12-13', 13, 'Cardiff') ;
INSERT into Lottery value ('2021-12-13', 4, 'Cardiff') ;
INSERT into Lottery value ('2021-12-13', 15, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 16, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 17, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 18, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 19, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 20, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 21, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 22, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 23, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 24, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 25, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 26, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 27, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 28, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 29, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 30, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 31, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 32, 'Cardiff') ;
INSERT into Lottery value ('2021-12-14', 33, 'Cardiff') ;

SELECT * FROM adms2.lottery;

-- select * from desk where desk_location='Bristol' and desk_id not in (select Desk_desk_id from booking where booking_date='2021-12-11') and '2021-12-12' not in (select date from lottery);