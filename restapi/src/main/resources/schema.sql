create table project(project_code varchar(128) not null, primary key(project_code));
create table department(department_code varchar(128) not null, primary key(department_code));
create table employee(employee_code varchar(128) not null, primary key(employee_code));

alter table project add column department_code_ref varchar(128);
alter table department add column project_code_ref varchar(128);
alter table employee add column project_code_ref varchar(128);
alter table employee add column department_code_ref varchar(128);

alter table project add constraint fk_deptcode FOREIGN KEY(department_code_ref) references department(department_code);
alter table department add constraint fk_projectcode FOREIGN KEY(project_code_ref) references project(project_code);
alter table employee add constraint fk_deptcode_1 FOREIGN KEY(department_code_ref) references department(department_code);
alter table employee add constraint fk_projectcode_1 FOREIGN KEY(project_code_ref) references project(project_code);
