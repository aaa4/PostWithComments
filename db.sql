/*drop schema public cascade;
create schema public;
*/

drop table post cascade ;
drop table comment cascade ;

create table post(
  id serial not null primary key ,
  content text,
  description varchar(250)



);

create table comment(
  id serial not null primary key ,
  content text,
  post_id integer,
  constraint fk_post
  foreign key (post_id)
    references post(id)
