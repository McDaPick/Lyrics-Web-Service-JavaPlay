# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id                            integer auto_increment not null,
  username                      varchar(255),
  pass                          varchar(255),
  song                          varchar(255),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists user;

