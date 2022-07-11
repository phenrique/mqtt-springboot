CREATE TABLE device (
    device_id   SERIAL,
    code        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT device_id_pkey PRIMARY KEY (device_id)
);

CREATE TABLE mensuration (
    mensuration_id SERIAL NOT NULL,
    device_id      INTEGER NOT NULL,
    temperature    INTEGER,
    humidity       INTEGER,
    timestamp      timestamp,
    CONSTRAINT mensuration_id_pkey PRIMARY KEY (mensuration_id),
    CONSTRAINT device_id_fk FOREIGN KEY(device_id) REFERENCES device(device_id)
);

INSERT INTO device (code, description)
VALUES
    ('esp32', 'teste1');

INSERT INTO mensuration (device_id, temperature, humidity, timestamp)
VALUES
    (1, 32, 55, '2016-06-22 19:10:25-07'),
    (1, 29, 59, '2016-06-22 21:00:25-07');
