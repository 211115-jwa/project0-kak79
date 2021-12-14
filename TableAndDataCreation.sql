
drop table if exists dog cascade;
drop table if exists breed cascade;


create table if not exists breed (
	id serial unique not null primary key,
	breed_name varchar(50) not null,
	breed_size varchar(5) not null, -- XS, S, M, L, XL
	breed_group varchar(50) not null, -- pull list of groupss from AKC
	active_lvl varchar(50) not null, -- pull list of activity levelss from AKC
	bark_amt varchar(50) not null, -- pull list of barking levels from AKC
	coat_tp varchar(50) not null, -- pull list of coat types from AKC
	coat_lngth varchar(50) not null, -- S, M, L
	shedd varchar(50) not null, -- pull list of shedding from AKC
	train varchar(50) not null -- pull list of trainability from AKC
);
insert into breed
(breed_name, breed_size, breed_group, active_lvl, bark_amt, coat_tp, coat_lngth, shedd, train )
values
('Akita', 'L', 'Working Group', 'Regular Exercise', 'When Necessary', 'Double', 'Medium', 'Regularly', 'Agreeable'),
('Alaskan Malamute', 'L', 'Working Group', 'Regular Exercise', 'Medium', 'Double', 'Medium', 'Regularly', 'Agreeable'),
('Bichon Frise', 'S', 'Non-Sporting Group',  'Regular Exercise', 'Medium', 'Double', 'Long', 'Infrequent', 'Independent'),
('Chihuahua', 'XS', 'Toy Group',  'Energetic', 'Vocal', 'Smooth', 'Short', 'Infrequent', 'Eager To Please'),
('Great Dane', 'XL', 'Working Group',  'Regular Exercise', 'Medium', 'Smooth', 'Short', 'Infrequent', 'Agreeable'),
('Irish Wolfhound', 'XL', 'Hound Group', 'Energetic', 'When Necessary', 'Wiry', 'Medium', 'Occasional', 'Agreeable'),
('Scottish Terrier', 'M', 'Terrier Group', 'Regular Exercise', 'Frequent', 'Wiry', 'Medium', 'Occasional', 'Stubborn');


create table if not exists dog (
	id serial unique not null primary key,
	n_me varchar(50) not null, -- name of dog
	gender varchar(5) not null, -- m or f
	breed_id integer not null references breed, -- pull list of breeds from AKC
	akc_reg bool not null, -- true , false 
	ag_ int not null, -- 0-25
	fixed bool not null
);
INSERT INTO dog 
( n_me, gender, breed_id, akc_reg, ag_, fixed)
VALUES 
('Goldie', 'f', 4, false, 4, true),
('Tallia', 'f', 2, false, 6, false),
('Jill', 'f', 3, true, 5, true),
('Tricia', 'f', 6, true, 5, false),
('Gale', 'm', 5,  true, 1, true),
('Alexa', 'f', 3, false, 8, false),
('Benedict', 'm', 6,  false, 3, false),
('Sergent', 'm', 1, true, 4, true),
('Elonore', 'f',  7,  false, 6, false),
('Lewie', 'm',  4, false, 1, true);


COMMIT
