with sub as (
    select cart_id
    from cart_products
    where name = "Milk"
),  sub2 as(
    select cart_id
    from cart_products
    where name = "Yogurt")

select sub.cart_id
from sub
join sub2
where sub.cart_id = sub2.cart_id
order by cart_id