-- ===============================
-- DOCTOR DATA
-- ===============================
INSERT INTO doctor (name, specialization, email, joining_date)
VALUES
('Dr. Rajesh Sharma', 'Cardiology', 'rajesh@hospital.com', '2022-01-10'),
('Dr. Anjali Verma', 'Neurology', 'anjali@hospital.com', '2021-05-15'),
('Dr. Vikram Singh', 'Orthopedics', 'vikram@hospital.com', '2023-03-20');

-- ===============================
-- PATIENT DATA
-- ===============================
INSERT INTO patient (patient_name, gender, birth_date, email, blood_group, created_at)
VALUES
('Amit Kumar', 'Male', '1995-06-15', 'amit@gmail.com', 'A_POSITIVE', CURDATE()),
('Priya Sharma', 'Female', '1998-09-20', 'priya@gmail.com', 'B_POSITIVE', CURDATE()),
('Rohan Gupta', 'Male', '1992-12-05', 'rohan@gmail.com', 'O_POSITIVE', CURDATE());

-- ===============================
-- INSURANCE DATA
-- (id must match patient id for OneToOne)
-- ===============================
INSERT INTO insurance (id, policy_number, provider_company, valit_to, creation_date, patient)
VALUES
(1, 'POL12345', 'Star Health', '2027-12-31', CURDATE(), 1),
(2, 'POL67890', 'HDFC Ergo', '2026-10-15', CURDATE(), 2);

-- ===============================
-- DEPARTMENT DATA
-- ===============================
INSERT INTO department (id, name, created_at, head_doctor_id)
VALUES
(1, 'Cardiology', CURDATE(), 1),
(2, 'Neurology', CURDATE(), 2);

-- ===============================
-- DEPARTMENT <-> DOCTOR (ManyToMany)
-- ===============================
INSERT INTO dpt_doctor_table (dpt_id, dr_id)
VALUES
(1, 1),
(2, 2),
(1, 3);

-- ===============================
-- APPOINTMENT DATA
-- ===============================
INSERT INTO appointment (appointment_time, probleml, status, doctor, patient)
VALUES
('2026-03-01', 'Chest Pain', 'SCHEDULED', 1, 1),
('2026-03-02', 'Headache', 'COMPLETED', 2, 2),
('2026-03-03', 'Knee Injury', 'PENDING', 3, 3);