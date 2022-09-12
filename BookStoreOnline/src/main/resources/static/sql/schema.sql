create database book_store;
use book_store;
create table tbl_categories
(
    category_id   bigint auto_increment
        primary key,
    category_name varchar(255) null,
    constraint UK_qvot280kxf79jx56raqnm23ti
        unique (category_name)
);

create table tbl_books
(
    book_id           bigint auto_increment
        primary key,
    book_about        longtext     null,
    book_author       varchar(255) null,
    book_discount     double       null,
    book_image        varchar(255) null,
    book_language     varchar(255) null,
    book_name         varchar(255) null,
    book_price        double       null,
    book_publish_date date         null,
    book_publisher    varchar(255) null,
    book_quantity     int          null,
    book_category_id  bigint       null,
    constraint FK1oecvbd0v7cqqjwdk3an1qok4
        foreign key (book_category_id) references tbl_categories (category_id)
);

create table tbl_users
(
    user_id                bigint auto_increment
        primary key,
    user_address           varchar(255) null,
    user_email             varchar(255) null,
    user_enable            bit          null,
    user_full_name         varchar(255) null,
    user_password          varchar(255) null,
    user_phone             varchar(255) null,
    user_role              varchar(255) null,
    user_verification_code varchar(255) null
);

create table tbl_orders
(
    order_id               bigint auto_increment
        primary key,
    order_date             datetime     null,
    order_receiver_address varchar(255) null,
    order_receiver_name    varchar(255) null,
    order_receiver_phone   varchar(255) null,
    order_total_amount     double       null,
    user_id                bigint       null,
    constraint FKpppim1yc9udwxeam99pmiarh3
        foreign key (user_id) references tbl_users (user_id)
);

create table tbl_order_items
(
    item_id       bigint auto_increment
        primary key,
    book_id       bigint null,
    order_id      bigint null,
    item_quantity int    null,
    constraint FKc11h2kg9x4xu88d28ojvl5eje
        foreign key (book_id) references tbl_books (book_id),
    constraint FKi5qvuwu0gqfww50julf2kq3d7
        foreign key (order_id) references tbl_orders (order_id)
);
