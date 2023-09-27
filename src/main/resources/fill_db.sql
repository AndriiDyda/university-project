insert into t_lector(name,salary,degree)
values ('Ronald Black',1200,'ASSISTANT');
insert into t_lector(name,salary,degree)
values ('John Smith',1400,'ASSISTANT');
insert into t_lector(name,salary,degree)
values ('Antonio Silva',2750,'ASSOCIATE_PROFESSOR');
insert into t_lector(name,salary,degree)
values ('David Bennett',6000,'ASSISTANT');
insert into t_lector(name,salary,degree)
values ('Gabriel Collins',4330,'ASSOCIATE_PROFESSOR');
insert into t_lector(name,salary,degree)
values ('Marcus Allen',1500,'PROFESSOR');
insert into t_lector(name,salary,degree)
values ('Bernardo Carter',5850,'PROFESSOR');

insert into t_department(name,head_of_department_id)
values ('Hardware',3);
insert into t_department(name,head_of_department_id)
values ('Development',5);

insert into lector_department(lector_id,department_id)
values (1,1);
insert into lector_department(lector_id,department_id)
values (1,2);
insert into lector_department(lector_id,department_id)
values (2,2);
insert into lector_department(lector_id,department_id)
values (3,1);
insert into lector_department(lector_id,department_id)
values (4,1);
insert into lector_department(lector_id,department_id)
values (5,2);
insert into lector_department(lector_id,department_id)
values (6,2);
insert into lector_department(lector_id,department_id)
values (7,1);
insert into lector_department(lector_id,department_id)
values (7,2);