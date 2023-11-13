insert into member (id) values (999);

insert into stock (id, current_price, low_price, high_price, name) values (9999, 1000, 800, 1200, 'Apple');
insert into stock (id, current_price, low_price, high_price, name) values (9998, 3000, 3000, 3000, 'Google');
insert into stock (id, current_price, low_price, high_price, name) values (9997, 10000, 8000, 10000, 'Nvidia');
insert into stock (id, current_price, low_price, high_price, name) values (9996, 200, 100, 220, 'Amazon');
insert into stock (id, current_price, low_price, high_price, name) values (9995, 2000, 2200, 2300, 'Meta');
insert into stock (id, current_price, low_price, high_price, name) values (9994, 100, 50, 100, 'Uber');

insert into trade (id, is_traded, price, quantity, stock_id) values (99999, false, 1000, 10000, 9999);
insert into trade (id, is_traded, price, quantity, stock_id) values (99998, false, 3000, 10000, 9998);
insert into trade (id, is_traded, price, quantity, stock_id) values (99997, false, 10000, 10000, 9997);
