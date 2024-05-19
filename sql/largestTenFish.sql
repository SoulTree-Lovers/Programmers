-- 가장 큰 물고기 10마리 구하기 --

select id, length
from fish_info
where length > 10
order by length desc, id
limit 10;