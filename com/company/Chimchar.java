package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Chimchar extends Pokemon{
        int baseHealth = 30;
        int baseAttack = 3;
        int baseSpeed = (int) Math.round(Math.random()*10 + 1);
        String name = "chimchar";
        public Chimchar(){

        }
        public Chimchar(int Level){
            this.level = Level;
            this.health = baseHealth * Level;
            this.currentHealth = baseHealth * Level;
            this.attack = baseAttack * Level;
            this.normAttack = this.attack;
            this.speed = baseSpeed;
            this.normSpeed = this.speed;
        }

        final static int cdRest = 3;
        final static int cdLeech = 5;
        static int thisCdRest=3;
        static int thisCdLeech=5;

        public void attackStart(Pokemon Poke) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean isAttacked = false;
            while (!isAttacked) {
                try {
                    System.out.println();
                    System.out.println("Введите номер атаки который вы хотите использовать");

                    System.out.print("1 - Rest. Текущий статус: ");
                    if (thisCdRest >= cdRest) System.out.println("доступно к использованию");
                    else System.out.println("перезаряжается. Осталось " + (cdRest - thisCdRest) + " раундов");

                    System.out.print("2 - Leech. Текущий статус: ");
                    if (thisCdLeech >= cdLeech) System.out.println("доступно к использованию");
                    else System.out.println("перезаряжается. Осталось " + (cdLeech - thisCdLeech) + " раундов");

                    System.out.println("3 - Attack. Текущий статус: доступно");

                    int attackNumber = Integer.parseInt(reader.readLine());
                    System.out.println();
                    if (!isAttacked)
                        if (attackNumber == 1) {
                            if (thisCdRest >= cdRest) {
                                    double beforeHeal = this.currentHealth;
                                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал Rest");
                                    this.Rest();
                                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " восстановил " + (this.currentHealth - beforeHeal) + " здоровья.");
                                    isAttacked = true;
                                    thisCdRest = 0;
                            }
                        }
                    if (!isAttacked)
                        if (attackNumber == 2) {
                            if (thisCdLeech >= cdLeech)
                                    System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал Leech");
                                    double healthBeforeAttack = Poke.currentHealth;
                                    this.Leech(Poke);
                                    System.out.println("Нанесено " + (healthBeforeAttack - Poke.currentHealth) + " урона покемону " + String.valueOf(Poke.getClass()).substring(18));
                                    isAttacked = true;
                                    thisCdLeech = 0;

                        }
                    if (attackNumber == 3) {
                        if (!isAttacked) {
                            System.out.println("Покемон " + String.valueOf(this.getClass()).substring(18) + " использовал Attack");
                            double healthBeforeAttack = Poke.currentHealth;
                            this.Attack(Poke);
                            System.out.println("Нанесено " + (healthBeforeAttack - Poke.currentHealth) + " урона покемону " + String.valueOf(Poke.getClass()).substring(18));
                            isAttacked = true;
                        }
                    }
                    if (!isAttacked) System.out.println("Проверьте правильность ввода и доступность использованных атак");
                }
                catch (IOException|NumberFormatException ex){
                    System.out.println("Введите корректное значение атаки");
                }
            }
            Utility.buffCheck(this);
            thisCdLeech += 1;
            thisCdRest += 1;

        }

        public void Attack(Pokemon Poke){
            Poke.currentHealth -= this.attack;
        }

        public void Leech(Pokemon Poke){
            Poke.currentHealth -= this.attack/1.5;
            this.currentHealth += this.attack/1.5;
            if (this.currentHealth > this.health) this.currentHealth = this.health;
        }

        public void Rest(){
            this.currentHealth += this.health/2;
            if (this.currentHealth > this.health) this.currentHealth = this.health;

        }
    }
