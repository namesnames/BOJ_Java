with sub as (
    select car_id
    from car_rental_company_rental_history
    where "2022-10-16" between start_date and end_date
)

select c.car_id,
       case when sub.car_id is not null then '대여중'
            else '대여 가능'
       end as availability
from car_rental_company_rental_history c
left join sub on c.car_id = sub.car_id
group by c.car_id
order by c.car_id desc;
