INSERT into product_group (id, name) values (1, 'Food') ON CONFLICT DO NOTHING;
INSERT into product_group (id, name) values (2, 'Toys') ON CONFLICT DO NOTHING;
INSERT into product_group (id, name) values (3, 'Sports Gear') ON CONFLICT DO NOTHING;
