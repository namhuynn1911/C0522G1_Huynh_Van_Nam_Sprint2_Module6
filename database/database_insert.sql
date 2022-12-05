use project_spring2_6;

-- add usename
insert into user (username, password, is_delete) values ('customer1', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC', 0);
insert into user (username, password, is_delete) values ('customer2', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC', 0);
insert into user (username, password, is_delete) values ('wkleinhausen2', '$2a$10$pZNW3zOtmMXwvWeWmRZYxeSbhRKvZE20dxWKQIX2SGlOTXKCBGfJC', 0);


-- add customer
insert into customer (id, name, gender, email, address, phone_number, username, id_card, day_of_birth, is_delete) values (1, 'Huỳnh Văn nam', 1, 'namhuynh191193@gmail', 'Quảng Nam', '0909850091', 'customer1', '578856430', '1993-11-19', 0);
insert into customer (id, name, gender, email, address, phone_number, username, id_card, day_of_birth, is_delete) values (2, 'Nguyễn Văn phúc', 1, 'phuc@gmail', 'Nghệ An', '0909850091', 'customer2', '578856430', '1998-11-19', 0);

-- add role

INSERT INTO `role` (`id`, `is_delete`, `name`) VALUES ('1', 0, 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `is_delete`, `name`) VALUES ('2', 0, 'ROLE_EMPLOYEE');
INSERT INTO `role` (`id`, `is_delete`, `name`) VALUES ('3', 0, 'ROLE_CUSTOMER');

-- add product

insert into product_type(name) 
value
('Vợt cầu lông'),
('Giày cầu lông'),
('Phụ kiện khác');

-- add producer
insert into producer(name) 
value
('Yonex'),
('Li-Ning'),
('Adidas'),
('Mizuno');

-- add product

insert into product (name, image, date_of_manufacture, price, promotion, content, producer_id, product_type_id, is_delete) values ('Yonex 88d pro', 'https://ptshop.vn/wp-content/uploads/2021/03/ax88d-p-193.jpg', '2020-12-10', 400000, 'giảm giá 33%', 'Công nghệ carbon giúp trãi nghiệm tốt hơn, nhẹ hơn,mạnh mẽ cho việc công', 1, 1, 0);
insert into product (name, image, date_of_manufacture, price, promotion, content, producer_id, product_type_id, is_delete) values ('Yonex 88s pro', 'https://thegioithethao.vn/images/products/2021/10/14/large/vot-cau-long-astrox-88s-pro_1634185023.png', '2020-12-10', 450000, 'giảm giá 33%', 'Công nghệ carbon giúp trãi nghiệm tốt hơn, nhẹ hơn,công thủ toàn diện', 1, 1, 0);
insert into product (name, image, date_of_manufacture, price, promotion, content, producer_id, product_type_id, is_delete) values ('Li-Ning 900i', 'https://lzd-img-global.slatic.net/g/p/ac3d695b3fd9cf2b13c35954af3a531c.jpg_720x720q80.jpg', '2021-09-29', 350000, 'giảm giá 20%', 'Công nghệ hiện đại nhất cho dòng vợt hiện nay, được tuyển thủ Lindan sử dụng thường xuyên', 2, 1, 0);
insert into product (name, image, date_of_manufacture, price, promotion, content, producer_id, product_type_id, is_delete) values ('JPX V-Edition', 'https://hvshop.vn/wp-content/uploads/2022/09/Mizuno-jpx-limited-edition-speed-600x745.jpg', '2019-09-29', 400000, 'giảm giá 10%', 'Là mẫu được đánh giá là mạnh mẽ nhất cảu dòng vợt Mizuno, được tuyển thủ Watanabe yêu thích sử dụng', 4, 1, 0);
insert into product (name, image, date_of_manufacture, price, promotion, content, producer_id, product_type_id, is_delete) values ('Adidas Spieler E07.1', 'https://meta.vn/Data/image/2021/04/22/spieler-e07-1-matte-silver-1.jpg', '2021-09-29', 400000, 'giảm giá 30%', 'Là mẫu được đánh giá là mạnh mẽ nhất cảu dòng vợt Mizuno, được tuyển thủ Watanabe yêu thích sử dụng', 3, 1, 0);

