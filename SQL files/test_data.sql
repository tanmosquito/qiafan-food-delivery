/*商户数据*/
insert into business as b(
account, password, business_name, phone, telephone, disabled, category_id,
opening_time, closing_time, last_login_ip,
disabled_date_time, address, delivery_cost, minimum_order
)
values (
'test_business', '75804184', '测试商户', '18565677021', '0755-23152262', false, 10,
'09:00:00', '20:00:00', '10.0.0.1', null, '深圳市南山区松坪村', 10, 0.0
) on conflict do nothing;

/*用户数据*/
insert into customer as c(
account, password, nickname, phone, gender, email
) values (
'test_customer', '123456', 'tester', '13888888888', 'MALE', 'tester@qiafan.com'
) on conflict do nothing;

/*快递员数据*/
insert into deliverier as d(
) on conflict do nothing;

/*优惠券池数据*/
insert into coupon_pool as cp(
) values (
) on conflict do nothing;

/*订单数据*/
insert into customer_delivery_order as cdo()
values () on conflict do nothing;