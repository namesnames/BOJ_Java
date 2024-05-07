# 결과물에 ingredient_type을 써야하므로 where in sub가 아닌 join을 해야한다고 판단

select info.ingredient_type, sum(h.total_order) as total_order
from first_half h
join icecream_info info
on info.flavor = h.flavor
group by ingredient_type

