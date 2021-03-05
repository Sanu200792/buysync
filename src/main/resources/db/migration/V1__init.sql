create table `item`
(
    `item_id`   nvarchar(25) not null,
    `item_name` nvarchar(255) not null,
    `nick_name` text default null,
    `unit`      nvarchar(25),
    primary key (`item_id`)
);

create table `item_quantity`
(
    `item_id`  nvarchar(25) not null,
    `quantity` double not null,
    primary key (`item_id`)
);

create table `buy`
(
    `buy_id`          nvarchar(100) not null,
    `item_id`         nvarchar(25) not null,
    `quantity`        double    not null,
    `expiry_date`     timestamp not null,
    `event_timestamp` timestamp not null,
    primary key (`buy_id`)
);

create table `use`
(
    `trans_id`        nvarchar(100) not null,
    `item_id`         nvarchar(100) not null,
    `used_weight`     double    not null,
    `current_weight`  double    not null,
    `event_timestamp` timestamp not null,
    primary key (`trans_id`)
);