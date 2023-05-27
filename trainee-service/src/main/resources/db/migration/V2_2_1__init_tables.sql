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

INSERT INTO stage_activity (id, stage_id, activity_type, code, description, link_to_ext_resource, start_datetime,
                            end_datetime)
VALUES (1, 2, 'WEBINAR', 'WB001', 'Введение в использование платформы', 'https://www.mosttrainee.com/webinars/intro',
        '2022-06-05 10:00:00', '2022-06-05 11:00:00'),
       (2, 3, 'TEST', 'Тест по русскому', 'Тест по русскому языку.',
        'https://www.mosttrainee.com/tests/basic-programming', '2022-01-02 14:00:00', '2022-01-02 15:00:00'),
       (3, 3, 'TEST', 'Тест по аналитике', 'Тест по методам анализа данных',
        'https://www.mosttrainee.com/tests/basic-programming', '2022-01-02 14:00:00', '2022-01-02 15:00:00'),
       (4, 3, 'TEST', 'Тест по граммотности', 'Тест по компютерной граммотности',
        'https://www.mosttrainee.com/tests/basic-programming', '2022-01-02 14:00:00', '2022-01-02 15:00:00'),
       (5, 4, 'WEBINAR', 'Обзор решения кейсов', 'Введение в использование кейс-платформы',
        'https://www.mosttrainee.com/webinars/intro', '2022-06-05 10:00:00', '2022-06-05 11:00:00'),
       (6, 4, 'CHALLENGE', 'Кейс Газпром', 'Спроектируйте новую систему трубопровода',
        'https://www.mosttrainee.com/challenges/restful-api-spring-boot', '2022-01-03 09:00:00', '2022-01-05 18:00:00'),
       (7, 5, 'WEBINAR', 'Устройство структур', 'Введение в структуру правительства москвы',
        'https://www.mosttrainee.com/webinars/intro', '2022-06-05 10:00:00', '2022-06-05 11:00:00'),
       (8, 6, 'INTERVIEW', 'Собес с наставником', 'Просто поговорите о жизни и ценностях',
        'https://www.mosttrainee.com/interviews/senior-developer', '2022-01-06 11:00:00', '2022-01-06 12:00:00');


insert into user_creds (id, username, password, user_type)
values (1, 'supervisor1', '$2a$12$NpTpjIoxBO2.u987gpbC/.SRqFwoTK8TAiMpQ40.g9dAAUCUDwxFK', 'SUPERVISOR');

insert into user_creds (id, username, password, user_type)
values (2, 'mentor1', '$2a$12$NpTpjIoxBO2.u987gpbC/.SRqFwoTK8TAiMpQ40.g9dAAUCUDwxFK', 'MENTOR');
insert into user_creds (id, username, password, user_type)
values (3, 'mentor2', '$2a$12$NpTpjIoxBO2.u987gpbC/.SRqFwoTK8TAiMpQ40.g9dAAUCUDwxFK', 'MENTOR');
insert into user_creds (id, username, password, user_type)
values (4, 'mentor3', '$2a$12$NpTpjIoxBO2.u987gpbC/.SRqFwoTK8TAiMpQ40.g9dAAUCUDwxFK', 'MENTOR');
insert into user_creds (id, username, password, user_type)
values (5, 'mentor4', '$2a$12$NpTpjIoxBO2.u987gpbC/.SRqFwoTK8TAiMpQ40.g9dAAUCUDwxFK', 'MENTOR');

INSERT INTO supervisors (id, last_name, first_name, middle_name, email, phone)
VALUES (1, 'Smith', 'John', 'James', 'jsmith@email.com', '555-1234');

INSERT INTO organization (id, name, info, supervisor_id)
VALUES (1, 'ABC Inc.', 'A company that specializes in manufacturing widgets.', 1);
INSERT INTO organization (id, name, info, supervisor_id)
VALUES (2, 'XYZ Corp.', 'A company that provides consulting services for small businesses.', 1);

INSERT INTO mentors (id, last_name, first_name, middle_name, organization_id, position, email, rating, is_qualified)
VALUES (2, 'Smith', 'John', 'Doe', 1, 'Manager', 'jsmith@abcinc.com', 4.5, true);
INSERT INTO mentors (id, last_name, first_name, middle_name, organization_id, position, email, rating, is_qualified)
VALUES (3, 'Johnson', 'Jane', '', 1, 'Senior Engineer', 'jjohnson@abcinc.com', 4.2, true);
INSERT INTO mentors (id, last_name, first_name, middle_name, organization_id, position, email, rating, is_qualified)
VALUES (4, 'Garcia', 'Maria', 'Elena', 2, 'Consultant', 'mgarcia@xyzcorp.com', 4.8, false);
INSERT INTO mentors (id, last_name, first_name, middle_name, organization_id, position, email, rating, is_qualified)
VALUES (5, 'Lee', 'David', '', 2, 'Consultant', 'dlee@xyzcorp.com', 4.0, true);


INSERT INTO address (id, city, street, building, flat, email, phone)
VALUES (1, 'Moscow', 'Tverskaya Street', '15', '25A', 'nkuznetsov@definc.com', '555-6789');
INSERT INTO address (id, city, street, building, flat, email, phone)
VALUES (2, 'Moscow', 'Arbat Street', '20', '30B', 'asokolov@definc.com', '555-4321');

INSERT INTO branches (id, name, info, address_id)
VALUES (1, 'Городская среда', 'Направление по развитию городской среды', 1);
INSERT INTO branches (id, name, info, address_id)
VALUES (2, 'Медиасфера', 'Направление по развитию медиасферы и внедрению новых инноваций', 2);

INSERT INTO internship_types (id, code, description, is_active)
VALUES (1, 'IT', 'Information Technology Internship', true);
INSERT INTO internship_types (id, code, description, is_active)
VALUES (2, 'HR', 'Human Resources Internship', true);

INSERT INTO application (id, name, description, requirement, work_time, internship_type_id, branch_id, type, start_date,
                         end_date, created_by, created_at, is_active)
VALUES (1, 'IT Internship Application', 'This is an application for an Information Technology Internship',
        'Requirements: Basic programming knowledge', 'Full-time', 1, 1, 'ON_SITE', '2023-01-01', '2023-06-23', 2,
        '2023-05-01', true);

INSERT INTO application (id, name, description, requirement, work_time, internship_type_id, branch_id, type, start_date,
                         end_date, created_by, created_at, is_active)
VALUES (2, 'HR Internship Application', 'This is an application for a Human Resources Internship',
        'Requirements: Good communication skills', 'Part-time', 2, 2, 'REMOTE', '2023-02-01', '2023-04-30', 3,
        '2023-05-01', true);

INSERT INTO application (id, name, description, requirement, work_time, internship_type_id, branch_id, type, start_date,
                         end_date, created_by, created_at, is_active)
VALUES (3, 'Marketing Internship Application', 'This is an application for a Marketing Internship',
        'Requirements: Experience with social media marketing', 'Full-time', 1, 1, 'HYBRID', '2023-03-01', '2023-08-31',
        4, '2023-05-01', true);