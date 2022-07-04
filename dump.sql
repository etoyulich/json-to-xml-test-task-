--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: client; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA client;


ALTER SCHEMA client OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: clients; Type: TABLE; Schema: client; Owner: postgres
--

CREATE TABLE client.clients (
    name character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    patronymic character varying(255) DEFAULT ''::character varying,
    birth_date date NOT NULL,
    id integer NOT NULL,
    document_id integer NOT NULL,
    gender character varying(10) NOT NULL
);


ALTER TABLE client.clients OWNER TO postgres;

--
-- Name: documents; Type: TABLE; Schema: client; Owner: postgres
--

CREATE TABLE client.documents (
    series character varying(255) NOT NULL,
    number character varying(255) NOT NULL,
    issue_date date NOT NULL,
    type character varying(30) NOT NULL,
    id integer NOT NULL
);


ALTER TABLE client.documents OWNER TO postgres;

--
-- Name: documents_id_seq; Type: SEQUENCE; Schema: client; Owner: postgres
--

CREATE SEQUENCE client.documents_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client.documents_id_seq OWNER TO postgres;

--
-- Name: documents_id_seq; Type: SEQUENCE OWNED BY; Schema: client; Owner: postgres
--

ALTER SEQUENCE client.documents_id_seq OWNED BY client.documents.id;


--
-- Name: users_id_seq; Type: SEQUENCE; Schema: client; Owner: postgres
--

CREATE SEQUENCE client.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: client; Owner: postgres
--

ALTER SEQUENCE client.users_id_seq OWNED BY client.clients.id;


--
-- Name: clients id; Type: DEFAULT; Schema: client; Owner: postgres
--

ALTER TABLE ONLY client.clients ALTER COLUMN id SET DEFAULT nextval('client.users_id_seq'::regclass);


--
-- Name: documents id; Type: DEFAULT; Schema: client; Owner: postgres
--

ALTER TABLE ONLY client.documents ALTER COLUMN id SET DEFAULT nextval('client.documents_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: client; Owner: postgres
--

INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 1, 2, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 2, 3, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 3, 4, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 4, 5, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 5, 6, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 6, 7, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 7, 8, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 8, 9, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 9, 10, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 10, 11, 'MAN');
INSERT INTO client.clients (name, surname, patronymic, birth_date, id, document_id, gender) VALUES ('Тест', 'Тестов', 'Тестович', '1990-01-01', 11, 12, 'MAN');


--
-- Data for Name: documents; Type: TABLE DATA; Schema: client; Owner: postgres
--

INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 1);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 2);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 3);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 4);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 5);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 6);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 7);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 8);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 9);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 10);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 11);
INSERT INTO client.documents (series, number, issue_date, type, id) VALUES ('1333', '112233', '2020-01-01', 'PASSPORT', 12);


--
-- Name: documents_id_seq; Type: SEQUENCE SET; Schema: client; Owner: postgres
--

SELECT pg_catalog.setval('client.documents_id_seq', 12, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: client; Owner: postgres
--

SELECT pg_catalog.setval('client.users_id_seq', 11, true);


--
-- Name: documents documents_pk; Type: CONSTRAINT; Schema: client; Owner: postgres
--

ALTER TABLE ONLY client.documents
    ADD CONSTRAINT documents_pk PRIMARY KEY (id);


--
-- Name: clients users_pk; Type: CONSTRAINT; Schema: client; Owner: postgres
--

ALTER TABLE ONLY client.clients
    ADD CONSTRAINT users_pk PRIMARY KEY (id);


--
-- Name: clients users_documents_id_fk; Type: FK CONSTRAINT; Schema: client; Owner: postgres
--

ALTER TABLE ONLY client.clients
    ADD CONSTRAINT users_documents_id_fk FOREIGN KEY (document_id) REFERENCES client.documents(id);


--
-- PostgreSQL database dump complete
--

