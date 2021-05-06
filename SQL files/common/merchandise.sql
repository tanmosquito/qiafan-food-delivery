create table merchandise(
	id serial primary key,
	name varchar not null,
	ingredient_description varchar not null,
	unit varchar not null,
	about varchar,
	business_id integer not null,
	merchandise_category_id integer not null
);