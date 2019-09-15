create table orders(

	order_id bigint not null auto_increment,
	commandNumber bigint not null,
	creationDate timestamp,
	modificationDate timestamp,
	primary key(order_id),
	unique index(commandNumber)

)