select count(fi.fish_type) as fish_count
from fish_info fi
join fish_name_info fni
on fi.fish_type = fni.fish_type
where fni.fish_name = "BASS" or fni.fish_name = "SNAPPER"