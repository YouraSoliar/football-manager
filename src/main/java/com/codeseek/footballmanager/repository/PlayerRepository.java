package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
