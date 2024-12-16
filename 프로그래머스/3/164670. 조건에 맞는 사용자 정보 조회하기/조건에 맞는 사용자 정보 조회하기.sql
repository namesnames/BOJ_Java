with sub as (select writer_id
             from used_goods_board
             group by writer_id
             having count(writer_id) >= 3)
             
select user_id, nickname, 
       concat(city," ",ugu.street_address1," ",ugu.street_address2) as "전체주소",
       concat(substring(ugu.tlno,1,3),"-", substring(ugu.tlno,4,4),"-",
              substring(ugu.tlno,8,4)) as "전화번호"
from sub
join used_goods_user ugu
on sub.writer_id = ugu.user_id
order by user_id desc
