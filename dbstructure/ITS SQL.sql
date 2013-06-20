--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.4
-- Dumped by pg_dump version 9.2.4
-- Started on 2013-06-20 14:08:36

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 16550)
-- Name: orion; Type: SCHEMA; Schema: -; Owner: itstooladmin
--

CREATE SCHEMA orion;


ALTER SCHEMA orion OWNER TO itstooladmin;

SET search_path = orion, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 16553)
-- Name: categories; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE categories (
    category_id integer NOT NULL,
    name character varying(100),
    description character varying(300),
    deleted boolean DEFAULT false
);


ALTER TABLE orion.categories OWNER TO itstooladmin;

--
-- TOC entry 169 (class 1259 OID 16551)
-- Name: categories_category_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE categories_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.categories_category_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2017 (class 0 OID 0)
-- Dependencies: 169
-- Name: categories_category_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE categories_category_id_seq OWNED BY categories.category_id;


--
-- TOC entry 172 (class 1259 OID 16562)
-- Name: inputs; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE inputs (
    input_id integer NOT NULL,
    operation_id integer NOT NULL,
    name character varying(20) NOT NULL,
    type character varying(20) NOT NULL,
    display_name character varying(40),
    deleted boolean DEFAULT false
);


ALTER TABLE orion.inputs OWNER TO itstooladmin;

--
-- TOC entry 171 (class 1259 OID 16560)
-- Name: inputs_input_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE inputs_input_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.inputs_input_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2018 (class 0 OID 0)
-- Dependencies: 171
-- Name: inputs_input_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE inputs_input_id_seq OWNED BY inputs.input_id;


--
-- TOC entry 174 (class 1259 OID 16571)
-- Name: operations; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE operations (
    operation_id integer NOT NULL,
    name character varying(50) NOT NULL,
    type character(1) NOT NULL,
    sql_code text NOT NULL,
    detail character varying(300),
    deleted boolean DEFAULT false
);


ALTER TABLE orion.operations OWNER TO itstooladmin;

--
-- TOC entry 176 (class 1259 OID 16583)
-- Name: operations_categories; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE operations_categories (
    operation_role_id integer NOT NULL,
    category_id integer NOT NULL,
    operation_id integer NOT NULL
);


ALTER TABLE orion.operations_categories OWNER TO itstooladmin;

--
-- TOC entry 175 (class 1259 OID 16581)
-- Name: operations_categories_operation_role_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE operations_categories_operation_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.operations_categories_operation_role_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2019 (class 0 OID 0)
-- Dependencies: 175
-- Name: operations_categories_operation_role_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE operations_categories_operation_role_id_seq OWNED BY operations_categories.operation_role_id;


--
-- TOC entry 178 (class 1259 OID 16591)
-- Name: operations_execution_history; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE operations_execution_history (
    operation_execution_history_id integer NOT NULL,
    user_id integer NOT NULL,
    operation_id integer NOT NULL,
    execution_time timestamp without time zone
);


ALTER TABLE orion.operations_execution_history OWNER TO itstooladmin;

--
-- TOC entry 177 (class 1259 OID 16589)
-- Name: operations_execution_history_operation_execution_history_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE operations_execution_history_operation_execution_history_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.operations_execution_history_operation_execution_history_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2020 (class 0 OID 0)
-- Dependencies: 177
-- Name: operations_execution_history_operation_execution_history_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE operations_execution_history_operation_execution_history_id_seq OWNED BY operations_execution_history.operation_execution_history_id;


--
-- TOC entry 180 (class 1259 OID 16599)
-- Name: operations_execution_values; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE operations_execution_values (
    operation_execution_value_id integer NOT NULL,
    input_id integer NOT NULL,
    operation_execution_history_id integer NOT NULL,
    value character varying(200)
);


ALTER TABLE orion.operations_execution_values OWNER TO itstooladmin;

--
-- TOC entry 179 (class 1259 OID 16597)
-- Name: operations_execution_values_operation_execution_value_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE operations_execution_values_operation_execution_value_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.operations_execution_values_operation_execution_value_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2021 (class 0 OID 0)
-- Dependencies: 179
-- Name: operations_execution_values_operation_execution_value_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE operations_execution_values_operation_execution_value_id_seq OWNED BY operations_execution_values.operation_execution_value_id;


--
-- TOC entry 173 (class 1259 OID 16569)
-- Name: operations_operation_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE operations_operation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.operations_operation_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2022 (class 0 OID 0)
-- Dependencies: 173
-- Name: operations_operation_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE operations_operation_id_seq OWNED BY operations.operation_id;


--
-- TOC entry 182 (class 1259 OID 16607)
-- Name: outputs; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE outputs (
    output_id integer NOT NULL,
    operation_id integer NOT NULL,
    name character varying(20),
    type character varying(20),
    display_order smallint,
    display_name character varying(40),
    deleted boolean DEFAULT false
);


ALTER TABLE orion.outputs OWNER TO itstooladmin;

--
-- TOC entry 181 (class 1259 OID 16605)
-- Name: outputs_output_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE outputs_output_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.outputs_output_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2023 (class 0 OID 0)
-- Dependencies: 181
-- Name: outputs_output_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE outputs_output_id_seq OWNED BY outputs.output_id;


--
-- TOC entry 184 (class 1259 OID 16616)
-- Name: roles; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE roles (
    role_id integer NOT NULL,
    name character varying(20) NOT NULL,
    deleted boolean
);


ALTER TABLE orion.roles OWNER TO itstooladmin;

--
-- TOC entry 183 (class 1259 OID 16614)
-- Name: roles_role_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE roles_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.roles_role_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2024 (class 0 OID 0)
-- Dependencies: 183
-- Name: roles_role_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE roles_role_id_seq OWNED BY roles.role_id;


--
-- TOC entry 186 (class 1259 OID 16624)
-- Name: users; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE users (
    user_id integer NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    last_modified timestamp without time zone NOT NULL,
    status character(1) NOT NULL,
    deleted boolean DEFAULT false NOT NULL
);


ALTER TABLE orion.users OWNER TO itstooladmin;

--
-- TOC entry 187 (class 1259 OID 16631)
-- Name: users_categories; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE users_categories (
    user_category_id integer NOT NULL,
    category_id integer NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE orion.users_categories OWNER TO itstooladmin;

--
-- TOC entry 189 (class 1259 OID 16638)
-- Name: users_roles; Type: TABLE; Schema: orion; Owner: itstooladmin; Tablespace: 
--

CREATE TABLE users_roles (
    user_role_id integer NOT NULL,
    role_id integer NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE orion.users_roles OWNER TO itstooladmin;

--
-- TOC entry 188 (class 1259 OID 16636)
-- Name: users_roles_user_role_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE users_roles_user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.users_roles_user_role_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2025 (class 0 OID 0)
-- Dependencies: 188
-- Name: users_roles_user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE users_roles_user_role_id_seq OWNED BY users_roles.user_role_id;


--
-- TOC entry 185 (class 1259 OID 16622)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: orion; Owner: itstooladmin
--

CREATE SEQUENCE users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orion.users_user_id_seq OWNER TO itstooladmin;

--
-- TOC entry 2026 (class 0 OID 0)
-- Dependencies: 185
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: orion; Owner: itstooladmin
--

ALTER SEQUENCE users_user_id_seq OWNED BY users.user_id;


--
-- TOC entry 1976 (class 2604 OID 16556)
-- Name: category_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY categories ALTER COLUMN category_id SET DEFAULT nextval('categories_category_id_seq'::regclass);


--
-- TOC entry 1978 (class 2604 OID 16565)
-- Name: input_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY inputs ALTER COLUMN input_id SET DEFAULT nextval('inputs_input_id_seq'::regclass);


--
-- TOC entry 1980 (class 2604 OID 16574)
-- Name: operation_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY operations ALTER COLUMN operation_id SET DEFAULT nextval('operations_operation_id_seq'::regclass);


--
-- TOC entry 1982 (class 2604 OID 16586)
-- Name: operation_role_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY operations_categories ALTER COLUMN operation_role_id SET DEFAULT nextval('operations_categories_operation_role_id_seq'::regclass);


--
-- TOC entry 1983 (class 2604 OID 16594)
-- Name: operation_execution_history_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY operations_execution_history ALTER COLUMN operation_execution_history_id SET DEFAULT nextval('operations_execution_history_operation_execution_history_id_seq'::regclass);


--
-- TOC entry 1984 (class 2604 OID 16602)
-- Name: operation_execution_value_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY operations_execution_values ALTER COLUMN operation_execution_value_id SET DEFAULT nextval('operations_execution_values_operation_execution_value_id_seq'::regclass);


--
-- TOC entry 1985 (class 2604 OID 16610)
-- Name: output_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY outputs ALTER COLUMN output_id SET DEFAULT nextval('outputs_output_id_seq'::regclass);


--
-- TOC entry 1987 (class 2604 OID 16619)
-- Name: role_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY roles ALTER COLUMN role_id SET DEFAULT nextval('roles_role_id_seq'::regclass);


--
-- TOC entry 1988 (class 2604 OID 16627)
-- Name: user_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY users ALTER COLUMN user_id SET DEFAULT nextval('users_user_id_seq'::regclass);


--
-- TOC entry 1990 (class 2604 OID 16641)
-- Name: user_role_id; Type: DEFAULT; Schema: orion; Owner: itstooladmin
--

ALTER TABLE ONLY users_roles ALTER COLUMN user_role_id SET DEFAULT nextval('users_roles_user_role_id_seq'::regclass);


--
-- TOC entry 1992 (class 2606 OID 16559)
-- Name: categories_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category_id);


--
-- TOC entry 1994 (class 2606 OID 16568)
-- Name: inputs_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY inputs
    ADD CONSTRAINT inputs_pkey PRIMARY KEY (input_id);


--
-- TOC entry 1998 (class 2606 OID 16588)
-- Name: operations_categories_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY operations_categories
    ADD CONSTRAINT operations_categories_pkey PRIMARY KEY (operation_role_id);


--
-- TOC entry 2000 (class 2606 OID 16596)
-- Name: operations_execution_history_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY operations_execution_history
    ADD CONSTRAINT operations_execution_history_pkey PRIMARY KEY (operation_execution_history_id);


--
-- TOC entry 2002 (class 2606 OID 16604)
-- Name: operations_execution_values_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY operations_execution_values
    ADD CONSTRAINT operations_execution_values_pkey PRIMARY KEY (operation_execution_value_id);


--
-- TOC entry 1996 (class 2606 OID 16580)
-- Name: operations_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY operations
    ADD CONSTRAINT operations_pkey PRIMARY KEY (operation_id);


--
-- TOC entry 2004 (class 2606 OID 16613)
-- Name: outputs_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY outputs
    ADD CONSTRAINT outputs_pkey PRIMARY KEY (output_id);


--
-- TOC entry 2006 (class 2606 OID 16621)
-- Name: roles_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (role_id);


--
-- TOC entry 2010 (class 2606 OID 16635)
-- Name: users_categories_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY users_categories
    ADD CONSTRAINT users_categories_pkey PRIMARY KEY (user_category_id);


--
-- TOC entry 2008 (class 2606 OID 16630)
-- Name: users_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2012 (class 2606 OID 16643)
-- Name: users_roles_pkey; Type: CONSTRAINT; Schema: orion; Owner: itstooladmin; Tablespace: 
--

ALTER TABLE ONLY users_roles
    ADD CONSTRAINT users_roles_pkey PRIMARY KEY (user_role_id);


-- Completed on 2013-06-20 14:08:37

--
-- PostgreSQL database dump complete
--

