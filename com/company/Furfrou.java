package com.company;

public class Furfrou extends Pokemon {
    int baseHealth = 25;
    int baseAttack = 8;
    int baseSpeed = (int) Math.round(Math.random()*5 + 1);
    static double workUpMultiply = 1.5;
    static String name = "furfrou";

    final static int cdRest = 3;
    final static int cdWorkUp = 5;
    static int thisCdRest = 3;
    static int thisCdWorkUp = 5;

    public Furfrou(){

    }
    public Furfrou(int Level){
        this.level = Level;
        this.health = baseHealth * Level;
        this.currentHealth = baseHealth * Level;
        this.attack = baseAttack * Level;
        this.normAttack = this.attack;
        this.speed = baseSpeed;
        this.normSpeed = this.speed;
    }

    public void attackStart(Pokemon Poke){
        boolean isAttacked = false;
        if (!isAttacked){
            if(thisCdWorkUp >= cdWorkUp) {
                if (Math.random() < 0.6){
                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал WorkUp");
                    this.workUp();
                    System.out.println("Текущее значение атаки покемона " + String.valueOf(this.getClass()).substring(18) + " " + this.attack);
                    isAttacked = true;
                    thisCdWorkUp = 0;
                }
            }
        }
        if (!isAttacked){
            if (thisCdRest >= cdRest){
                if (Math.random() < 0.4){
                    double beforeHeal = this.currentHealth;
                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал Rest");
                    this.Rest();
                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " восстановил " + (this.currentHealth-beforeHeal) + " здоровья.");
                    isAttacked = true;
                    thisCdRest = 0;
                }
            }
        }
        if (!isAttacked){
            System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал Attack");
            double healthBeforeAttack = Poke.currentHealth;
            this.Attack(Poke);
            System.out.println("Нанесено " + (healthBeforeAttack - Poke.currentHealth) + " урона покемону " + String.valueOf(Poke.getClass()).substring(18));

        }
        Utility.buffCheck(this);
        thisCdRest++;
        thisCdWorkUp++;
    }

    public void workUp(){
        this.attack = this.attack * workUpMultiply;
        this.workUpCountBuffed = 3;
    }

    public void Rest(){
        this.currentHealth += this.health/2;
        if (this.currentHealth > this.health) this.currentHealth = this.health;
    }

    public void Attack(Pokemon Poke){
        Poke.currentHealth -= this.attack;
    }
}
