package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Chimchar chimchar = new Chimchar(7);
        Furfrou furfrou = new Furfrou( 6);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Выберите своего бойца");
        //System.out.println("1 - chimchar");
        //System.out.println("2 - furfrou");
       // try {
        //    int pokeCheck = Integer.parseInt(reader.readLine());
        //}
        //catch (IOException|NumberFormatException ex){

        //}
        Battle.letEmBattle(chimchar, furfrou);

    }
}
