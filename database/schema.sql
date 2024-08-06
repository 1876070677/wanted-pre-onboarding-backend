create table company (
    company_id int not null auto_increment primary key,
    name varchar(64) not null,
    country varchar(64) not null,
    region varchar(64) not null
) default character set utf8 collate utf8_general_ci;
create table recruiting (
    recruiting_id int not null auto_increment primary key,
    company_id int not null,
    position varchar(32) not null,
    reward int not null,
    description varchar(255) not null,
    tech varchar(32) not null,
    foreign key (company_id) references company(company_id)
) default character set utf8 collate utf8_general_ci;
create table user (
    user_id varchar(64) not null primary key,
    name varchar(64) not null
) default character set utf8 collate utf8_general_ci;
create table submitting (
    recruiting_id int not null,
    user_id varchar(64) not null,
    foreign key (recruiting_id) references recruiting(recruiting_id),
    foreign key (user_id) references user(user_id),
    primary key (recruiting_id, user_id)
) default character set utf8 collate utf8_general_ci;