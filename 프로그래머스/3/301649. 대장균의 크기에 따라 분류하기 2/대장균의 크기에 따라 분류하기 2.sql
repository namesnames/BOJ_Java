# with percentage as (
#     select id, 
#             ntile(4) over(order by size_of_colony desc) as grade
#     from ecoli_data
# )

# select e.id,
#     case when p.grade = 1 then "CRITICAL"
#         when p.grade = 2 then "HIGH"
#         when p.grade = 3 then "MEDIUM"
#         when p.grade = 4 then "LOW"
#     end as COLONY_NAME
# from ecoli_data e
# inner join percentage p
# on e.id = p.id
# order by id
with sub as(
    select id, 
    ntile(4) over (order by size_of_colony desc) as grade
    from ecoli_data
)

select e.id, 
    case when sub.grade = 1 then "CRITICAL"
         when sub.grade = 2 then "HIGH"
         when sub.grade = 3 then "MEDIUM"
         when sub.grade = 4 then "LOW"
    end as colony_name
from ecoli_data e
join sub
on e.id = sub.id
order by e.id









