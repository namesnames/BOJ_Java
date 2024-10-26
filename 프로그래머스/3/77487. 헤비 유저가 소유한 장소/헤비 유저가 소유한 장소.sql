with sub as (select host_id
             from places
             group by host_id
             having count(host_id) >= 2
            )

select places.id, places.name, places.host_id
from places
join sub
on places.host_id = sub.host_id
order by places.id