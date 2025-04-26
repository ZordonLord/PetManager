
-- Создание базы данных
CREATE DATABASE IF NOT EXISTS friends_of_human;
USE friends_of_human;

-- Таблица Animal
CREATE TABLE Animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    birth_date DATE,
    type VARCHAR(50),
    gender VARCHAR(10),
    color VARCHAR(30)
);

-- Домашние животные
CREATE TABLE Pet (
    animal_id INT PRIMARY KEY,
    FOREIGN KEY (animal_id) REFERENCES Animal(id)
);

-- Вьючные животные
CREATE TABLE PackAnimal (
    animal_id INT PRIMARY KEY,
    load_capacity INT,
    FOREIGN KEY (animal_id) REFERENCES Animal(id)
);

-- Собаки
CREATE TABLE Dog (
    animal_id INT PRIMARY KEY,
    breed VARCHAR(50),
    trained BOOL,
    commands TEXT,
    FOREIGN KEY (animal_id) REFERENCES Pet(animal_id)
);

-- Кошки
CREATE TABLE Cat (
    animal_id INT PRIMARY KEY,
    breed VARCHAR(50),
    indoor_only BOOL,
    FOREIGN KEY (animal_id) REFERENCES Pet(animal_id)
);

-- Хомяки
CREATE TABLE Hamster (
    animal_id INT PRIMARY KEY,
    cage_size VARCHAR(20),
    FOREIGN KEY (animal_id) REFERENCES Pet(animal_id)
);

-- Лошади
CREATE TABLE Horse (
    animal_id INT PRIMARY KEY,
    speed FLOAT,
    has_shoes BOOL,
    FOREIGN KEY (animal_id) REFERENCES PackAnimal(animal_id)
);

-- Верблюды
CREATE TABLE Camel (
    animal_id INT PRIMARY KEY,
    hump_count INT,
    FOREIGN KEY (animal_id) REFERENCES PackAnimal(animal_id)
);

-- Ослы
CREATE TABLE Donkey (
    animal_id INT PRIMARY KEY,
    stubborn_level INT,
    FOREIGN KEY (animal_id) REFERENCES PackAnimal(animal_id)
);

-- Пример вставки: собака
INSERT INTO Animal (name, birth_date, type, gender, color)
VALUES ('Барсик', '2020-03-15', 'Домашнее', 'male', 'черный');

SET @dog_id = LAST_INSERT_ID();

INSERT INTO Pet (animal_id) VALUES (@dog_id);
INSERT INTO Dog (animal_id, breed, trained, commands)
VALUES (@dog_id, 'Овчарка', TRUE, 'сидеть, лежать, фас');

-- Пример вставки: верблюд
INSERT INTO Animal (name, birth_date, type, gender, color)
VALUES ('Гоша', '2019-07-01', 'Вьючное', 'male', 'песочный');

SET @camel_id = LAST_INSERT_ID();

INSERT INTO PackAnimal (animal_id, load_capacity)
VALUES (@camel_id, 200);

INSERT INTO Camel (animal_id, hump_count)
VALUES (@camel_id, 2);
