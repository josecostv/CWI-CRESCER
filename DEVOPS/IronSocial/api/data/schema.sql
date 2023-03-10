CREATE TABLE usuario (
                         id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                         nome VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         apelido VARCHAR(50),
                         data_nascimento DATE NOT NULL,
                         senha VARCHAR(128) NOT NULL,
                         url_imagem_perfil VARCHAR(512),
                         ativo BOOLEAN NOT NULL,
                         CONSTRAINT pk_usuario PRIMARY KEY (id),
                         CONSTRAINT uk_usuario_email UNIQUE (email)
);

CREATE TABLE permissao (
                           id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                           funcao VARCHAR(100) NOT NULL,
                           usuario_id BIGINT NOT NULL,
                           CONSTRAINT pk_permissao PRIMARY KEY (id),
                           CONSTRAINT uk_permissao UNIQUE (funcao, usuario_id),
                           CONSTRAINT fk_permissao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario
);

CREATE TABLE amizade (
                         id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                         usuario_id BIGINT NOT NULL,
                         amigo_id BIGINT NOT NULL,
                         CONSTRAINT pk_amizade PRIMARY KEY (id),
                         CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario,
                         CONSTRAINT fk_amigo_id FOREIGN KEY (amigo_id) REFERENCES usuario,
                         CONSTRAINT uk_amizade UNIQUE (usuario_id, amigo_id)
);

CREATE TABLE solicitacao_amizade (
                                     id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                                     usuario_enviou_id BIGINT NOT NULL,
                                     usuario_recebeu_id BIGINT NOT NULL,
                                     CONSTRAINT pk_pedido_amizade PRIMARY KEY (id),
                                     CONSTRAINT uk_solicitacao_amizade UNIQUE (usuario_enviou_id, usuario_recebeu_id)
);

CREATE TABLE publicacao(
                           id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                           mensagem VARCHAR(280) NOT NULL,
                           permissao VARCHAR(7) NOT NULL,
                           data_publicacao TIMESTAMP NOT NULL,
                           usuario_id BIGINT NOT NULL,
                           CONSTRAINT pk_publicacao PRIMARY KEY (id),
                           CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario,
                           CONSTRAINT ck_publicacao_permissao CHECK (permissao IN('PRIVADO', 'PUBLICO'))
);

CREATE TABLE publicacao_curtida(
                                   id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                                   publicacao_id BIGINT NOT NULL,
                                   usuario_id BIGINT NOT NULL,
                                   CONSTRAINT pk_publicacao_curtida PRIMARY KEY (id),
                                   CONSTRAINT fk_publicacao_id FOREIGN KEY (publicacao_id) REFERENCES publicacao,
                                   CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario,
                                   CONSTRAINT uk_publicacao_curtida UNIQUE (publicacao_id, usuario_id)
);

CREATE TABLE publicacao_comentada(
                                     id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                                     mensagem VARCHAR(280) NOT NULL,
                                     publicacao_id BIGINT NOT NULL,
                                     usuario_id BIGINT NOT NULL,
                                     CONSTRAINT pk_publicacao_comentada PRIMARY KEY (id),
                                     CONSTRAINT fk_publicacao_id FOREIGN KEY (publicacao_id) REFERENCES publicacao,
                                     CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario
);