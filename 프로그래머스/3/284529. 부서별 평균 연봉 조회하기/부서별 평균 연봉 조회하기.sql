with sub as (select dept_id, avg(sal) as sal
             from hr_employees
             group by dept_id
             )

select d.dept_id, d.dept_name_en, round(sub.sal,0) as avg_sal
from hr_department d
join sub
on d.dept_id = sub.dept_id
order by avg_sal desc
