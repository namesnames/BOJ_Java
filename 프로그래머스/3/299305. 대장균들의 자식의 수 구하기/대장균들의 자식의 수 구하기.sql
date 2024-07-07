# with sub as (select parent_id, count(parent_id) as cnt
# from ecoli_data
# group by parent_id
# having parent_id is not null
# )

# select id, ifnull(sub.cnt,0) as child_count
# from ecoli_data e
# left join sub
# on e.id = sub.parent_id
# order by e.id

with sub as (select parent_id, count(parent_id) as cnt
             from ecoli_data
             group by parent_id
             having parent_id is not null
             )

select e.id, ifnull(sub.cnt, 0) as child_count
from ecoli_data e
left join sub
on e.id = sub.parent_id
order by id