-- Create the database and connect to it.
connect 'jdbc:derby://localhost:1527/studentdb;create=true';

-- Add a user to the database, username dev, password dev
CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.user.dev','dev');

-- Grant all privileges to user dev
CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.database.fullAccessUsers','dev');

-- Disconnect from the newly created database
disconnect;

-- Reconnect to the newly created database as user dev
connect 'jdbc:derby://localhost:1527/studentdb;user=dev;password=dev';

-- Create tables
CREATE TABLE STUDENTS (STUDENT_ID ID BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL, FIRST_NAME VARCHAR(20), LAST_NAME VARCHAR(20), EMAIL VARCHAR(30), PRIMARY KEY (STUDENT_ID));
INSERT INTO STUDENTS (FIRST_NAME, LAST_NAME, EMAIL) VALUES ('Juan', 'Puente', 'ju@ju.com');
INSERT INTO STUDENTS (FIRST_NAME, LAST_NAME, EMAIL) VALUES ('Laura', 'Montecillo', 'lu@ju.com');
INSERT INTO STUDENTS (FIRST_NAME, LAST_NAME, EMAIL) VALUES ('Maria', 'Vargas', 'ma@ju.com');