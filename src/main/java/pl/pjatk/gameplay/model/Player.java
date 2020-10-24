package pl.pjatk.gameplay.model;


public class Player {
    private Long id;
    private String name;
    private int hp;
    private int attack;
    private int mana;

    public Player() {
    }

    public Player(Long id, String name, int hp, int attack, int mana) {
        this.id = id;
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
