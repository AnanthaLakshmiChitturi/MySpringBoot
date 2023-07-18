
CREATE TABLE employees (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    job_start_date DATE,
    salary DOUBLE
);


alter table employees add department varchar(20);

-- Inserting data in employees table
INSERT INTO employees (first_name, last_name, job_start_date, salary, department) VALUES
('John', 'Doe', '2023-01-15', 60000, 'IT'),
('Jane', 'Smith', '2022-11-02', 55000, 'HR'),
('Michael', 'Johnson', '2023-02-28', 70000, 'Engineering'),
('Emily', 'Williams', '2022-09-20', 58000, 'Sales'),
('Robert', 'Brown', '2023-03-10', 62000, 'Finance'),
('Sarah', 'Miller', '2022-12-18', 56000, 'Engineering'),
('David', 'Taylor', '2023-01-05', 65000, 'Finance'),
('Olivia', 'Anderson', '2022-10-22', 59000, 'Engineering'),
('James', 'Martinez', '2023-02-15', 72000, 'Sales'),
('Sophia', 'Lee', '2022-11-30', 60000, 'Finance');


-- 3. Write a SQL query to find the highest salary from an "Employee" table.
        -- 1st method
SELECT MAX(salary) AS max_salary FROM employees;

	    -- 2nd method
SELECT first_name, last_name, salary AS max_salary FROM employees WHERE salary = (SELECT  MAX(salary) FROM employees);

        -- 3rd method
SELECT first_name, last_name, salary AS max_salary FROM employees WHERE salary IN (SELECT MAX(salary) FROM employees);

        -- 4th method
SELECT first_name, last_name, salary AS max_salary FROM employees ORDER BY salary DESC LIMIT 1;

        -- 5th method
SELECT e1.first_name, e1.last_name, e1.salary AS max_salary FROM employees e1 LEFT JOIN employees e2 ON e1.salary < e2.salary WHERE e2.salary IS NULL;


-- 4. write a query to find all the employees who joined in the last 6 months
SELECT * FROM employees WHERE job_start_date >= DATE_SUB(CURRENT_DATE, INTERVAL 6 MONTH);

-- 5. write a query display number of employees in each department.


-- 2.  Write a SQL query to update email_address on the consultant_detail table
UPDATE consultant_details SET email_address = 'new_email_address@example.com' WHERE consultant_id = 'CD001';

-- 3. Write a SQL to find total number of submissions for each constulant.
SELECT consultant_details.consultant_id,consultant_details.first_name AS consultant_first_name, consultant_details.last_name AS consultant_last_name,count(*) AS total_submission
FROM consultant_details JOIN submission ON (consultant_details.consultant_id = submission.consultant_id) GROUP BY consultant_details.consultant_id;

-- 4. Write a SQL to find total number of submissions for each constulant by each submission day
SELECT consultant_details.consultant_id,consultant_details.first_name AS consultant_first_name, consultant_details.last_name AS consultant_last_name,
count(*) AS total_submission,submission.submission_date
FROM consultant_details JOIN submission ON (consultant_details.consultant_id = submission.consultant_id) GROUP BY consultant_details.consultant_id,submission.submission_date;


-- 5. write a SQL to delete all submissions where "rate" is null
DELETE FROM submission WHERE pay_rate IS NULL;

-- 6. Given a lead name and submission date, Write a SQL query to find the submissions.
SELECT submission.* FROM submission JOIN consultant_details ON (submission.consultant_id=consultant_details.consultant_id)
JOIN lead_details ON (lead_details.lead_id=consultant_details.lead_id)
WHERE ( lead_details.first_name ="John" AND lead_details.last_name="Doe");

-- 7. Write a SQL query to find the number of submissions by each lead.
SELECT ld.lead_id,ld.first_name,ld.last_name, COUNT(s.submission_id) AS num_submissions FROM lead_details AS ld
LEFT JOIN consultant_details AS cd ON (ld.lead_id = cd.lead_id)
LEFT JOIN submission AS s ON (cd.consultant_id = s.consultant_id)
GROUP BY ld.lead_id;