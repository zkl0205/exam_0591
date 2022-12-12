

ALTER TABLE `exam_0591`.`test1_crime` 
ADD COLUMN `id` int NOT NULL AUTO_INCREMENT AFTER `start_date_time`,
ADD PRIMARY KEY (`id`);

SELECT t1.* from test1_crime t1 INNER JOIN (SELECT incident_id, MAX(id) id, COUNT(*) from test1_crime GROUP BY incident_id 
) t2 on  t1.id= t2.id

SELECT t1.* from test1_crime t1 INNER JOIN (SELECT incident_id, MAX(id) id, COUNT(*) from test1_crime GROUP BY incident_id 
) t2 on  t1.id= t2.id

DELETE from test1_crime WHERE id not in (SELECT id from (SELECT t1.id from test1_crime t1 INNER JOIN (SELECT incident_id, MAX(id) id from test1_crime GROUP BY incident_id 
) t2 on  t1.id= t2.id) t3)

ALTER TABLE `exam_0591`.`test1_crime` 
DROP COLUMN `id`,
DROP PRIMARY KEY;

ALTER TABLE `exam_0591`.`test1_crime` 
MODIFY COLUMN `incident_id` int(11) NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY (`incident_id`);
