USE adlister_db;

INSERT INTO users(username, email, password) VALUES ('John', 'john@email.com', 'john123');

INSERT ads(user_id, title, description) VALUES
        (1, 'Test Ad 1', 'Test Ad Description 1'),
        (1, 'Test Ad 2', 'Test Ad Description 2'),
        (1, 'Test Ad 3', 'Test Ad Description 3'),
        (1, 'Test Ad 4', 'Test Ad Description 4');