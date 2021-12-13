CREATE TABLE tab_fornecedores
(
  for_id serial NOT NULL,
  for_nmFantasia character varying(50),
  for_rzSocial character varying(50),
  for_cnpj character varying(14) ,
  for_inscEstadual character varying(15) ,
  for_inscMunicipal character varying(15),
  for_email character varying(100) ,
  for_status character varying(10),
  for_end_tipo character varying(50),
  for_end_cep character varying(11),
  for_end_tipoLogradouro character varying(50),
  for_end_logradouro character varying(200),
  for_end_numero character varying(11),
  for_end_bairro character varying(100),
  for_end_complemento character varying(200),
  for_end_cidade character varying(50),
  for_end_estado_uf character varying(2),
  for_end_pais character varying(55),
  for_tipo_empresa character varying(50),
  for_tipo_fornecimento character varying(50),
  for_dtCadastro date NOT NULL,
  CONSTRAINT tab_fornecedores_pkey PRIMARY KEY (for_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tab_fornecedores OWNER TO postgres;


CREATE TABLE tab_produtos
(
  pro_id serial NOT NULL,
  pro_descricao character varying(50),
  pro_for_id integer NOT NULL,
  pro_dtCadastro date NOT NULL,
  CONSTRAINT tab_produtos_pkey PRIMARY KEY (pro_id),
  CONSTRAINT pro_for_idfk FOREIGN KEY (pro_for_id)
  REFERENCES tab_fornecedores (for_id) MATCH SIMPLE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tab_produtos OWNER TO postgres;


CREATE TABLE tab_servicos
(
  ser_id serial NOT NULL,
  ser_descricao character varying(50),
  ser_for_id integer NOT NULL,
  ser_dtCadastro date NOT NULL,
  CONSTRAINT tab_servicos_pkey PRIMARY KEY (ser_id),
  CONSTRAINT ser_for_idfk FOREIGN KEY (ser_for_id)
  REFERENCES tab_fornecedores (for_id) MATCH SIMPLE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tab_servicos OWNER TO postgres;


CREATE TABLE tab_cnaes
(
  cna_id serial NOT NULL,
  cna_numero character varying(50),
  cna_dtCadastro date NOT NULL,
  cna_for_id integer NOT NULL,
  CONSTRAINT tab_cna_pkey PRIMARY KEY (cna_id),
   CONSTRAINT cna_for_idfk FOREIGN KEY (cna_for_id)
   REFERENCES tab_fornecedores (for_id) MATCH SIMPLE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tab_cnaes OWNER TO postgres;


CREATE TABLE tab_telefones
(
  tel_id serial NOT NULL,
  tel_dddTelefone character varying(3),
  tel_ddiTelefone character varying(3),
  tel_numeroTelefone character varying(11),
  tel_for_id integer NOT NULL,
  tel_dtCadastro timestamp without time zone,
  CONSTRAINT tab_telefones_pkey PRIMARY KEY (tel_id),
  CONSTRAINT tel_for_idfk FOREIGN KEY (tel_for_id)
	REFERENCES tab_fornecedores (for_id) MATCH SIMPLE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tab_telefones OWNER TO postgres;

CREATE TABLE tab_contatos
(
  ctt_id serial NOT NULL,
  ctt_nome character varying(50),
  ctt_dpto character varying(50),
  ctt_email character varying(50),
  ctt_dddTelefone character varying(3),
  ctt_ddiTelefone character varying(3),
  ctt_numeroTelefone character varying(11),
  ctt_dtCadastro date NOT NULL,
  ctt_for_id integer NOT NULL,
  CONSTRAINT tab_contatos_pkey PRIMARY KEY (ctt_id),
  CONSTRAINT ctt_for_idfk FOREIGN KEY (ctt_for_id)
	REFERENCES tab_fornecedores (for_id) MATCH SIMPLE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tab_contatos OWNER TO postgres;