package com.company;

public abstract class Pokemon {
    int baseSpeed;
    double health;
    double currentHealth;
    double attack;
    double normAttack;
    int speed;
    int normSpeed;
    int level;
    int countSlowed;
    int workUpCountBuffed;

    static String name;
    public abstract void attackStart(Pokemon poke);
}
