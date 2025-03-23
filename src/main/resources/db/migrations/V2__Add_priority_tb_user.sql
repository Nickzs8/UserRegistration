-- V2: Migration to add priority column in user table

ALTER TABLE tb_user
ADD COLUMN priority INT NOT NULL DEFAULT 3;

ALTER TABLE tb_user
ADD CONSTRAINT check_priority CHECK (priority BETWEEN 0 AND 3);