SELECT * FROM (
SELECT history_id essay_id, title, content, history_sign essay_sign, record_time publish_time, 
home_show, '心路历程' classify, 'history' class_code, visitor_num, comment_num, praise_num, 'Silence' nikename FROM history LEFT JOIN 
statistic ON history.history_sign = statistic.pertain
UNION
SELECT message_id essay_id, '' title, content, message_sign essay_sign, message_time publish_time, 
home_show, '用户留言' classify,'message' class_code, 0 visitor_num, 
(SELECT COUNT(1) FROM message m1 WHERE m1.father_id = m2.message_id) comment_num, 0 praise_num, 
nikename FROM message m2 LEFT JOIN USER ON USER.user_sign = m2.user_sign WHERE user_sign = ''
UNION
SELECT opinion_id essay_id, title, content, opinion_sign essay_sign, publish_time, home_show, '分享生活' classify, 'opinion' class_code,
visitor_num, comment_num, praise_num, nikename FROM opinion LEFT JOIN USER ON USER.user_sign = opinion.publisher LEFT JOIN statistic ON
statistic.pertain = opinion.opinion_sign
UNION
SELECT technical_id essay_id, title, content, technical_sign essay_sign, publish_time, home_show, classify, 'technical' class_code,
visitor_num, comment_num, praise_num, nikename FROM technical LEFT JOIN USER ON USER.user_sign = technical.publisher LEFT JOIN statistic ON
statistic.pertain = technical.technical_sign ) essay ORDER BY publish_time DESC LIMIT 0, 30

SELECT SUM(num) num FROM (
SELECT COUNT(1) num FROM history
UNION ALL
SELECT COUNT(1) num FROM message
UNION ALL
SELECT COUNT(1) num FROM opinion
UNION ALL
SELECT COUNT(1) num FROM technical
) essayNum

UPDATE history SET home_show = 0 WHERE history_sign = '05c90db17911558fac3968b853e299cc';