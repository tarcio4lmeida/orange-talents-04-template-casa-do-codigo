INSERT INTO tb_autor (nome, email, data_cadastro, descricao) values ('Alex', 'alex@gmail.com', '2020-07-13T20:50:07.12345Z', 'um autor desconhecido');
INSERT INTO tb_autor (nome, email, data_cadastro, descricao) values ('Maria', 'maria@gmail.com', '2020-07-13T20:50:07.12345Z', 'Uma autora famosa');

INSERT INTO tb_categoria(nome) values('Biografia');
INSERT INTO tb_categoria(nome) values('Ação');
INSERT INTO tb_categoria(nome) values('Romance');
INSERT INTO tb_categoria(nome) values('Aventura');
INSERT INTO tb_categoria(nome) values('Terror');


INSERT INTO tb_livro(titulo, resumo, sumario, preco, qtd_paginas, isbn, data_publicacao, categoria_id, autor_id) values (
  'uma visão além do alcance', 
  'Stephen W. Hawking é reconhecido internacionalmente como um dos génios do século XX. físico inglês de 46 anos de idade',
  'teste teste teste teste teste teste',
  25.0,
  100,
  'ISBN 978-85-8057-646-7211-',
  TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07.12345Z',
  1,
  1);
  
  
INSERT INTO tb_livro(titulo, resumo, sumario, preco, qtd_paginas, isbn, data_publicacao, categoria_id, autor_id) values (
  'A vida é bela', 
  'Stephen W. Hawking é reconhecido internacionalmente como um dos génios do século XX. físico inglês de 46 anos de idade',
  'teste teste teste teste teste teste',
  25.0,
  100,
  'ISBN 978-85-8057-646-722',
  TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07.12345Z',
  2,
  2);
  
  
INSERT INTO tb_livro(titulo, resumo, sumario, preco, qtd_paginas, isbn, data_publicacao, categoria_id, autor_id) values (
  'Pai rico, pai pobre', 
  'Stephen W. Hawking é reconhecido internacionalmente como um dos génios do século XX. físico inglês de 46 anos de idade',
  'teste teste teste teste teste teste',
  25.0,
  100,
  'ISBN 978-85-8057-646-7297',
  TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07.12345Z',
  2,
  2);
  
INSERT INTO tb_livro(titulo, resumo, sumario, preco, qtd_paginas, isbn, data_publicacao, categoria_id, autor_id) values (
  'O homem que enganou o diabo', 
  'Stephen W. Hawking é reconhecido internacionalmente como um dos génios do século XX. físico inglês de 46 anos de idade',
  'teste teste teste teste teste teste',
  25.0,
  100,
  'ISBN 978-85-8057-646-7290',
  TIMESTAMP WITH TIME ZONE '2021-07-13T20:50:07.12345Z',
  1,
  2);
  
INSERT INTO tb_pais(nome) values('Argentina');
INSERT INTO tb_pais(nome) values('Peru');
INSERT INTO tb_pais(nome) values('Chile');
INSERT INTO tb_pais(nome) values('Uruguai');
INSERT INTO tb_pais(nome) values('Mexico');

INSERT INTO tb_estado(nome, pais_id) values('Canelones', 4);
INSERT INTO tb_estado(nome, pais_id) values('Artigas', 4);
INSERT INTO tb_estado(nome, pais_id) values('Flores', 4);

INSERT INTO tb_estado(nome, pais_id) values('Estado do México', 5);
INSERT INTO tb_estado(nome, pais_id) values('Nuevo León', 5);
