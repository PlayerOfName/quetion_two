ALTER TABLE match
    ADD CONSTRAINT uc_match_away_team UNIQUE (away_team_id);

ALTER TABLE match
    ADD CONSTRAINT uc_match_home_team UNIQUE (home_team_id);