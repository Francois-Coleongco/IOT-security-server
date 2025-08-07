CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL
);
-- Password: 'awnoidroppeditinthewater' (bcrypt hash)

INSERT INTO users (username, password_hash) VALUES (
  'admin', 
  '$2a$12$GWfQIwg2dI.eO13eUhm8M.MXWFOnf2cU8Vbnz6vecubbgGzuC2ujm'
);
