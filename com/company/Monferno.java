package com.company;

public class Monferno extends Chimchar{
    static int baseHealth = 40;
    static int baseAttack = 5;
    static int baseSpeed = (int) Math.round(Math.random()*15 + 1);
    static String name = "monferno";

    final static int cdSlowAttack = 6;
    static int thisCdSlowAttack = 6;
    public Monferno(int Level){
        this.level = Level;
        this.currentHealth = baseHealth * Level;
        this.attack = baseAttack * Level;
        this.speed = baseSpeed;
    }

    public void slowAttack(Pokemon Poke){
        Poke.speed -= (int) Math.round(Math.random() * 5);
        Poke.countSlowed = 5;// нереализованный функционал

        Poke.currentHealth -= this.attack/1.3;
    }

    public void attackStart(Pokemon Poke){
        boolean isAttacked = false;
        if (!isAttacked)
            if (thisCdRest >= cdRest){
                if (Math.random() < 0.5){
                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал Rest");
                    this.Rest();
                    isAttacked = true;
                    thisCdRest = 0;
                }
            }
        if (!isAttacked)
            if (thisCdLeech >= cdLeech)
                if (Math.random() < 0.8) {
                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал Leech");
                    this.Leech(Poke);
                    isAttacked = true;
                    thisCdLeech = 0;
                }
        if (!isAttacked)
            if (thisCdSlowAttack >= cdSlowAttack)
                if (Math.random() < 0.6){
                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал SlowAttack");
                    this.slowAttack(Poke);
                    isAttacked = true;
                    thisCdSlowAttack = 0;
                }

        if (!isAttacked) {
            System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал Attack");
            this.Attack(Poke);
        }
        thisCdLeech += 1;
        thisCdRest += 1;
        thisCdSlowAttack +=1;
    }

}