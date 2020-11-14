package pl.pjatk.gameplay.service;


import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Damage;
import pl.pjatk.gameplay.model.FightData;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DamageService {

    private PlayerRepository playerRepository;
    public DamageService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> fight(Damage damage){
        Player attacker =  damage.getPlayers().stream().filter(x->x.getId()== damage.getAttackerId()).findFirst().get();
        Player receiver =  damage.getPlayers().stream().filter(x->x.getId()== damage.getReceiverId()).findFirst().get();
        receiver.setHp(receiver.getHp()-damage.getDamagePoint());
        attacker.setMana(attacker.getMana()-10);
        playerRepository.saveAll(damage.getPlayers());
        return damage.getPlayers();
    }

    public List<Player> fight2(FightData damage){
        Player attacker =  playerRepository.findById(damage.getAttackerId()).get();
        Player receiver =  playerRepository.findById(damage.getReceiverId()).get();
        receiver.setHp(receiver.getHp()-damage.getDamagePoint());
        attacker.setMana(attacker.getMana()-damage.getMana());
        List<Player> afterfight = new ArrayList<>(){{add(attacker); add(receiver);}};
        playerRepository.saveAll(afterfight);
        return afterfight;
    }
}
