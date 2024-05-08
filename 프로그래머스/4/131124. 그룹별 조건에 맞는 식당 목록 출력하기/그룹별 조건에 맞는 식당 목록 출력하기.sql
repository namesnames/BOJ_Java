select m.member_name, r.review_text, 
       date_format(r.review_date,"%Y-%m-%d") as review_date
from member_profile m
join
    (select member_id,sum(review_score) as total
     from rest_review
     group by member_id
     order by total desc 
     limit 1) as sub
join rest_review r
on sub.member_id = m.member_id and r.member_id = sub.member_id
order by review_date, r.review_text
