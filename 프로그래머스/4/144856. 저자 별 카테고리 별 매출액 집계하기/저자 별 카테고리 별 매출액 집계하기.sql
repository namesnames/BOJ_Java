with sub as (
    select book_id, sum(sales) as "count"
    from book_sales
    where sales_date like "2022-01-%"
    group by book_id)

select a.author_id, a.author_name, b.category, 
        sum((sub.count * b.price)) as total_sales
from book b
join author a on a.author_id = b.author_id
join sub on sub.book_id = b.book_id
group by a.author_id, b.category
order by a.author_id, b.category desc

