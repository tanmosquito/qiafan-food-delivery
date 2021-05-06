create table customer_address(
	id serial primary key,
	owner_id integer not null,
	country_id varchar not null,
	province_id varchar not null,
	city_id varchar not null,
	district_id varchar not null,
	street_id varchar not null,
	remain_address varchar not null,
	tag varchar not null,
	is_default boolean not null default false,
	DISABLED BOOLEAN DEFAULT FALSE,
CREATED_DATE_TIME TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
	LAST_MODIFIED_DATE_TIME TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
		DISABLED_DATE_TIME TIMESTAMP WITH TIME ZONE
);