
INSERT INTO "modules"(name,link) VALUES ('Biblioteka','/library');
INSERT INTO "modules"(name,link) VALUES ('Świetlica','/croom');

INSERT INTO "genre"(name,english_name) VALUES ('liryka','lyric');
INSERT INTO "genre"(name,english_name) VALUES ('elegia','elegy');
INSERT INTO "genre"(name,english_name) VALUES ('hymn','hymn');
INSERT INTO "genre"(name,english_name) VALUES ('fraszka','epigram');
INSERT INTO "genre"(name,english_name) VALUES ('psalm','psalm');
INSERT INTO "genre"(name,english_name) VALUES ('oda','ode');
INSERT INTO "genre"(name,english_name) VALUES ('pieśń','song');
INSERT INTO "genre"(name,english_name) VALUES ('sonet','sonnet');
INSERT INTO "genre"(name,english_name) VALUES ('tren','threnody');
INSERT INTO "genre"(name,english_name) VALUES ('ballada','ballad');
INSERT INTO "genre"(name,english_name) VALUES ('epika','epic');
INSERT INTO "genre"(name,english_name) VALUES ('epos','epic poem');
INSERT INTO "genre"(name,english_name) VALUES ('powieść','novel');
INSERT INTO "genre"(name,english_name) VALUES ('satyra','satire');
INSERT INTO "genre"(name,english_name) VALUES ('legenda','legend');
INSERT INTO "genre"(name,english_name) VALUES ('opowiadanie','short story');
INSERT INTO "genre"(name,english_name) VALUES ('baśń','fairy tale');
INSERT INTO "genre"(name,english_name) VALUES ('bajka','fable');
INSERT INTO "genre"(name,english_name) VALUES ('dramat','drama');
INSERT INTO "genre"(name,english_name) VALUES ('dramat antyczny','ancient drama');
INSERT INTO "genre"(name,english_name) VALUES ('komedia','comedy');
INSERT INTO "genre"(name,english_name) VALUES ('tragedia','tragedy');
INSERT INTO "genre"(name,english_name) VALUES ('opera','opera');
INSERT INTO "genre"(name,english_name) VALUES ('nowela','novella');
INSERT INTO "genre"(name,english_name) VALUES ('epopeja','epic');
INSERT INTO "genre"(name,english_name) VALUES ('przypowieść','parable');
INSERT INTO "genre"(name,english_name) VALUES ('fantasy','fantasy');
INSERT INTO "genre"(name,english_name) VALUES ('science fiction','science fiction');
INSERT INTO "genre"(name,english_name) VALUES ('horror','horror');
INSERT INTO "genre"(name,english_name) VALUES ('kryminał','crime');
INSERT INTO "genre"(name,english_name) VALUES ('sensacja','sensation');
INSERT INTO "genre"(name,english_name) VALUES ('thriller','thriller');
INSERT INTO "genre"(name,english_name) VALUES ('literatura młodzieżowa','young adult literature');
INSERT INTO "genre"(name,english_name) VALUES ('literatura obyczajowa','social literature');
INSERT INTO "genre"(name,english_name) VALUES ('romans','romance');
INSERT INTO "genre"(name,english_name) VALUES ('literatura piękna','fine literature');
INSERT INTO "genre"(name,english_name) VALUES ('powieść historyczna','historical novel');
INSERT INTO "genre"(name,english_name) VALUES ('powieść przygodowa','adventure novel');
INSERT INTO "genre"(name,english_name) VALUES ('biografia','biography');
INSERT INTO "genre"(name,english_name) VALUES ('autobiografia','autobiography');
INSERT INTO "genre"(name,english_name) VALUES ('pamiętnik','diary');
INSERT INTO "genre"(name,english_name) VALUES ('reportaż','reportage');
INSERT INTO "genre"(name,english_name) VALUES ('finanse','finance');
INSERT INTO "genre"(name,english_name) VALUES ('psychologia','psychology');
INSERT INTO "genre"(name,english_name) VALUES ('historia','history');
INSERT INTO "genre"(name,english_name) VALUES ('medycyna','medicine');
INSERT INTO "genre"(name,english_name) VALUES ('fizyka','physics');
INSERT INTO "genre"(name,english_name) VALUES ('matematyka','mathematics');
INSERT INTO "genre"(name,english_name) VALUES ('filozofia','philosophy');
INSERT INTO "genre"(name,english_name) VALUES ('astronomia','astronomy');
INSERT INTO "genre"(name,english_name) VALUES ('biologia','biology');
INSERT INTO "genre"(name,english_name) VALUES ('ekologia','ecology');
INSERT INTO "genre"(name,english_name) VALUES ('polityka','politics');
INSERT INTO "genre"(name,english_name) VALUES ('opowiadania','stories');
INSERT INTO "genre"(name,english_name) VALUES ('powieści dla dzieci','novels for children');
INSERT INTO "genre"(name,english_name) VALUES ('opowieści dla młodszych dzieci','stories for younger children');
INSERT INTO "genre"(name,english_name) VALUES ('popularnonaukowa dziecięca','popular science for children');
INSERT INTO "genre"(name,english_name) VALUES ('wierszyki','rhymes');
INSERT INTO "genre"(name,english_name) VALUES ('piosenki','songs');
INSERT INTO "genre"(name,english_name) VALUES ('komiksy','comics');
INSERT INTO "genre"(name,english_name) VALUES ('poezja','poetry');
INSERT INTO "genre"(name,english_name) VALUES ('albumy','albums');
INSERT INTO "genre"(name,english_name) VALUES ('czasopisma','magazines');
INSERT INTO "genre"(name,english_name) VALUES ('ezoteryka','esotericism');
INSERT INTO "genre"(name,english_name) VALUES ('senniki','dream books');
INSERT INTO "genre"(name,english_name) VALUES ('horoskopy','horoscopes');
INSERT INTO "genre"(name,english_name) VALUES ('film','film');
INSERT INTO "genre"(name,english_name) VALUES ('kino','cinema');
INSERT INTO "genre"(name,english_name) VALUES ('telewizja','television');
INSERT INTO "genre"(name,english_name) VALUES ('hobby','hobby');
INSERT INTO "genre"(name,english_name) VALUES ('inne','other');
INSERT INTO "genre"(name,english_name) VALUES ('kulinaria','cuisine');
INSERT INTO "genre"(name,english_name) VALUES ('przepisy kulinarne','recipes');
INSERT INTO "genre"(name,english_name) VALUES ('militaria','military');
INSERT INTO "genre"(name,english_name) VALUES ('wojskowość','military affairs');
INSERT INTO "genre"(name,english_name) VALUES ('motoryzacja','automotive');
INSERT INTO "genre"(name,english_name) VALUES ('muzyka','music');
INSERT INTO "genre"(name,english_name) VALUES ('poradniki','guides');
INSERT INTO "genre"(name,english_name) VALUES ('religia','religion');
INSERT INTO "genre"(name,english_name) VALUES ('rozrywka','entertainment');
INSERT INTO "genre"(name,english_name) VALUES ('rękodzieło','handicraft');
INSERT INTO "genre"(name,english_name) VALUES ('sport','sport');
INSERT INTO "genre"(name,english_name) VALUES ('sztuka','art');
INSERT INTO "genre"(name,english_name) VALUES ('teatr','theatre');
INSERT INTO "genre"(name,english_name) VALUES ('turystyka','tourism');
INSERT INTO "genre"(name,english_name) VALUES ('mapy','maps');
INSERT INTO "genre"(name,english_name) VALUES ('atlasy','atlases');

insert into "users"(login, name, surname, role) values ('admin','Tomasz','Administracyjny','{"role": {"job":"administrator", "admin":true, "module":[]}}');
insert into "users"(login, name, surname, role) values ('BibAneta','Aneta','Biblioteczna','{"role": {"job":"bibliotekarz", "admin":false, "module":[1]}}');
insert into "users"(login, name, surname, role) values ('LanBartosz','Bartosz','Langare','{"role": {"job":"wychowawca świetlicy", "admin":false, "module":[2]}}');
insert into "users"(login, name, surname, role) values ('user','Krzysztof','Użyteczny','{"role": {"job":"student", "admin":false, "module":[]}}');


insert into asset (module_id) values (1);
insert into asset (module_id) values (1);
insert into asset (module_id) values (1);
insert into asset (module_id) values (1);
insert into asset (module_id) values (1);
insert into asset (module_id) values (1);


Insert into "author"(name) values ('Michael Dobbs');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
insert into "authors_of_book"(id_book, id_author) values (1,1);
Insert into "generes_of_book"(book_id,genere_id) values(1,53);
Insert into "generes_of_book"(book_id,genere_id) values(1,13);
Insert into "generes_of_book"(book_id,genere_id) values(1,19);
insert into "book_copy"(book_id, is_rented, date_added, asset_id) values (1,false,'2020-01-01',1);
insert into "book_copy"(book_id, is_rented, date_added, asset_id) values (1,false,'2020-01-01',2);
insert into "book_copy"(book_id, is_rented, date_added, asset_id) values (1,false,'2020-01-01',3);
insert into "book_copy"(book_id, is_rented, date_added, asset_id) values (1,false,'2020-01-01',4);
insert into "book_copy"(book_id, is_rented, date_added, asset_id) values (1,false,'2020-01-01',5);
insert into "book_copy"(book_id, is_rented, date_added, asset_id) values (1,false,'2020-01-01',6);
insert into "loans"(user_id, date_of_rental) values (2,'2020-03-03');
UPDATE "book_copy" SET  is_rented = true ,"loan_id"=1  WHERE id = 6;




Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');
Insert into "book_info"(isbn, book_title, published_year, publisher, virtual, cover, language, pages, description) values ('9788324026555','House of Cards Bezwzgledna gra o wladze',2015,'Społeczny Instytut Wydawniczy Znak',false,'https://ia802805.us.archive.org/view_archive.php?archive=/35/items/covers_0009/covers_0009_37.zip&file=0009377898.jpg','pl',416,'HOUSE OF CARDS - KTO ROZDAJE KARTY NA NAJWYZSZYCH SZCZEBLACH WLADZY?');


insert into "item_category"(name) values ('gra planszowa');
insert into "item_category"(name) values ('książka');
insert into "item_category"(name) values ('film');
insert into "item_category"(name) values ('kość');

insert into asset (module_id) values(2);
insert into asset (module_id) values(2);
insert into asset (module_id) values(2);
insert into asset (module_id) values(2);
insert into asset (module_id) values(2);
insert into asset (module_id) values(2);

insert into item(date_added,asset_id,description,keywords,name) values('2022-01-01',7,'gra','gra,planszowa,monopol','monopol-gra planszowa');
insert into item(date_added,asset_id,description,keywords,name) values('2022-01-01',8,'gra','gra,planszowa,monopol','monopol-gra planszowa');
insert into item(date_added,asset_id,description,keywords,name) values('2022-01-01',9,'gra','gra,planszowa,monopol','monopol-gra planszowa');
insert into item(date_added,asset_id,description,keywords,name) values('2022-01-01',10,'gra','gra,planszowa,monopol','monopol-gra planszowa');
insert into item(date_added,asset_id,description,keywords,name) values('2022-01-01',11,'gra','gra,planszowa,monopol','monopol-gra planszowa');
insert into item(date_added,asset_id,description,keywords,name) values('2022-01-01',12,'gra','gra,planszowa,monopol','monopol-gra planszowa');

insert into item_category_items(categories_id,items_id) values (1,1);
insert into item_category_items(categories_id,items_id) values (1,2);
insert into item_category_items(categories_id,items_id) values (1,3);
insert into item_category_items(categories_id,items_id) values (1,4);
insert into item_category_items(categories_id,items_id) values (1,5);
insert into item_category_items(categories_id,items_id) values (1,6);
insert into item_category_items(categories_id,items_id) values (3,2);
insert into item_category_items(categories_id,items_id) values (2,5);
insert into item_category_items(categories_id,items_id) values (2,3);

