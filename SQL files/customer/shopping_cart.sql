create table shopping_cart(
id serial,
owner_id integer not null,
merchandise_id integer not null,
merchandise_name varchar not null,
merchandise_segment_id integer not null,
price money not null,
quantity integer not null default 1,
disabled boolean not null default false,
disabled_date_time timestamp with time zone,
created_date_time timestamp with time zone not null,
last_modified_date_time timestamp with time zone not null default now()
);