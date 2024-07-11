with sub as (select food_type, max(favorites) as favorites
             from rest_info
             group by food_type
             )
             
select r.food_type, r.rest_id, rest_name, r.favorites
from rest_info r
join sub
on (r.food_type = sub.food_type and r.favorites = sub.favorites)
order by food_type desc;