CREATE SEQUENCE IF NOT EXISTS match_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS team_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE match
(
    id                      BIGINT NOT NULL,
    date_match              TIMESTAMP WITHOUT TIME ZONE,
    number_points_away_team INTEGER,
    number_points_home_team INTEGER,
    season                  VARCHAR(255),
    away_team_id            BIGINT,
    home_team_id            BIGINT,
    CONSTRAINT match_pkey PRIMARY KEY (id)
);

CREATE TABLE team
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT team_pkey PRIMARY KEY (id)
);

ALTER TABLE match
    ADD CONSTRAINT fk6ihefb9r7f0fcm0xuves72b2l FOREIGN KEY (home_team_id) REFERENCES team (id) ON DELETE NO ACTION;

ALTER TABLE match
    ADD CONSTRAINT fksyjor2anx7bkbst7ebyw13jcs FOREIGN KEY (away_team_id) REFERENCES team (id) ON DELETE NO ACTION;