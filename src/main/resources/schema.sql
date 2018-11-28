-- CREATE TABLE IF NOT EXISTS mirror_manager (
--   id BIGINT PRIMARY KEY AUTO_INCREMENT,
--   service_instance_id VARCHAR(36)
-- );
--
-- CREATE TABLE IF NOT EXISTS mirror (
--   id BIGINT PRIMARY KEY AUTO_INCREMENT,
--   mirror_manager BIGINT,
--   mirror_manager_key BIGINT,
--   mirror_name VARCHAR(255),
--   mirror_uri VARCHAR(255),
--   source_uri VARCHAR(255)
-- );
--
-- CREATE TABLE IF NOT EXISTS config_server_parameters (
--   id BIGINT PRIMARY KEY AUTO_INCREMENT,
--   mirror_manager BIGINT,
--   parameters VARCHAR(1000)
-- );


CREATE TABLE IF NOT EXISTS mirror_register (
  mirror BIGINT,
  mirror_requester BIGINT
);

CREATE TABLE IF NOT EXISTS mirror (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  mirror_name VARCHAR(255),
  mirror_uri VARCHAR(255),
  source_uri VARCHAR(255),
);

CREATE TABLE IF NOT EXISTS mirror_requester (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  service_instance_id VARCHAR(36)
);

CREATE TABLE IF NOT EXISTS config_server_parameters (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  mirror_requester BIGINT,
  parameters VARCHAR(1000)
);




create TABLE book (
  id     IDENTITY,
  title  VARCHAR(200)
);

create TABLE book_author (
  book INTEGER,
  author INTEGER
);

create table author (
  id IDENTITY,
  name VARchar(200)
);