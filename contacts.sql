-- Table: contacts

-- DROP TABLE contacts;

CREATE TABLE contacts
(
  id integer NOT NULL,
  email character varying(255),
  firstname character varying(255),
  lastname character varying(255),
  telephone character varying(255),
  CONSTRAINT contacts_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE contacts
  OWNER TO postgres;