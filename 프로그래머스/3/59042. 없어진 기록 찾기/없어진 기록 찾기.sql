-- 코드를 입력하세요
SELECT b.animal_id, b.name
from animal_ins a
,animal_outs b
where b.animal_id = a.animal_id(+)
and a.animal_id is null
order by b.animal_id