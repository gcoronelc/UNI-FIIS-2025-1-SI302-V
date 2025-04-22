

select * 
from EDUCA2..CURSO;
go


select cur_vacantes - cur_matriculados vacantes
from CURSO where cur_id=19;