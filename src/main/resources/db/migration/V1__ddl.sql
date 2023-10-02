create table if not exists song
(
    song_id     serial not null primary key,
    name        text,
    artist      text,
    album       text,
    length      text,
    resource_id int    not null,
    year        int
);
