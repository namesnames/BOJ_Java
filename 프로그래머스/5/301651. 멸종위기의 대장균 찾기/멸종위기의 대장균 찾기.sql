with recursive cte as(
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, 1 + c.generation as generation
    from ecoli_data e
    join cte c
    on e.parent_id = c.id
)

select count(*) as "count", generation
from cte
where id not in (select parent_id
                 from cte
                 where parent_id is not null)
group by generation
order by generation