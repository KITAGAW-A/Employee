
CREATE TABLE IF NOT EXISTS employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    gender VARCHAR(10),
    hobby VARCHAR(100),
    department VARCHAR(50),
    position VARCHAR(50),
    photo_url VARCHAR(255)
);