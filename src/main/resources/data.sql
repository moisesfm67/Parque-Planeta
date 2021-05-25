-- inserts sem os ids, para deixar o proprio mysql decidir
-- Entity: GeneratedValue (strategy = GenerationType.IDENTITY)
-- Ao usar o AUTO, acaba usando IDENTITY (que estoura excecao porque o id nao tem um valor default)
insert into toy (name, location) values ('Montanha Russa', 'Norte');
insert into toy (name, location) values ('Roda-Gigante', 'Centro');