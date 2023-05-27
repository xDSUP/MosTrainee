INSERT INTO stage_scheduler (id, code, description, start_date, end_date, active)
VALUES (1, 'RECRUITMENT', 'Сбор заявок на стажировку', '2023-05-01', '2023-06-04', false),
       (2, 'CAREER_WEEK', 'Неделя карьеры', '2023-06-05', '2023-06-11', false),
       (3, 'TEST_WEEK', 'Неделя тестирования', '2023-06-12', '2023-06-18', false),
       (4, 'CASE_CHAMPIONSHIP', 'Кейс-чемпионат', '2023-06-19', '2023-06-25', false),
       (5, 'EMPLOYERS_MARATHON', 'Марафон работодателей', '2023-06-26', '2023-07-02', false),
       (6, 'INTERNSHIP_CHOICE', 'Выбор стажировки', '2023-07-03', '2023-07-09', false),
       (7, 'INTERNSHIP_1', 'Первый этап стажировки', '2023-07-10', '2023-09-09', false),
       (8, 'INTERNSHIP_2', 'Второй этап стажировки', '2023-09-10', '2023-11-09', false),
       (9, 'INTERNSHIP_3', 'Третий этап стажировки', '2023-11-10', '2024-02-01', false);

INSERT INTO stage_activity (id, stage_id, activity_type, code, description, link_to_ext_resource, start_datetime, end_datetime)
VALUES (1, 2, 'WEBINAR', 'WB001', 'Введение в использование платформы', 'https://www.mosttrainee.com/webinars/intro', '2022-06-05 10:00:00', '2022-06-05 11:00:00'),
       (2, 3, 'TEST', 'Тест по русскому', 'Тест по русскому языку.', 'https://www.mosttrainee.com/tests/basic-programming', '2022-01-02 14:00:00', '2022-01-02 15:00:00'),
       (3, 3, 'TEST', 'Тест по аналитике', 'Тест по методам анализа данных', 'https://www.mosttrainee.com/tests/basic-programming', '2022-01-02 14:00:00', '2022-01-02 15:00:00'),
       (4, 3, 'TEST', 'Тест по граммотности', 'Тест по компютерной граммотности', 'https://www.mosttrainee.com/tests/basic-programming', '2022-01-02 14:00:00', '2022-01-02 15:00:00'),
       (5, 4, 'WEBINAR', 'Обзор решения кейсов', 'Введение в использование кейс-платформы', 'https://www.mosttrainee.com/webinars/intro', '2022-06-05 10:00:00', '2022-06-05 11:00:00'),
       (6, 4, 'CHALLENGE', 'Кейс Газпром', 'Спроектируйте новую систему трубопровода', 'https://www.mosttrainee.com/challenges/restful-api-spring-boot', '2022-01-03 09:00:00', '2022-01-05 18:00:00'),
       (7, 5, 'WEBINAR', 'Устройство структур', 'Введение в структуру правительства москвы', 'https://www.mosttrainee.com/webinars/intro', '2022-06-05 10:00:00', '2022-06-05 11:00:00'),
       (8, 6, 'INTERVIEW', 'Собес с наставником', 'Просто поговорите о жизни и ценностях', 'https://www.mosttrainee.com/interviews/senior-developer', '2022-01-06 11:00:00', '2022-01-06 12:00:00');
