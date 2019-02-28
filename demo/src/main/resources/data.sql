insert into product_table
values(1,'Apple iPhone 7 Plus, GSM Unlocked, 32GB - Rose Gold (Refurbished)');

insert into product_table
values(2,'Dragon Quest XI Echoes of an Elusive Age: Edition of Light - PlayStation 4');

insert into order_table(id, order_status, create_date )
values(1, 0, now());


insert into order_product(order_id, product_id)
values(1, 1);
insert into order_product(order_id, product_id)
values(1, 2);