DROP TABLE IF EXISTS Departments;
DROP TABLE IF EXISTS Employees;
DROP TABLE IF EXISTS Salaries;
DROP TABLE IF EXISTS payrolls;

CREATE TABLE Departments (
                             id varchar(36) PRIMARY KEY,
                             name VARCHAR(255) NOT NULL
);
CREATE TABLE Employees (
                           id varchar(36) PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           address TEXT,
                           phone VARCHAR(15),
                           email VARCHAR(255) UNIQUE,
                           department_id varchar(36),
                           FOREIGN KEY (department_id) REFERENCES Departments(id)
);
CREATE TABLE Salaries (
                          id varchar(36) PRIMARY KEY,
                          employee_id varchar(36),
                          base_salary bigint NOT NULL,
                          FOREIGN KEY (employee_id) REFERENCES Employees(id)
);
CREATE TABLE Payrolls (
                          id varchar(36) PRIMARY KEY,
                          employee_id varchar(36),
                          salary_id varchar(36),
                          pay_date DATE NOT NULL,
                          bonus bigint DEFAULT 0,
                          total bigint,
                          FOREIGN KEY (employee_id) REFERENCES Employees(id),
                          FOREIGN KEY (salary_id) REFERENCES Salaries(id)
);