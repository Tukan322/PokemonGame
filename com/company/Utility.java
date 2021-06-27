package com.company;

public class Utility {
    //Buff counters and returning to normal state
    static public void buffCheck(Pokemon poke) {
        poke.countSlowed--;
        poke.workUpCountBuffed--;
        if (poke.countSlowed == 0) {
            System.out.println("Усиление покемона " + String.valueOf(poke.getClass()).substring(18) + " от способности slowAttack завершилось. Текущее значение скорости " + poke.normSpeed);
            poke.speed = poke.normSpeed;
        }
        if (poke.workUpCountBuffed == 0) {
            System.out.println("Усиление покемона " + String.valueOf(poke.getClass()).substring(18) + " от способности workUp завершилось. Текущее значение атаки " + poke.normAttack);
            poke.attack = poke.normAttack;
        }
    }
}
