insert into product_table
values(1000,'Apple iPhone 7 Plus, GSM Unlocked, 32GB - Rose Gold (Refurbished)');

insert into product_table
values(2000,'Dragon Quest XI Echoes of an Elusive Age: Edition of Light - PlayStation 4');

insert into order_table(id, order_status, create_date )
values(1000, 0, now());


insert into order_product(order_id, product_id)
values(1000, 1000);
insert into order_product(order_id, product_id)
values(1000, 2000);