INSERT INTO usuario (nome, email, apelido, data_nascimento, senha, url_imagem_perfil, ativo) VALUES
                                                                                                 ('João Silva', 'joao.silva@gmail.com', 'joaosilva', '1990-01-01', '$2a$12$GuJmSKuEL3lgWdr1YBtivOTcBaQ/DWtPtNFQGYTggTdtI6Bg2qI2S
', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSU4lrqANPnXmusNdulIrE2Vg1VPQHHpOmqo6lFMzRn0k7iH3JzFSIXaOG2h78uIUEB8uQ&usqp=CAU', true),
                                                                                                 ('Maria Santos', 'maria.santos@hotmail.com', 'mariasantos', '1995-05-15', '$2a$12$GuJmSKuEL3lgWdr1YBtivOTcBaQ/DWtPtNFQGYTggTdtI6Bg2qI2S
', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSU4lrqANPnXmusNdulIrE2Vg1VPQHHpOmqo6lFMzRn0k7iH3JzFSIXaOG2h78uIUEB8uQ&usqp=CAU', true),
                                                                                                 ('Carlos Souza', 'carlos.souza@yahoo.com', 'carlossouza', '1985-10-20', '$2a$12$GuJmSKuEL3lgWdr1YBtivOTcBaQ/DWtPtNFQGYTggTdtI6Bg2qI2S
', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSU4lrqANPnXmusNdulIrE2Vg1VPQHHpOmqo6lFMzRn0k7iH3JzFSIXaOG2h78uIUEB8uQ&usqp=CAU', true);


INSERT INTO permissao (funcao, usuario_id) VALUES
                                               ('ADMIN', 1),
                                               ('USUARIO', 2),
                                               ('USUARIO', 3);


INSERT INTO amizade (usuario_id, amigo_id) VALUES
                                               (1, 2),
                                               (1, 3),
                                               (2, 1),
                                               (3, 1);


INSERT INTO solicitacao_amizade (usuario_enviou_id, usuario_recebeu_id) VALUES
                                                                            (2, 3),
                                                                            (3, 2);


INSERT INTO publicacao (mensagem, permissao, data_publicacao, usuario_id) VALUES
                                                                              ('Olá mundo!', 'PUBLICO', '2022-01-01 12:00:00', 1),
                                                                              ('Estou muito feliz hoje!', 'PRIVADO', '2022-02-01 15:30:00', 2),
                                                                              ('Que dia lindo!', 'PUBLICO', '2022-03-01 10:00:00', 3);


INSERT INTO publicacao_curtida (publicacao_id, usuario_id) VALUES
                                                               (1, 2),
                                                               (1, 3),
                                                               (2, 1),
                                                               (3, 1),
                                                               (3, 2);


INSERT INTO publicacao_comentada (mensagem, publicacao_id, usuario_id) VALUES
                                                                           ('Concordo!', 1, 2),
                                                                           ('Também achei!', 1, 3),
                                                                           ('Que legal!', 3, 2);