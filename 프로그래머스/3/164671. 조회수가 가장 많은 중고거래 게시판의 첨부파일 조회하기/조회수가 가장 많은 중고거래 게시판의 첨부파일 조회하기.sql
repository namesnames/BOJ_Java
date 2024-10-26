-- 코드를 입력하세요
with sub as (select board_id 
             from used_goods_board
             order by views desc
             limit 1
            )

select concat("/home/grep/src/", sub.board_id,
              "/",ugf.file_id, file_name, file_ext)
              as FILE_PATH
from used_goods_file as ugf
join sub
on ugf.board_id = sub.board_id
order by ugf.file_id desc