

insert into dog 
	(n_me, gender, breed, akc_reg, ag_, fixed)
	values 
	('Jackie', 'f', 'Akita', true, 0, false)
	returning id;


SELECT
	dog.id,
	dog.n_me AS dog_name,
	dog.gender,
	dog.breed,
	dog.akc_reg,
	dog.ag_ AS dog_age,
	dog.fixed,
	breed.breed_size,
	breed.breed_group,
	breed.active_lvl,
	breed.bark_amt,
	breed.coat_tp,
	breed.coat_lngth,
	breed.shedd,
	breed.train
	FROM dog 
	FULL OUTER JOIN breed 
    ON breed.breed_name = dog.breed
    WHERE breed_size = 'XS'
    order by id


SELECT
	dog.id,
	dog.n_me AS dog_name,
	dog.gender,
	dog.breed,
	dog.akc_reg,
	dog.ag_ AS dog_age,
	dog.fixed,
	breed.breed_size,
	breed.breed_group,
	breed.active_lvl,
	breed.bark_amt,
	breed.coat_tp,
	breed.coat_lngth,
	breed.shedd,
	breed.train
	FROM dog 
	FULL OUTER JOIN breed 
    ON breed.breed_name = dog.breed
    WHERE gender = 'f'
    order by id


SELECT
	dog.id,
	dog.n_me AS dog_name,
	dog.gender,
	dog.breed,
	dog.akc_reg,
	dog.ag_ AS dog_age,
	dog.fixed,
	breed.breed_size,
	breed.breed_group,
	breed.active_lvl,
	breed.bark_amt,
	breed.coat_tp,
	breed.coat_lngth,
	breed.shedd,
	breed.train
	FROM dog 
	FULL OUTER JOIN breed 
    ON breed.breed_name = dog.breed;
      
