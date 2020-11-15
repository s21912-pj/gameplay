package pl.pjatk.gameplay.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    Logger logger = LoggerFactory.getLogger(PlayerService.class);
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id){
        logger.debug(String.format("Try to find player with id: %s",id));
        return playerRepository.findById(id);
    }

    public Player savePlayer(Player player){
        logger.debug(String.format("Create new player: %s",player.toString()));
        return playerRepository.save(player);
    }

    public Optional<Player> updateUser(Long id, Player player){
        Optional<Player> player1 = playerRepository.findById(id);
        if(player1.isPresent()){
          player1 = player1.map(p->{
                p.setMana(player.getMana());
                p.setHp(player.getHp());
                p.setAttack(player.getAttack());
                p.setName(player.getName());
                return p;
            });
          playerRepository.save(player1.get());
        }
        return player1;
    }

    public List<Player> batchSave(List<Player> players){
        logger.debug("Create new players - through batch");
        return playerRepository.saveAll(players);
    }


}
