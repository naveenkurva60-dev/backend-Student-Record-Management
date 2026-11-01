-- =========================================================
-- Schema for Student Internship Application Management System
-- =========================================================

CREATE DATABASE IF NOT EXISTS student_internship_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE student_internship_db;

CREATE TABLE IF NOT EXISTS internship_applications (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  student_name VARCHAR(255) NOT NULL,
  roll_number VARCHAR(100) NOT NULL,
  company_name VARCHAR(255) NOT NULL,
  status VARCHAR(100) NOT NULL
);
