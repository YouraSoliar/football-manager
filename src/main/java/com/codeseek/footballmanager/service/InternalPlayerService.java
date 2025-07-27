package com.codeseek.footballmanager.service;

import com.codeseek.footballmanager.model.Player;

public interface InternalPlayerService {
    Player getEntityById(Long id);
    Player saveEntity(Player player);
}
