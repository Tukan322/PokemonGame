package com.company;


public class Battle {
    static Class<? extends Pokemon> firstClass;
    static Class<? extends Pokemon> secondClass;

    public Battle(){
    }

    static public void getBattle(Pokemon poke1, Pokemon poke2){
        firstClass = poke1.getClass();
        secondClass = poke2.getClass();
    }

    static public void letEmBattle(Pokemon poke1, Pokemon poke2){
        int i = 0;
        poke1.countSlowed = -1;
        poke1.workUpCountBuffed = -1;
        poke2.countSlowed = -1;
        poke2.workUpCountBuffed = -1;


        System.out.println("Начальное здоровье покемонов:");
        System.out.println(String.valueOf(poke1.getClass()).substring(18) + " " + poke1.currentHealth);
        System.out.println(String.valueOf(poke2.getClass()).substring(18) + " " + poke2.currentHealth);
        System.out.println("Вы сражаетесь за покемона Chimchar!");
        System.out.println();
        while(true){

            i++;
            System.out.println("Round " + i);
            if (poke1.speed > poke2.speed) {
                System.out.println("Скорость покемона " + String.valueOf(poke1.getClass()).substring(18) + " больше. Он атакует первым");

                poke1.attackStart(poke2);
                poke2.attackStart(poke1);

            }

            else{
                System.out.println("Скорость покемона " + String.valueOf(poke2.getClass()).substring(18) + " больше. Он атакует первым");
                System.out.println();
                poke2.attackStart(poke1);
                poke1.attackStart(poke2);
            }
            System.out.println();
            System.out.println("Текущее здоровье");
            System.out.println(String.valueOf(poke1.getClass()).substring(18) + " " + poke1.currentHealth);
            System.out.println(String.valueOf(poke2.getClass()).substring(18) + " " + poke2.currentHealth);
            System.out.println();



            if (poke1.currentHealth <= 0) {
                String poke2Class = String.valueOf(poke2.getClass());
                poke2Class = poke2Class.substring(18);
                System.out.println("Победил покемон " + poke2Class);
                break;
            }
            if (poke2.currentHealth <= 0){
                String poke1Class = String.valueOf(poke1.getClass());
                poke1Class = poke1Class.substring(18);
                System.out.println("Победил покемон " + poke1Class);
                break;
            }

        }
    }
}
