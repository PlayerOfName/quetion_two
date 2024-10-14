package com.shvetsov.quetion2.match;

import com.shvetsov.quetion2.dto.match.MatchDTO;
import com.shvetsov.quetion2.mappers.MatchMapper;
import com.shvetsov.quetion2.models.Match;
import com.shvetsov.quetion2.models.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MatchMapperTest {

    @Autowired
    private MatchMapper matchMapper;

    @Test
    public void testFromMatchCreateDto() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-01");
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setDateMatch(date);
        matchDTO.setSeason("2024");
        matchDTO.setNumberPointsHomeTeam(3);
        matchDTO.setNumberPointsAwayTeam(1);

        Match match = matchMapper.fromMatchCreateDto(matchDTO);

        assertEquals(date, match.getDateMatch());
        assertEquals("2024", match.getSeason());
        assertEquals(3, match.getNumberPointsHomeTeam());
        assertEquals(1, match.getNumberPointsAwayTeam());
    }
}
