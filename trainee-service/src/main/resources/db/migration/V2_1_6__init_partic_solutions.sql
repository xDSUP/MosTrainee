INSERT INTO participant (id, last_name, first_name, middle_name, birth_date, nationality, status, citizenship, rating,
                         address_id, education_type, internship_id)
VALUES (1, 'Doe', 'John', 'Michael', '1995-01-01', 'RUSSIA', 'RELEVANT', 'RUSSIA', 8, 1, 'HIGHER', 1);

INSERT INTO participant (id, last_name, first_name, middle_name, birth_date, nationality, status, citizenship, rating,
                         address_id, education_type, internship_id)
VALUES (2, 'Smith', 'Jane', 'Elizabeth', '1998-05-17', 'RUSSIA', 'RELEVANT', 'RUSSIA', 7, 2, 'BACHELOR', 2);

INSERT INTO participant_solutions(id, participant_id, application_id, solution, comment, status, created_at, score)
VALUES (1, 1, 1, E'\x546869732069732061207465737420736F6C7574696F6E2E', 'This is a test solution.', 'INVITED',
        '2021-06-01', 90.5);

INSERT INTO participant_solutions (id, participant_id, application_id, solution, comment, status, created_at, score)
VALUES (2, 2, 2, E'\x5472656174652061206E657720736F6C7574696F6E2E', 'Create a new solution.', 'FAILURE', '2021-07-12',
        80.2);