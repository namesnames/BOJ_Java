select p.product_id, p.product_name, (p.price * sub.amount) as total_sales
from food_product p
join (select product_id, sum(amount) as amount
      from food_order
      where produce_date like "2022-05-%"
      group by product_id) as sub
on p.product_id = sub.product_id 
order by total_sales desc, p.product_id 
