package pl.pjatk.gameplay.service;


import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.Dto.PlayerDto;
import pl.pjatk.gameplay.model.FightData;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;
import pl.pjatk.gameplay.utils.DtoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DamageService {

    private PlayerRepository playerRepository;
    public DamageService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public List<Player> fight(FightData damage) {
        Optional<Player> attacker =  playerRepository.findById(damage.getAttackerId());
        Optional<Player> receiver =  playerRepository.findById(damage.getReceiverId());
        if(attacker.isPresent()&&receiver.isPresent()) {
            receiver.get().setHp(receiver.get().getHp() - damage.getDamagePoint());
            attacker.get().setMana(attacker.get().getMana() - damage.getMana());
            List<Player> afterfight = new ArrayList<>() {{
                add(attacker.get());
                add(receiver.get());
            }};
            playerRepository.saveAll(afterfight);
            return afterfight;
        }else{
           throw new NoSuchElementException(String.format("Fight cant be performed." +" Attacker Id: %d or receiver %d does not exist."
                   ,damage.getAttackerId(),damage.getReceiverId()));
        }
    }
}
