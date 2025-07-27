package com.codeseek.footballmanager.init;

import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.model.Team;
import com.codeseek.footballmanager.repository.PlayerRepository;
import com.codeseek.footballmanager.repository.TeamRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (teamRepository.count() == 0 && playerRepository.count() == 0) {
            Team barcelona = new Team();
            barcelona.setName("Barcelona");
            barcelona.setCommission(BigDecimal.valueOf(0.01));
            barcelona.setBalance(BigDecimal.valueOf(10000000));
            teamRepository.save(barcelona);

            Team karpaty = new Team();
            karpaty.setName("Karpaty");
            karpaty.setCommission(BigDecimal.valueOf(0.1));
            karpaty.setBalance(BigDecimal.valueOf(8000000));
            teamRepository.save(karpaty);

            Team shakhtar = new Team();
            shakhtar.setName("Shakhtar");
            shakhtar.setCommission(BigDecimal.valueOf(0.05));
            shakhtar.setBalance(BigDecimal.valueOf(7000000));
            teamRepository.save(shakhtar);

            Player yurii = new Player();
            yurii.setName("Yurii");
            yurii.setAge(25);
            yurii.setMonthsExperience(36);
            yurii.setTeam(null);
            playerRepository.save(yurii);

            Player vitalii = new Player();
            vitalii.setName("Vitalii");
            vitalii.setAge(22);
            vitalii.setMonthsExperience(24);
            vitalii.setTeam(null);
            playerRepository.save(vitalii);

            Player nazarii = new Player();
            nazarii.setName("Nazarii");
            nazarii.setAge(18);
            nazarii.setMonthsExperience(30);
            nazarii.setTeam(null);
            playerRepository.save(nazarii);
        }
    }
}
