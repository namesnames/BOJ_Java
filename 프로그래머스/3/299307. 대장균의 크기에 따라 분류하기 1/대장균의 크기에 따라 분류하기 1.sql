select id,
    case when size_of_colony > 1000 then "HIGH"
         when size_of_colony between 101 and 1000 then "MEDIUM"
         when size_of_colony <= 100 then "LOW"
    end as "SIZE"
from ecoli_data
order by id