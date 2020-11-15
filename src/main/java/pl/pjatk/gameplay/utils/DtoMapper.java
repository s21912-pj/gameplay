package pl.pjatk.gameplay.utils;


import pl.pjatk.gameplay.Dto.PlayerDto;
import pl.pjatk.gameplay.model.Player;

public class DtoMapper {

    public static Player convertToPlayer(PlayerDto player){
        return new Player(player.getName(),player.getHp(),player.getAttack(),player.getMana());
    }
    public static PlayerDto convertToPlayerDto(Player player){
        return new PlayerDto(player.getId(),player.getName(),player.getHp(),player.getAttack(),player.getMana());
    }
}
