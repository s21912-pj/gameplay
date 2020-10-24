package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    private List<Player> players = List.of(new Player(1L,"Marlon",30,2,100),
                       new Player(2L,"Anderson",30,3,100));

    public List<Player> findAll(){
        return players;
    }

    public Optional<Player> findById(Long id){
        return players.stream()
                .filter(player->player.getId()==id)
                .findFirst();
    }

    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }
}
