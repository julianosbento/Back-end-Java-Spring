--CREATE TABLE user (
--    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
--    name VARCHAR(30) NOT NULL,
--    email varchar(50) NOT NULL,
--    password text not null, 
--    constraint user_pk primary key (id),
--    constraint email_uk unique key (email)
--);

CREATE TABLE appointment (
    id BIGINT UNSIGNED not null auto_increment,
    date timestamp not null,
    user_id bigint unsigned not null,
    constraint appointment_pk primary key(id),
    foreign key user_fk (user_id) references USR_USUARIO (usr_id)
);{
