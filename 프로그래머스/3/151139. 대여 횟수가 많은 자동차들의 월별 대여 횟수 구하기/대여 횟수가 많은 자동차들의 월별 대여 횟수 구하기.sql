select month(start_date) as month,
       c.car_id, count(c.car_id) as records
from car_rental_company_rental_history c
join        
            (select car_id
            from car_rental_company_rental_history
            where START_DATE between '2022-08-01' and '2022-10-31'
            group by car_id
            having count(car_id) >= 5
    )as sub
on c.car_id = sub.car_id
where START_DATE between '2022-08-01' and '2022-10-31'
group by month, car_id
having records > 0
order by month, car_id desc

# select month(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where START_DATE between '2022-08-01' and '2022-10-31'
# and CAR_ID in (select CAR_ID
#                from CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                where START_DATE between '2022-08-01' and '2022-10-31'
#                group by CAR_ID
#                having count(CAR_ID) >= 5
#               )
# group by 1, 2
# having RECORDS > 0
# order by 1, 2 desc