insert into project values('P000',null);
insert into project values('P101',null);
insert into project values('P201',null);
insert into project values('P301',null);
insert into project values('P401',null);

insert into department values('D000',null);
insert into department values('D101',null);
insert into department values('D201',null);
insert into department values('D301',null);
insert into department values('D401',null);

update department d set project_code_ref = 'P000' where d.department_code = 'D000';
update department d set project_code_ref = 'P101' where d.department_code = 'D101';
update department d set project_code_ref = 'P201' where d.department_code = 'D201';
update department d set project_code_ref = 'P301' where d.department_code = 'D301';
update department d set project_code_ref = 'P401' where d.department_code = 'D401';

update project p set department_code_ref = 'D000' where p.project_code =  'P000';
update project p set department_code_ref = 'D101' where p.project_code =  'P101';
update project p set department_code_ref = 'D201' where p.project_code =  'P201';
update project p set department_code_ref = 'D301' where p.project_code =  'P301';
update project p set department_code_ref = 'D401' where p.project_code =  'P401';

insert into employee values('E101','P101','D101');
insert into employee values('E201','P201','D201');
insert into employee values('E301','P301','D301');
insert into employee values('E401','P401','D401');
insert into employee values('E501','P401','D401');