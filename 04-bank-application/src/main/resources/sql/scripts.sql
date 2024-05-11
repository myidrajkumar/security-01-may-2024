--Postgres Only

--DB Creation
CREATE DATABASE bankingdb
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'

--Schema Creation
CREATE SCHEMA IF NOT EXISTS users_schema
    AUTHORIZATION postgres;

--Tables Creation

-- 1. Users
CREATE SEQUENCE IF NOT EXISTS users_schema.users_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE users_schema.users_id_seq
    OWNED BY users_schema.users.id;

ALTER SEQUENCE users_schema.users_id_seq
    OWNER TO postgres;
    
CREATE TABLE IF NOT EXISTS users_schema.users
(
    id integer NOT NULL DEFAULT nextval('users_schema.users_id_seq'::regclass),
    username character varying(45) NOT NULL,
    password character varying(45) NOT NULL,
    enabled integer NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

ALTER TABLE IF EXISTS users_schema.users
    OWNER to postgres;

--2. Authorities
CREATE SEQUENCE IF NOT EXISTS users_schema.authorities_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE users_schema.authorities_id_seq
    OWNED BY users_schema.authorities.id;

ALTER SEQUENCE users_schema.authorities_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS users_schema.authorities
(
    id integer NOT NULL DEFAULT nextval('users_schema.authorities_id_seq'::regclass),
    username character varying(45) NOT NULL,
    authority character varying(45) NOT NULL,
    CONSTRAINT authorities_pkey PRIMARY KEY (id)
)

ALTER TABLE IF EXISTS users_schema.authorities
    OWNER to postgres;