package pl.pjatk.gameplay.Dto;


public class FightDataDto {
    private Long attackerId;
    private Long receiverId;
    private int damagePoint;
    private int mana;

    public FightDataDto() {
    }

    public FightDataDto(Long attackerId, Long receiverId, int damagePoint, int mana) {
        this.attackerId = attackerId;
        this.receiverId = receiverId;
        this.damagePoint = damagePoint;
        this.mana = mana;
    }

    public Long getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public int getDamagePoint() {
        return damagePoint;
    }

    public void setDamagePoint(int damagePoint) {
        this.damagePoint = damagePoint;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
