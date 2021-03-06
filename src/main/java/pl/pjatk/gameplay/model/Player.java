package pl.pjatk.gameplay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
    @Id@GeneratedValue
    private Long id;
    private String name;
    private int hp;
    private int attack;
    private int mana;

    public Player() {
    }

    public Player(String name, int hp, int attack, int mana) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.mana = mana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
