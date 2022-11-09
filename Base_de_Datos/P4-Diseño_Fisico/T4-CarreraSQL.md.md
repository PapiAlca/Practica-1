# CARRERA SQL
1.- 
SELECT * FROM family_members;

2.-
SELECT name, species FROM family_members;

3.-
SELECT * FROM family_members WHERE species = 'dog';

4.-
SELECT * FROM family_members WHERE num_books_read > 190;

5.-
SELECT * FROM family_members WHERE num_books_read >= 180;

6.-
SELECT * FROM friends_of_pickles WHERE species = 'dog' AND height_cm < 45;

7.-
SELECT * FROM friends_of_pickles WHERE species = 'dog' OR height_cm < 45;

8.-
SELECT * FROM friends_of_pickles WHERE species NOT IN ('cat', 'dog');

9.-
SELECT DISTINCT species FROM friends_of_pickles WHERE height_cm > 50;

10.-
SELECT * FROM friends_of_pickles ORDER BY height_cm DESC;

11.-
SELECT * FROM friends_of_pickles ORDER BY height_cm DESC LIMIT 1;

12.-
SELECT COUNT(*) FROM friends_of_pickles;

13.-
SELECT COUNT(*) FROM friends_of_pickles WHERE species = 'dog';

14.-
SELECT SUM(num_books_read) FROM family_members;

15.-
SELECT AVG(num_books_read) FROM family_members;

16.-
SELECT MAX(num_books_read) FROM family_members;

17.-
SELECT MAX(height_cm), species FROM friends_of_pickles GROUP BY species;

18.-
SELECT * FROM family_members WHERE num_books_read = (SELECT MAX(num_books_read) FROM family_members);

19.-
SELECT  * FROM family_members WHERE favorite_book NOT NULL;

20.-
SELECT * FROM celebs_born WHERE birthdate > '1980-09-01';

21.-
SELECT character.name, character_actor.actor_name
FROM character
INNER JOIN character_actor
ON character_actor.character_id = character.id;

22.-


23.-

24.-

25.-

26.-

27.-

28.-

29.-

30.-

31.-