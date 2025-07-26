package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
