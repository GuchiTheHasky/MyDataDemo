create sequence if not exists data_id_sequence;

create table if not exists myData
(
    id integer default nextval('data_id_sequence'::regclass) not null primary key,
    bytes bytea,
    modify_at timestamp
);
