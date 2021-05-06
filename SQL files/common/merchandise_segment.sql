create table merchandise_segment(
	id serial primary key,
	is_subject boolean not null default false,
	merchandise_id integer not null,
	merchandise_segment_name varchar not null,
	price float not null default 0.00,
	inventory integer not null default 0,
	discount float default 1.00
);