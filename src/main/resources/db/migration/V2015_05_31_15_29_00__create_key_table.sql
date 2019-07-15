CREATE TABLE key_stock (
  id          bigserial  NOT NULL,
  number       VARCHAR(100)           NOT NULL,
  type        VARCHAR(100)           NOT NULL,
  created_at       TIMESTAMP,
  created_by       VARCHAR(255),
  updated_at TIMESTAMP,
  updated_by VARCHAR(255),
  CONSTRAINT pk_key_stock_id PRIMARY KEY (id)
);