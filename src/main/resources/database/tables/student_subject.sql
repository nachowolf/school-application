create table student_subject(
id serial not null primary key,
student_id int not null,
subject_id int not null,
foreign key (student_id) references student(student_id),
foreign key (subject_id) references subject(subject_id)
);