package pl.pjatk.gameplay.controller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.model.Damage;
import pl.pjatk.gameplay.model.FightData;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.DamageService;
import pl.pjatk.gameplay.service.PlayerService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("v1/player")
public class ApiPlayer {

    private PlayerService playerService;
    private DamageService damageService;

    public ApiPlayer(PlayerService playerService, DamageService damageService) {

        this.playerService = playerService;
        this.damageService = damageService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll(){
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public Optional<Player> findById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return Optional.ofNullable(playerService.findById(id))
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody Player player){
        return ResponseEntity.ok(playerService.savePlayer(player));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Player>> saveBatchPlayer(@RequestBody List<Player> player){
        return ResponseEntity.ok(playerService.batchSave(player));
    }

    @PutMapping("/fight")
    public List<Player>fight(@RequestBody Damage damage){
        return damageService.fight(damage);
    }
    @PutMapping("/fight2")
    public List<Player>fight2(@RequestBody FightData fightData){
        return damageService.fight2(fightData);
    }
}
