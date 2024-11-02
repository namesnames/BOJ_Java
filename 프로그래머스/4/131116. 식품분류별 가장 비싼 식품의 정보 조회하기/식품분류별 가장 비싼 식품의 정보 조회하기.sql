# with sub as (select max(price) as max_price
#              from food_product
#              where category in ("과자","국","김치","식용유")
#              group by category)

# select fp.category, sub.max_price, fp.product_name
# from food_product fp
# join sub
# on fp.price = sub.max_price
# order by fp.price desc
WITH sub AS (
    SELECT category, MAX(price) AS max_price
    FROM food_product
    WHERE category IN ("과자", "국", "김치", "식용유")
    GROUP BY category
)
SELECT fp.category, sub.max_price, fp.product_name
FROM food_product fp
JOIN sub
ON fp.category = sub.category AND fp.price = sub.max_price
ORDER BY sub.max_price DESC;
