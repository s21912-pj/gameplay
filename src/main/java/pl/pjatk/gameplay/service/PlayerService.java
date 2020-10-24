package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;

import java.util.List;

@Service
public class PlayerService {

    public List<Player> findAll(){
        return List.of(new Player(1L,"Marlon",30,2,100),
                       new Player(2L,"Anderson",30,3,100));
    }
}
