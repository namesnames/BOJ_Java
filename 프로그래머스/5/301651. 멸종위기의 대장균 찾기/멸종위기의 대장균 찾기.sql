with recursive cte as(
    select id,parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select a.id, a.parent_id, b.generation + 1 as generation
    from ecoli_data as a
    inner join cte b
    on a.parent_id = b.id
    )

select count(generation) as "count", generation
from cte b
where b.id not in (select distinct parent_id
                    from ecoli_data
                    where parent_id is not null)
group by generation
order by generation
