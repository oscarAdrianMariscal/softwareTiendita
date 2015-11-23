--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.1
-- Dumped by pg_dump version 9.4.1
-- Started on 2015-11-22 19:28:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 178 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 25387)
-- Name: categoriaproducto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categoriaproducto (
    idcategoria integer NOT NULL,
    categoria character varying(30)
);


ALTER TABLE categoriaproducto OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 33576)
-- Name: detalleticket; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detalleticket (
    idproducto integer NOT NULL,
    idticket integer NOT NULL,
    cantidad integer
);


ALTER TABLE detalleticket OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 25400)
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE empleado (
    idempleado integer NOT NULL,
    nombreempleado character varying(30),
    apellidoempleado character varying(30),
    salario numeric(10,2),
    puesto character varying(20),
    horario character varying(15),
    edad integer,
    telefono character varying(20),
    direccion character varying(50),
    correo character varying(50)
);


ALTER TABLE empleado OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 25382)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE producto (
    idproducto integer NOT NULL,
    nombre character varying(30),
    precio numeric(10,2),
    idproveedor integer,
    idcategoria integer,
    cantidad integer
);


ALTER TABLE producto OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 25392)
-- Name: proveedor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE proveedor (
    idproveedor integer NOT NULL,
    nombreproveedor character varying(20),
    domicilio character varying(50),
    telefono character varying(20),
    correo character varying(50)
);


ALTER TABLE proveedor OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 25397)
-- Name: ticket; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ticket (
    idempleado integer,
    fecha character varying(20),
    idticket integer NOT NULL
);


ALTER TABLE ticket OWNER TO postgres;

--
-- TOC entry 2026 (class 0 OID 25387)
-- Dependencies: 173
-- Data for Name: categoriaproducto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY categoriaproducto (idcategoria, categoria) FROM stdin;
1	Abarrotes
2	Cremeria
3	Verduras
\.


--
-- TOC entry 2030 (class 0 OID 33576)
-- Dependencies: 177
-- Data for Name: detalleticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detalleticket (idproducto, idticket, cantidad) FROM stdin;
1	1	2
2	1	1
5	1	1
5	2	2
4	2	1
3	2	3
\.


--
-- TOC entry 2029 (class 0 OID 25400)
-- Dependencies: 176
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY empleado (idempleado, nombreempleado, apellidoempleado, salario, puesto, horario, edad, telefono, direccion, correo) FROM stdin;
1	Carlo	Martinez	1200.00	Empleado	8:00-16:00	20	33-15-85-15	Av. Patria No. 154	carmar95@gmail.com
2	Alejandro	Campero	1000.00	Empleado	16:00-22:00	22	33-17-95-14	Guanajuto No. 124	calemp@gmail.com
\.


--
-- TOC entry 2025 (class 0 OID 25382)
-- Dependencies: 172
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY producto (idproducto, nombre, precio, idproveedor, idcategoria, cantidad) FROM stdin;
1	Chetos	5.00	2	1	50
2	Churrumaiz	5.00	2	1	70
3	Nito	6.00	1	1	40
4	Donas Bimbo	8.00	1	1	50
5	Roles de Canela	10.50	1	1	50
\.


--
-- TOC entry 2027 (class 0 OID 25392)
-- Dependencies: 174
-- Data for Name: proveedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY proveedor (idproveedor, nombreproveedor, domicilio, telefono, correo) FROM stdin;
1	Bimbo	Av. Gonzalez Gallo No. 458	01-800-456-852	clientes@bimbo.com.mx
2	Sabritas	Av. Vallarta No. 748	01-800-956-252	clientes@sabritas.com.mx
\.


--
-- TOC entry 2028 (class 0 OID 25397)
-- Dependencies: 175
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ticket (idempleado, fecha, idticket) FROM stdin;
2	22/11/2013	1
2	22/11/2015	2
\.


--
-- TOC entry 1902 (class 2606 OID 25391)
-- Name: categoriaproducto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoriaproducto
    ADD CONSTRAINT categoriaproducto_pkey PRIMARY KEY (idcategoria);


--
-- TOC entry 1910 (class 2606 OID 33592)
-- Name: detalleticket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalleticket
    ADD CONSTRAINT detalleticket_pkey PRIMARY KEY (idproducto, idticket);


--
-- TOC entry 1908 (class 2606 OID 25404)
-- Name: empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (idempleado);


--
-- TOC entry 1900 (class 2606 OID 25386)
-- Name: producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (idproducto);


--
-- TOC entry 1904 (class 2606 OID 25396)
-- Name: proveedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proveedor
    ADD CONSTRAINT proveedor_pkey PRIMARY KEY (idproveedor);


--
-- TOC entry 1906 (class 2606 OID 33585)
-- Name: ticket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (idticket);


--
-- TOC entry 1914 (class 2606 OID 33579)
-- Name: detalleticket_idproducto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalleticket
    ADD CONSTRAINT detalleticket_idproducto_fkey FOREIGN KEY (idproducto) REFERENCES producto(idproducto);


--
-- TOC entry 1915 (class 2606 OID 33586)
-- Name: detalleticket_idticket_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalleticket
    ADD CONSTRAINT detalleticket_idticket_fkey FOREIGN KEY (idticket) REFERENCES ticket(idticket);


--
-- TOC entry 1912 (class 2606 OID 25410)
-- Name: fk_producto_idcategoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT fk_producto_idcategoria FOREIGN KEY (idcategoria) REFERENCES categoriaproducto(idcategoria);


--
-- TOC entry 1911 (class 2606 OID 25405)
-- Name: fk_producto_idproveedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT fk_producto_idproveedor FOREIGN KEY (idproveedor) REFERENCES proveedor(idproveedor);


--
-- TOC entry 1913 (class 2606 OID 25420)
-- Name: fk_ticket_idempleado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ticket
    ADD CONSTRAINT fk_ticket_idempleado FOREIGN KEY (idempleado) REFERENCES empleado(idempleado);


--
-- TOC entry 2037 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-11-22 19:29:03

--
-- PostgreSQL database dump complete
--

