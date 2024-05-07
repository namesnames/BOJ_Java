# 상품구매 년도/ 월/ 그 month에 몇 명이 구매? / 그게 전체중에 몇 프로?
# 전체 인원 수를 어떻게 가져오지

select year(sales_date) as year, month(sales_date) as month
        , count(distinct(o.user_id)) as puchased_users, 
          round(count(distinct(o.user_id))/sub.total,1) as PUCHASED_RATIO
from online_sale o
join(  # 2021년에 가입한 user_id들과 총 인원 같이 나옴
        select user_id, (select count(*) from user_info 
                         where joined like "2021-%") as total 
        from user_info
        where joined like "2021-%"
    ) as sub
on o.user_id = sub.user_id
group by year,month
order by year,month




