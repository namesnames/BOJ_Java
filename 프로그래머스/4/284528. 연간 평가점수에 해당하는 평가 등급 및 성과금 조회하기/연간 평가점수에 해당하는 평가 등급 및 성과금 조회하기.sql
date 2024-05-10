with sub as (
    select emp_no,
           case when avg(score) >= 96 then "S"
                when avg(score) >= 90 then "A"
                when avg(score) >= 80 then "B"
                else "C"
           end as grade,
            case when avg(score) >= 96 then 20
                 when avg(score) >= 90 then 15
                 when avg(score) >= 80 then 10
                 else 0
           end as rate
    from hr_grade
    group by emp_no
)

select sub.emp_no as emp_no , he.emp_name as emp_name, sub.grade,
       he.sal * sub.rate/100 as bonus
from hr_employees he
join sub
on he.emp_no = sub.emp_no
order by he.emp_no

