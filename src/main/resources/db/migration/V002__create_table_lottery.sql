CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE Lottery (
    id                 UUID PRIMARY KEY               DEFAULT uuid_generate_v4(),
    name               VARCHAR(80)           NOT NULL,
    modality           modality_lottery_type NOT NULL,
    description        VARCHAR(255)          NOT NULL,
    modality_special   BOOLEAN               NOT NULL DEFAULT FALSE,
    modality_supported BOOLEAN               NOT NULL DEFAULT FALSE,
    created_at         TIMESTAMP                      DEFAULT CURRENT_TIMESTAMP,
    updated_at         TIMESTAMP                      DEFAULT CURRENT_TIMESTAMP
);