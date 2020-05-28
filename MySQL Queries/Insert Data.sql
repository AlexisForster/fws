drop table bookshelf;

select * from story;
Insert into story (summary, title, bookshelf_Id)
values ('Summary of story 1', 'Title of story 1', 1);

select * from bookshelf;
Insert into bookshelf (code, name)
values ('BS001', 'Bookshelf 1');

select * from story;
update story
set image_link = '..//assets//images//bookcovers//little-chief3.jpg' where id = 1;

select * from story;

select * from staff where staffname like '%Jerome%';