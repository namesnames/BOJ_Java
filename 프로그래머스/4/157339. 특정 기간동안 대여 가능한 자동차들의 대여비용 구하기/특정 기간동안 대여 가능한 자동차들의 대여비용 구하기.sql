select a.car_id, a.car_type, 
       floor(a.daily_fee * 30 * (100 - c.discount_rate)/100) as fee
from CAR_RENTAL_COMPANY_CAR a
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
on a.car_type = c.car_type
where a.car_id not in (select car_id
            from CAR_RENTAL_COMPANY_RENTAL_HISTORY b
            where end_date >= "2022-11-01" and start_date <= "2022-11-01"
            )
    and a.car_type in ("SUV","세단") and c.duration_type = "30일 이상"
having fee between 500000 and 1999999
order by fee desc, a.car_type, a.car_id
