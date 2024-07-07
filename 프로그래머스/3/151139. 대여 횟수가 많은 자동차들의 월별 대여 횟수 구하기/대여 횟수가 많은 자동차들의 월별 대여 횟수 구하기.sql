# group by A,B (칼럼 2개)
# GROUP BY 성별, 지역 이라고 했을 때에, 경기도 여성 / 경기도 남성 / 서울 여성 / 서울 남성 이런 식으로 성별과 지역을 이용해 만들 수 있는 모든 경우의 수로 그룹을 만들수 있게 됩니다.
# https://www.inflearn.com/questions/27971/group-by%EC%97%90-%EB%91%90-%EA%B0%9C-%EC%9D%B4%EC%83%81%EC%9D%98-column%EC%9D%84-%EC%93%B0%EB%8A%94-%EA%B2%BD%EC%9A%B0

select month(start_date) as month,
       c.car_id, count(c.car_id) as records
from car_rental_company_rental_history c
join        
            (select car_id
            from car_rental_company_rental_history
            where START_DATE >= '2022-08-01' and start_date <= '2022-10-31'
            group by car_id
            having count(car_id) >= 5
    )as sub
on c.car_id = sub.car_id
where START_DATE >= '2022-08-01' and start_date <= '2022-10-31'
group by month, car_id
having records > 0
order by month, car_id desc