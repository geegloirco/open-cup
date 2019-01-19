DROP DATABASE IF EXISTS opencup_db;
CREATE DATABASE opencup_db;

DROP TABLE IF EXISTS country;
create table country (
  id SERIAL PRIMARY KEY,
  title VARCHAR(128),
  phoneCode VARCHAR(10)
);

DROP TABLE IF EXISTS province;
create table province (
  id SERIAL PRIMARY KEY,
  country_id INT,
  title VARCHAR(128),
  CONSTRAINT fk_province_country FOREIGN KEY (country_id) REFERENCES country (id)
);

DROP TABLE IF EXISTS city;
create table city (
  id SERIAL PRIMARY KEY,
  country_id INT,
  province_id INT,
  title VARCHAR(128),
  phoneCode VARCHAR(10),
  CONSTRAINT fk_city_country FOREIGN KEY (country_id) REFERENCES country (id),
  CONSTRAINT fk_city_province FOREIGN KEY (province_id) REFERENCES province (id)
);

DROP TABLE IF EXISTS users;
create table users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(128),
  mail VARCHAR(128),
  mobile VARCHAR(11),
  password VARCHAR(128),
  image VARCHAR(128),
  enter_date timestamp NOT NULL,
  CONSTRAINT uk_user_mail UNIQUE (mail),
  CONSTRAINT uk_user_mobile UNIQUE (mobile)
);

DROP TABLE IF EXISTS user_info;
create table user_info (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL UNIQUE,
  first_name VARCHAR(40),
  last_name VARCHAR(40),
  full_name VARCHAR(80),
  national_code VARCHAR(10),
  birthdate CHAR(10),
  age INT,
  CONSTRAINT fk_user_info_user FOREIGN KEY (user_id) REFERENCES users (id)
);