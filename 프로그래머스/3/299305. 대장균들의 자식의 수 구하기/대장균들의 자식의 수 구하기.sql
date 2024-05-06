with child as(
    select parent_id, count(parent_id) as child_count
    from ecoli_data
    group by parent_id)
    
select a.id as "ID", ifnull(c.child_count,0) as "CHILD_COUNT"
from ecoli_data a 
left join child c
on a.id = c.parent_id
