-- =========================================
-- SEED - TABELA GAMES
-- =========================================
-- Considerando:
-- id -> AUTO_INCREMENT
-- launch -> DATE
-- price -> DECIMAL
--
-- Ajuste os nomes das tabelas relacionais
-- caso o Hibernate gere nomes diferentes.
-- =========================================

INSERT INTO games (name, launch, price) VALUES
                                            ('The Witcher 3: Wild Hunt', '2015-05-19', 149.90),
                                            ('Cyberpunk 2077', '2020-12-10', 199.90),
                                            ('Red Dead Redemption 2', '2018-10-26', 249.90),
                                            ('Grand Theft Auto V', '2013-09-17', 129.90),
                                            ('Minecraft', '2011-11-18', 99.90),
                                            ('Elden Ring', '2022-02-25', 229.90),
                                            ('Dark Souls III', '2016-03-24', 159.90),
                                            ('Sekiro: Shadows Die Twice', '2019-03-22', 179.90),
                                            ('God of War', '2018-04-20', 199.90),
                                            ('God of War Ragnarök', '2022-11-09', 299.90),
                                            ('Horizon Zero Dawn', '2017-02-28', 149.90),
                                            ('Horizon Forbidden West', '2022-02-18', 299.90),
                                            ('The Last of Us Part II', '2020-06-19', 249.90),
                                            ('Ghost of Tsushima', '2020-07-17', 249.90),
                                            ('Spider-Man Remastered', '2022-08-12', 249.90),
                                            ('Resident Evil 4', '2005-01-11', 79.90),
                                            ('Resident Evil 4 Remake', '2023-03-24', 249.90),
                                            ('Resident Evil Village', '2021-05-07', 199.90),
                                            ('Baldur''s Gate 3', '2023-08-03', 199.90),
                                            ('Divinity: Original Sin 2', '2017-09-14', 119.90),
                                            ('League of Legends', '2009-10-27', 0.00),
                                            ('Valorant', '2020-06-02', 0.00),
                                            ('Counter-Strike 2', '2023-09-27', 0.00),
                                            ('Dota 2', '2013-07-09', 0.00),
                                            ('Fortnite', '2017-07-21', 0.00),
                                            ('Overwatch 2', '2022-10-04', 0.00),
                                            ('FIFA 23', '2022-09-30', 299.90),
                                            ('EA Sports FC 25', '2025-09-27', 349.90),
                                            ('Forza Horizon 5', '2021-11-09', 249.90),
                                            ('Need for Speed Heat', '2019-11-08', 179.90),
                                            ('Call of Duty: Modern Warfare III', '2023-11-10', 349.90),
                                            ('Battlefield 1', '2016-10-21', 149.90),
                                            ('Battlefield V', '2018-11-20', 149.90),
                                            ('Terraria', '2011-05-16', 32.99),
                                            ('Stardew Valley', '2016-02-26', 24.99),
                                            ('Hades', '2020-09-17', 73.99),
                                            ('Celeste', '2018-01-25', 36.99),
                                            ('Cuphead', '2017-09-29', 54.99),
                                            ('Portal 2', '2011-04-19', 32.99),
                                            ('Half-Life 2', '2004-11-16', 29.99),
                                            ('The Legend of Zelda: Breath of the Wild', '2017-03-03', 299.90),
                                            ('The Legend of Zelda: Tears of the Kingdom', '2023-05-12', 357.99),
                                            ('Super Mario Odyssey', '2017-10-27', 249.90),
                                            ('Animal Crossing: New Horizons', '2020-03-20', 299.90),
                                            ('Metroid Dread', '2021-10-08', 299.90),
                                            ('Pokémon Scarlet', '2022-11-18', 299.90),
                                            ('Pokémon Violet', '2022-11-18', 299.90),
                                            ('Final Fantasy VII Remake', '2020-04-10', 249.90),
                                            ('Persona 5 Royal', '2019-10-31', 249.90),
                                            ('Monster Hunter: World', '2018-01-26', 129.90);

-- =========================================
-- EXEMPLOS DE RELACIONAMENTOS
-- =========================================
-- Use apenas se suas tabelas já existirem
-- e os IDs baterem corretamente.
-- =========================================

-- -----------------------------------------
-- GAME <-> DEVELOPERS (ManyToMany)
-- -----------------------------------------
-- Exemplo de tabela gerada:
-- games_developers(game_id, developers_id)

INSERT INTO games_developers (game_id, developers_id) VALUES
                                                          (1, 1),
                                                          (2, 1),
                                                          (3, 2),
                                                          (4, 2),
                                                          (5, 3),
                                                          (6, 4),
                                                          (7, 4),
                                                          (8, 4);

-- -----------------------------------------
-- GAME <-> PUBLISHERS (ManyToMany)
-- -----------------------------------------
-- Exemplo:
-- games_publishers(game_id, publishers_id)

INSERT INTO games_publishers (game_id, publishers_id) VALUES
                                                          (1, 1),
                                                          (2, 1),
                                                          (3, 2),
                                                          (4, 2),
                                                          (5, 3),
                                                          (6, 4),
                                                          (7, 4),
                                                          (8, 5);

-- -----------------------------------------
-- GAME -> FRANCHISE (ManyToOne)
-- -----------------------------------------

UPDATE games SET franchise_id = 1 WHERE id IN (9, 10);
UPDATE games SET franchise_id = 2 WHERE id IN (16, 17, 18);
UPDATE games SET franchise_id = 3 WHERE id IN (41, 42);
UPDATE games SET franchise_id = 4 WHERE id IN (46, 47);

-- =========================================
-- RESET AUTO_INCREMENT (MySQL)
-- OPCIONAL
-- =========================================

ALTER TABLE games AUTO_INCREMENT = 100;