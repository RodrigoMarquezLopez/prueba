CREATE DATABASE api_logs;

USE api_logs;

CREATE TABLE peticion_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at datetime(6),
    ip VARCHAR(45) NOT NULL
);