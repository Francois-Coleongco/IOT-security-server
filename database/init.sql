CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);
-- Password: 'awnoidroppeditinthewater' (bcrypt hash rounds = 12)

INSERT INTO users (username, password) VALUES (
  'admin', 
  '$2a$12$dsJV9TIdfKz8tgfv2gEl6.6NbQhRScq34ITxM.qzJkEO.pQRRoRNK'
);


CREATE TABLE IF NOT EXISTS pir_sensor_data (
  id SERIAL PRIMARY KEY,
  location VARCHAR(50) UNIQUE NOT NULL,
  timestamp TIMESTAMPTZ
);


INSERT INTO  pir_sensor_data(location, timestamp) VALUES (
  'myRoom', 
   CURRENT_TIMESTAMP 
);
