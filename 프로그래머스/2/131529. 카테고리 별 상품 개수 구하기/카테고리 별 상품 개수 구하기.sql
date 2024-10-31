with sub as (select product_id, substring(product_code,1,2) as code
             from product)
             
select sub.code as category, count(sub.product_id) as products
from sub
group by category
order by category