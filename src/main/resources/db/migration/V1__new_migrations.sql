CREATE SEQUENCE IF NOT EXISTS match_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS team_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE match
(
    id                      BIGINT NOT NULL,
    away_team_id            BIGINT,
    home_team_id            BIGINT,
    date_match              TIMESTAMP WITHOUT TIME ZONE,
    season                  VARCHAR(255),
    number_points_home_team INTEGER,
    number_points_away_team INTEGER,
    CONSTRAINT pk_match PRIMARY KEY (id)
);

CREATE TABLE team
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_team PRIMARY KEY (id)
);

ALTER TABLE match
    ADD CONSTRAINT uc_match_away_team UNIQUE (away_team_id);

ALTER TABLE match
    ADD CONSTRAINT uc_match_home_team UNIQUE (home_team_id);

ALTER TABLE match
    ADD CONSTRAINT FK_MATCH_ON_AWAY_TEAM FOREIGN KEY (away_team_id) REFERENCES team (id);

ALTER TABLE match
    ADD CONSTRAINT FK_MATCH_ON_HOME_TEAM FOREIGN KEY (home_team_id) REFERENCES team (id);