

insert into dog 
	(n_me, gender, breed_id, akc_reg, ag_, fixed)
	values 
	('Jackie', 'f', 1, true, 0, false)
	returning id;


SELECT
	dog.id,
	dog.n_me AS dog_name,
	dog.gender,
	breed.breed_name AS breed,
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
    ON breed.id = dog.breed_id
    WHERE dog.id = 3
    
    
SELECT
	dog.id,
	dog.n_me AS dog_name,
	dog.gender,
	breed.breed_name AS breed,
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
    ON breed.id = dog.breed_id
    WHERE breed_size = 'XS'
    order by id


SELECT
	dog.id,
	dog.n_me AS dog_name,
	dog.gender,
	breed.breed_name AS breed,
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
    ON breed.id = dog.breed_id
    WHERE gender = 'f'
    order by id


SELECT
	dog.id,
	dog.n_me AS dog_name,
	dog.gender,
	breed.breed_name AS breed,
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
    ON breed.id = dog.breed_id;
      
