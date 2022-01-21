-- 1. display full addresses from locations table in a single column
select STREET_ADDRESS||' '||POSTAL_CODE||' '||CITY||' '||COUNTRY_ID as FULL_ADDRESS
from LOCATIONS;
-- 2. display all information of the employee who has the minimum salary in employees table
-- 3. display the second minimum salary from the employees
-- 4. display all information of the employee who has the second minimum salary
-- 5. list all the employees who are making above the average salary;
-- 6. list all the employees who are making less than the average salary
-- 7. display manager name of 'Neena'
select * from employees;

select FIRST_NAME from EMPLOYEES
where EMPLOYEE_ID=(select MANAGER_ID from EMPLOYEES
where FIRST_NAME='Neena');
-- 8. find the 3rd maximum salary from the employees table (do not include duplicates)
-- 9. find the 5th maximum salary from the employees table (do not include duplicates)
-- 10. find the 7th maximum salary from the employees table (do not include duplicates)
-- 11. find the 10th maximum salary from the employees table (do not include duplicates)
-- 12. find the 3rd minimum salary from the employees table (do not include duplicates)
-- 13. find the 5th minimum salary from the employees table (do not include duplicates)
-- 14. find the 7th maximum salary from the employees table (do not include duplicates)
-- 15. find the 10th maximum salary from the employees table (do not include duplicates)