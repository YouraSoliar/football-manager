package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.dto.TransferAssignRequestDto;
import com.codeseek.footballmanager.dto.TransferMoveRequestDto;
import com.codeseek.footballmanager.exception.LackOfMoneyException;
import com.codeseek.footballmanager.exception.TransferException;
import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.model.Team;
import com.codeseek.footballmanager.service.InternalPlayerService;
import com.codeseek.footballmanager.service.InternalTeamService;
import com.codeseek.footballmanager.service.TransferService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private static final int PRICE_MULTIPLIER = 100000;
    private final InternalPlayerService internalPlayerService;
    private final InternalTeamService internalTeamService;

    @Transactional
    @Override
    public void transferPlayer(TransferMoveRequestDto requestDto) {
        Player player = internalPlayerService.getEntityById(requestDto.getPlayerId());
        Team sellerTeam = internalTeamService.getEntityById(requestDto.getSellerTeamId());
        Team buyerTeam = internalTeamService.getEntityById(requestDto.getBuyerTeamId());

        double totalPrice = getTotalPrice(player, sellerTeam.getCommission());
        checkBuyerTeamBalance(buyerTeam, totalPrice);
        performTransfer(player, sellerTeam, buyerTeam, totalPrice);
    }

    @Override
    public void updatePlayerTeamAssignment(TransferAssignRequestDto requestDto) {
        Player player = internalPlayerService.getEntityById(requestDto.getPlayerId());

        if (requestDto.getTeamId() == null) {
            player.setTeam(null);
        } else {
            Team team = internalTeamService.getEntityById(requestDto.getTeamId());
            if (player.getTeam() == null) {
                if (!team.getPlayers().contains(player)) {
                    team.getPlayers().add(player);
                    player.setTeam(team);
                    internalTeamService.saveEntity(team);
                } else {
                    throw new TransferException("Team " + team.getId() + " already has player " + player.getId());
                }
            } else {
                throw new TransferException("Player " + player.getId() + " has team");
            }
        }
        internalPlayerService.saveEntity(player);
    }

    private double getTotalPrice(Player player, BigDecimal commission) {
        double transferPrice = (double) (player.getMonthsExperience() * PRICE_MULTIPLIER) / player.getAge();
        double commissionPrice = transferPrice * commission.doubleValue();
        return transferPrice + commissionPrice;
    }

    private void checkBuyerTeamBalance(Team buyerTeam, double totalPrice) {
        if (buyerTeam.getBalance().doubleValue() < totalPrice) {
            throw new LackOfMoneyException("No enough money in buying team with id"
                    + buyerTeam.getId() + ". Needed amount " + totalPrice
                    + ", actual balance " + buyerTeam.getBalance());
        }
    }

    private void performTransfer(Player player, Team sellerTeam, Team buyerTeam, double totalPrice) {
        sellerTeam.setBalance(sellerTeam.getBalance().add(BigDecimal.valueOf(totalPrice)));
        buyerTeam.setBalance(buyerTeam.getBalance().subtract(BigDecimal.valueOf(totalPrice)));

        if (sellerTeam.getPlayers().remove(player)) {
            if (!buyerTeam.getPlayers().contains(player)) {
                buyerTeam.getPlayers().add(player);
                player.setTeam(buyerTeam);
            } else {
                throw new TransferException("Team " + buyerTeam.getId() + " already has player " + player.getId());
            }
        } else {
            throw new TransferException("Can`t remove player " + player.getId()
                    + ", from the Team " + sellerTeam.getId());
        }

        internalPlayerService.saveEntity(player);
        internalTeamService.saveEntity(sellerTeam);
        internalTeamService.saveEntity(buyerTeam);
    }
}
