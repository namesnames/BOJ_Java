# select 
#     case when date_format(differentiation_date, "%m") in ("01","02","03") then '1Q'
#          when date_format(differentiation_date, "%m") in ("04","05","06") then '2Q'
#          when date_format(differentiation_date, "%m") in ("07","08","09") then '3Q'
#          when date_format(differentiation_date, "%m") in ("10","11","12") then '4Q'
#     end as quarter
#     , count(*) as ecoli_count
#     from ecoli_data
#     group by quarter
#     order by quarter

select case when month(differentiation_date) in (1,2,3) then '1Q'
            when month(differentiation_date) in (4,5,6) then '2Q'
            when month(differentiation_date) in (7,8,9) then '3Q'
            when month(differentiation_date) in (10,11,12) then '4Q'
            end as quarter, count(*) as ecoli_count
from ecoli_data
group by quarter
order by quarter