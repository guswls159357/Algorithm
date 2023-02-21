SELECT o.animal_id AS animal_id, o.name AS name FROM animal_outs o
LEFT JOIN animal_ins i ON i.animal_id = o.animal_id
WHERE i.animal_type IS NULL
ORDER BY o.animal_id ASC;