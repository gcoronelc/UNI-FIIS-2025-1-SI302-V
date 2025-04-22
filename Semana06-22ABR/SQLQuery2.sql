

select count(1) cont from ALUMNO
where alu_id = 1;
go

select cur_vacantes, cur_matriculados 
from CURSO where cur_id = 1;
go


select cur_precio 
from CURSO where cur_id = 1;
go

select * from curso
where cur_id =0;
go

update curso 
set cur_matriculados = cur_matriculados + 1
where cur_id = ?
go


select * from curso where cur_id = 6;
select * from matricula where cur_id = 6;
go


insert into matricula(cur_id,alu_id,emp_id,mat_tipo,mat_fecha,mat_precio,mat_cuotas,mat_nota)
values(?,?,?,?,GETDATE(),?,?,?);
go



