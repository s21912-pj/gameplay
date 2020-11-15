package pl.pjatk.gameplay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.Dto.PlayerDto;
import pl.pjatk.gameplay.model.FightData;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.DamageService;
import pl.pjatk.gameplay.service.PlayerService;
import pl.pjatk.gameplay.utils.DtoMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
    public ResponseEntity<PlayerDto> findById(@PathVariable Long id) {
        return playerService.findById(id)
                .map(player->ResponseEntity.ok().body(DtoMapper.convertToPlayerDto(player)))
                .orElseThrow(()->new NoSuchElementException(String.format("Player with id: %d does not exist.",id)));
    }

    @PostMapping
    public ResponseEntity<PlayerDto> savePlayer(@RequestBody PlayerDto player){
        return ResponseEntity.ok(
                DtoMapper.convertToPlayerDto(playerService.savePlayer(DtoMapper.convertToPlayer(player))));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<PlayerDto>> saveBatchPlayer(@RequestBody List<PlayerDto> players){
        return ResponseEntity.ok(playerService.batchSave(
                players.stream()
                        .map(DtoMapper::convertToPlayer)
                        .collect(Collectors.toList()))
                .stream()
                .map(DtoMapper::convertToPlayerDto)
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> patchUpdatePlayer(@PathVariable Long id, @RequestBody PlayerDto player)  {
       return ResponseEntity.status(201)
               .body(DtoMapper
                       .convertToPlayerDto(playerService.updateUser(id, DtoMapper.convertToPlayer(player)).get()));
    }

    @PutMapping("/fight")
    public ResponseEntity<List<PlayerDto>>fight(@RequestBody FightData fightData){
            return ResponseEntity.status(204).body(damageService.fight(fightData)
                    .stream()
                    .map(DtoMapper::convertToPlayerDto)
                    .collect(Collectors.toList()));

    }
}
