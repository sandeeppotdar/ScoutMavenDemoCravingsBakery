--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2017-08-14 12:51:59 EDT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 171 (class 3079 OID 12018)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 171
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 44829)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE account (
    accountnum text NOT NULL,
    accountname text NOT NULL,
    balance integer NOT NULL
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 2197 (class 0 OID 44829)
-- Dependencies: 170
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY account (accountnum, accountname, balance) FROM stdin;
Z1001	Zach	887
E5001	Eric	543
S1001	Sandeep	519
\.


--
-- TOC entry 2089 (class 2606 OID 44836)
-- Name: account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY account
    ADD CONSTRAINT account_pkey PRIMARY KEY (accountnum);


--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 170
-- Name: account; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE account FROM PUBLIC;
REVOKE ALL ON TABLE account FROM postgres;
GRANT ALL ON TABLE account TO postgres;
GRANT ALL ON TABLE account TO initech;


-- Completed on 2017-08-14 12:52:00 EDT

--
-- PostgreSQL database dump complete
--

