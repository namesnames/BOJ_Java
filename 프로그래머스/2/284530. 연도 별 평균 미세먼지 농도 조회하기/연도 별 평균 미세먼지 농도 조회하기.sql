select YEAR(YM) as YEAR, round(avg(PM_VAL1),2) as PM10, 
                        round(avg(PM_VAL2),2) as "PM2.5"
from air_pollution
where location2 = "수원"
group by YEAR
order by YEAR 

# DATE_FORMAT은 문자열로 반환
# YEAR 정수로 반환